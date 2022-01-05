package com.java.cms;

public class Customer {

	private int Customerid;
	private String Customername;
	private String Customercity;
	private String Customerstate;
	private String Customeremail;
	private String Customermobile;
	public int getCustomerid() {
		return Customerid;
	}
	public void setCustomerid(int customerid) {
		Customerid = customerid;
	}
	public String getCustomername() {
		return Customername;
	}
	public void setCustomername(String customername) {
		Customername = customername;
	}
	public String getCustomercity() {
		return Customercity;
	}
	public void setCustomercity(String customercity) {
		Customercity = customercity;
	}
	public String getCustomerstate() {
		return Customerstate;
	}
	public void setCustomerstate(String customerstate) {
		Customerstate = customerstate;
	}
	public String getCustomeremail() {
		return Customeremail;
	}
	public void setCustomeremail(String customeremail) {
		Customeremail = customeremail;
	}
	public String getCustomermobile() {
		return Customermobile;
	}
	public void setCustomermobile(String customermobile) {
		Customermobile = customermobile;
	}
	@Override
	public String toString() {
		return "Customer [Customerid=" + Customerid + ", Customername=" + Customername + ", Customercity="
				+ Customercity + ", Customerstate=" + Customerstate + ", Customeremail=" + Customeremail
				+ ", Customermobile=" + Customermobile + "]";
	}
	
	
}
