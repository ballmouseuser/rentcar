package com.pgy.rentcar.dto;

public class ReserveView {
	String img;
	String name;
	String memid;
	int babyseat;
	int dday;
	int insurance;
	int navigation;
	int qty;
	String rday;
	int regno;
	int wifi;
	int price;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public int getBabyseat() {
		return babyseat;
	}

	public void setBabyseat(int babyseat) {
		this.babyseat = babyseat;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public int getInsurance() {
		return insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	public int getNavigation() {
		return navigation;
	}

	public void setNavigation(int navigation) {
		this.navigation = navigation;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public int getWifi() {
		return wifi;
	}

	public void setWifi(int wifi) {
		this.wifi = wifi;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ReserveView [img=" + img + ", name=" + name + ", memid=" + memid + ", babyseat=" + babyseat + ", dday="
				+ dday + ", insurance=" + insurance + ", navigation=" + navigation + ", qty=" + qty + ", rday=" + rday
				+ ", regno=" + regno + ", wifi=" + wifi + ", price=" + price + "]";
	}

	// 요금정보
	public String getFeeInfo() {
		String feeString = "";
		int a, b;
		feeString += "차량대여료:" + (a = getPrice() * qty * dday);
		feeString += "/옵션대:" + (b = (insurance * 10000 * dday * qty) + (wifi * 10000 * qty) + (navigation * 0)
				+ (babyseat * 5000 * qty));
		feeString += "  [ 총계: " + (a + b) + " ]";
		return feeString;
	}

	// 예약확인 정보 한 row생성 소스 만들기
	public String getReverseInfoRow(String color) {
		StringBuffer trBuffer = new StringBuffer();
		trBuffer.append("<tr align='center' bgcolor='" + color + "'>");
		int a, b;
		// 예약번호 // 차량이미지// 차종 // 예약일 // 대여일수 // 대여수량 // 보험 // wifi// navi // bbst //
		// 대여금액내역// 수정 // 삭제
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + getRegno() + "");
		trBuffer.append("</td>");

		trBuffer.append("<td height='50' width='10%'>");
		trBuffer.append("<img width='150' height='70' alt='' src='resources/img/" + getImg() + "' >");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + getName() + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='10%'>");
		trBuffer.append("" + getRday() + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + getDday() + "");
		trBuffer.append("</td>");

		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + getQty() + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + insurance + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + wifi + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + navigation + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' width='3%'>");
		trBuffer.append("" + babyseat + "");
		trBuffer.append("</td>");
		//
		trBuffer.append("<td height='50' >");
		trBuffer.append("" + getFeeInfo() + "");
		trBuffer.append("</td>");

		// trBuffer.append("</tr>");

		return trBuffer.toString();
	}
}