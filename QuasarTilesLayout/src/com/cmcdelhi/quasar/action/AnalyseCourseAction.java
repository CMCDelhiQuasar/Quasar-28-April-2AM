package com.cmcdelhi.quasar.action;

import java.util.Date;

public class AnalyseCourseAction {

	Date startdate;
	Date enddate;
	String checkall;
	String allcourse;
	String checkj2se;
	String j2seduration;
	String checkj2ee;
	String j2eeduration;
	String checkandriod;
	String andriodduration;
	String checkdotnet;
	String dotnetduration;
	String checkphp;
	String phpduration;

	public String execute() {
		System.out.println("come to analyse course action"+checkall);
		return "success";

 	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getCheckall() {
		return checkall;
	}

	public void setCheckall(String checkall) {
		this.checkall = checkall;
	}

	public String getAllcourse() {
		return allcourse;
	}

	public void setAllcourse(String allcourse) {
		this.allcourse = allcourse;
	}

	public String getCheckj2se() {
		return checkj2se;
	}

	public void setCheckj2se(String checkj2se) {
		this.checkj2se = checkj2se;
	}

	public String getJ2seduration() {
		return j2seduration;
	}

	public void setJ2seduration(String j2seduration) {
		this.j2seduration = j2seduration;
	}

	public String getCheckj2ee() {
		return checkj2ee;
	}

	public void setCheckj2ee(String checkj2ee) {
		this.checkj2ee = checkj2ee;
	}

	public String getJ2eeduration() {
		return j2eeduration;
	}

	public void setJ2eeduration(String j2eeduration) {
		this.j2eeduration = j2eeduration;
	}

	public String getCheckandriod() {
		return checkandriod;
	}

	public void setCheckandriod(String checkandriod) {
		this.checkandriod = checkandriod;
	}

	public String getAndriodduration() {
		return andriodduration;
	}

	public void setAndriodduration(String andriodduration) {
		this.andriodduration = andriodduration;
	}

	public String getCheckdotnet() {
		return checkdotnet;
	}

	public void setCheckdotnet(String checkdotnet) {
		this.checkdotnet = checkdotnet;
	}

	public String getDotnetduration() {
		return dotnetduration;
	}

	public void setDotnetduration(String dotnetduration) {
		this.dotnetduration = dotnetduration;
	}

	public String getCheckphp() {
		return checkphp;
	}

	public void setCheckphp(String checkphp) {
		this.checkphp = checkphp;
	}

	public String getPhpduration() {
		return phpduration;
	}

	public void setPhpduration(String phpduration) {
		this.phpduration = phpduration;
	}
      
}
