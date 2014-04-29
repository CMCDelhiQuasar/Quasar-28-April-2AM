package com.cmcdelhi.quasar.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;

///Author Gufran Khurshid 29 April 2014 

public class GraphingService {

	QuasarConnectionManager quasarConnectionManager;

	public GraphingService() {
		quasarConnectionManager = QuasarConnectionManager.getInstance();
	}

	int getTotalStudentNoOfStudent() {
		return 0;
	}

	// date in yyyy-MM-dd format 2014-04-30
	int getTotalStudentNoOfStudentRegisteredOnADate(String specifiedate) {
		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Payment.class);
		try {

			Date minDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse(specifiedate);

			Date maxDate = new Date(minDate.getTime()
					+ TimeUnit.DAYS.toMillis(1));

			System.out.println(minDate);
			System.out.println(maxDate);

			// System.out.println();

			Conjunction and = Restrictions.conjunction();
			and.add(Restrictions.ge("paymentDetails.proposedDate", minDate));
			and.add(Restrictions.lt("paymentDetails.proposedDate", maxDate));

			c.add(and);

			return c.list().size();

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			return 0;
		}

	}

	// date in yyyy-MM-dd format
	int getTotalStudentNoOfStudentRegisteredBetwenDates(String startDate,
			String endDate) {
		return 0;
	}

	int getTotalStudentNoOfStudentRegisteredBetwenDatesForACourse(
			String startDate, String endDate, String courseName) {
		return 0;
	}

}
