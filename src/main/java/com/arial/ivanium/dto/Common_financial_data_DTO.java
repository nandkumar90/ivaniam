package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="com_financial_statement")
public class Common_financial_data_DTO {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String ID;
	
	@Column(name = "ticker")
	private String ticker;

	@Column(name = "statement")
	private String statement;

	@Column(name = "fiscal_Year")
	private String fiscal_year;

	@Column(name = "fiscal_Period")
	private String fiscal_period;

	@Column(name = "Is_operatingrevenue")
	private String operatingrevenue;

	@Column(name = "Is_otherrevenue")
	private String otherrevenue;

	@Column(name = "Is_totalrevenue")
	private String totalrevenue;

	@Column(name = "Is_operatingcostofrevenue")
	private String operatingcostofrevenue;

	@Column(name = "Is_othercostofrevenue")
	private String othercostofrevenue;

	@Column(name = "Is_totalcostofrevenue")
	private String totalcostofrevenue;

	@Column(name = "Is_totalgrossprofit")
	private String totalgrossprofit;

	@Column(name = "Is_sgaexpense")
	private String sgaexpense;

	@Column(name = "Is_marketingexpense")
	private String marketingexpense;

	@Column(name = "Is_explorationexpense")
	private String explorationexpense;

	@Column(name = "Is_depreciationexpense")
	private String depreciationexpense;

	@Column(name = "Is_impairmentexpense")
	private String impairmentexpense;

	@Column(name = "Is_totaloperatingexpenses")
	private String totaloperatingexpenses;

	@Column(name = "Is_totaloperatingincome")
	private String totaloperatingincome;

	@Column(name = "Is_totalinterestexpense")
	private String totalinterestexpense;

	@Column(name = "Is_otherincome")
	private String otherincome;

	@Column(name = "Is_totalotherincome")
	private String totalotherincome;

	@Column(name = "Is_totalpretaxincome")
	private String totalpretaxincome;

	@Column(name = "Is_incometaxexpense")
	private String incometaxexpense;

	@Column(name = "Is_netincomecontinuing")
	private String netincomecontinuing;

	@Column(name = "Is_netincome")
	private String netincome;

	@Column(name = "Is_netincometocommon")
	private String netincometocommon;

	@Column(name = "Is_weightedavebasicsharesos")
	private String weightedavebasicsharesos;

	@Column(name = "Is_basiceps")
	private String basiceps;

	@Column(name = "Is_weightedavedilutedsharesos")
	private String weightedavedilutedsharesos;

	@Column(name = "Is_dilutedeps")
	private String dilutedeps;

	@Column(name = "Is_weightedavebasicdilutedsharesos")
	private String weightedavebasicdilutedsharesos;

	@Column(name = "Is_basicdilutedeps")
	private String basicdilutedeps;

	@Column(name = "Is_cashdividendspershare")
	private String cashdividendspershare;
	
	
	//cash flow
	@Column(name = "Cf_netincome")
	private String cfnetincome;
	@Column(name = "Cf_netincomecontinuing")
	private String Cf_netincomecontinuing;
	@Column(name = "Cf_depreciationexpense")
	private String Cf_depreciationexpense;
	@Column(name = "Cf_noncashadjustmentstonetincome")
	private String noncashadjustmentstonetincome;
	@Column(name = "Cf_increasedecreaseinoperatingcapital")
	private String increasedecreaseinoperatingcapital;
	@Column(name = "Cf_netcashfromcontinuingoperatingactivities")
	private String netcashfromcontinuingoperatingactivities;
	@Column(name = "Cf_netcashfromoperatingactivities")
	private String netcashfromoperatingactivities;
	@Column(name = "Cf_purchaseofplantpropertyandequipment")
	private String purchaseofplantpropertyandequipment;
	@Column(name = "Cf_acquisitions")
	private String acquisitions;
	@Column(name = "Cf_divestitures")
	private String divestitures;
	@Column(name = "Cf_otherinvestingactivitiesnet")
	private String otherinvestingactivitiesnet;
	@Column(name = "Cf_netcashfromcontinuinginvestingactivities")
	private String netcashfromcontinuinginvestingactivities;

	@Column(name = "Cf_netcashfrominvestingactivities")
	private String netcashfrominvestingactivities;
	
	@Column(name = "Cf_repaymentofdebt")
	private String repaymentofdebt;
	
	@Column(name = "Cf_repurchaseofcommonequity")
	private String repurchaseofcommonequity;

	@Column(name = "Cf_paymentofdividends")
	private String paymentofdividends;
	@Column(name = "Cf_issuanceofdebt")
	private String issuanceofdebt;

	@Column(name = "Cf_issuanceofcommonequity")
	private String issuanceofcommonequity;
	@Column(name = "Cf_otherfinancingactivitiesnet")
	private String otherfinancingactivitiesnet;
	@Column(name = "Cf_netcashfromcontinuingfinancingactivities")
	private String netcashfromcontinuingfinancingactivities;
	@Column(name = "Cf_netcashfromfinancingactivities")
	private String netcashfromfinancingactivities;
	@Column(name = "Cf_effectofexchangeratechanges")
	private String effectofexchangeratechanges;
	@Column(name = "Cf_netchangeincash")
	private String netchangeincash;
	
	//@Column(name = "otherspecialcharges")
	//private String otherspecialcharges;
	
	
	///Balance Sheet
	@Column(name="Bs_cashandequivalents")
	private String cashandequivalents;
	
	@Column(name="Bs_accountsreceivable")
	private String accountsreceivable;
	
	@Column(name="Bs_netinventory")
	private String netinventory;
	
	@Column(name="Bs_othercurrentassets")
	private String othercurrentassets;
	
	@Column(name="Bs_totalcurrentassets")
	private String totalcurrentassets;
	
	@Column(name="Bs_grossppe")
	private String grossppe;
	
	@Column(name="Bs_accumulateddepreciation")
	private String accumulateddepreciation;
	
	@Column(name="Bs_netppe")
	private String netppe;
	
	@Column(name="Bs_othernoncurrentassets")
	private String othernoncurrentassets;
	
	@Column(name="Bs_totalnoncurrentassets")
	private String totalnoncurrentassets;
	
	@Column(name="Bs_totalassets")
	private String totalassets;
	
	@Column(name="Bs_shorttermdebt")
	private String shorttermdebt;
	
	@Column(name="Bs_accountspayable")
	private String accountspayable;
	
	@Column(name="Bs_othercurrentliabilities")
	private String othercurrentliabilities;
	
	@Column(name="Bs_totalcurrentliabilities")
	private String totalcurrentliabilities;
	
	@Column(name="Bs_longtermdebt")
	private String longtermdebt;
	
	@Column(name="Bs_othernoncurrentliabilities")
	private String othernoncurrentliabilities;
	
	@Column(name="Bs_totalnoncurrentliabilities")
	private String totalnoncurrentliabilities;
	
	@Column(name="Bs_totalliabilities")
	private String totalliabilities;
	
	@Column(name="Bs_commitmentsandcontingencies")
	private String commitmentsandcontingencies;
	
	@Column(name="Bs_commonequity")
	private String commonequity;
	
	@Column(name="Bs_retainedearnings")
	private String retainedearnings;
	
	@Column(name="Bs_treasurystock")
	private String treasurystock;
	
	@Column(name="Bs_aoci")
	private String aoci;
	
	@Column(name="Bs_totalcommonequity")
	private String totalcommonequity;
	
	@Column(name="Bs_totalequity")
	private String totalequity;
	
	@Column(name="Bs_totalequityandnoncontrollinginterests")
	private String totalequityandnoncontrollinginterests;
	
	

	
	
	  

	
	@Column(name="Bs_totalliabilitiesandequity")
	private String totalliabilitiesandequity;
	
	@Column(name="Bs_currentdeferredtaxassets")
	private String currentdeferredtaxassets;
	
	@Column(name="Bs_noncurrentdeferredtaxassets")
	private String noncurrentdeferredtaxassets;
	
	@Column(name="Bs_dividendspayable")
	private String dividendspayable;
			
	@Column(name="Bs_currentdeferredtaxliabilities")
	private String currentdeferredtaxliabilities;
			
	@Column(name="Bs_noncurrentdeferredtaxliabilities")
	private String noncurrentdeferredtaxliabilities;
	
	
	
	//Calculation
	@Column(name = "Cal_revenuegrowth")
	private String revenuegrowth;

	@Column(name = "Cal_nopat")
	private String nopat;
	
	@Column(name = "Cal_nopatmargin")
	private String nopatmargin;
	
	@Column(name = "Cal_investedcapital")
	private String investedcapital;
	
	@Column(name = "Cal_investedcapitalturnover")
	private String investedcapitalturnover;
	
	@Column(name = "Cal_investedcapitalincreasedecrease")
	private String investedcapitalincreasedecrease;
	
	@Column(name = "Cal_freecashflow")
	private String freecashflow;
	
	@Column(name = "Cal_netnonopex")
	private String netnonopex;
	
	@Column(name = "Cal_netnonopobligations")
	private String netnonopobligations;
	
	@Column(name = "Cal_ebit")
	private String ebit;
	@Column(name = "Cal_depreciationandamortization")
	private String depreciationandamortization;
	@Column(name = "Cal_ebitda")
	private String ebitda;
	@Column(name = "Cal_capex")
	private String capex;
	@Column(name = "Cal_dfcfnwc")
	private String dfcfnwc;
	@Column(name = "Cal_dfnwc")
	private String dfnwc;
	@Column(name = "Cal_nwc")
	private String nwc;
	@Column(name = "Cal_debt")
	private String debt;
	@Column(name = "Cal_ltdebtandcapleases")
	private String ltdebtandcapleases;
	@Column(name = "Cal_netdebt")
	private String netdebt;
	@Column(name = "Cal_totalcapital")
	private String totalcapital;
	@Column(name = "Cal_bookvaluepershare")
	private String bookvaluepershare;
	@Column(name = "Cal_tangbookvaluepershare")
	private String tangbookvaluepershare;
	@Column(name = "Cal_marketcap")
	private String marketcap;
	@Column(name = "Cal_enterprisevalue")
	private String enterprisevalue;
	@Column(name = "Cal_pricetobook")
	private String pricetobook;
	@Column(name = "Cal_pricetotangiblebook")
	private String pricetotangiblebook;
	@Column(name = "Cal_pricetorevenue")
	private String pricetorevenue;
	@Column(name = "Cal_pricetoearnings")
	private String pricetoearnings;
	@Column(name = "Cal_dividendyield")
	private String dividendyield;
	@Column(name = "Cal_earningsyield")
	private String earningsyield;
	@Column(name = "Cal_evtoinvestedcapital")
	private String evtoinvestedcapital;
	@Column(name = "Cal_evtorevenue")
	private String evtorevenue;
	@Column(name = "Cal_evtoebitda")
	private String evtoebitda;
	@Column(name = "Cal_evtoebit")
	private String evtoebit;
	@Column(name = "Cal_evtonopat")
	private String evtonopat;
	@Column(name = "Cal_evtoocf")
	private String evtoocf;
	@Column(name = "Cal_evtofcff")
	private String evtofcff;
	@Column(name = "Cal_ebitdagrowth")
	private String ebitdagrowth;
	@Column(name = "Cal_ebitgrowth")
	private String ebitgrowth;
	@Column(name = "Cal_nopatgrowth")
	private String nopatgrowth;
	@Column(name = "Cal_netincomegrowth")
	private String netincomegrowth;
	@Column(name = "Cal_epsgrowth")
	private String epsgrowth;
	@Column(name = "Cal_ocfgrowth")
	private String ocfgrowth;
	@Column(name = "Cal_fcffgrowth")
	private String fcffgrowth;
	@Column(name = "Cal_investedcapitalgrowth")
	private String investedcapitalgrowth;
	@Column(name = "Cal_revenueqoqgrowth")
	private String revenueqoqgrowth;
	@Column(name = "Cal_ebitdaqoqgrowth")
	private String ebitdaqoqgrowth;
	@Column(name = "Cal_ebitqoqgrowth")
	private String ebitqoqgrowth;
	@Column(name = "Cal_nopatqoqgrowth")
	private String nopatqoqgrowth;
	@Column(name = "Cal_netincomeqoqgrowth")
	private String netincomeqoqgrowth;
	@Column(name = "Cal_epsqoqgrowth")
	private String epsqoqgrowth;
	@Column(name = "Cal_ocfqoqgrowth")
	private String ocfqoqgrowth;
	@Column(name = "Cal_fcffqoqgrowth")
	private String fcffqoqgrowth;
	@Column(name = "Cal_investedcapitalqoqgrowth")
	private String investedcapitalqoqgrowth;
	@Column(name = "Cal_grossmargin")
	private String grossmargin;
	@Column(name = "Cal_ebitdamargin")
	private String ebitdamargin;
	@Column(name = "Cal_operatingmargin")
	private String operatingmargin;
	@Column(name = "Cal_ebitmargin")
	private String ebitmargin;
	@Column(name = "Cal_profitmargin")
	private String profitmargin;
	@Column(name = "Cal_costofrevtorevenue")
	private String costofrevtorevenue;
	@Column(name = "Cal_sgaextorevenue")
	private String sgaextorevenue;
	@Column(name = "Cal_rdextorevenue")
	private String rdextorevenue;
	@Column(name = "Cal_opextorevenue")
	private String opextorevenue;
	@Column(name = "Cal_taxburdenpct")
	private String taxburdenpct;
	@Column(name = "Cal_interestburdenpct")
	private String interestburdenpct;
	@Column(name = "Cal_efftaxrate")
	private String efftaxrate;
	@Column(name = "Cal_assetturnover")
	private String assetturnover;
	@Column(name = "Cal_arturnover")
	private String arturnover;
	@Column(name = "Cal_invturnover")
	private String invturnover;
	@Column(name = "Cal_faturnover")
	private String faturnover;
	@Column(name = "Cal_apturnover")
	private String apturnover;
	@Column(name = "Cal_dso")
	private String dso;
	@Column(name = "Cal_dio")
	private String dio;
	@Column(name = "Cal_dpo")
	private String dpo;
	@Column(name = "Cal_ccc")
	private String ccc;
	@Column(name = "Cal_finleverage")
	private String finleverage;
	@Column(name = "Cal_leverageratio")
	private String leverageratio;
	@Column(name = "Cal_compoundleveragefactor")
	private String compoundleveragefactor;
	@Column(name = "Cal_ltdebttoequity")
	private String ltdebttoequity;
	@Column(name = "Cal_debttoequity")
	private String debttoequity;
	@Column(name = "Cal_roic")
	private String roic;
	@Column(name = "Cal_nnep")
	private String nnep;
	@Column(name = "Cal_roicnnepspread")
	private String roicnnepspread;
	@Column(name = "Cal_rnnoa")
	private String rnnoa;
	@Column(name = "Cal_roe")
	private String roe;
	@Column(name = "Cal_croic")
	private String croic;
	@Column(name = "Cal_oroa")
	private String oroa;
	@Column(name = "Cal_roa")
	private String roa;
	@Column(name = "Cal_noncontrollinginterestsharingratio")
	private String noncontrollinginterestsharingratio;
	@Column(name = "Cal_roce")
	private String roce;
	@Column(name = "Cal_divpayoutratio")
	private String divpayoutratio;
	@Column(name = "Cal_augmentedpayoutratio")
	private String augmentedpayoutratio;
	@Column(name = "Cal_ocftocapex")
	private String ocftocapex;
	@Column(name = "Cal_stdebttocap")
	private String stdebttocap;
	@Column(name = "Cal_ltdebttocap")
	private String ltdebttocap;
	@Column(name = "Cal_debttototalcapital")
	private String debttototalcapital;
	@Column(name = "Cal_preferredtocap")
	private String preferredtocap;
	@Column(name = "Cal_noncontrolinttocap")
	private String noncontrolinttocap;
	@Column(name = "Cal_commontocap")
	private String commontocap;
	@Column(name = "Cal_debttoebitda")
	private String debttoebitda;
	@Column(name = "Cal_netdebttoebitda")
	private String netdebttoebitda;
	@Column(name = "Cal_ltdebttoebitda")
	private String ltdebttoebitda;
	@Column(name = "Cal_debttonopat")
	private String debttonopat;
	@Column(name = "Cal_netdebttonopat")
	private String netdebttonopat;
	@Column(name = "Cal_ltdebttonopat")
	private String ltdebttonopat;
	@Column(name = "Cal_altmanzscore")
	private String altmanzscore;
	@Column(name = "Cal_ebittointerestex")
	private String ebittointerestex;
	@Column(name = "Cal_nopattointerestex")
	private String nopattointerestex;
	@Column(name = "Cal_ebitlesscapextointerestex")
	private String ebitlesscapextointerestex;
	@Column(name = "Cal_nopatlesscapextointex")
	private String nopatlesscapextointex;
	@Column(name = "Cal_ocftointerestex")
	private String ocftointerestex;
	@Column(name = "Cal_ocflesscapextointerestex")
	private String ocflesscapextointerestex;
	@Column(name = "Cal_fcfftointerestex")
	private String fcfftointerestex;
	@Column(name = "Cal_currentratio")
	private String currentratio;
	@Column(name = "Cal_quickratio")
	private String quickratio;
	@Column(name = "Cal_dfcfnwctorev")
	private String dfcfnwctorev;
	@Column(name = "Cal_dfnwctorev")
	private String dfnwctorev;
	@Column(name = "Cal_nwctorev")
	private String nwctorev;
	@Column(name = "Cal_normalizednopat")
	private String normalizednopat;
	@Column(name = "Cal_normalizednopatmargin")
	private String normalizednopatmargin;
	@Column(name = "Cal_pretaxincomemargin")
	private String pretaxincomemargin;

	
	
	//getter setter method

	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
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

	public String getOperatingrevenue() {
		return operatingrevenue;
	}

	public void setOperatingrevenue(String operatingrevenue) {
		this.operatingrevenue = operatingrevenue;
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

	public String getIsDepreciationexpense() {
		return depreciationexpense;
	}

	public void setIsDepreciationexpense(String depreciationexpense) {
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

	/*public String getOtherspecialcharges() {
		return otherspecialcharges;
	}

	public void setOtherspecialcharges(String otherspecialcharges) {
		this.otherspecialcharges = otherspecialcharges;
	}*/
	
	
	
	
	
	
	//Cash flow
	public String cfgetNetincome() {
		return netincome;
	}

	public void setCfNetincome(String netincome) {
		this.netincome = netincome;
	}

	public String getCfNetincomecontinuing() {
		return netincomecontinuing;
	}

	public void setCfNetincomecontinuing(String netincomecontinuing) {
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
	
	
	// Balance Sheet
	public String getCashandequivalents() {
		return cashandequivalents;
	}

	public void setCashandequivalents(String cashandequivalents) {
		this.cashandequivalents = cashandequivalents;
	}

	public String getAccountsreceivable() {
		return accountsreceivable;
	}

	public void setAccountsreceivable(String accountsreceivable) {
		this.accountsreceivable = accountsreceivable;
	}

	public String getNetinventory() {
		return netinventory;
	}

	public void setNetinventory(String netinventory) {
		this.netinventory = netinventory;
	}

	public String getOthercurrentassets() {
		return othercurrentassets;
	}

	public void setOthercurrentassets(String othercurrentassets) {
		this.othercurrentassets = othercurrentassets;
	}

	public String getTotalcurrentassets() {
		return totalcurrentassets;
	}

	public void setTotalcurrentassets(String totalcurrentassets) {
		this.totalcurrentassets = totalcurrentassets;
	}

	public String getGrossppe() {
		return grossppe;
	}

	public void setGrossppe(String grossppe) {
		this.grossppe = grossppe;
	}

	public String getAccumulateddepreciation() {
		return accumulateddepreciation;
	}

	public void setAccumulateddepreciation(String accumulateddepreciation) {
		this.accumulateddepreciation = accumulateddepreciation;
	}

	public String getNetppe() {
		return netppe;
	}

	public void setNetppe(String netppe) {
		this.netppe = netppe;
	}

	public String getOthernoncurrentassets() {
		return othernoncurrentassets;
	}

	public void setOthernoncurrentassets(String othernoncurrentassets) {
		this.othernoncurrentassets = othernoncurrentassets;
	}

	public String getTotalnoncurrentassets() {
		return totalnoncurrentassets;
	}

	public void setTotalnoncurrentassets(String totalnoncurrentassets) {
		this.totalnoncurrentassets = totalnoncurrentassets;
	}

	public String getTotalassets() {
		return totalassets;
	}

	public void setTotalassets(String totalassets) {
		this.totalassets = totalassets;
	}

	public String getShorttermdebt() {
		return shorttermdebt;
	}

	public void setShorttermdebt(String shorttermdebt) {
		this.shorttermdebt = shorttermdebt;
	}

	public String getAccountspayable() {
		return accountspayable;
	}

	public void setAccountspayable(String accountspayable) {
		this.accountspayable = accountspayable;
	}

	public String getOthercurrentliabilities() {
		return othercurrentliabilities;
	}

	public void setOthercurrentliabilities(String othercurrentliabilities) {
		this.othercurrentliabilities = othercurrentliabilities;
	}

	public String getTotalcurrentliabilities() {
		return totalcurrentliabilities;
	}

	public void setTotalcurrentliabilities(String totalcurrentliabilities) {
		this.totalcurrentliabilities = totalcurrentliabilities;
	}

	public String getLongtermdebt() {
		return longtermdebt;
	}

	public void setLongtermdebt(String longtermdebt) {
		this.longtermdebt = longtermdebt;
	}

	public String getOthernoncurrentliabilities() {
		return othernoncurrentliabilities;
	}

	public void setOthernoncurrentliabilities(String othernoncurrentliabilities) {
		this.othernoncurrentliabilities = othernoncurrentliabilities;
	}

	public String getTotalnoncurrentliabilities() {
		return totalnoncurrentliabilities;
	}

	public void setTotalnoncurrentliabilities(String totalnoncurrentliabilities) {
		this.totalnoncurrentliabilities = totalnoncurrentliabilities;
	}

	public String getTotalliabilities() {
		return totalliabilities;
	}

	public void setTotalliabilities(String totalliabilities) {
		this.totalliabilities = totalliabilities;
	}

	public String getCommitmentsandcontingencies() {
		return commitmentsandcontingencies;
	}

	public void setCommitmentsandcontingencies(String commitmentsandcontingencies) {
		this.commitmentsandcontingencies = commitmentsandcontingencies;
	}

	public String getCommonequity() {
		return commonequity;
	}

	public void setCommonequity(String commonequity) {
		this.commonequity = commonequity;
	}

	public String getRetainedearnings() {
		return retainedearnings;
	}

	public void setRetainedearnings(String retainedearnings) {
		this.retainedearnings = retainedearnings;
	}

	public String getTreasurystock() {
		return treasurystock;
	}

	public void setTreasurystock(String treasurystock) {
		this.treasurystock = treasurystock;
	}

	public String getAoci() {
		return aoci;
	}

	public void setAoci(String aoci) {
		this.aoci = aoci;
	}

	public String getTotalcommonequity() {
		return totalcommonequity;
	}

	public void setTotalcommonequity(String totalcommonequity) {
		this.totalcommonequity = totalcommonequity;
	}

	public String getTotalequity() {
		return totalequity;
	}

	public void setTotalequity(String totalequity) {
		this.totalequity = totalequity;
	}

	public String getTotalequityandnoncontrollinginterests() {
		return totalequityandnoncontrollinginterests;
	}

	public void setTotalequityandnoncontrollinginterests(String totalequityandnoncontrollinginterests) {
		this.totalequityandnoncontrollinginterests = totalequityandnoncontrollinginterests;
	}
	
	
	public String getTotalliabilitiesandequity() {
		return totalliabilitiesandequity;
	}

	public void setTotalliabilitiesandequity(String totalliabilitiesandequity) {
		this.totalliabilitiesandequity = totalliabilitiesandequity;
	}
	
	
	public String getCurrentdeferredtaxassets() {
		return currentdeferredtaxassets;
	}

	public void setCurrentdeferredtaxassets(String currentdeferredtaxassets) {
		this.currentdeferredtaxassets = currentdeferredtaxassets;
	}
	
	
	public String getNoncurrentdeferredtaxassets() {
		return noncurrentdeferredtaxassets;
	}

	public void setNoncurrentdeferredtaxassets(String noncurrentdeferredtaxassets) {
		this.noncurrentdeferredtaxassets = noncurrentdeferredtaxassets;
	}
	
	
	public String getDividendspayable() {
		return dividendspayable;
	}

	public void setDividendspayable(String dividendspayable) {
		this.dividendspayable = dividendspayable;
	}
	

	
	
	public String getCurrentdeferredtaxliabilities() {
		return currentdeferredtaxliabilities;
	}

	public void setCurrentdeferredtaxliabilities(String currentdeferredtaxliabilities) {
		this.currentdeferredtaxliabilities = currentdeferredtaxliabilities;
	}
	
	
	public String getNoncurrentdeferredtaxliabilities() {
		return noncurrentdeferredtaxliabilities;
	}

	public void setNoncurrentdeferredtaxliabilities(String noncurrentdeferredtaxliabilities) {
		this.noncurrentdeferredtaxliabilities = noncurrentdeferredtaxliabilities;
	}
	
	
	//Calculation
	public String getRevenuegrowth() {
		return revenuegrowth;
	}

	public void setRevenuegrowth(String revenuegrowth) {
		this.revenuegrowth = revenuegrowth;
	}

	public String getNopat() {
		return nopat;
	}

	public void setNopat(String nopat) {
		this.nopat = nopat;
	}

	public String getNopatmargin() {
		return nopatmargin;
	}

	public void setNopatmargin(String nopatmargin) {
		this.nopatmargin = nopatmargin;
	}

	public String getInvestedcapital() {
		return investedcapital;
	}

	public void setInvestedcapital(String investedcapital) {
		this.investedcapital = investedcapital;
	}

	public String getInvestedcapitalturnover() {
		return investedcapitalturnover;
	}

	public void setInvestedcapitalturnover(String investedcapitalturnover) {
		this.investedcapitalturnover = investedcapitalturnover;
	}

	public String getInvestedcapitalincreasedecrease() {
		return investedcapitalincreasedecrease;
	}

	public void setInvestedcapitalincreasedecrease(String investedcapitalincreasedecrease) {
		this.investedcapitalincreasedecrease = investedcapitalincreasedecrease;
	}

	public String getFreecashflow() {
		return freecashflow;
	}

	public void setFreecashflow(String freecashflow) {
		this.freecashflow = freecashflow;
	}

	public String getNetnonopex() {
		return netnonopex;
	}

	public void setNetnonopex(String netnonopex) {
		this.netnonopex = netnonopex;
	}

	public String getNetnonopobligations() {
		return netnonopobligations;
	}

	public void setNetnonopobligations(String netnonopobligations) {
		this.netnonopobligations = netnonopobligations;
	}

	public String getEbit() {
		return ebit;
	}

	public void setEbit(String ebit) {
		this.ebit = ebit;
	}

	public String getDepreciationandamortization() {
		return depreciationandamortization;
	}

	public void setDepreciationandamortization(String depreciationandamortization) {
		this.depreciationandamortization = depreciationandamortization;
	}

	public String getEbitda() {
		return ebitda;
	}

	public void setEbitda(String ebitda) {
		this.ebitda = ebitda;
	}

	public String getCapex() {
		return capex;
	}

	public void setCapex(String capex) {
		this.capex = capex;
	}

	public String getDfcfnwc() {
		return dfcfnwc;
	}

	public void setDfcfnwc(String dfcfnwc) {
		this.dfcfnwc = dfcfnwc;
	}

	public String getDfnwc() {
		return dfnwc;
	}

	public void setDfnwc(String dfnwc) {
		this.dfnwc = dfnwc;
	}

	public String getNwc() {
		return nwc;
	}

	public void setNwc(String nwc) {
		this.nwc = nwc;
	}

	public String getDebt() {
		return debt;
	}

	public void setDebt(String debt) {
		this.debt = debt;
	}

	public String getLtdebtandcapleases() {
		return ltdebtandcapleases;
	}

	public void setLtdebtandcapleases(String ltdebtandcapleases) {
		this.ltdebtandcapleases = ltdebtandcapleases;
	}

	public String getNetdebt() {
		return netdebt;
	}

	public void setNetdebt(String netdebt) {
		this.netdebt = netdebt;
	}

	public String getTotalcapital() {
		return totalcapital;
	}

	public void setTotalcapital(String totalcapital) {
		this.totalcapital = totalcapital;
	}

	public String getBookvaluepershare() {
		return bookvaluepershare;
	}

	public void setBookvaluepershare(String bookvaluepershare) {
		this.bookvaluepershare = bookvaluepershare;
	}

	public String getTangbookvaluepershare() {
		return tangbookvaluepershare;
	}

	public void setTangbookvaluepershare(String tangbookvaluepershare) {
		this.tangbookvaluepershare = tangbookvaluepershare;
	}

	public String getMarketcap() {
		return marketcap;
	}

	public void setMarketcap(String marketcap) {
		this.marketcap = marketcap;
	}

	public String getEnterprisevalue() {
		return enterprisevalue;
	}

	public void setEnterprisevalue(String enterprisevalue) {
		this.enterprisevalue = enterprisevalue;
	}

	public String getPricetobook() {
		return pricetobook;
	}

	public void setPricetobook(String pricetobook) {
		this.pricetobook = pricetobook;
	}

	public String getPricetotangiblebook() {
		return pricetotangiblebook;
	}

	public void setPricetotangiblebook(String pricetotangiblebook) {
		this.pricetotangiblebook = pricetotangiblebook;
	}

	public String getPricetorevenue() {
		return pricetorevenue;
	}

	public void setPricetorevenue(String pricetorevenue) {
		this.pricetorevenue = pricetorevenue;
	}

	public String getPricetoearnings() {
		return pricetoearnings;
	}

	public void setPricetoearnings(String pricetoearnings) {
		this.pricetoearnings = pricetoearnings;
	}

	public String getDividendyield() {
		return dividendyield;
	}

	public void setDividendyield(String dividendyield) {
		this.dividendyield = dividendyield;
	}

	public String getEarningsyield() {
		return earningsyield;
	}

	public void setEarningsyield(String earningsyield) {
		this.earningsyield = earningsyield;
	}

	public String getEvtoinvestedcapital() {
		return evtoinvestedcapital;
	}

	public void setEvtoinvestedcapital(String evtoinvestedcapital) {
		this.evtoinvestedcapital = evtoinvestedcapital;
	}

	public String getEvtorevenue() {
		return evtorevenue;
	}

	public void setEvtorevenue(String evtorevenue) {
		this.evtorevenue = evtorevenue;
	}

	public String getEvtoebitda() {
		return evtoebitda;
	}

	public void setEvtoebitda(String evtoebitda) {
		this.evtoebitda = evtoebitda;
	}

	public String getEvtoebit() {
		return evtoebit;
	}

	public void setEvtoebit(String evtoebit) {
		this.evtoebit = evtoebit;
	}

	public String getEvtonopat() {
		return evtonopat;
	}

	public void setEvtonopat(String evtonopat) {
		this.evtonopat = evtonopat;
	}

	public String getEvtoocf() {
		return evtoocf;
	}

	public void setEvtoocf(String evtoocf) {
		this.evtoocf = evtoocf;
	}

	public String getEvtofcff() {
		return evtofcff;
	}

	public void setEvtofcff(String evtofcff) {
		this.evtofcff = evtofcff;
	}

	public String getEbitdagrowth() {
		return ebitdagrowth;
	}

	public void setEbitdagrowth(String ebitdagrowth) {
		this.ebitdagrowth = ebitdagrowth;
	}

	public String getEbitgrowth() {
		return ebitgrowth;
	}

	public void setEbitgrowth(String ebitgrowth) {
		this.ebitgrowth = ebitgrowth;
	}

	public String getNopatgrowth() {
		return nopatgrowth;
	}

	public void setNopatgrowth(String nopatgrowth) {
		this.nopatgrowth = nopatgrowth;
	}

	public String getNetincomegrowth() {
		return netincomegrowth;
	}

	public void setNetincomegrowth(String netincomegrowth) {
		this.netincomegrowth = netincomegrowth;
	}

	public String getEpsgrowth() {
		return epsgrowth;
	}

	public void setEpsgrowth(String epsgrowth) {
		this.epsgrowth = epsgrowth;
	}

	public String getOcfgrowth() {
		return ocfgrowth;
	}

	public void setOcfgrowth(String ocfgrowth) {
		this.ocfgrowth = ocfgrowth;
	}

	public String getFcffgrowth() {
		return fcffgrowth;
	}

	public void setFcffgrowth(String fcffgrowth) {
		this.fcffgrowth = fcffgrowth;
	}

	public String getInvestedcapitalgrowth() {
		return investedcapitalgrowth;
	}

	public void setInvestedcapitalgrowth(String investedcapitalgrowth) {
		this.investedcapitalgrowth = investedcapitalgrowth;
	}

	public String getRevenueqoqgrowth() {
		return revenueqoqgrowth;
	}

	public void setRevenueqoqgrowth(String revenueqoqgrowth) {
		this.revenueqoqgrowth = revenueqoqgrowth;
	}

	public String getEbitdaqoqgrowth() {
		return ebitdaqoqgrowth;
	}

	public void setEbitdaqoqgrowth(String ebitdaqoqgrowth) {
		this.ebitdaqoqgrowth = ebitdaqoqgrowth;
	}

	public String getEbitqoqgrowth() {
		return ebitqoqgrowth;
	}

	public void setEbitqoqgrowth(String ebitqoqgrowth) {
		this.ebitqoqgrowth = ebitqoqgrowth;
	}

	public String getNopatqoqgrowth() {
		return nopatqoqgrowth;
	}

	public void setNopatqoqgrowth(String nopatqoqgrowth) {
		this.nopatqoqgrowth = nopatqoqgrowth;
	}

	public String getNetincomeqoqgrowth() {
		return netincomeqoqgrowth;
	}

	public void setNetincomeqoqgrowth(String netincomeqoqgrowth) {
		this.netincomeqoqgrowth = netincomeqoqgrowth;
	}

	public String getEpsqoqgrowth() {
		return epsqoqgrowth;
	}

	public void setEpsqoqgrowth(String epsqoqgrowth) {
		this.epsqoqgrowth = epsqoqgrowth;
	}

	public String getOcfqoqgrowth() {
		return ocfqoqgrowth;
	}

	public void setOcfqoqgrowth(String ocfqoqgrowth) {
		this.ocfqoqgrowth = ocfqoqgrowth;
	}

	public String getFcffqoqgrowth() {
		return fcffqoqgrowth;
	}

	public void setFcffqoqgrowth(String fcffqoqgrowth) {
		this.fcffqoqgrowth = fcffqoqgrowth;
	}

	public String getInvestedcapitalqoqgrowth() {
		return investedcapitalqoqgrowth;
	}

	public void setInvestedcapitalqoqgrowth(String investedcapitalqoqgrowth) {
		this.investedcapitalqoqgrowth = investedcapitalqoqgrowth;
	}

	public String getGrossmargin() {
		return grossmargin;
	}

	public void setGrossmargin(String grossmargin) {
		this.grossmargin = grossmargin;
	}

	public String getEbitdamargin() {
		return ebitdamargin;
	}

	public void setEbitdamargin(String ebitdamargin) {
		this.ebitdamargin = ebitdamargin;
	}

	public String getOperatingmargin() {
		return operatingmargin;
	}

	public void setOperatingmargin(String operatingmargin) {
		this.operatingmargin = operatingmargin;
	}

	public String getEbitmargin() {
		return ebitmargin;
	}

	public void setEbitmargin(String ebitmargin) {
		this.ebitmargin = ebitmargin;
	}

	public String getProfitmargin() {
		return profitmargin;
	}

	public void setProfitmargin(String profitmargin) {
		this.profitmargin = profitmargin;
	}

	public String getCostofrevtorevenue() {
		return costofrevtorevenue;
	}

	public void setCostofrevtorevenue(String costofrevtorevenue) {
		this.costofrevtorevenue = costofrevtorevenue;
	}

	public String getSgaextorevenue() {
		return sgaextorevenue;
	}

	public void setSgaextorevenue(String sgaextorevenue) {
		this.sgaextorevenue = sgaextorevenue;
	}

	public String getRdextorevenue() {
		return rdextorevenue;
	}

	public void setRdextorevenue(String rdextorevenue) {
		this.rdextorevenue = rdextorevenue;
	}

	public String getOpextorevenue() {
		return opextorevenue;
	}

	public void setOpextorevenue(String opextorevenue) {
		this.opextorevenue = opextorevenue;
	}

	public String getTaxburdenpct() {
		return taxburdenpct;
	}

	public void setTaxburdenpct(String taxburdenpct) {
		this.taxburdenpct = taxburdenpct;
	}

	public String getInterestburdenpct() {
		return interestburdenpct;
	}

	public void setInterestburdenpct(String interestburdenpct) {
		this.interestburdenpct = interestburdenpct;
	}

	public String getEfftaxrate() {
		return efftaxrate;
	}

	public void setEfftaxrate(String efftaxrate) {
		this.efftaxrate = efftaxrate;
	}

	public String getAssetturnover() {
		return assetturnover;
	}

	public void setAssetturnover(String assetturnover) {
		this.assetturnover = assetturnover;
	}

	public String getArturnover() {
		return arturnover;
	}

	public void setArturnover(String arturnover) {
		this.arturnover = arturnover;
	}

	public String getInvturnover() {
		return invturnover;
	}

	public void setInvturnover(String invturnover) {
		this.invturnover = invturnover;
	}

	public String getFaturnover() {
		return faturnover;
	}

	public void setFaturnover(String faturnover) {
		this.faturnover = faturnover;
	}

	public String getApturnover() {
		return apturnover;
	}

	public void setApturnover(String apturnover) {
		this.apturnover = apturnover;
	}

	public String getDso() {
		return dso;
	}

	public void setDso(String dso) {
		this.dso = dso;
	}

	public String getDio() {
		return dio;
	}

	public void setDio(String dio) {
		this.dio = dio;
	}

	public String getDpo() {
		return dpo;
	}

	public void setDpo(String dpo) {
		this.dpo = dpo;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public String getFinleverage() {
		return finleverage;
	}

	public void setFinleverage(String finleverage) {
		this.finleverage = finleverage;
	}

	public String getLeverageratio() {
		return leverageratio;
	}

	public void setLeverageratio(String leverageratio) {
		this.leverageratio = leverageratio;
	}

	public String getCompoundleveragefactor() {
		return compoundleveragefactor;
	}

	public void setCompoundleveragefactor(String compoundleveragefactor) {
		this.compoundleveragefactor = compoundleveragefactor;
	}

	public String getLtdebttoequity() {
		return ltdebttoequity;
	}

	public void setLtdebttoequity(String ltdebttoequity) {
		this.ltdebttoequity = ltdebttoequity;
	}

	public String getDebttoequity() {
		return debttoequity;
	}

	public void setDebttoequity(String debttoequity) {
		this.debttoequity = debttoequity;
	}

	public String getRoic() {
		return roic;
	}

	public void setRoic(String roic) {
		this.roic = roic;
	}

	public String getNnep() {
		return nnep;
	}

	public void setNnep(String nnep) {
		this.nnep = nnep;
	}

	public String getRoicnnepspread() {
		return roicnnepspread;
	}

	public void setRoicnnepspread(String roicnnepspread) {
		this.roicnnepspread = roicnnepspread;
	}

	public String getRnnoa() {
		return rnnoa;
	}

	public void setRnnoa(String rnnoa) {
		this.rnnoa = rnnoa;
	}

	public String getRoe() {
		return roe;
	}

	public void setRoe(String roe) {
		this.roe = roe;
	}

	public String getCroic() {
		return croic;
	}

	public void setCroic(String croic) {
		this.croic = croic;
	}

	public String getOroa() {
		return oroa;
	}

	public void setOroa(String oroa) {
		this.oroa = oroa;
	}

	public String getRoa() {
		return roa;
	}

	public void setRoa(String roa) {
		this.roa = roa;
	}

	public String getNoncontrollinginterestsharingratio() {
		return noncontrollinginterestsharingratio;
	}

	public void setNoncontrollinginterestsharingratio(String noncontrollinginterestsharingratio) {
		this.noncontrollinginterestsharingratio = noncontrollinginterestsharingratio;
	}

	public String getRoce() {
		return roce;
	}

	public void setRoce(String roce) {
		this.roce = roce;
	}

	public String getDivpayoutratio() {
		return divpayoutratio;
	}

	public void setDivpayoutratio(String divpayoutratio) {
		this.divpayoutratio = divpayoutratio;
	}

	public String getAugmentedpayoutratio() {
		return augmentedpayoutratio;
	}

	public void setAugmentedpayoutratio(String augmentedpayoutratio) {
		this.augmentedpayoutratio = augmentedpayoutratio;
	}

	public String getOcftocapex() {
		return ocftocapex;
	}

	public void setOcftocapex(String ocftocapex) {
		this.ocftocapex = ocftocapex;
	}

	public String getStdebttocap() {
		return stdebttocap;
	}

	public void setStdebttocap(String stdebttocap) {
		this.stdebttocap = stdebttocap;
	}

	public String getLtdebttocap() {
		return ltdebttocap;
	}

	public void setLtdebttocap(String ltdebttocap) {
		this.ltdebttocap = ltdebttocap;
	}

	public String getDebttototalcapital() {
		return debttototalcapital;
	}

	public void setDebttototalcapital(String debttototalcapital) {
		this.debttototalcapital = debttototalcapital;
	}

	public String getPreferredtocap() {
		return preferredtocap;
	}

	public void setPreferredtocap(String preferredtocap) {
		this.preferredtocap = preferredtocap;
	}

	public String getNoncontrolinttocap() {
		return noncontrolinttocap;
	}

	public void setNoncontrolinttocap(String noncontrolinttocap) {
		this.noncontrolinttocap = noncontrolinttocap;
	}

	public String getCommontocap() {
		return commontocap;
	}

	public void setCommontocap(String commontocap) {
		this.commontocap = commontocap;
	}

	public String getDebttoebitda() {
		return debttoebitda;
	}

	public void setDebttoebitda(String debttoebitda) {
		this.debttoebitda = debttoebitda;
	}

	public String getNetdebttoebitda() {
		return netdebttoebitda;
	}

	public void setNetdebttoebitda(String netdebttoebitda) {
		this.netdebttoebitda = netdebttoebitda;
	}

	public String getLtdebttoebitda() {
		return ltdebttoebitda;
	}

	public void setLtdebttoebitda(String ltdebttoebitda) {
		this.ltdebttoebitda = ltdebttoebitda;
	}

	public String getDebttonopat() {
		return debttonopat;
	}

	public void setDebttonopat(String debttonopat) {
		this.debttonopat = debttonopat;
	}

	public String getNetdebttonopat() {
		return netdebttonopat;
	}

	public void setNetdebttonopat(String netdebttonopat) {
		this.netdebttonopat = netdebttonopat;
	}

	public String getLtdebttonopat() {
		return ltdebttonopat;
	}

	public void setLtdebttonopat(String ltdebttonopat) {
		this.ltdebttonopat = ltdebttonopat;
	}

	public String getAltmanzscore() {
		return altmanzscore;
	}

	public void setAltmanzscore(String altmanzscore) {
		this.altmanzscore = altmanzscore;
	}

	public String getEbittointerestex() {
		return ebittointerestex;
	}

	public void setEbittointerestex(String ebittointerestex) {
		this.ebittointerestex = ebittointerestex;
	}

	public String getNopattointerestex() {
		return nopattointerestex;
	}

	public void setNopattointerestex(String nopattointerestex) {
		this.nopattointerestex = nopattointerestex;
	}

	public String getEbitlesscapextointerestex() {
		return ebitlesscapextointerestex;
	}

	public void setEbitlesscapextointerestex(String ebitlesscapextointerestex) {
		this.ebitlesscapextointerestex = ebitlesscapextointerestex;
	}

	public String getNopatlesscapextointex() {
		return nopatlesscapextointex;
	}

	public void setNopatlesscapextointex(String nopatlesscapextointex) {
		this.nopatlesscapextointex = nopatlesscapextointex;
	}

	public String getOcftointerestex() {
		return ocftointerestex;
	}

	public void setOcftointerestex(String ocftointerestex) {
		this.ocftointerestex = ocftointerestex;
	}

	public String getOcflesscapextointerestex() {
		return ocflesscapextointerestex;
	}

	public void setOcflesscapextointerestex(String ocflesscapextointerestex) {
		this.ocflesscapextointerestex = ocflesscapextointerestex;
	}

	public String getFcfftointerestex() {
		return fcfftointerestex;
	}

	public void setFcfftointerestex(String fcfftointerestex) {
		this.fcfftointerestex = fcfftointerestex;
	}

	public String getCurrentratio() {
		return currentratio;
	}

	public void setCurrentratio(String currentratio) {
		this.currentratio = currentratio;
	}

	public String getQuickratio() {
		return quickratio;
	}

	public void setQuickratio(String quickratio) {
		this.quickratio = quickratio;
	}

	public String getDfcfnwctorev() {
		return dfcfnwctorev;
	}

	public void setDfcfnwctorev(String dfcfnwctorev) {
		this.dfcfnwctorev = dfcfnwctorev;
	}

	public String getDfnwctorev() {
		return dfnwctorev;
	}

	public void setDfnwctorev(String dfnwctorev) {
		this.dfnwctorev = dfnwctorev;
	}

	public String getNwctorev() {
		return nwctorev;
	}

	public void setNwctorev(String nwctorev) {
		this.nwctorev = nwctorev;
	}

	public String getNormalizednopat() {
		return normalizednopat;
	}

	public void setNormalizednopat(String normalizednopat) {
		this.normalizednopat = normalizednopat;
	}

	public String getNormalizednopatmargin() {
		return normalizednopatmargin;
	}

	public void setNormalizednopatmargin(String normalizednopatmargin) {
		this.normalizednopatmargin = normalizednopatmargin;
	}

	public String getPretaxincomemargin() {
		return pretaxincomemargin;
	}

	public void setPretaxincomemargin(String pretaxincomemargin) {
		this.pretaxincomemargin = pretaxincomemargin;
	}


}
