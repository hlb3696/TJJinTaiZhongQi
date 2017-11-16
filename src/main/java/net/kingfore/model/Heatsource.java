/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 热源
 * 
 * @author JF_Hao
 *
 */
public class Heatsource {

	private String readTime;
	private double outDoorTemp;
	private double buWaterPressure;
	private double buWaterValve;
	private double oneNetInTemp;
	private double oneNetInPressure;
	private double oneNetInFlow;
	private double oneNetOutTemp;
	private double oneNetOutPressure;
	private double oneNetOutFlow;
	private double mainfoldInTemp;
	private double mainfoldInPressure;
	private double mainfoldInFlow;
	private double mainfoldOutTemp;
	private double mainfoldOutPressure;
	private double mainfoldOutFlow;

	private double oneBuWaterPump1;
	private String oneBuWaterPump1Status;
	private double oneBuWaterPump2;
	private String oneBuWaterPump2Status;
	private double oneWaterBoxYeWei;
	private double oneNetInValve;

	public Heatsource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heatsource(String readTime, double outDoorTemp, double buWaterPressure, double buWaterValve,
			double oneNetInTemp, double oneNetInPressure, double oneNetInFlow, double oneNetOutTemp,
			double oneNetOutPressure, double oneNetOutFlow, double mainfoldInTemp, double mainfoldInPressure,
			double mainfoldInFlow, double mainfoldOutTemp, double mainfoldOutPressure, double mainfoldOutFlow,
			double oneBuWaterPump1, String oneBuWaterPump1Status, double oneBuWaterPump2, String oneBuWaterPump2Status,
			double oneWaterBoxYeWei, double oneNetInValve) {
		super();
		this.readTime = readTime;
		this.outDoorTemp = outDoorTemp;
		this.buWaterPressure = buWaterPressure;
		this.buWaterValve = buWaterValve;
		this.oneNetInTemp = oneNetInTemp;
		this.oneNetInPressure = oneNetInPressure;
		this.oneNetInFlow = oneNetInFlow;
		this.oneNetOutTemp = oneNetOutTemp;
		this.oneNetOutPressure = oneNetOutPressure;
		this.oneNetOutFlow = oneNetOutFlow;
		this.mainfoldInTemp = mainfoldInTemp;
		this.mainfoldInPressure = mainfoldInPressure;
		this.mainfoldInFlow = mainfoldInFlow;
		this.mainfoldOutTemp = mainfoldOutTemp;
		this.mainfoldOutPressure = mainfoldOutPressure;
		this.mainfoldOutFlow = mainfoldOutFlow;
		this.oneBuWaterPump1 = oneBuWaterPump1;
		this.oneBuWaterPump1Status = oneBuWaterPump1Status;
		this.oneBuWaterPump2 = oneBuWaterPump2;
		this.oneBuWaterPump2Status = oneBuWaterPump2Status;
		this.oneWaterBoxYeWei = oneWaterBoxYeWei;
		this.oneNetInValve = oneNetInValve;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public double getOutDoorTemp() {
		return outDoorTemp;
	}

	public void setOutDoorTemp(double outDoorTemp) {
		this.outDoorTemp = outDoorTemp;
	}

	public double getBuWaterPressure() {
		return buWaterPressure;
	}

	public void setBuWaterPressure(double buWaterPressure) {
		this.buWaterPressure = buWaterPressure;
	}

	public double getBuWaterValve() {
		return buWaterValve;
	}

	public void setBuWaterValve(double buWaterValve) {
		this.buWaterValve = buWaterValve;
	}

	public double getOneNetInTemp() {
		return oneNetInTemp;
	}

	public void setOneNetInTemp(double oneNetInTemp) {
		this.oneNetInTemp = oneNetInTemp;
	}

	public double getOneNetInPressure() {
		return oneNetInPressure;
	}

	public void setOneNetInPressure(double oneNetInPressure) {
		this.oneNetInPressure = oneNetInPressure;
	}

	public double getOneNetInFlow() {
		return oneNetInFlow;
	}

	public void setOneNetInFlow(double oneNetInFlow) {
		this.oneNetInFlow = oneNetInFlow;
	}

	public double getOneNetOutTemp() {
		return oneNetOutTemp;
	}

	public void setOneNetOutTemp(double oneNetOutTemp) {
		this.oneNetOutTemp = oneNetOutTemp;
	}

	public double getOneNetOutPressure() {
		return oneNetOutPressure;
	}

	public void setOneNetOutPressure(double oneNetOutPressure) {
		this.oneNetOutPressure = oneNetOutPressure;
	}

	public double getOneNetOutFlow() {
		return oneNetOutFlow;
	}

	public void setOneNetOutFlow(double oneNetOutFlow) {
		this.oneNetOutFlow = oneNetOutFlow;
	}

	public double getMainfoldInTemp() {
		return mainfoldInTemp;
	}

	public void setMainfoldInTemp(double mainfoldInTemp) {
		this.mainfoldInTemp = mainfoldInTemp;
	}

	public double getMainfoldInPressure() {
		return mainfoldInPressure;
	}

	public void setMainfoldInPressure(double mainfoldInPressure) {
		this.mainfoldInPressure = mainfoldInPressure;
	}

	public double getMainfoldInFlow() {
		return mainfoldInFlow;
	}

	public void setMainfoldInFlow(double mainfoldInFlow) {
		this.mainfoldInFlow = mainfoldInFlow;
	}

	public double getMainfoldOutTemp() {
		return mainfoldOutTemp;
	}

	public void setMainfoldOutTemp(double mainfoldOutTemp) {
		this.mainfoldOutTemp = mainfoldOutTemp;
	}

	public double getMainfoldOutPressure() {
		return mainfoldOutPressure;
	}

	public void setMainfoldOutPressure(double mainfoldOutPressure) {
		this.mainfoldOutPressure = mainfoldOutPressure;
	}

	public double getMainfoldOutFlow() {
		return mainfoldOutFlow;
	}

	public void setMainfoldOutFlow(double mainfoldOutFlow) {
		this.mainfoldOutFlow = mainfoldOutFlow;
	}

	public double getOneBuWaterPump1() {
		return oneBuWaterPump1;
	}

	public void setOneBuWaterPump1(double oneBuWaterPump1) {
		this.oneBuWaterPump1 = oneBuWaterPump1;
	}

	public String getOneBuWaterPump1Status() {
		return oneBuWaterPump1Status;
	}

	public void setOneBuWaterPump1Status(String oneBuWaterPump1Status) {
		this.oneBuWaterPump1Status = oneBuWaterPump1Status;
	}

	public double getOneBuWaterPump2() {
		return oneBuWaterPump2;
	}

	public void setOneBuWaterPump2(double oneBuWaterPump2) {
		this.oneBuWaterPump2 = oneBuWaterPump2;
	}

	public String getOneBuWaterPump2Status() {
		return oneBuWaterPump2Status;
	}

	public void setOneBuWaterPump2Status(String oneBuWaterPump2Status) {
		this.oneBuWaterPump2Status = oneBuWaterPump2Status;
	}

	public double getOneWaterBoxYeWei() {
		return oneWaterBoxYeWei;
	}

	public void setOneWaterBoxYeWei(double oneWaterBoxYeWei) {
		this.oneWaterBoxYeWei = oneWaterBoxYeWei;
	}

	public double getOneNetInValve() {
		return oneNetInValve;
	}

	public void setOneNetInValve(double oneNetInValve) {
		this.oneNetInValve = oneNetInValve;
	}

}
