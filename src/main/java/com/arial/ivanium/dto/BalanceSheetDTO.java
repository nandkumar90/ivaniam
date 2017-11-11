package com.arial.ivanium.dto;

	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="balance_sheetDTO")
	public class BalanceSheetDTO {
		@Id
		@Column(name=" id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private String id ;
		
		@Column(name="ticker")
		private String ticker;
		
		@Column(name="statement")
		private String statement;

		
		@Column(name="fiscal_Year")
		private String fiscal_year;
		
		@Column(name="fiscal_Period")
		private String fiscal_period;
		
		@Column(name="cashandequivalents")
		private String cashandequivalents;
		
		@Column(name="accountsreceivable")
		private String accountsreceivable;
		
		@Column(name="netinventory")
		private String netinventory;
		
		@Column(name="othercurrentassets")
		private String othercurrentassets;
		
		@Column(name="totalcurrentassets")
		private String totalcurrentassets;
		
		@Column(name="grossppe")
		private String grossppe;
		
		@Column(name="accumulateddepreciation")
		private String accumulateddepreciation;
		
		@Column(name="netppe")
		private String netppe;
		
		@Column(name="othernoncurrentassets")
		private String othernoncurrentassets;
		
		@Column(name="totalnoncurrentassets")
		private String totalnoncurrentassets;
		
		@Column(name="totalassets")
		private String totalassets;
		
		@Column(name="shorttermdebt")
		private String shorttermdebt;
		
		@Column(name="accountspayable")
		private String accountspayable;
		
		@Column(name="othercurrentliabilities")
		private String othercurrentliabilities;
		
		@Column(name="totalcurrentliabilities")
		private String totalcurrentliabilities;
		
		@Column(name="longtermdebt")
		private String longtermdebt;
		
		@Column(name="othernoncurrentliabilities")
		private String othernoncurrentliabilities;
		
		@Column(name="totalnoncurrentliabilities")
		private String totalnoncurrentliabilities;
		
		@Column(name="totalliabilities")
		private String totalliabilities;
		
		@Column(name="commitmentsandcontingencies")
		private String commitmentsandcontingencies;
		
		@Column(name="commonequity")
		private String commonequity;
		
		@Column(name="retainedearnings")
		private String retainedearnings;
		
		@Column(name="treasurystock")
		private String treasurystock;
		
		@Column(name="aoci")
		private String aoci;
		
		@Column(name="totalcommonequity")
		private String totalcommonequity;
		
		@Column(name="totalequity")
		private String totalequity;
		
		@Column(name="totalequityandnoncontrollinginterests")
		private String totalequityandnoncontrollinginterests;
		
		
	
		
		
		  

		
		@Column(name="totalliabilitiesandequity")
		private String totalliabilitiesandequity;
		
		@Column(name="currentdeferredtaxassets")
		private String currentdeferredtaxassets;
		
		@Column(name="noncurrentdeferredtaxassets")
		private String noncurrentdeferredtaxassets;
		
		@Column(name="dividendspayable")
		private String dividendspayable;
				
		@Column(name="currentdeferredtaxliabilities")
		private String currentdeferredtaxliabilities;
				
		@Column(name="noncurrentdeferredtaxliabilities")
		private String noncurrentdeferredtaxliabilities;

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
		
		
		

		

		

}
