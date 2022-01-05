package com.java.cms;

public class Vendor {

	private int vendorid;
	private String vendorname;
	private String vendorstate;
	private String vendorcity;
	private String vendoremail;
	private String vendormobile;
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getVendorstate() {
		return vendorstate;
	}
	public void setVendorstate(String vendorstate) {
		this.vendorstate = vendorstate;
	}
	public String getVendorcity() {
		return vendorcity;
	}
	public void setVendorcity(String vendorcity) {
		this.vendorcity = vendorcity;
	}
	public String getVendoremail() {
		return vendoremail;
	}
	public void setVendoremail(String vendoremail) {
		this.vendoremail = vendoremail;
	}
	public String getVendormobile() {
		return vendormobile;
	}
	public void setVendormobile(String vendormobile) {
		this.vendormobile = vendormobile;
	}
	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", vendorname=" + vendorname + ", vendorstate=" + vendorstate
				+ ", vendorcity=" + vendorcity + ", vendoremail=" + vendoremail + ", vendormobile=" + vendormobile
				+ "]";
	}
	
	
	
}
