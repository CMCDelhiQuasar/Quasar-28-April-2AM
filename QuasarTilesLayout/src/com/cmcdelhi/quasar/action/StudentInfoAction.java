package com.cmcdelhi.quasar.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cmcdelhi.quasar.paymentDetails.InstallmentPayment;
import com.cmcdelhi.quasar.paymentDetails.PaymentDetails;
import com.cmcdelhi.quasar.student.*;
import com.opensymphony.xwork2.ActionSupport;

public class StudentInfoAction extends ActionSupport {

	String emailid;
	String user;
	List<Student> studentinfo = new ArrayList<Student>();

	public String execute() {
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			Query query = s.createQuery("from Student where emailid=:user");
			query.setParameter("user", getEmailid());
			List<Student> list = query.list();

			for (Iterator it = list.iterator(); it.hasNext();) {
				Student student = (Student) it.next();
				studentinfo.add(student);
			//	System.out.println("student "+ (InstallmentPayment) student.getPaymentsList().get(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public List<Student> getStudentinfo() {
		return studentinfo;
	}

	public void setStudentinfo(List<Student> studentinfo) {
		this.studentinfo = studentinfo;
	}

}
