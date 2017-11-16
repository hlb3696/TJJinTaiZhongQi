/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 测温表抄
 * @author JF_Hao
 *
 */
public class Tempmeter {

	private String readTime;
	private String workStatus;
	private String meterNo;
	private String areaName;
	private String buildingNo;
	private String houseNo;
	private String roomNo;
	private double accReading;
	private double lastPower;
	private double signalStrength;

	public Tempmeter(String readTime, String workStatus, String meterNo, String areaName, String buildingNo,
			String houseNo, String roomNo, double accReading, double lastPower, double signalStrength) {
		super();
		this.readTime = readTime;
		this.workStatus = workStatus;
		this.meterNo = meterNo;
		this.areaName = areaName;
		this.buildingNo = buildingNo;
		this.houseNo = houseNo;
		this.roomNo = roomNo;
		this.accReading = accReading;
		this.lastPower = lastPower;
		this.signalStrength = signalStrength;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public double getAccReading() {
		return accReading;
	}

	public void setAccReading(double accReading) {
		this.accReading = accReading;
	}

	public double getLastPower() {
		return lastPower;
	}

	public void setLastPower(double lastPower) {
		this.lastPower = lastPower;
	}

	public double getSignalStrength() {
		return signalStrength;
	}

	public void setSignalStrength(double signalStrength) {
		this.signalStrength = signalStrength;
	}

}
