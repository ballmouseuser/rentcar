package com.pgy.rentcar.dto;

public class Rent_Reserve_Dto {
	private int regno;
	private int no;
	private int qty;
	private int dday;
	private String rday;
	private int insurance;
	private int wifi;
	private int navigation;
	private int babyseat;
	private String memid;
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getInsurance() {
		return insurance;
	}
	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getNavigation() {
		return navigation;
	}
	public void setNavigation(int navigation) {
		this.navigation = navigation;
	}
	public int getBabyseat() {
		return babyseat;
	}
	public void setBabyseat(int babyseat) {
		this.babyseat = babyseat;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	@Override
	public String toString() {
		return "Rent_Reserve_Dto [regno=" + regno + ", no=" + no + ", qty=" + qty + ", dday=" + dday + ", rday=" + rday
				+ ", insurance=" + insurance + ", wifi=" + wifi + ", navigation=" + navigation + ", babyseat="
				+ babyseat + ", memid=" + memid + "]";
	}
	
}
