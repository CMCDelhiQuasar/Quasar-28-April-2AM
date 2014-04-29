package com.cmcdelhi.quasar.student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.service.PaymentService;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();

		Session s = sf.openSession();

		s.beginTransaction();

		// // Criteria c = s.createCriteria(Student.class);
		// // c.add(Restrictions.eq("studentId", 9L));
		// // c.add(Restrictions.eq("name", "Salman Khurshid"));
		// Criteria c = s.createCriteria(Student.class);
		// // c.createAlias("student.paymentsList", "payment");
		// // c.createAlias("student.paymentsList", "payment");
		// // c.add(Restrictions.eq("payment.paymentID", 22L));
		// // c.add(Restrictions.eq("payment.paymentDetails.proposedAmount",
		// // 3000.00));
		// c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		// // c.createAlias("student.paymentsList", "payment");
		// // c.createAlias("student.feeDetails", "feeDetails");
		// c.add(Restrictions.eq("student.feeDetails.courseFees", 12000.00));
		//
		// List<Student> studentList = c.list();
		//
		// System.out.println("Student List Size : " + studentList.size());
		//
		// System.out.println("---------------->>");
		//
		// for (Student st : studentList) {
		// System.out.println(st.getStudentId() + "  " + st.getName());
		// }

		Criteria c = s.createCriteria(Payment.class);
		try {

			Date minDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse("2014-04-30");

			Date maxDate = new Date(minDate.getTime()
					+ TimeUnit.DAYS.toMillis(1));

			System.out.println(minDate);
			System.out.println(maxDate);

			// System.out.println();

			Conjunction and = Restrictions.conjunction();
			and.add(Restrictions.ge("paymentDetails.proposedDate", minDate));
			and.add(Restrictions.lt("paymentDetails.proposedDate", maxDate));

			c.add(and);

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		}

		List<Payment> paymentList = c.list();

		System.out.println("Payment List Size " + paymentList.size());

		for (Payment p : paymentList) {
			System.out.println(p.getPaymentID());
		}

		s.getTransaction().commit();
		s.close();

		// StudentService ss = new StudentService();
		//
		// for (Student stu : ss.getStudent("", 0, null, 0, "", 0,
		// PaymentStatus.FULLPAID, 0)) {
		// System.out.print(stu.getName());
		// System.out.println(" >>>>>>> ");
		// System.out.println("          ");
		// for (Payment p : stu.getPaymentsList()) {
		// System.out.println("          " + p.getPaymentID() + " : "
		// + p.getPaymentStatus());
		// }
		// }

//		PaymentService ps = new PaymentService();
//
//		for (Payment p : ps.getPayment(0, 0, null, 0, 0, "2014-04-25", null, 0, 0,
//				null, 0, 0, 0L)) {
//			System.out.println("" + p.getPaymentID());
//		}
	}
}
