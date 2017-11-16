/**
 * 2017年10月30日
 */
package net.kingfore.model;

/**
 * @author JF_Hao
 *
 */
public class ExcelObj {

	public String stationNo;

	public String heatMeter;

	public String name;

	public String jkNo;

	public String jkType;

	public String value;

	public ExcelObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExcelObj(String stationNo, String heatMeter, String name, String jkNo, String jkType, String value) {
		super();
		this.stationNo = stationNo;
		this.heatMeter = heatMeter;
		this.name = name;
		this.jkNo = jkNo;
		this.jkType = jkType;
		this.value = value;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getHeatMeter() {
		return heatMeter;
	}

	public void setHeatMeter(String heatMeter) {
		this.heatMeter = heatMeter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJkNo() {
		return jkNo;
	}

	public void setJkNo(String jkNo) {
		this.jkNo = jkNo;
	}

	public String getJkType() {
		return jkType;
	}

	public void setJkType(String jkType) {
		this.jkType = jkType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ExcelObj [stationNo=" + stationNo + ", heatMeter=" + heatMeter + ", name=" + name + ", jkNo=" + jkNo
				+ ", jkType=" + jkType + ", value=" + value + "]";
	}

}
