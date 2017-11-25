package com.arial.ivanium.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="com_short_interest_data")
public class HistoricaldataDTO {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@Column(name="ticker")
	private String ticker;
	
	@Column(name="date")
	private String date;

	@Column(name="Short_interest")
      private String value;
	
	/*@Column(name="item")
    private String item;*/
	

	
	
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}


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
	
	
	/*public String getItem() {
		return ticker;
	}

	public void setItem(String item) {
		this.item = item;
	}*/
	
	
	
      

}

