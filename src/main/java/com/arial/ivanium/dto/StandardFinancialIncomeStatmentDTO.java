package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "financial_income_statement")
public class StandardFinancialIncomeStatmentDTO {
	@Id
	@Column(name = " id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(name = "ticker")
	private String ticker;

	@Column(name = "statement")
	private String statement;

	@Column(name = "fiscal_Year")
	private String fiscal_year;

	@Column(name = "fiscal_Period")
	private String fiscal_period;

	@Column(name = "operatingrevenu")
	private String operatingrevenu;

	@Column(name = "otherrevenue")
	private String otherrevenue;

	@Column(name = "totalrevenue")
	private String totalrevenue;

	@Column(name = "operatingcostofrevenue")
	private String operatingcostofrevenue;

	@Column(name = "othercostofrevenue")
	private String othercostofrevenue;

	@Column(name = "totalcostofrevenue")
	private String totalcostofrevenue;

	@Column(name = "totalgrossprofit")
	private String totalgrossprofit;

	@Column(name = "sgaexpense")
	private String sgaexpense;

	@Column(name = "marketingexpense")
	private String marketingexpense;

	@Column(name = "explorationexpense")
	private String explorationexpense;

	@Column(name = "depreciationexpense")
	private String depreciationexpense;

	@Column(name = "impairmentexpense")
	private String impairmentexpense;

	@Column(name = "totaloperatingexpenses")
	private String totaloperatingexpenses;

	@Column(name = "totaloperatingincome")
	private String totaloperatingincome;

	@Column(name = "totalinterestexpense")
	private String totalinterestexpense;

	@Column(name = "otherincome")
	private String otherincome;

	@Column(name = "totalotherincome")
	private String totalotherincome;

	@Column(name = "totalpretaxincome")
	private String totalpretaxincome;

	@Column(name = "incometaxexpense")
	private String incometaxexpense;

	@Column(name = "netincomecontinuing")
	private String netincomecontinuing;

	@Column(name = "netincome")
	private String netincome;

	@Column(name = "netincometocommon")
	private String netincometocommon;

	@Column(name = "weightedavebasicsharesos")
	private String weightedavebasicsharesos;

	@Column(name = "basiceps")
	private String basiceps;

	@Column(name = "weightedavedilutedsharesos")
	private String weightedavedilutedsharesos;

	@Column(name = "dilutedeps")
	private String dilutedeps;

	@Column(name = "weightedavebasicdilutedsharesos")
	private String weightedavebasicdilutedsharesos;

	@Column(name = "basicdilutedeps")
	private String basicdilutedeps;

	@Column(name = "cashdividendspershare")
	private String cashdividendspershare;
	
	@Column(name = "otherspecialcharges")
	private String otherspecialcharges;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getFiscal_year() {
		return fiscal_year;
	}

	public void setFiscal_year(String fiscal_year) {
		this.fiscal_year = fiscal_year;
	}

	public String getFiscal_period() {
		return fiscal_period;
	}

	public void setFiscal_period(String fiscal_period) {
		this.fiscal_period = fiscal_period;
	}

	public String getOperatingrevenu() {
		return operatingrevenu;
	}

	public void setOperatingrevenu(String operatingrevenu) {
		this.operatingrevenu = operatingrevenu;
	}

	public String getOtherrevenue() {
		return otherrevenue;
	}

	public void setOtherrevenue(String otherrevenue) {
		this.otherrevenue = otherrevenue;
	}

	public String getTotalrevenue() {
		return totalrevenue;
	}

	public void setTotalrevenue(String totalrevenue) {
		this.totalrevenue = totalrevenue;
	}

	public String getOperatingcostofrevenue() {
		return operatingcostofrevenue;
	}

	public void setOperatingcostofrevenue(String operatingcostofrevenue) {
		this.operatingcostofrevenue = operatingcostofrevenue;
	}

	public String getOthercostofrevenue() {
		return othercostofrevenue;
	}

	public void setOthercostofrevenue(String othercostofrevenue) {
		this.othercostofrevenue = othercostofrevenue;
	}

	public String getTotalcostofrevenue() {
		return totalcostofrevenue;
	}

	public void setTotalcostofrevenue(String totalcostofrevenue) {
		this.totalcostofrevenue = totalcostofrevenue;
	}

	public String getTotalgrossprofit() {
		return totalgrossprofit;
	}

	public void setTotalgrossprofit(String totalgrossprofit) {
		this.totalgrossprofit = totalgrossprofit;
	}

	public String getSgaexpense() {
		return sgaexpense;
	}

	public void setSgaexpense(String sgaexpense) {
		this.sgaexpense = sgaexpense;
	}

	public String getMarketingexpense() {
		return marketingexpense;
	}

	public void setMarketingexpense(String marketingexpense) {
		this.marketingexpense = marketingexpense;
	}

	public String getExplorationexpense() {
		return explorationexpense;
	}

	public void setExplorationexpense(String explorationexpense) {
		this.explorationexpense = explorationexpense;
	}

	public String getDepreciationexpense() {
		return depreciationexpense;
	}

	public void setDepreciationexpense(String depreciationexpense) {
		this.depreciationexpense = depreciationexpense;
	}

	public String getImpairmentexpense() {
		return impairmentexpense;
	}

	public void setImpairmentexpense(String impairmentexpense) {
		this.impairmentexpense = impairmentexpense;
	}

	public String getTotaloperatingexpenses() {
		return totaloperatingexpenses;
	}

	public void setTotaloperatingexpenses(String totaloperatingexpenses) {
		this.totaloperatingexpenses = totaloperatingexpenses;
	}

	public String getTotaloperatingincome() {
		return totaloperatingincome;
	}

	public void setTotaloperatingincome(String totaloperatingincome) {
		this.totaloperatingincome = totaloperatingincome;
	}

	public String getTotalinterestexpense() {
		return totalinterestexpense;
	}

	public void setTotalinterestexpense(String totalinterestexpense) {
		this.totalinterestexpense = totalinterestexpense;
	}

	public String getOtherincome() {
		return otherincome;
	}

	public void setOtherincome(String otherincome) {
		this.otherincome = otherincome;
	}

	public String getTotalotherincome() {
		return totalotherincome;
	}

	public void setTotalotherincome(String totalotherincome) {
		this.totalotherincome = totalotherincome;
	}

	public String getTotalpretaxincome() {
		return totalpretaxincome;
	}

	public void setTotalpretaxincome(String totalpretaxincome) {
		this.totalpretaxincome = totalpretaxincome;
	}

	public String getIncometaxexpense() {
		return incometaxexpense;
	}

	public void setIncometaxexpense(String incometaxexpense) {
		this.incometaxexpense = incometaxexpense;
	}

	public String getNetincomecontinuing() {
		return netincomecontinuing;
	}

	public void setNetincomecontinuing(String netincomecontinuing) {
		this.netincomecontinuing = netincomecontinuing;
	}

	public String getNetincome() {
		return netincome;
	}

	public void setNetincome(String netincome) {
		this.netincome = netincome;
	}

	public String getNetincometocommon() {
		return netincometocommon;
	}

	public void setNetincometocommon(String netincometocommon) {
		this.netincometocommon = netincometocommon;
	}

	public String getWeightedavebasicsharesos() {
		return weightedavebasicsharesos;
	}

	public void setWeightedavebasicsharesos(String weightedavebasicsharesos) {
		this.weightedavebasicsharesos = weightedavebasicsharesos;
	}

	public String getBasiceps() {
		return basiceps;
	}

	public void setBasiceps(String basiceps) {
		this.basiceps = basiceps;
	}

	public String getWeightedavedilutedsharesos() {
		return weightedavedilutedsharesos;
	}

	public void setWeightedavedilutedsharesos(String weightedavedilutedsharesos) {
		this.weightedavedilutedsharesos = weightedavedilutedsharesos;
	}

	public String getDilutedeps() {
		return dilutedeps;
	}

	public void setDilutedeps(String dilutedeps) {
		this.dilutedeps = dilutedeps;
	}

	public String getWeightedavebasicdilutedsharesos() {
		return weightedavebasicdilutedsharesos;
	}

	public void setWeightedavebasicdilutedsharesos(String weightedavebasicdilutedsharesos) {
		this.weightedavebasicdilutedsharesos = weightedavebasicdilutedsharesos;
	}

	public String getBasicdilutedeps() {
		return basicdilutedeps;
	}

	public void setBasicdilutedeps(String basicdilutedeps) {
		this.basicdilutedeps = basicdilutedeps;
	}

	public String getCashdividendspershare() {
		return cashdividendspershare;
	}

	public void setCashdividendspershare(String cashdividendspershare) {
		this.cashdividendspershare = cashdividendspershare;
	}

	public String getOtherspecialcharges() {
		return otherspecialcharges;
	}

	public void setOtherspecialcharges(String otherspecialcharges) {
		this.otherspecialcharges = otherspecialcharges;
	}
	
	

}
