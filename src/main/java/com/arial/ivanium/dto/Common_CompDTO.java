package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="com_sec_filing_data")
public class Common_CompDTO {
	
	@Id
	@Column(name=" id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id ;
	
	
	@Column(name=" filing_date")
	private String filing_date ;
	
	
	@Column(name="Ticker")
	private String Ticker ;
	

	@Column(name="period_ended")
   private String period_ended;
	

	@Column(name="report_type")
	private String report_type;
	
	@Column(name="filing_url")
	private String filing_url
	;
	@Column(name="report_url")
	private String report_url;
	
	
	public String getTicker() {
		return Ticker;
	}
	public void setTicker(String Ticker) {
		this.Ticker = Ticker;
	}
	/*public String getAccepted_date() {
		return accepted_date;
	}
	public void setAccepted_date(String accepted_date) {
		this.accepted_date = accepted_date;
	}*/
	public String getFiling_date() {
		return filing_date;
	}
	public void setFiling_date(String filing_date) {
		this.filing_date = filing_date;
	}
	
	
	
	public String getPeriod_ended() {
		return period_ended;
	}
	public void setPeriod_ended(String period_ended) {
		this.period_ended = period_ended;
	}
	/*public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}*/
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getFiling_url() {
		return filing_url;
	}
	public void setFiling_url(String filing_url) {
		this.filing_url = filing_url;
	}
	public String getReport_url() {
		return report_url;
	}
	public void setReport_url(String report_url) {
		this.report_url = report_url;
	}
	
	

}
