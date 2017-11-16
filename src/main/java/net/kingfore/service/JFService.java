/**
 * 2017年10月27日
 */
package net.kingfore.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.kingfore.model.ExcelObj;
import net.kingfore.utils.Utils;


/**
 * @author JF_Hao
 *
 */
@Service
public class JFService {
	
	//private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Utils utils;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String readTime = ""; // 采集时间
	
	// 对象转json字符串
	ObjectMapper mapper = new ObjectMapper();

	// 上传数据
	public Object uploadData() {

		readTime = dateFormat.format(new Date());

		// 1. 获取所有的站点编号
		HashSet<String> allStationNo = utils.readStationNoByExcelFile();
		System.out.println("全部站点编号：" + allStationNo);

		// 2. 获取所有正式的接口(url)
		Map<String, String> allUrlMap = getAllUrl();
		
		//测试接口
		//Map<String, String> allUrlMap = getAllUrlTest();
		//System.out.println("全部接口：" + allUrlMap);

		// 3. 获取所有杰控数据 (根据杰控编号和杰控类型)
		List<Map<String, Object>> allReadJKData = utils.getAllReadJKData();
		//List<Map<String, Object>> allReadJKData = utils.random();
		System.out.println( "所有杰控数据：" + allReadJKData);
		//logger.info("所有杰控数据：" + allReadJKData);

		// 4. 根据站点编号、全部接口、全部杰控数据 开始上传数据
		//uploadDataByAllStationNoAndAllUrlAndAllReadJKData(allStationNo, allUrlMap, allReadJKData);

		return "success";
	}

	// 根据 全部站点编号、全部接口、全部杰控数据 上传数据
	public Object uploadDataByAllStationNoAndAllUrlAndAllReadJKData(HashSet<String> allStationNo,
			Map<String, String> allUrlMap, List<Map<String, Object>> allReadJKData) {
		Iterator<String> iterator = allStationNo.iterator();
		// 循环站点编号
		while (iterator.hasNext()) {
			//依次得到每一个站点编号
			String stationNo = iterator.next();
			// 根据站点编号获取供热仪表名称
			List<String> heatMeterList = utils.getHeatMeterByStationNo(stationNo);
			for (String heatMeter : heatMeterList) {
				// 根据 供热仪表名称 获取url地址
				String urlByHeatMeter = allUrlMap.get(heatMeter.replaceAll("\\d+", ""));
				// 根据站点编号和供热仪表名称 获取 Excel对象(字段名称、杰控编号、杰控类型、固定值)
				List<ExcelObj> excelObjList = utils.getExcelObjByStationNoAndHeatMeter(stationNo, heatMeter);
				//数据集合对象
				List<Object> datList = getDataByUrlAndHeatMeterObjAndAllReadJKData(excelObjList, allReadJKData);
				try {
					Map<String, Object> resultMap = new HashMap<>();
					List<Object> rootList = new ArrayList<>();
					Map<String, Object> dataMap = new HashMap<>();
					dataMap.put("stationNo", stationNo);
					dataMap.put("data", datList);
					rootList.add(dataMap);
					resultMap.put("root", rootList);
					
					//把对象转为json字符串
					String rootJson = mapper.writeValueAsString(resultMap);
					uploadDataByUrlAndJsonData(urlByHeatMeter, rootJson);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				
			}
		}
		return null;
	}

	// 根据 excel对象集（每一个仪表对象）、全部杰控数据 	获取data数组对象
	public List<Object> getDataByUrlAndHeatMeterObjAndAllReadJKData(List<ExcelObj> excelObjList,
			List<Map<String, Object>> allReadJKData) {
		List<Object> dataList = new ArrayList<>();
		Map<String, Object> mapObj = new HashMap<>();
		if (excelObjList != null && excelObjList.size() > 0) {
			for (int i = 0; i < excelObjList.size(); i++) {
				ExcelObj excelObj = excelObjList.get(i);
				String heatMeter = excelObj.getHeatMeter();
				String jkType = excelObj.getJkType();
				String jkNo = excelObj.getJkNo();
				String value = excelObj.getValue();
				String name = excelObj.getName();

				if ("readTime".equals(name)) { // 如果字段名称是采集时间，则引用上面生成的时间
					mapObj.put("readTime", readTime);
					continue;
				} else if (value != null && !"".equals(value)) { // 如果表格中的value(固定值)列不为空，则以表格中的值为准
					mapObj.put(name, value);
					continue;
				} else if (jkNo == null && "".equals(jkNo)) { // 如果杰控编号为空，则值默认都是0
					mapObj.put(name, 0);
					continue;
				}

				for (Map<String, Object> allReadJKDataMap : allReadJKData) {
					if (jkType != null) {
						String jkType_A = (String) allReadJKDataMap.get("jkType");
						Map<Integer, Double> jkNoAndValueMap = (Map<Integer, Double>) allReadJKDataMap.get("jkNoAndValue");
						if (jkType.equals(jkType_A)) {
							if (jkNo != null && !"".equals(jkNo)) {
								Double valNow = jkNoAndValueMap.get(Integer.parseInt(jkNo));
								
								//判断保留几位小数
								int digitNumber = digitNumberByHeatMeterAndName(heatMeter, name);
								if(digitNumber == 0){ //0代表int类型
									if(valNow != null){
										mapObj.put(name, (int)valNow.doubleValue());
										break;
									}
								}else if(digitNumber == 2){ //double 保留2位
									mapObj.put(name, parseDouble(valNow, 2));
									break;
								}else if(digitNumber == 4){ //double 保留4位
									mapObj.put(name, parseDouble(valNow, 4));
									break;
								}else if(digitNumber == -1){ //String类型
									mapObj.put(name, valNow.toString());
									break;
								}else if(digitNumber == -2){ //状态值 0 或 1
									if(valNow == null){
										mapObj.put(name, 0);
									}else{
										mapObj.put(name, ((int)valNow.doubleValue()) == 0 ? ((int)valNow.doubleValue()) : 1);
										break;
									}
								}
							}
						}
					}
				}
			}
		}

		//如果数据不为空，则添加到list中.
		if (mapObj != null && !mapObj.isEmpty() && mapObj.size() > 0) { 
			dataList.add(mapObj);
		}
		return dataList;
	}

	//根据url和json格式的数据开始上传
	public String uploadDataByUrlAndJsonData(String urlStr, String jsonData) {

		// 设定连接的相关参数
		HttpURLConnection connection = null;
		String strResponse = "";
		BufferedReader reader = null;

		try {
			// 服务地址
			URL url = new URL(urlStr);

			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(30 * 1000);
			connection.setReadTimeout(30 * 1000);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			connection.setRequestProperty("Connection", "close");

			// 输出上传数据
			OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
			output.write(jsonData);
			output.flush();
			output.close();

			// 获取服务端的反馈
			String strLine = "";
			int statusCode = connection.getResponseCode();
			if (statusCode == 200) {
				InputStream in = connection.getInputStream();
				reader = new BufferedReader(new InputStreamReader(in));
				while ((strLine = reader.readLine()) != null) {
					strResponse += strLine + "\n";
				}
				strResponse = strResponse.trim();
			}else{
				InputStream in = connection.getInputStream();
				reader = new BufferedReader(new InputStreamReader(in));
				while ((strLine = reader.readLine()) != null) {
					strResponse += strLine + "\n";
				}
				strResponse = strResponse.trim();
			}
			
			//logger.info("接口地址：" + url);
			//logger.info("上传的json数据：" + jsonData);
			//logger.info("响应据：" + strResponse);
			
			/*System.out.println("接口地址：" + url);
			System.out.println("上传的json数据：" + jsonData);
			System.out.println("响应据：" + strResponse);*/
		} catch (ConnectException e) {
			//logger.info(urlStr + "：接口地址连接超时。");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
			}
			try {
				connection.disconnect();
			} catch (Exception e) {
			}
		}
		return "success";
	}

	// 根据 供热仪表名称判断url地址
	public String getUrlByHeatMeter(String heatMeter) {
		String url = null;
		Map<String, String> allUrl = getAllUrl();
		for (String key : allUrl.keySet()) {
			if (heatMeter.contains(key)) {
				url = allUrl.get(key);
			}
		}
		return url;
	}

	// 获取所有正式的接口
	public Map<String, String> getAllUrl() {
		Map<String, String> map = new HashMap<>();
		map.put("heatmeter", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/consuming/heatmeter/");
		map.put("watermeter", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/consuming/watermeter/");
		map.put("ammeter", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/consuming/ammeter/");
		map.put("gasmemter", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/consuming/gasmeter/");
		map.put("tempmeter", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/consuming/tempmeter/");
		map.put("heatsource", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/running/heatsource/");
		map.put("boiler", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/running/boiler/");
		map.put("tranheating", "http://hbgrbhnm.zoomkey.com.cn:30057/spi/running/tranheating/");
		return map;
	}
	
	//所有测试接口
	public Map<String, String> getAllUrlTest(){
		Map<String, String> map = new HashMap<>();
		map.put("heatmeter", "http://47.93.172.107:30058/spi/consuming/heatmeter/");
		map.put("watermeter", "http://47.93.172.107:30058/spi/consuming/watermeter/");
		map.put("ammeter", "http://47.93.172.107:30058/spi/consuming/ammeter/");
		map.put("gasmemter", "http://47.93.172.107:30058/spi/consuming/gasmeter/");
		map.put("tempmeter", "http://47.93.172.107:30058/spi/consuming/tempmeter/");
		map.put("heatsource", "http://47.93.172.107:30058/spi/running/heatsource/");
		map.put("boiler", "http://47.93.172.107:30058/spi/running/boiler/");
		map.put("tranheating", "http://47.93.172.107:30058/spi/running/tranheating/");
		return map;
	}
	
	
	
	
	
	/**
	 * 根据供热仪表和字段名称获取保留几位小数或者是什么数据类型
	 * 0：int类型，2：double类型小数点后面保留2位，4：double类型小数点后面保留4位
	 * -1：字符串类型, -2：工作状态只值只能是0或1
	 * @author 作者:小郝
	 * @version 创建时间:2017年10月31日
	 * @param heatMeter
	 * @param name
	 * @return
	 */
	public int digitNumberByHeatMeterAndName(String heatMeter,String name){
		name = name.trim(); heatMeter = heatMeter.trim();
		if(heatMeter.contains("heatmeter")){//热量表抄表
			if("workStatus,workTime,".contains(name + ",")){
				return 0;
			}else if("inTemp,outTemp,tempDiff,".contains(name + ",")){
				return 2;
			}else if("accHeat,accCold,power,flow,accFlow,".contains(name + ",")){
				return 4;
			}else if("meterNo,installAddr,heatUnit,coldUnit,powerUnit,accFlowUnit,flowUnit,".contains(name + ",")){
				return -1;
			}else if("workStatus,".contains(name + ",")){
				return -2;
			}
		}else if(heatMeter.contains("watermeter")){
			if("".contains(name + ",")){
				return 0;
			}else if("".contains(name + ",")){
				return 2;
			}else if("accFlow,flow,".contains(name + ",")){
				return 4;
			}else if("readTime,meterNo,installAddr,".contains(name + ",")){
				return -1;
			}else if("workStatus,".contains(name + ",")){
				return -2;
			}
		}else if(heatMeter.contains("ammeter")){
			if("accReading".contains(name + ",")){
				return 4;
			}else if("readTime,meterNo,installAddr,".contains(name + ",")){
				return -1;
			}else if("workStatus,".contains(name + ",")){
				return -2;
			}
		}else if(heatMeter.contains("gasmemter")){
			if("accReading,temp,pressure,flow,".contains(name + ",")){
				return 4;
			}else if("readTime,meterNo,installAddr,".contains(name + ",")){
				return -1;
			}else if("workStatus,".contains(name + ",")){
				return -2;
			}
		}else if(heatMeter.contains("tempmeter")){
			if("accReading,lastPower,signalStrength".contains(name + ",")){
				return 2;
			}else if("readTime,meterNo,areaName,buildingNo,houseNo,roomNo,".contains(name + ",")){
				return -1;
			}else if("workStatus,".contains(name + ",")){
				return -2;
			}
		}else if(heatMeter.contains("heatsource")){
			if("buWaterValve,oneNetInValve".contains(name + ",")){
				return 0;
			}else if("outDoorTemp,oneNetInTemp,oneNetOutTemp,mainfoldInTemp,mainfoldOutTemp,".contains(name + ",")){
				return 2;
			}else if("buWaterPressure,oneNetInPressure,oneNetInFlow,oneNetOutPressure,oneNetOutFlow,mainfoldInPressure,mainfoldInFlow,mainfoldOutPressure,mainfoldOutFlow,oneBuWaterPump1,oneBuWaterPump2,oneWaterBoxYeWei,".contains(name + ",")){
				return 4;
			}else if("readTime,".contains(name + ",")){
				return -1;
			}else if("oneBuWaterPump1Status,oneBuWaterPump2Status,".contains(name + ",")){
				return -2;
			}
		}else if(heatMeter.contains("boiler")){
			if("economizerOxygen,".contains(name + ",")){
				return 0;
			}else if("oneNetInTemp,oneNetOutTemp,hearthTemp,economizerTemp,".contains(name + ",")){
				return 2;
			}else if("oneNetInPressure,oneNetInFlow,oneNetOutPressure,oneNetOutFlow,hearthPressure,fuelGasInstantPressure,fuelGasInstantFlow,fuelGasTotalPressure,fuelGasTotalFlow,".contains(name + ",")){
				return 4;
			}else if("readTime,".contains(name + ",")){
				return -1;
			}
		}else if(heatMeter.contains("tranheating")){
			if("buWaterValve,oneNetInValve,".contains(name + ",")){
				return 0;
			}else if("outDoorTemp,oneNetInTemp,oneNetOutTemp,twoNetInTemp,twoNetOutTemp,".contains(name + ",")){
				return 2;
			}else if("buWaterPressure,oneNetInPressure,oneNetInFlow,oneNetOutPressure,oneNetOutFlow,twoNetInPressure,twoNetInFlow,twoNetOutPressure,twoNetOutFlow,oneBuWaterPump1,oneBuWaterPump2,oneWaterBoxYeWei,twoLoopPump1,twoLoopPump2,twoBuWaterPump1,twoBuWaterPump2,twoNetSecondPump1,twoBuWaterYeWei,".contains(name + ",")){
				return 4;
			}else if("readTime,".contains(name + ",")){
				return -1;
			}else if("oneBuWaterPump1Status,oneBuWaterPump2Status,twoLoopPump1Status,twoLoopPump2Status,twoBuWaterPump1Status,twoBuWaterPump2Status,twoNetSecondPump1Status,".contains(name + ",")){
				return -2;
			}
		}
		return 0;
	}
	
	/**
	 * 根据double值和指定的保留位置截取double值
	 * @author 作者:小郝
	 * @param dValue 值
	 * @param n		指定位数
	 * @return
	 */
	public double parseDouble(Double dValue, int n) {
		double formatValue = 0.0;
		if(dValue == null || "".equals(dValue)){
			return formatValue;
		}
		String plainString = new BigDecimal(dValue).toPlainString();
		
		if (plainString.length() - plainString.indexOf(".") < n) {
			formatValue = dValue;
		} else {
			String subValue = plainString.substring(0, plainString.indexOf(".") + n);
			formatValue = Double.parseDouble(subValue);
		}
		return formatValue;
	}
	
	

}
