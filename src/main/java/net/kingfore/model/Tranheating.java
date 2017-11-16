/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 换热站
 * 
 * @author JF_Hao
 *
 */
public class Tranheating {

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
	private double twoNetInTemp;
	private double twoNetInPressure;
	private double twoNetInFlow;
	private double twoNetOutTemp;
	private double twoNetOutPressure;
	private double twoNetOutFlow;
	private double oneBuWaterPump1;

	private String oneBuWaterPump1Status;
	private double oneBuWaterPump2;
	private String oneBuWaterPump2Status;
	private double oneWaterBoxYeWei;
	private double oneNetInValve;
	private double twoLoopPump1;
	private String twoLoopPump1Status;
	private double twoLoopPump2;
	private String twoLoopPump2Status;
	private double twoBuWaterPump1;
	private String twoBuWaterPump1Status;
	private double twoBuWaterPump2;
	private String twoBuWaterPump2Status;
	private double twoNetSecondPump1;
	private String twoNetSecondPump1Status;
	private double twoBuWaterYeWei;

	public Tranheating(String readTime, double outDoorTemp, double buWaterPressure, double buWaterValve,
			double oneNetInTemp, double oneNetInPressure, double oneNetInFlow, double oneNetOutTemp,
			double oneNetOutPressure, double oneNetOutFlow, double twoNetInTemp, double twoNetInPressure,
			double twoNetInFlow, double twoNetOutTemp, double twoNetOutPressure, double twoNetOutFlow,
			double oneBuWaterPump1, String oneBuWaterPump1Status, double oneBuWaterPump2, String oneBuWaterPump2Status,
			double oneWaterBoxYeWei, double oneNetInValve, double twoLoopPump1, String twoLoopPump1Status,
			double twoLoopPump2, String twoLoopPump2Status, double twoBuWaterPump1, String twoBuWaterPump1Status,
			double twoBuWaterPump2, String twoBuWaterPump2Status, double twoNetSecondPump1,
			String twoNetSecondPump1Status, double twoBuWaterYeWei) {
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
		this.twoNetInTemp = twoNetInTemp;
		this.twoNetInPressure = twoNetInPressure;
		this.twoNetInFlow = twoNetInFlow;
		this.twoNetOutTemp = twoNetOutTemp;
		this.twoNetOutPressure = twoNetOutPressure;
		this.twoNetOutFlow = twoNetOutFlow;
		this.oneBuWaterPump1 = oneBuWaterPump1;
		this.oneBuWaterPump1Status = oneBuWaterPump1Status;
		this.oneBuWaterPump2 = oneBuWaterPump2;
		this.oneBuWaterPump2Status = oneBuWaterPump2Status;
		this.oneWaterBoxYeWei = oneWaterBoxYeWei;
		this.oneNetInValve = oneNetInValve;
		this.twoLoopPump1 = twoLoopPump1;
		this.twoLoopPump1Status = twoLoopPump1Status;
		this.twoLoopPump2 = twoLoopPump2;
		this.twoLoopPump2Status = twoLoopPump2Status;
		this.twoBuWaterPump1 = twoBuWaterPump1;
		this.twoBuWaterPump1Status = twoBuWaterPump1Status;
		this.twoBuWaterPump2 = twoBuWaterPump2;
		this.twoBuWaterPump2Status = twoBuWaterPump2Status;
		this.twoNetSecondPump1 = twoNetSecondPump1;
		this.twoNetSecondPump1Status = twoNetSecondPump1Status;
		this.twoBuWaterYeWei = twoBuWaterYeWei;
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

	public double getTwoNetInTemp() {
		return twoNetInTemp;
	}

	public void setTwoNetInTemp(double twoNetInTemp) {
		this.twoNetInTemp = twoNetInTemp;
	}

	public double getTwoNetInPressure() {
		return twoNetInPressure;
	}

	public void setTwoNetInPressure(double twoNetInPressure) {
		this.twoNetInPressure = twoNetInPressure;
	}

	public double getTwoNetInFlow() {
		return twoNetInFlow;
	}

	public void setTwoNetInFlow(double twoNetInFlow) {
		this.twoNetInFlow = twoNetInFlow;
	}

	public double getTwoNetOutTemp() {
		return twoNetOutTemp;
	}

	public void setTwoNetOutTemp(double twoNetOutTemp) {
		this.twoNetOutTemp = twoNetOutTemp;
	}

	public double getTwoNetOutPressure() {
		return twoNetOutPressure;
	}

	public void setTwoNetOutPressure(double twoNetOutPressure) {
		this.twoNetOutPressure = twoNetOutPressure;
	}

	public double getTwoNetOutFlow() {
		return twoNetOutFlow;
	}

	public void setTwoNetOutFlow(double twoNetOutFlow) {
		this.twoNetOutFlow = twoNetOutFlow;
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

	public double getTwoLoopPump1() {
		return twoLoopPump1;
	}

	public void setTwoLoopPump1(double twoLoopPump1) {
		this.twoLoopPump1 = twoLoopPump1;
	}

	public String getTwoLoopPump1Status() {
		return twoLoopPump1Status;
	}

	public void setTwoLoopPump1Status(String twoLoopPump1Status) {
		this.twoLoopPump1Status = twoLoopPump1Status;
	}

	public double getTwoLoopPump2() {
		return twoLoopPump2;
	}

	public void setTwoLoopPump2(double twoLoopPump2) {
		this.twoLoopPump2 = twoLoopPump2;
	}

	public String getTwoLoopPump2Status() {
		return twoLoopPump2Status;
	}

	public void setTwoLoopPump2Status(String twoLoopPump2Status) {
		this.twoLoopPump2Status = twoLoopPump2Status;
	}

	public double getTwoBuWaterPump1() {
		return twoBuWaterPump1;
	}

	public void setTwoBuWaterPump1(double twoBuWaterPump1) {
		this.twoBuWaterPump1 = twoBuWaterPump1;
	}

	public String getTwoBuWaterPump1Status() {
		return twoBuWaterPump1Status;
	}

	public void setTwoBuWaterPump1Status(String twoBuWaterPump1Status) {
		this.twoBuWaterPump1Status = twoBuWaterPump1Status;
	}

	public double getTwoBuWaterPump2() {
		return twoBuWaterPump2;
	}

	public void setTwoBuWaterPump2(double twoBuWaterPump2) {
		this.twoBuWaterPump2 = twoBuWaterPump2;
	}

	public String getTwoBuWaterPump2Status() {
		return twoBuWaterPump2Status;
	}

	public void setTwoBuWaterPump2Status(String twoBuWaterPump2Status) {
		this.twoBuWaterPump2Status = twoBuWaterPump2Status;
	}

	public double getTwoNetSecondPump1() {
		return twoNetSecondPump1;
	}

	public void setTwoNetSecondPump1(double twoNetSecondPump1) {
		this.twoNetSecondPump1 = twoNetSecondPump1;
	}

	public String getTwoNetSecondPump1Status() {
		return twoNetSecondPump1Status;
	}

	public void setTwoNetSecondPump1Status(String twoNetSecondPump1Status) {
		this.twoNetSecondPump1Status = twoNetSecondPump1Status;
	}

	public double getTwoBuWaterYeWei() {
		return twoBuWaterYeWei;
	}

	public void setTwoBuWaterYeWei(double twoBuWaterYeWei) {
		this.twoBuWaterYeWei = twoBuWaterYeWei;
	}

}
