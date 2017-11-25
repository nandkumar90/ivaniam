package com.arial.ivanium.dto;

public class CimarexEnergy {
	private int id;
	private String ticker;
	private int year;
	private double DilutedEPSexExtraordinaryItems;
	private double OperatingCFPS;
	private double EBITDA;
	private double EnterpriseValueYearEnd;
	private double MarketCapYearEnd;
	private double AvgSharesOut;
	private double PxFYE;
	private double NetDebt;
	private double BVPS;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getDilutedEPSexExtraordinaryItems() {
		return DilutedEPSexExtraordinaryItems;
	}

	public void setDilutedEPSexExtraordinaryItems(double dilutedEPSexExtraordinaryItems) {
		DilutedEPSexExtraordinaryItems = dilutedEPSexExtraordinaryItems;
	}

	public double getOperatingCFPS() {
		return OperatingCFPS;
	}

	public void setOperatingCFPS(double operatingCFPS) {
		OperatingCFPS = operatingCFPS;
	}

	public double getEBITDA() {
		return EBITDA;
	}

	public void setEBITDA(double eBITDA) {
		EBITDA = eBITDA;
	}

	public double getEnterpriseValueYearEnd() {
		return EnterpriseValueYearEnd;
	}

	public void setEnterpriseValueYearEnd(double enterpriseValueYearEnd) {
		EnterpriseValueYearEnd = enterpriseValueYearEnd;
	}

	public double getMarketCapYearEnd() {
		return MarketCapYearEnd;
	}

	public void setMarketCapYearEnd(double marketCapYearEnd) {
		MarketCapYearEnd = marketCapYearEnd;
	}

	public double getAvgSharesOut() {
		return AvgSharesOut;
	}

	public void setAvgSharesOut(double avgSharesOut) {
		AvgSharesOut = avgSharesOut;
	}

	public double getPxFYE() {
		return PxFYE;
	}

	public void setPxFYE(double pxFYE) {
		PxFYE = pxFYE;
	}

	public double getNetDebt() {
		return NetDebt;
	}

	public void setNetDebt(double netDebt) {
		NetDebt = netDebt;
	}

	public double getBVPS() {
		return BVPS;
	}

	public void setBVPS(double bVPS) {
		BVPS = bVPS;
	}

}
