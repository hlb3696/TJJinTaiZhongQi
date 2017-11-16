/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 燃气表抄表
 * 
 * @author JF_Hao
 */
public class Gasmemter {

	private String readTime;
	private String workStatus;
	private String meterNo;
	private String installAddr;
	private double accReading;
	private double temp;
	private double pressure;
	private double flow;

	public Gasmemter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gasmemter(String readTime, String workStatus, String meterNo, String installAddr, double accReading,
			double temp, double pressure, double flow) {
		super();
		this.readTime = readTime;
		this.workStatus = workStatus;
		this.meterNo = meterNo;
		this.installAddr = installAddr;
		this.accReading = accReading;
		this.temp = temp;
		this.pressure = pressure;
		this.flow = flow;
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

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

}
