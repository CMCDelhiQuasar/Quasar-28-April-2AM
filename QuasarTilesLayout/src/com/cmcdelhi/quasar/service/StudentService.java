package com.cmcdelhi.quasar.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;

public class StudentService {

	QuasarConnectionManager quasarConnectionManager;

	public StudentService() {
		quasarConnectionManager = QuasarConnectionManager.getInstance();
	}

	public List<Student> getAllStudent() {
		System.out.println("Inside getallstudent method...");
		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Student.class);
		return c.list();
	}

	public List<Student> getStudent(String name, long id, String emailId,
			double courseFees, String courseName, long contactNumber,
			PaymentStatus paymentStatus, long paymentId) {

		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Student.class, "student");
		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		if (name != null && !name.equals("")) {
			c.add(Restrictions.eq("student.name", name));
		}

		if (id != 0) {
			c.add(Restrictions.eq("student.studentId", id));
		}

		if (emailId != null && !emailId.equals("")) {
			c.add(Restrictions.eq("student.emailId", emailId));
		}

		if (courseFees != 0.0) {
			c.add(Restrictions.eq("student.feeDetails.courseFees", courseFees));
		}

		if (courseName != null && !courseName.equals("")) {
			c.add(Restrictions.eq("student.courseName", courseName));
		}

		if (contactNumber != 0) {
			c.add(Restrictions.eq("student.contactNumber", contactNumber));
		}

		if (paymentStatus != null) {
			c.createAlias("student.paymentsList", "payment");
			c.add(Restrictions.eq("payment.paymentStatus", paymentStatus));
		}

		return c.list();
	}

}
