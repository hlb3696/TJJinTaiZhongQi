/**
 * 2017年10月27日
 */
package net.kingfore.model;

/**
 * 锅炉
 * 
 * @author JF_Hao
 *
 */
public class Boiler {

	private String readTime;
	private double oneNetInTemp;
	private double oneNetInPressure;
	private double oneNetInFlow;
	private double oneNetOutTemp;
	private double oneNetOutPressure;
	private double oneNetOutFlow;
	private double hearthTemp;
	private double hearthPressure;
	private double fuelGasInstantPressure;
	private double fuelGasInstantFlow;
	private double fuelGasTotalPressure;
	private double fuelGasTotalFlow;
	private double economizerTemp;
	private double economizerOxygen;

	public Boiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boiler(String readTime, double oneNetInTemp, double oneNetInPressure, double oneNetInFlow,
			double oneNetOutTemp, double oneNetOutPressure, double oneNetOutFlow, double hearthTemp,
			double hearthPressure, double fuelGasInstantPressure, double fuelGasInstantFlow,
			double fuelGasTotalPressure, double fuelGasTotalFlow, double economizerTemp, double economizerOxygen) {
		super();
		this.readTime = readTime;
		this.oneNetInTemp = oneNetInTemp;
		this.oneNetInPressure = oneNetInPressure;
		this.oneNetInFlow = oneNetInFlow;
		this.oneNetOutTemp = oneNetOutTemp;
		this.oneNetOutPressure = oneNetOutPressure;
		this.oneNetOutFlow = oneNetOutFlow;
		this.hearthTemp = hearthTemp;
		this.hearthPressure = hearthPressure;
		this.fuelGasInstantPressure = fuelGasInstantPressure;
		this.fuelGasInstantFlow = fuelGasInstantFlow;
		this.fuelGasTotalPressure = fuelGasTotalPressure;
		this.fuelGasTotalFlow = fuelGasTotalFlow;
		this.economizerTemp = economizerTemp;
		this.economizerOxygen = economizerOxygen;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
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

	public double getHearthTemp() {
		return hearthTemp;
	}

	public void setHearthTemp(double hearthTemp) {
		this.hearthTemp = hearthTemp;
	}

	public double getHearthPressure() {
		return hearthPressure;
	}

	public void setHearthPressure(double hearthPressure) {
		this.hearthPressure = hearthPressure;
	}

	public double getFuelGasInstantPressure() {
		return fuelGasInstantPressure;
	}

	public void setFuelGasInstantPressure(double fuelGasInstantPressure) {
		this.fuelGasInstantPressure = fuelGasInstantPressure;
	}

	public double getFuelGasInstantFlow() {
		return fuelGasInstantFlow;
	}

	public void setFuelGasInstantFlow(double fuelGasInstantFlow) {
		this.fuelGasInstantFlow = fuelGasInstantFlow;
	}

	public double getFuelGasTotalPressure() {
		return fuelGasTotalPressure;
	}

	public void setFuelGasTotalPressure(double fuelGasTotalPressure) {
		this.fuelGasTotalPressure = fuelGasTotalPressure;
	}

	public double getFuelGasTotalFlow() {
		return fuelGasTotalFlow;
	}

	public void setFuelGasTotalFlow(double fuelGasTotalFlow) {
		this.fuelGasTotalFlow = fuelGasTotalFlow;
	}

	public double getEconomizerTemp() {
		return economizerTemp;
	}

	public void setEconomizerTemp(double economizerTemp) {
		this.economizerTemp = economizerTemp;
	}

	public double getEconomizerOxygen() {
		return economizerOxygen;
	}

	public void setEconomizerOxygen(double economizerOxygen) {
		this.economizerOxygen = economizerOxygen;
	}

}
