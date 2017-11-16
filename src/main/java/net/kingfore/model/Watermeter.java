/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 水表抄表
 * 
 * @author JF_Hao
 *
 */
public class Watermeter {

	private String readTime;
	private String workStatus;
	private String meterNo;
	private String installAddr;
	private double accFlow;
	private double flow;

	public Watermeter(String readTime, String workStatus, String meterNo, String installAddr, double accFlow,
			double flow) {
		super();
		this.readTime = readTime;
		this.workStatus = workStatus;
		this.meterNo = meterNo;
		this.installAddr = installAddr;
		this.accFlow = accFlow;
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

	public double getAccFlow() {
		return accFlow;
	}

	public void setAccFlow(double accFlow) {
		this.accFlow = accFlow;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

}
