package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Historical_data")
public class Historical_data_Common_DTO {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String ID;
	
	@Column(name="Ticker")
	private String Ticker;
	@Column(name="date")
	private String date;
	@Column(name="Close_price")
	private String Close_price;
	@Column(name="volume")
	private String volume;
	@Column(name="beta")
	private String beta;
	
	public Historical_data_Common_DTO(String ticker) {
		this.Ticker = ticker;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTicker() {
		return Ticker;
	}
	public void setTicker(String ticker) {
		Ticker = ticker;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClose_price() {
		return Close_price;
	}
	public void setClose_price(String close_price) {
		Close_price = close_price;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getBeta() {
		return beta;
	}
	public void setBeta(String beta) {
		this.beta = beta;
	}



}
