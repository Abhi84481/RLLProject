package com.java.cms;

public class Restaurant {
	
	private int rid;
	private String rname;;
	private String City;
	private String Branch;
	private String Email;
	private String ContactNo;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", rname=" + rname + ", City=" + City + ", Branch=" + Branch + ", Email="
				+ Email + ", ContactNo=" + ContactNo + "]";
	}
	

}
