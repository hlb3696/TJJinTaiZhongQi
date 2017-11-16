/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 电表抄表
 * @author JF_Hao
 *
 */
public class Ammeter {

	private String readTime;
	private String workStatus;
	private String meterNo;
	private String installAddr;
	private double accReading;
	
	

	public Ammeter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ammeter(String readTime, String workStatus, String meterNo, String installAddr, double accReading) {
		super();
		this.readTime = readTime;
		this.workStatus = workStatus;
		this.meterNo = meterNo;
		this.installAddr = installAddr;
		this.accReading = accReading;
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

	public String getInstallAddr() {
		return installAddr;
	}

	public void setInstallAddr(String installAddr) {
		this.installAddr = installAddr;
	}

	public double getAccReading() {
		return accReading;
	}

	public void setAccReading(double accReading) {
		this.accReading = accReading;
	}

}
