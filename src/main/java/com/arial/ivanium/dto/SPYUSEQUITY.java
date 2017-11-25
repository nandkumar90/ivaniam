package com.arial.ivanium.dto;

public class SPYUSEQUITY {
	private int id;
	private String ticker;
	private int year;
	private double Close_Price;
	private double fyeps;
	private double pe;

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

	public double getClose_Price() {
		return Close_Price;
	}

	public void setClose_Price(double close_Price) {
		Close_Price = close_Price;
	}

	public double getFyeps() {
		return fyeps;
	}

	public void setFyeps(double fyeps) {
		this.fyeps = fyeps;
	}

	public double getPe() {
		return pe;
	}

	public void setPe(double pe) {
		this.pe = pe;
	}

}
