package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="financial_income_statement")
public class IntiutionalOwnershipDTO {
	@Id
	
	@Column(name="owner_cik")	
	private String owner_cik;
	
	@Column(name="owner_name")
	private String owner_name;
	
	@Column(name="period_ended")
    private String period_ended;
	
	@Column(name="value")
    private String value;
	
	@Column(name="amount")
    private String amount;
	
	@Column(name="sole_voting_authority")
	private String sole_voting_authority;
	
	@Column(name="shared_voting_authority")
	private String shared_voting_authority;
	
	@Column(name="no_voting_authority")
	private String no_voting_authority;
	
	@Column(name="prev_amount")
	private String prev_amount;
	
	@Column(name="amount_chg")
	private String amount_chg;
	
	@Column(name="amount_pct_chg")
	private String  amount_pct_chg;
	
	public String getOwner_cik() {
		return owner_cik;
	}
	public void setOwner_cik(String owner_cik) {
		this.owner_cik = owner_cik;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getPeriod_ended() {
		return period_ended;
	}
	public void setPeriod_ended(String period_ended) {
		this.period_ended = period_ended;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSole_voting_authority() {
		return sole_voting_authority;
	}
	public void setSole_voting_authority(String sole_voting_authority) {
		this.sole_voting_authority = sole_voting_authority;
	}
	public String getShared_voting_authority() {
		return shared_voting_authority;
	}
	public void setShared_voting_authority(String shared_voting_authority) {
		this.shared_voting_authority = shared_voting_authority;
	}
	public String getNo_voting_authority() {
		return no_voting_authority;
	}
	public void setNo_voting_authority(String no_voting_authority) {
		this.no_voting_authority = no_voting_authority;
	}
	public String getPrev_amount() {
		return prev_amount;
	}
	public void setPrev_amount(String prev_amount) {
		this.prev_amount = prev_amount;
	}
	public String getAmount_chg() {
		return amount_chg;
	}
	public void setAmount_chg(String amount_chg) {
		this.amount_chg = amount_chg;
	}
	public String getAmount_pct_chg() {
		return amount_pct_chg;
	}
	public void setAmount_pct_chg(String amount_pct_chg) {
		this.amount_pct_chg = amount_pct_chg;
	}
}
