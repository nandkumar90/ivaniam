package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="financial_income_statement")

public class NewsDTO {
	
	@Id
	@Column(name="TAG")
	private String id;
	
	@Column(name="ticker")
	private String ticker;
	
	@Column(name="figi_ticker")
	private String figi_ticker;
	
	@Column(name="figi")
	private String figi;
	
	@Column(name="title")
	private String title;
	
	@Column(name="publication_date")
	private String publication_date;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="url")
	private String url;
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getFigi_ticker() {
		return figi_ticker;
	}
	public void setFigi_ticker(String figi_ticker) {
		this.figi_ticker = figi_ticker;
	}
	public String getFigi() {
		return figi;
	}
	public void setFigi(String figi) {
		this.figi = figi;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
