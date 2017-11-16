/**
 * 2017年10月27日
 */
package net.kingfore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KF.App.App;
import com.KF.Modul.Receive.OutCome;
import com.KF.Modul.Receive.RecReadSimulationR8PL;
import com.KF.Modul.Send.ReadSimulationR8PL;
import com.KF.Netty.KFChannelHandlerAdapter;

import io.netty.channel.ChannelHandlerContext;
import net.kingfore.model.ExcelObj;
import net.kingfore.model.Propertie;

/**
 * @author JF_Hao
 *
 */
@Component
public class Utils {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Propertie propertie;

	int MaxDataPac = 300;
	// App app = new App(ip, port, MaxDataPac);
	App app = null;

	// 获取Excel文件
	private HSSFWorkbook getExcelBook() {
		HSSFWorkbook book = null;
		try {
			InputStream inputStream = new FileInputStream(new File(propertie.getRealExcelFilePath()));
			book = new HSSFWorkbook(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}

	// 读取Excel表格中的所有站点编号(自动去重)
	public HashSet<String> readStationNoByExcelFile() {
		HashSet<String> hashSet = new HashSet<>();
		HSSFWorkbook excelBook = getExcelBook();
		HSSFSheet sheet = excelBook.getSheetAt(0);
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
				String cellValue = getCellValue(row.getCell(0));
				if(cellValue != null && !"".equals(cellValue)){
					hashSet.add(cellValue);
				}
			}
		}
		return hashSet;
	}

	// 判断单元格是空。
	public boolean cellIsNull(HSSFCell cell) {
		boolean b = true;
		if (cell != null && !"".equals(cell) && cell.getCellType() != CellType.BLANK.getCode()) {
			b = false;
		}
		return b;
	}

	/**
	 * 对Excel的各个单元格的格式进行判断并转换
	 */
	private String getCellValue(HSSFCell cell) {
		String cellValue = "";
		if (cell != null && !"".equals(cell)) {
			DecimalFormat df = new DecimalFormat("#");
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				cellValue = cell.getRichStringCellValue().getString().trim();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				cellValue = df.format(cell.getNumericCellValue()).toString();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				cellValue = cell.getCellFormula();
				break;
			default:
				cellValue = "";
			}
		}
		return cellValue;
	}

	// 根据杰控类型("AI"、"AR"等)转换成杰控对应的数据值
	private byte convertType(String jk_type) {
		byte type = -1;
		switch (jk_type.toUpperCase()) {
		case "AI":
			type = 1;
			break;
		case "AO":
			type = 2;
			break;
		case "AR":
			type = 3;
			break;
		case "VA":
			type = 7;
			break;
		}
		return type;
	}

	// 根据数值转换成杰控类型("AI"、"AR"等)
	public String convertTypeByNo(byte type) {
		String Type = "";
		switch (type) {
		case 1:
			Type = "AI";
			break;
		case 2:
			Type = "AO";
			break;
		case 3:
			Type = "AR";
			break;
		case 7:
			Type = "VA";
			break;
		}
		return Type;
	}

	// 读取表格中所有的杰控类型和杰控编号
	public Map<String, HashSet<Integer>> readJKNoAndJkTypeByExcelFile() {
		Map<String, HashSet<Integer>> resultMap = new HashMap<>();

		HashSet<Integer> AI_JKNoList = new HashSet<>();
		HashSet<Integer> AO_JKNoList = new HashSet<>();
		HashSet<Integer> AR_JKNoList = new HashSet<>();
		HashSet<Integer> VA_JKNoList = new HashSet<>();

		HSSFSheet sheet = getExcelBook().getSheetAt(0);
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
				HSSFCell cellType = row.getCell(4);
				HSSFCell cellNo = row.getCell(3);
				// 如果杰控类型和杰控编号都不为空则添加数据
				if (!cellIsNull(cellType) && !cellIsNull(cellNo)) {
					String jkType = cellType.getStringCellValue();
					int jkNo = Integer.parseInt(getCellValue(cellNo));
					if ("AI".equals(jkType)) {
						AI_JKNoList.add(jkNo);
					} else if ("AO".equals(jkType)) {
						AO_JKNoList.add(jkNo);
					} else if ("AR".equals(jkType)) {
						AR_JKNoList.add(jkNo);
					} else if ("VA".equals(jkType)) {
						VA_JKNoList.add(jkNo);
					}
				}
			}
		}

		if (AI_JKNoList != null && AI_JKNoList.size() > 0)
			resultMap.put("AI", AI_JKNoList);
		if (AO_JKNoList != null && AO_JKNoList.size() > 0)
			resultMap.put("AO", AO_JKNoList);
		if (AR_JKNoList != null && AR_JKNoList.size() > 0)
			resultMap.put("AR", AR_JKNoList);
		if (VA_JKNoList != null && VA_JKNoList.size() > 0)
			resultMap.put("VA", VA_JKNoList);

		return resultMap;
	}

	// 根据杰控类型和杰控编号获取实时数据
	public LinkedList<Object> readJKDataByJkTypeAndJkNo() {
		// 读取表格中所有的杰控类型和杰控编号
		Map<String, HashSet<Integer>> JKNoAndJkType = readJKNoAndJkTypeByExcelFile();

		for (Map.Entry<String, HashSet<Integer>> entry : JKNoAndJkType.entrySet()) {
			String jkType = entry.getKey(); // 杰控类型
			HashSet<Integer> jkNoList = entry.getValue(); // 杰控编号集
			// System.out.println("杰控类型：" + jkType);
			// System.out.println("杰控编号：" + jkNoList);

			// 如果杰控编号不是空，则进行获取值
			if (!jkNoList.isEmpty() && jkNoList.size() > 0 && jkType != null && !"".equals(jkType)) {
				// 再次重新收集杰空编号，因为杰控服务器最多一次只可以接收2700个编号
				LinkedList<Integer> List_jk_no = new LinkedList<>();
				Iterator<Integer> iterator = jkNoList.iterator();
				int i = 0;
				while (iterator.hasNext()) {
					List_jk_no.push(iterator.next());
					if (List_jk_no.size() >= 2700 || i == jkNoList.size() - 1) {
						ReadSimulationR8PL readSimulationR8PL = new ReadSimulationR8PL();
						readSimulationR8PL.setType(convertType(jkType));
						readSimulationR8PL.setIndexS(List_jk_no);
						ChannelHandlerContext ctx = KFChannelHandlerAdapter.ctxJk;
						try {
							if (ctx != null && ctx.channel().isActive()) {

							} else {
								app = new App(propertie.getJkIP(), propertie.getJkPort(), MaxDataPac);
							}
							if (app.send(readSimulationR8PL.toArrByte())) {
								Thread.sleep(500);
							}
						} catch (Exception e) {
							logger.info("杰控相关异常：" + e.getMessage());
							e.printStackTrace();
						}
						List_jk_no.clear();
					}
					i = i + 1;
				}
			}
		}
		logger.info("定时写库:共接收[" + OutCome.KFResponseData.size() + "]条有效数据。");
		return OutCome.KFResponseData;
	}

	// 获取所有杰控实时数据
	public List<Map<String, Object>> getAllReadJKData() {
		List<Map<String, Object>> list = new ArrayList<>();
		// 获取杰控编号对应的实时数据
		LinkedList<Object> JKDataList = readJKDataByJkTypeAndJkNo();

		if (JKDataList != null && JKDataList.size() > 0) {
			while (JKDataList.size() > 0) {
				Object obj = JKDataList.get(0);
				if (obj instanceof RecReadSimulationR8PL) {
					RecReadSimulationR8PL recReadSimulationR8PL = (RecReadSimulationR8PL) obj;
					byte type = recReadSimulationR8PL.getType();
					String jkTypeStr = convertTypeByNo(type);
					byte error = recReadSimulationR8PL.getError();
					if (error == 0) {
						Date dt = recReadSimulationR8PL.getDt();
						Map<Integer, Double> jkMap = recReadSimulationR8PL.getValues();
						HashMap<String, Object> map = new HashMap<>();
						map.put("jkType", jkTypeStr); // 杰控类型
						map.put("jkNoAndValue", jkMap);// 杰控编号和对应的值
						list.add(map);
						// System.out.println(jkMap);
					}
				}
				JKDataList.remove(0);
			}
		} else {
			System.out.println("获取杰控数据失败。");
		}
		return list;
	}
	
	//根据站点编号获取供热仪表名称
	public List<String> getHeatMeterByStationNo(String stationNo){
		HashSet<String> set = new HashSet<>();
		HSSFSheet sheet = getExcelBook().getSheetAt(0);
		for(int i = 1;i < sheet.getLastRowNum() + 1; i++){
			HSSFRow row = sheet.getRow(i);
			if(row != null){
				String cellValue = getCellValue(row.getCell(1));
				if(cellValue != null && !"".equals(cellValue)){
					set.add(cellValue);
				}
			}
		}
		List<String> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}
	
	//随机生成杰控数据
	public List<Map<String, Object>> random(){
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<Integer, Double> AImap = new HashMap<>();
		Map<Integer, Double> ARmap = new HashMap<>();
		Map<Integer, Double> VAmap = new HashMap<>();
		Map<Integer, Double> AOmap = new HashMap<>();
		for(int i = 0;i < 500;i++){
			AImap.put(i, Math.random());
			ARmap.put(i, Math.random());
			VAmap.put(i, Math.random());
			AOmap.put(i, Math.random());
		}
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("jkType", "AI"); // 杰控类型
		map1.put("jkNoAndValue", AImap);// 杰控编号和对应的值
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("jkType", "AR"); // 杰控类型
		map2.put("jkNoAndValue", ARmap);// 杰控编号和对应的值
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("jkType", "VA"); // 杰控类型
		map3.put("jkNoAndValue", VAmap);// 杰控编号和对应的值
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("jkType", "AO"); // 杰控类型
		map4.put("jkNoAndValue", AOmap);// 杰控编号和对应的值
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		
		return list;
	}
	
	//根据站点编号和供热仪表    获取  字段名称、杰控编号、杰控类型、固定值
	public List<ExcelObj> getExcelObjByStationNoAndHeatMeter(String stationNo,String heatMeter){
		List<ExcelObj> list = new ArrayList<>();
		HSSFSheet sheet = getExcelBook().getSheetAt(0);
		for(int i = 1;i < sheet.getLastRowNum() + 1; i++){
			HSSFRow row = sheet.getRow(i);
			if(row != null){
				String StationNo = getCellValue(row.getCell(0));
				String HeatMeter = getCellValue(row.getCell(1));
				if(StationNo != null && StationNo.equals(stationNo) && HeatMeter != null && HeatMeter.equals(heatMeter)){
					String name = getCellValue(row.getCell(2));
					String jkNo = getCellValue(row.getCell(3));
					String jdType = getCellValue(row.getCell(4));
					String value = getCellValue(row.getCell(5));
					ExcelObj ExcelObj = new ExcelObj(stationNo, heatMeter, name, jkNo, jdType, value);
					list.add(ExcelObj);
				}
			}
		}
		return list;
	}
	
	

}
