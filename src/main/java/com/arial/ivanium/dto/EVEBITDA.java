package com.arial.ivanium.dto;

import java.util.Date;

public class EVEBITDA {

	private int ID;
	private String Ticker;
	private Date date;
	private double actualevEBITDA;
	private double average;
	private double pSD;
	private double nSD;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTicker() {
		return Ticker;
	}
	public void setTicker(String ticker) {
		Ticker = ticker;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getActualevEBITDA() {
		return actualevEBITDA;
	}
	public void setActualevEBITDA(double actualevEBITDA) {
		this.actualevEBITDA = actualevEBITDA;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public double getpSD() {
		return pSD;
	}
	public void setpSD(double pSD) {
		this.pSD = pSD;
	}
	public double getnSD() {
		return nSD;
	}
	public void setnSD(double nSD) {
		this.nSD = nSD;
	}
	

}
