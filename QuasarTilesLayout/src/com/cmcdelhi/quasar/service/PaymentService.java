package com.cmcdelhi.quasar.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;

public class PaymentService {

	QuasarConnectionManager quasarConnectionManager;

	public PaymentService() {
		quasarConnectionManager = QuasarConnectionManager.getInstance();
	}

	// hey the paymentDate,proposedDate must be in yyyy-MM-dd
	public List<Payment> getPayment(long studentId, long paymentId,
			PaymentStatus paymentStatus, double depositedAmount,
			double proposedAmount, String paymentDate, String proposedDate,
			long ddNumber, double cashAmount, String bankName,
			long chequeNumber, long receiptNumber, long transactionId) {

		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Payment.class, "payment");
		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		if (studentId != 0) {
			c.add(Restrictions.eq("payment.student.studentId", paymentId));
		}

		if (paymentId != 0) {
			c.add(Restrictions.eq("payment.paymentId", paymentId));
		}

		if (paymentStatus != null) {
			c.add(Restrictions.eq("payment.paymentStatus", paymentStatus));
		}

		if (depositedAmount != 0.0) {
			c.add(Restrictions.eq("payment.paymentDetails.depositedAmount",
					depositedAmount));
		}

		if (proposedAmount != 0.0) {
			c.add(Restrictions.eq("payment.paymentDetails.proposedAmount",
					proposedAmount));
		}

		if (paymentDate != null && !paymentDate.equals("")) {
			c.add(Restrictions.eq("payment.paymentDetails.paymentDate",
					paymentDate));
		}

		if (proposedDate != null && !proposedDate.equals("")) {
			c.add(Restrictions.eq("payment.paymentDetails.proposedDate",
					proposedDate));
		}

		if (ddNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.DDNumber", ddNumber));
		}

		if (cashAmount != 0.0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.cashAmount", cashAmount));
		}

		if (bankName != null && !bankName.equals("")) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.bankName", bankName));
		}

		if (chequeNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.chequeNumber", chequeNumber));
		}

		if (receiptNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.receiptNumber", receiptNumber));
		}

		if (transactionId != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.trasactionID", transactionId));
		}

		return c.list();
	}

}
