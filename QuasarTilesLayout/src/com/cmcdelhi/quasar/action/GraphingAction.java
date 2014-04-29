package com.cmcdelhi.quasar.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.joda.time.Days;

import com.cmcdelhi.quasar.service.GraphingService;
import com.opensymphony.xwork2.ActionSupport;

public class GraphingAction extends ActionSupport implements
		ServletRequestAware {

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

	int startDay;
	int endDay;

	String startDateString;
	String endDateString;

	ArrayList<Integer> ticks = new ArrayList<Integer>();

	HttpServletRequest request;

	ArrayList<Integer> allCourseList = new ArrayList<Integer>();
	ArrayList<Integer> j2seList = new ArrayList<Integer>();
	ArrayList<Integer> j2eeList = new ArrayList<Integer>();
	ArrayList<Integer> androidList = new ArrayList<Integer>();
	ArrayList<Integer> phpList = new ArrayList<Integer>();
	ArrayList<Integer> dotnetList = new ArrayList<Integer>();

	GraphingService gs;

	@Override
	public String execute() throws Exception {

		gs = new GraphingService();

		// checking of all course mapping
		// System.out.println("Check All : " + checkall);
		// System.out.println(" All Course : " + allcourse);
		// System.out.println("Check J2SE : " + checkj2se);
		// System.out.println("J2SE : " + j2seduration);

		startDateString = startdate.toString();
		endDateString = enddate.toString();

		startDay = startdate.getDate();

		endDay = daysBetween(startdate, enddate);

		for (int i = startDay; i <= endDay; i++) {

			ticks.add(i);

		}

		if (checkall.equals("true")) {
			System.out.println("All Courses True ");

			if (allcourse.equals("6 months")) {

				System.out.println(startdate);
				System.out.println(enddate);

				for (int year = startdate.getYear(); year <= enddate.getYear(); year++) {
					for (int month = startdate.getMonth(); month <= enddate
							.getMonth(); month++) {
						for (int date = startdate.getDate(); date <= enddate
								.getDate(); date++) {

							int n = gs
									.getTotalStudentNoOfStudentRegisteredOnADate(new SimpleDateFormat(
											"yyyy-MM-dd").parse((year + 1900)
											+ "-" + (month + 1) + "-" + date));

							Date d = new SimpleDateFormat("yyyy-MM-dd")
									.parse((year + 1900) + "-" + (month + 1)
											+ "-" + date);
							System.out.println("BIS :" + d + " : " + n);

							allCourseList.add(n);
						}
					}
				}

			} else {
				allCourseList.add(0);
				allCourseList.add(1);
			}

		} else {
			allCourseList.add(0);
			allCourseList.add(1);
		}

		System.out
				.println("Allcourse ArrayList Size : " + allCourseList.size());

		return SUCCESS;
	}

	public ArrayList<Integer> getNoOfRegistration() throws ParseException {

		gs = new GraphingService();

		ArrayList<Integer> pointsList = new ArrayList<Integer>();

		for (int i = 1; i <= 30; i++) {
			int n = gs
					.getTotalStudentNoOfStudentRegisteredOnADate(new SimpleDateFormat(
							"yyyy-MM-dd").parse("2014-04-" + i));
			pointsList.add(n);
		}

		return pointsList;

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

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public ArrayList<Integer> getAllCourseList() {
		return allCourseList;
	}

	public void setAllCourseList(ArrayList<Integer> allCourseList) {
		this.allCourseList = allCourseList;
	}

	public ArrayList<Integer> getJ2seList() {
		return j2seList;
	}

	public void setJ2seList(ArrayList<Integer> j2seList) {
		this.j2seList = j2seList;
	}

	public ArrayList<Integer> getJ2eeList() {
		return j2eeList;
	}

	public void setJ2eeList(ArrayList<Integer> j2eeList) {
		this.j2eeList = j2eeList;
	}

	public ArrayList<Integer> getAndroidList() {
		return androidList;
	}

	public void setAndroidList(ArrayList<Integer> androidList) {
		this.androidList = androidList;
	}

	public ArrayList<Integer> getPhpList() {
		return phpList;
	}

	public void setPhpList(ArrayList<Integer> phpList) {
		this.phpList = phpList;
	}

	public ArrayList<Integer> getDotnetList() {
		return dotnetList;
	}

	public void setDotnetList(ArrayList<Integer> dotnetList) {
		this.dotnetList = dotnetList;
	}

	public ArrayList<Integer> getTicks() {
		return ticks;
	}

	public void setTicks(ArrayList<Integer> ticks) {
		this.ticks = ticks;
	}

	// this calculatges the days between two dates
	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

}
