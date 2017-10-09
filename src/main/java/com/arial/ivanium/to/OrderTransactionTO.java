package com.arial.ivanium.to;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//userId, addressId, list of MenuItems and other details from the request
public class OrderTransactionTO {
	
	public static class MenuItem {
		
		@JsonProperty
		private String menuItem;
		
		@JsonProperty
		private int quantity;

		public MenuItem(String menuItem, int quantity) {
			this.menuItem = menuItem;
			this.quantity = quantity;
		}
		
		public MenuItem() {
			
		}

		public String getMenuItem() {
			return menuItem;
		}

		public void setMenuItem(String menuItem) {
			this.menuItem = menuItem;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
	}

	@JsonProperty
	private String userId;
	
	@JsonProperty
	private String addressId;
	
	private String email;
	
	@JsonProperty
	private List<MenuItem> menuItems = new ArrayList<MenuItem>();

	@JsonProperty
	private int promotionalWalletCut;

	@JsonProperty
	private int walletCashCut;
	
	@JsonProperty
	private String isCOD = "true";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public int getPromotionalWalletCut() {
		return promotionalWalletCut;
	}

	public void setPromotionalWalletCut(int promotionalWalletCut) {
		this.promotionalWalletCut = promotionalWalletCut;
	}

	public int getWalletCashCut() {
		return walletCashCut;
	}

	public void setWalletCashCut(int walletCashCut) {
		this.walletCashCut = walletCashCut;
	}

	public String getIsCOD() {
		return isCOD;
	}

	public void setIsCOD(String isCOD) {
		this.isCOD = isCOD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
