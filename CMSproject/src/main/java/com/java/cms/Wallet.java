package com.java.cms;

public class Wallet {
	
	private int walletId;
	private int customerId;
	private String wallettype;
	private int amount;
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getWallettype() {
		return wallettype;
	}
	public void setWallettype(String wallettype) {
		this.wallettype = wallettype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", customerId=" + customerId + ", wallettype=" + wallettype
				+ ", amount=" + amount + "]";
	}
	

}
