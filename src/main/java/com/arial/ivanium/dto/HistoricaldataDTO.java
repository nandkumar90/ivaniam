package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="financial_income_statement")
public class HistoricaldataDTO {
	@Id
	@Column(name="TAG")
	private String id;
	
	@Column(name="date")
	private String date;

	@Column(name="value")
      private String value;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
      
      

}
