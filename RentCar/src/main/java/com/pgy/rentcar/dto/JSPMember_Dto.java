package com.pgy.rentcar.dto;

public class JSPMember_Dto {
	private String id;
	private String pass;
	private String email;
	private String tel;
	private String age;
	private String job;
	private String hobby;

	public String getId() {
		return id;
	}

	public JSPMember_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSPMember_Dto(String id, String pass, String email, String tel, String age, String job, String hobby) {
		super();
		this.id = id;
		this.pass = pass;
		this.email = email;
		this.tel = tel;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "JSPMember_Dto [id=" + id + ", pass=" + pass + ", email=" + email + ", tel=" + tel + ", age=" + age
				+ ", job=" + job + ", hobby=" + hobby + "]";
	}
}
