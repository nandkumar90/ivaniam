package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="financial_income_statement")
public class FinancialIncomeStatmentDTO {
	@Column(name="VALUE")
	private String Value;
	
	@Id
	@Column(name="TAG")
	private String Tag;

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
	

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}
	
	
	
}
