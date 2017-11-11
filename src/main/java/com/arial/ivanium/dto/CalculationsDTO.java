package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fact_frac_ingredientstest")
public class CalculationsDTO {
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

	@Column(name = "revenuegrowth")
	private String revenuegrowth;

	@Column(name = "nopat")
	private String nopat;
	
	@Column(name = "nopatmargin")
	private String nopatmargin;
	
	@Column(name = "investedcapital")
	private String investedcapital;
	
	@Column(name = "investedcapitalturnover")
	private String investedcapitalturnover;
	
	@Column(name = "investedcapitalincreasedecrease")
	private String investedcapitalincreasedecrease;
	
	@Column(name = "freecashflow")
	private String freecashflow;
	
	@Column(name = "netnonopex")
	private String netnonopex;
	
	@Column(name = "netnonopobligations")
	private String netnonopobligations;
	
	@Column(name = "ebit")
	private String ebit;
	@Column(name = "depreciationandamortization")
	private String depreciationandamortization;
	@Column(name = "ebitda")
	private String ebitda;
	@Column(name = "capex")
	private String capex;
	@Column(name = "dfcfnwc")
	private String dfcfnwc;
	@Column(name = "dfnwc")
	private String dfnwc;
	@Column(name = "nwc")
	private String nwc;
	@Column(name = "debt")
	private String debt;
	@Column(name = "ltdebtandcapleases")
	private String ltdebtandcapleases;
	@Column(name = "netdebt")
	private String netdebt;
	@Column(name = "totalcapital")
	private String totalcapital;
	@Column(name = "bookvaluepershare")
	private String bookvaluepershare;
	@Column(name = "tangbookvaluepershare")
	private String tangbookvaluepershare;
	@Column(name = "marketcap")
	private String marketcap;
	@Column(name = "enterprisevalue")
	private String enterprisevalue;
	@Column(name = "pricetobook")
	private String pricetobook;
	@Column(name = "pricetotangiblebook")
	private String pricetotangiblebook;
	@Column(name = "pricetorevenue")
	private String pricetorevenue;
	@Column(name = "pricetoearnings")
	private String pricetoearnings;
	@Column(name = "dividendyield")
	private String dividendyield;
	@Column(name = "earningsyield")
	private String earningsyield;
	@Column(name = "evtoinvestedcapital")
	private String evtoinvestedcapital;
	@Column(name = "evtorevenue")
	private String evtorevenue;
	@Column(name = "evtoebitda")
	private String evtoebitda;
	@Column(name = "evtoebit")
	private String evtoebit;
	@Column(name = "evtonopat")
	private String evtonopat;
	@Column(name = "evtoocf")
	private String evtoocf;
	@Column(name = "evtofcff")
	private String evtofcff;
	@Column(name = "ebitdagrowth")
	private String ebitdagrowth;
	@Column(name = "ebitgrowth")
	private String ebitgrowth;
	@Column(name = "nopatgrowth")
	private String nopatgrowth;
	@Column(name = "netincomegrowth")
	private String netincomegrowth;
	@Column(name = "epsgrowth")
	private String epsgrowth;
	@Column(name = "ocfgrowth")
	private String ocfgrowth;
	@Column(name = "fcffgrowth")
	private String fcffgrowth;
	@Column(name = "investedcapitalgrowth")
	private String investedcapitalgrowth;
	@Column(name = "revenueqoqgrowth")
	private String revenueqoqgrowth;
	@Column(name = "ebitdaqoqgrowth")
	private String ebitdaqoqgrowth;
	@Column(name = "ebitqoqgrowth")
	private String ebitqoqgrowth;
	@Column(name = "nopatqoqgrowth")
	private String nopatqoqgrowth;
	@Column(name = "netincomeqoqgrowth")
	private String netincomeqoqgrowth;
	@Column(name = "epsqoqgrowth")
	private String epsqoqgrowth;
	@Column(name = "ocfqoqgrowth")
	private String ocfqoqgrowth;
	@Column(name = "fcffqoqgrowth")
	private String fcffqoqgrowth;
	@Column(name = "investedcapitalqoqgrowth")
	private String investedcapitalqoqgrowth;
	@Column(name = "grossmargin")
	private String grossmargin;
	@Column(name = "ebitdamargin")
	private String ebitdamargin;
	@Column(name = "operatingmargin")
	private String operatingmargin;
	@Column(name = "ebitmargin")
	private String ebitmargin;
	@Column(name = "profitmargin")
	private String profitmargin;
	@Column(name = "costofrevtorevenue")
	private String costofrevtorevenue;
	@Column(name = "sgaextorevenue")
	private String sgaextorevenue;
	@Column(name = "rdextorevenue")
	private String rdextorevenue;
	@Column(name = "opextorevenue")
	private String opextorevenue;
	@Column(name = "taxburdenpct")
	private String taxburdenpct;
	@Column(name = "interestburdenpct")
	private String interestburdenpct;
	@Column(name = "efftaxrate")
	private String efftaxrate;
	@Column(name = "assetturnover")
	private String assetturnover;
	@Column(name = "arturnover")
	private String arturnover;
	@Column(name = "invturnover")
	private String invturnover;
	@Column(name = "faturnover")
	private String faturnover;
	@Column(name = "apturnover")
	private String apturnover;
	@Column(name = "dso")
	private String dso;
	@Column(name = "dio")
	private String dio;
	@Column(name = "dpo")
	private String dpo;
	@Column(name = "ccc")
	private String ccc;
	@Column(name = "finleverage")
	private String finleverage;
	@Column(name = "leverageratio")
	private String leverageratio;
	@Column(name = "compoundleveragefactor")
	private String compoundleveragefactor;
	@Column(name = "ltdebttoequity")
	private String ltdebttoequity;
	@Column(name = "debttoequity")
	private String debttoequity;
	@Column(name = "roic")
	private String roic;
	@Column(name = "nnep")
	private String nnep;
	@Column(name = "roicnnepspread")
	private String roicnnepspread;
	@Column(name = "rnnoa")
	private String rnnoa;
	@Column(name = "roe")
	private String roe;
	@Column(name = "croic")
	private String croic;
	@Column(name = "oroa")
	private String oroa;
	@Column(name = "roa")
	private String roa;
	@Column(name = "noncontrollinginterestsharingratio")
	private String noncontrollinginterestsharingratio;
	@Column(name = "roce")
	private String roce;
	@Column(name = "divpayoutratio")
	private String divpayoutratio;
	@Column(name = "augmentedpayoutratio")
	private String augmentedpayoutratio;
	@Column(name = "ocftocapex")
	private String ocftocapex;
	@Column(name = "stdebttocap")
	private String stdebttocap;
	@Column(name = "ltdebttocap")
	private String ltdebttocap;
	@Column(name = "debttototalcapital")
	private String debttototalcapital;
	@Column(name = "preferredtocap")
	private String preferredtocap;
	@Column(name = "noncontrolinttocap")
	private String noncontrolinttocap;
	@Column(name = "commontocap")
	private String commontocap;
	@Column(name = "debttoebitda")
	private String debttoebitda;
	@Column(name = "netdebttoebitda")
	private String netdebttoebitda;
	@Column(name = "ltdebttoebitda")
	private String ltdebttoebitda;
	@Column(name = "debttonopat")
	private String debttonopat;
	@Column(name = "netdebttonopat")
	private String netdebttonopat;
	@Column(name = "ltdebttonopat")
	private String ltdebttonopat;
	@Column(name = "altmanzscore")
	private String altmanzscore;
	@Column(name = "ebittointerestex")
	private String ebittointerestex;
	@Column(name = "nopattointerestex")
	private String nopattointerestex;
	@Column(name = "ebitlesscapextointerestex")
	private String ebitlesscapextointerestex;
	@Column(name = "nopatlesscapextointex")
	private String nopatlesscapextointex;
	@Column(name = "ocftointerestex")
	private String ocftointerestex;
	@Column(name = "ocflesscapextointerestex")
	private String ocflesscapextointerestex;
	@Column(name = "fcfftointerestex")
	private String fcfftointerestex;
	@Column(name = "currentratio")
	private String currentratio;
	@Column(name = "quickratio")
	private String quickratio;
	@Column(name = "dfcfnwctorev")
	private String dfcfnwctorev;
	@Column(name = "dfnwctorev")
	private String dfnwctorev;
	@Column(name = "nwctorev")
	private String nwctorev;
	@Column(name = "normalizednopat")
	private String normalizednopat;
	@Column(name = "normalizednopatmargin")
	private String normalizednopatmargin;
	@Column(name = "pretaxincomemargin")
	private String pretaxincomemargin;

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
