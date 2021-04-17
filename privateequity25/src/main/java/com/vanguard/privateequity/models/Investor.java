package com.vanguard.privateequity.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Investor {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int investorid;
private int versionid;
private int poid;
  private String name;
  private String investorstatus;
  private Date enddate;
private String  email;
private String password,role;
  public int getInvestorid() {
	return investorid;
}
public void setInvestorid(int investorid) {
	this.investorid = investorid;
}
public int getVersionid() {
	return versionid;
}
public void setVersionid(int versionid) {
	this.versionid = versionid;
}
public int getPoid() {
	return poid;
}
public void setPoid(int poid) {
	this.poid = poid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getInvestorstatus() {
	return investorstatus;
}
public void setInvestorstatus(String investorstatus) {
	this.investorstatus = investorstatus;
}
public Date getEnddate() {
	return enddate;
}
public void setEnddate(Date enddate) {
	this.enddate = enddate;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "Investor [investorid=" + investorid + ", versionid=" + versionid + ", poid=" + poid + ", name=" + name
			+ ", investorstatus=" + investorstatus + ", enddate=" + enddate + ", email=" + email + ", password="
			+ password + ", role=" + role + "]";
}
}
