package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cover_detail")
public class CoverDetailDTO {
	@Id
	@Column(name=" id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Ticker;
	private int Year;

	private double EPS;
	private double CFPS;
	private double EBITDA;
	private double PE;
	private double PCFPS;
	private double EV_EBITDA;
	private double Production_MBOED;
	private double Production_Growth_PER;
	private double Consensus_EPS;
	private double Beat_Miss_vs_Con;
	private double Model_EPS_CAGR;
	private double FCF;
	private double FCF_per_share;
	private double FCF_Yield;
	private double Debt_to_Capital;
	private double Cashshare;
	private double BVshare;
	private double cover_detailcol;
	private double PBook;
	private double Div_Yield;
	private double Beta_to_SPX;
	private double Beta_to_XLE;
	private double Shares_Short_MM;
	private double Short_Interest_Per_Float;
	private double P;
	private double WACC;

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

	public double getEPS() {
		return EPS;
	}

	public void setEPS(double ePS) {
		EPS = ePS;
	}

	public double getCFPS() {
		return CFPS;
	}

	public void setCFPS(double cFPS) {
		CFPS = cFPS;
	}

	public double getEBITDA() {
		return EBITDA;
	}

	public void setEBITDA(double eBITDA) {
		EBITDA = eBITDA;
	}

	public double getPE() {
		return PE;
	}

	public void setPE(double pE) {
		PE = pE;
	}

	public double getPCFPS() {
		return PCFPS;
	}

	public void setPCFPS(double pCFPS) {
		PCFPS = pCFPS;
	}

	public double getEV_EBITDA() {
		return EV_EBITDA;
	}

	public void setEV_EBITDA(double eV_EBITDA) {
		EV_EBITDA = eV_EBITDA;
	}

	public double getProduction_MBOED() {
		return Production_MBOED;
	}

	public void setProduction_MBOED(double production_MBOED) {
		Production_MBOED = production_MBOED;
	}

	public double getProduction_Growth_PER() {
		return Production_Growth_PER;
	}

	public void setProduction_Growth_PER(double production_Growth_PER) {
		Production_Growth_PER = production_Growth_PER;
	}

	public double getConsensus_EPS() {
		return Consensus_EPS;
	}

	public void setConsensus_EPS(double consensus_EPS) {
		Consensus_EPS = consensus_EPS;
	}

	public double getBeat_Miss_vs_Con() {
		return Beat_Miss_vs_Con;
	}

	public void setBeat_Miss_vs_Con(double beat_Miss_vs_Con) {
		Beat_Miss_vs_Con = beat_Miss_vs_Con;
	}

	public double getModel_EPS_CAGR() {
		return Model_EPS_CAGR;
	}

	public void setModel_EPS_CAGR(double model_EPS_CAGR) {
		Model_EPS_CAGR = model_EPS_CAGR;
	}

	public double getFCF() {
		return FCF;
	}

	public void setFCF(double fCF) {
		FCF = fCF;
	}

	public double getFCF_per_share() {
		return FCF_per_share;
	}

	public void setFCF_per_share(double fCF_per_share) {
		FCF_per_share = fCF_per_share;
	}

	public double getFCF_Yield() {
		return FCF_Yield;
	}

	public void setFCF_Yield(double fCF_Yield) {
		FCF_Yield = fCF_Yield;
	}

	public double getDebt_to_Capital() {
		return Debt_to_Capital;
	}

	public void setDebt_to_Capital(double debt_to_Capital) {
		Debt_to_Capital = debt_to_Capital;
	}

	public double getCashshare() {
		return Cashshare;
	}

	public void setCashshare(double cashshare) {
		Cashshare = cashshare;
	}

	public double getBVshare() {
		return BVshare;
	}

	public void setBVshare(double bVshare) {
		BVshare = bVshare;
	}

	public double getCover_detailcol() {
		return cover_detailcol;
	}

	public void setCover_detailcol(double cover_detailcol) {
		this.cover_detailcol = cover_detailcol;
	}

	public double getPBook() {
		return PBook;
	}

	public void setPBook(double pBook) {
		PBook = pBook;
	}

	public double getDiv_Yield() {
		return Div_Yield;
	}

	public void setDiv_Yield(double div_Yield) {
		Div_Yield = div_Yield;
	}

	public double getBeta_to_SPX() {
		return Beta_to_SPX;
	}

	public void setBeta_to_SPX(double beta_to_SPX) {
		Beta_to_SPX = beta_to_SPX;
	}

	public double getBeta_to_XLE() {
		return Beta_to_XLE;
	}

	public void setBeta_to_XLE(double beta_to_XLE) {
		Beta_to_XLE = beta_to_XLE;
	}

	public double getShares_Short_MM() {
		return Shares_Short_MM;
	}

	public void setShares_Short_MM(double shares_Short_MM) {
		Shares_Short_MM = shares_Short_MM;
	}

	public double getShort_Interest_Per_Float() {
		return Short_Interest_Per_Float;
	}

	public void setShort_Interest_Per_Float(double short_Interest_Per_Float) {
		Short_Interest_Per_Float = short_Interest_Per_Float;
	}

	public double getP() {
		return P;
	}

	public void setP(double p) {
		P = p;
	}

	public double getWACC() {
		return WACC;
	}

	public void setWACC(double wACC) {
		WACC = wACC;
	}

}
