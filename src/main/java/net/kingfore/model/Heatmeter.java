/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 *热量表抄表
 * 
 * @author JF_Hao
 *
 */
public class Heatmeter {

	private String readTime;
	private String workStatus;
	private String meterNo;
	private String installAddr;
	private double accHeat;
	private double accCold;
	private double power;
	private double flow;
	private double accFlow;
	private double inTemp;
	private double outTemp;
	private double tempDiff;
	private int workTime;
	private String heatUnit;
	private String coldUnit;
	private String powerUnit;
	private String accFlowUnit;
	private String flowUnit;
	

	public Heatmeter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heatmeter(String readTime, String workStatus, String meterNo, String installAddr, double accHeat,
			double accCold, double power, double flow, double accFlow, double inTemp, double outTemp, double tempDiff,
			int workTime, String heatUnit, String coldUnit, String powerUnit, String accFlowUnit, String flowUnit) {
		super();
		this.readTime = readTime;
		this.workStatus = workStatus;
		this.meterNo = meterNo;
		this.installAddr = installAddr;
		this.accHeat = accHeat;
		this.accCold = accCold;
		this.power = power;
		this.flow = flow;
		this.accFlow = accFlow;
		this.inTemp = inTemp;
		this.outTemp = outTemp;
		this.tempDiff = tempDiff;
		this.workTime = workTime;
		this.heatUnit = heatUnit;
		this.coldUnit = coldUnit;
		this.powerUnit = powerUnit;
		this.accFlowUnit = accFlowUnit;
		this.flowUnit = flowUnit;
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

	public double getAccHeat() {
		return accHeat;
	}

	public void setAccHeat(double accHeat) {
		this.accHeat = accHeat;
	}

	public double getAccCold() {
		return accCold;
	}

	public void setAccCold(double accCold) {
		this.accCold = accCold;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public double getAccFlow() {
		return accFlow;
	}

	public void setAccFlow(double accFlow) {
		this.accFlow = accFlow;
	}

	public double getInTemp() {
		return inTemp;
	}

	public void setInTemp(double inTemp) {
		this.inTemp = inTemp;
	}

	public double getOutTemp() {
		return outTemp;
	}

	public void setOutTemp(double outTemp) {
		this.outTemp = outTemp;
	}

	public double getTempDiff() {
		return tempDiff;
	}

	public void setTempDiff(double tempDiff) {
		this.tempDiff = tempDiff;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public String getHeatUnit() {
		return heatUnit;
	}

	public void setHeatUnit(String heatUnit) {
		this.heatUnit = heatUnit;
	}

	public String getColdUnit() {
		return coldUnit;
	}

	public void setColdUnit(String coldUnit) {
		this.coldUnit = coldUnit;
	}

	public String getPowerUnit() {
		return powerUnit;
	}

	public void setPowerUnit(String powerUnit) {
		this.powerUnit = powerUnit;
	}

	public String getAccFlowUnit() {
		return accFlowUnit;
	}

	public void setAccFlowUnit(String accFlowUnit) {
		this.accFlowUnit = accFlowUnit;
	}

	public String getFlowUnit() {
		return flowUnit;
	}

	public void setFlowUnit(String flowUnit) {
		this.flowUnit = flowUnit;
	}

}
