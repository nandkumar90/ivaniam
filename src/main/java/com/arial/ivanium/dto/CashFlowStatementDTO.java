package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cash_flow_statement")
public class CashFlowStatementDTO {

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

	@Column(name = "netincome")
	private String netincome;
	@Column(name = "netincomecontinuing")
	private String netincomecontinuing;
	@Column(name = "depreciationexpense")
	private String depreciationexpense;
	@Column(name = "noncashadjustmentstonetincome")
	private String noncashadjustmentstonetincome;
	@Column(name = "increasedecreaseinoperatingcapital")
	private String increasedecreaseinoperatingcapital;
	@Column(name = "netcashfromcontinuingoperatingactivities")
	private String netcashfromcontinuingoperatingactivities;
	@Column(name = "netcashfromoperatingactivities")
	private String netcashfromoperatingactivities;
	@Column(name = "purchaseofplantpropertyandequipment")
	private String purchaseofplantpropertyandequipment;
	@Column(name = "acquisitions")
	private String acquisitions;
	@Column(name = "divestitures")
	private String divestitures;
	@Column(name = "otherinvestingactivitiesnet")
	private String otherinvestingactivitiesnet;
	@Column(name = "netcashfromcontinuinginvestingactivities")
	private String netcashfromcontinuinginvestingactivities;

	@Column(name = "netcashfrominvestingactivities")
	private String netcashfrominvestingactivities;
	
	@Column(name = "repaymentofdebt")
	private String repaymentofdebt;
	
	@Column(name = "repurchaseofcommonequity")
	private String repurchaseofcommonequity;

	@Column(name = "paymentofdividends")
	private String paymentofdividends;
	@Column(name = "issuanceofdebt")
	private String issuanceofdebt;

	@Column(name = "issuanceofcommonequity")
	private String issuanceofcommonequity;
	@Column(name = "otherfinancingactivitiesnet")
	private String otherfinancingactivitiesnet;
	@Column(name = "netcashfromcontinuingfinancingactivities")
	private String netcashfromcontinuingfinancingactivities;
	@Column(name = "netcashfromfinancingactivities")
	private String netcashfromfinancingactivities;
	@Column(name = "effectofexchangeratechanges")
	private String effectofexchangeratechanges;
	@Column(name = "netchangeincash")
	private String netchangeincash;

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

	public String getNetincome() {
		return netincome;
	}

	public void setNetincome(String netincome) {
		this.netincome = netincome;
	}

	public String getNetincomecontinuing() {
		return netincomecontinuing;
	}

	public void setNetincomecontinuing(String netincomecontinuing) {
		this.netincomecontinuing = netincomecontinuing;
	}

	public String getDepreciationexpense() {
		return depreciationexpense;
	}

	public void setDepreciationexpense(String depreciationexpense) {
		this.depreciationexpense = depreciationexpense;
	}

	public String getNoncashadjustmentstonetincome() {
		return noncashadjustmentstonetincome;
	}

	public void setNoncashadjustmentstonetincome(String noncashadjustmentstonetincome) {
		this.noncashadjustmentstonetincome = noncashadjustmentstonetincome;
	}

	public String getIncreasedecreaseinoperatingcapital() {
		return increasedecreaseinoperatingcapital;
	}

	public void setIncreasedecreaseinoperatingcapital(String increasedecreaseinoperatingcapital) {
		this.increasedecreaseinoperatingcapital = increasedecreaseinoperatingcapital;
	}

	public String getNetcashfromcontinuingoperatingactivities() {
		return netcashfromcontinuingoperatingactivities;
	}

	public void setNetcashfromcontinuingoperatingactivities(String netcashfromcontinuingoperatingactivities) {
		this.netcashfromcontinuingoperatingactivities = netcashfromcontinuingoperatingactivities;
	}

	public String getNetcashfromoperatingactivities() {
		return netcashfromoperatingactivities;
	}

	public void setNetcashfromoperatingactivities(String netcashfromoperatingactivities) {
		this.netcashfromoperatingactivities = netcashfromoperatingactivities;
	}

	public String getPurchaseofplantpropertyandequipment() {
		return purchaseofplantpropertyandequipment;
	}

	public void setPurchaseofplantpropertyandequipment(String purchaseofplantpropertyandequipment) {
		this.purchaseofplantpropertyandequipment = purchaseofplantpropertyandequipment;
	}

	public String getAcquisitions() {
		return acquisitions;
	}

	public void setAcquisitions(String acquisitions) {
		this.acquisitions = acquisitions;
	}

	public String getDivestitures() {
		return divestitures;
	}

	public void setDivestitures(String divestitures) {
		this.divestitures = divestitures;
	}

	public String getOtherinvestingactivitiesnet() {
		return otherinvestingactivitiesnet;
	}

	public void setOtherinvestingactivitiesnet(String otherinvestingactivitiesnet) {
		this.otherinvestingactivitiesnet = otherinvestingactivitiesnet;
	}

	public String getNetcashfromcontinuinginvestingactivities() {
		return netcashfromcontinuinginvestingactivities;
	}

	public void setNetcashfromcontinuinginvestingactivities(String netcashfromcontinuinginvestingactivities) {
		this.netcashfromcontinuinginvestingactivities = netcashfromcontinuinginvestingactivities;
	}

	public String getNetcashfrominvestingactivities() {
		return netcashfrominvestingactivities;
	}

	public void setNetcashfrominvestingactivities(String netcashfrominvestingactivities) {
		this.netcashfrominvestingactivities = netcashfrominvestingactivities;
	}
	
	
	public String getRepaymentofdebt() {
		return repaymentofdebt;
	}

	public void setRepaymentofdebt(String repaymentofdebt) {
		this.repaymentofdebt = repaymentofdebt;
	}
	
	

	public String getRepurchaseofcommonequity() {
		return repurchaseofcommonequity;
	}

	public void setRepurchaseofcommonequity(String repurchaseofcommonequity) {
		this.repurchaseofcommonequity = repurchaseofcommonequity;
	}

	public String getPaymentofdividends() {
		return paymentofdividends;
	}

	public void setPaymentofdividends(String paymentofdividends) {
		this.paymentofdividends = paymentofdividends;
	}

	public String getIssuanceofdebt() {
		return issuanceofdebt;
	}

	public void setIssuanceofdebt(String issuanceofdebt) {
		this.issuanceofdebt = issuanceofdebt;
	}

	public String getIssuanceofcommonequity() {
		return issuanceofcommonequity;
	}

	public void setIssuanceofcommonequity(String issuanceofcommonequity) {
		this.issuanceofcommonequity = issuanceofcommonequity;
	}

	public String getOtherfinancingactivitiesnet() {
		return otherfinancingactivitiesnet;
	}

	public void setOtherfinancingactivitiesnet(String otherfinancingactivitiesnet) {
		this.otherfinancingactivitiesnet = otherfinancingactivitiesnet;
	}

	public String getNetcashfromcontinuingfinancingactivities() {
		return netcashfromcontinuingfinancingactivities;
	}

	public void setNetcashfromcontinuingfinancingactivities(String netcashfromcontinuingfinancingactivities) {
		this.netcashfromcontinuingfinancingactivities = netcashfromcontinuingfinancingactivities;
	}

	public String getNetcashfromfinancingactivities() {
		return netcashfromfinancingactivities;
	}

	public void setNetcashfromfinancingactivities(String netcashfromfinancingactivities) {
		this.netcashfromfinancingactivities = netcashfromfinancingactivities;
	}

	public String getEffectofexchangeratechanges() {
		return effectofexchangeratechanges;
	}

	public void setEffectofexchangeratechanges(String effectofexchangeratechanges) {
		this.effectofexchangeratechanges = effectofexchangeratechanges;
	}

	public String getNetchangeincash() {
		return netchangeincash;
	}

	public void setNetchangeincash(String netchangeincash) {
		this.netchangeincash = netchangeincash;
	}

}
