package com.arial.ivanium.dto;

import java.util.Date;

public class XesUsEquity {
	private int id;
	private String Ticker;
	private int Year;
	private Date date;
	private double PX_LAST;
	private double EQY_Diluted_SH_OUT;
	private double FY_EPS;
	private double m_FWD_EPS;
	private double FY_CFPS;
	private double m_FWD_CFPS;
	private double FY_EV;
	private double FY_EBITDA;
	private double xes_us_equitycol;
	private double m_fwd_EBITDA;
	private double FY_BVPS;
	private double m_fwd_BVPS;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return Ticker;
	}

	public void setTicker(String ticker) {
		Ticker = ticker;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPX_LAST() {
		return PX_LAST;
	}

	public void setPX_LAST(double pX_LAST) {
		PX_LAST = pX_LAST;
	}

	public double getEQY_Diluted_SH_OUT() {
		return EQY_Diluted_SH_OUT;
	}

	public void setEQY_Diluted_SH_OUT(double eQY_Diluted_SH_OUT) {
		EQY_Diluted_SH_OUT = eQY_Diluted_SH_OUT;
	}

	public double getFY_EPS() {
		return FY_EPS;
	}

	public void setFY_EPS(double fY_EPS) {
		FY_EPS = fY_EPS;
	}

	public double getM_FWD_EPS() {
		return m_FWD_EPS;
	}

	public void setM_FWD_EPS(double m_FWD_EPS) {
		this.m_FWD_EPS = m_FWD_EPS;
	}

	public double getFY_CFPS() {
		return FY_CFPS;
	}

	public void setFY_CFPS(double fY_CFPS) {
		FY_CFPS = fY_CFPS;
	}

	public double getM_FWD_CFPS() {
		return m_FWD_CFPS;
	}

	public void setM_FWD_CFPS(double m_FWD_CFPS) {
		this.m_FWD_CFPS = m_FWD_CFPS;
	}

	public double getFY_EV() {
		return FY_EV;
	}

	public void setFY_EV(double fY_EV) {
		FY_EV = fY_EV;
	}

	public double getFY_EBITDA() {
		return FY_EBITDA;
	}

	public void setFY_EBITDA(double fY_EBITDA) {
		FY_EBITDA = fY_EBITDA;
	}

	public double getXes_us_equitycol() {
		return xes_us_equitycol;
	}

	public void setXes_us_equitycol(double xes_us_equitycol) {
		this.xes_us_equitycol = xes_us_equitycol;
	}

	public double getM_fwd_EBITDA() {
		return m_fwd_EBITDA;
	}

	public void setM_fwd_EBITDA(double m_fwd_EBITDA) {
		this.m_fwd_EBITDA = m_fwd_EBITDA;
	}

	public double getFY_BVPS() {
		return FY_BVPS;
	}

	public void setFY_BVPS(double fY_BVPS) {
		FY_BVPS = fY_BVPS;
	}

	public double getM_fwd_BVPS() {
		return m_fwd_BVPS;
	}

	public void setM_fwd_BVPS(double m_fwd_BVPS) {
		this.m_fwd_BVPS = m_fwd_BVPS;
	}

}
