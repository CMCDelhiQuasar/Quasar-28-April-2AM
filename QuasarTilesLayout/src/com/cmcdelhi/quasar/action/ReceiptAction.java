package com.cmcdelhi.quasar.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.service.StudentService;
import com.cmcdelhi.quasar.student.Student;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.opensymphony.xwork2.ActionSupport;

public class ReceiptAction extends ActionSupport implements ServletRequestAware {
	private InputStream inputStream;

	HttpServletRequest request;
	String emailid;

	@Override
	public String execute() throws Exception {

		// Fetch the Details of the Student
		StudentService ss = new StudentService();
		List<Student> studentList = ss.getStudent(null, 0, emailid, 0, null, 0,
				null, 0);

		Student s = studentList.get(0);

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document doc = new Document(PageSize.LETTER);

		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(doc, buffer);
			pdfWriter.setPdfVersion(PdfWriter.PDF_VERSION_1_7);

			doc.open();

			// /Recipt Number Addition
			// Receipt # INV-768479
			Paragraph receiptNumber = new Paragraph("Receipt  #  INV-768479");
			receiptNumber.setAlignment(Paragraph.ALIGN_RIGHT);
			doc.add(receiptNumber);

			// header table
			// ///////////////////////////////////////////////////////
			float[] columnWidths = { 1f, 5f };
			PdfPTable headerTable = new PdfPTable(2);
			headerTable.setWidths(columnWidths);

			// Adding the CMC logo
			String relativeWebPath = "/images/logo.png";
			String absoluteDiskPath = request.getServletContext().getRealPath(
					relativeWebPath);
			Image imghead = Image.getInstance(absoluteDiskPath);
			imghead.setAlignment(Image.RIGHT);

			PdfPCell cell1 = new PdfPCell(imghead);
			cell1.setBorder(Rectangle.NO_BORDER);

			Paragraph cmctitle = new Paragraph("  CMC Delhi");
			cmctitle.add(new Chunk(
					"\n  8,Vaishali Enclave,Main Metro Road,\n  Pitam Pura,(Opp. Metro Pillar No. 351), New Delhi-110034,India \n  Service Tax Registration No.: Consult/Engr/383/CMC LTD/97 dated 23/12/97 \n  STCNo : AAACC2030KST003 "));
			cmctitle.setAlignment(Paragraph.ALIGN_RIGHT);

			PdfPCell cell2 = new PdfPCell(cmctitle);
			cell2.setBorder(Rectangle.NO_BORDER);

			headerTable.setWidthPercentage(100.0f);
			headerTable.addCell(cell1);
			headerTable.addCell(cell2);
			doc.add(headerTable);

			// ////////////////adding a faint line
			// //////////////////////////////////////
			// under title line seprator
			LineSeparator line1 = new LineSeparator(1, 100, new BaseColor(242,
					242, 242), LineSeparator.ALIGN_CENTER, -2);
			doc.add(line1);

			// //////////////////Student DEtails Paragrap
			Paragraph studentDetailTitle = new Paragraph("Student Detail");
			doc.add(studentDetailTitle);

			// StudentDetails
			// Table//////////////////////////////////////////////////////////
			float[] columnWidthsStuDetails = { 2f, 2f, 1f };
			PdfPTable stuDetTable = new PdfPTable(3);
			stuDetTable.setWidths(columnWidthsStuDetails);

			// Nested Table of Student Basic Details
			// Table Configuration
			float[] columnWidthsStuBasicDetails = { 1f, 3f };

			PdfPTable nestedTableStudentBasicDetails = new PdfPTable(2);
			nestedTableStudentBasicDetails
					.setHorizontalAlignment(Element.ALIGN_LEFT);
			nestedTableStudentBasicDetails.setWidthPercentage(90.00f);
			nestedTableStudentBasicDetails.addCell(new Paragraph("Name "));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s.getName()));
			nestedTableStudentBasicDetails.addCell(new Paragraph("ID "));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s
					.getStudentId()+""));
			nestedTableStudentBasicDetails.addCell(new Paragraph("Course "));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s
					.getCourseName()));
			nestedTableStudentBasicDetails.addCell(new Paragraph("Email"));
			nestedTableStudentBasicDetails
					.addCell(new Paragraph(s.getEmailId()));
			nestedTableStudentBasicDetails.addCell(new Paragraph("Contact "));
			nestedTableStudentBasicDetails.addCell(new Paragraph(s
					.getContactNumber()+""));

			nestedTableStudentBasicDetails
					.setWidths(columnWidthsStuBasicDetails);

			// coloumn for Studnet Basic Details
			PdfPCell cellstuDet1 = new PdfPCell();
			cellstuDet1.addElement(nestedTableStudentBasicDetails);
			cellstuDet1.setBorder(Rectangle.NO_BORDER);

			// Nested Table of Student Payment Details
			PdfPTable nestedTableStudentPaymentDetails = new PdfPTable(2);
			nestedTableStudentPaymentDetails
					.setHorizontalAlignment(Element.ALIGN_LEFT);
			nestedTableStudentPaymentDetails
					.addCell(new Paragraph("Course Fee"));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getCourseFees() + ""));
			nestedTableStudentPaymentDetails.addCell(new Paragraph("Discount"));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getDiscountAvailable() + ""));

			nestedTableStudentPaymentDetails.addCell(new Paragraph("S.Tax"));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getServiceTax() + ""));
			nestedTableStudentPaymentDetails.addCell(new Paragraph("Fine(%)"));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getFine() + ""));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(
					"Total Fees Rs"));
			nestedTableStudentPaymentDetails.addCell(new Paragraph(s
					.getFeeDetails().getTotalFee() + ""));

			// coloumn for Payment Details
			PdfPCell cellstuDet2 = new PdfPCell();
			cellstuDet2.addElement(nestedTableStudentPaymentDetails);
			cellstuDet2.setBorder(Rectangle.NO_BORDER);

			// coloumn for Studnet QR Code
			BarcodeQRCode qrcode = new BarcodeQRCode(
					"Bismillah Hirrahma Nirrahim", 100, 100, null);
			Image qrImg = qrcode.getImage();

			PdfPCell cellstuDet3 = new PdfPCell(qrImg);
			cellstuDet3.setBorder(Rectangle.NO_BORDER);

			stuDetTable.setWidthPercentage(100.0f);
			stuDetTable.addCell(cellstuDet1);
			stuDetTable.addCell(cellstuDet2);
			stuDetTable.addCell(cellstuDet3);

			doc.add(stuDetTable);

			// ////////////////adding a faint line
			// //////////////////////////////////////
			// under title line seprator
			LineSeparator line2 = new LineSeparator(1, 100, new BaseColor(242,
					242, 242), LineSeparator.ALIGN_CENTER, -2);
			doc.add(line2);

			// //////////////////Payment Paragrap
			Paragraph paymentDetailTitle = new Paragraph("Payment Detail");
			doc.add(paymentDetailTitle);

			// under address line seprator
			// Table//////////////////////////////////////////////////////////
			// float[] columnWidthsStuDetails = { 1f, 1f,1f };
			PdfPTable payDetTable = new PdfPTable(5);
			// stuDetTable.setWidths(columnWidthsStuDetails);

			// coloumn for Payment Type
			PdfPCell cellpayDet1 = new PdfPCell(new Paragraph("Type"));
			// coloumn for Payment Status
			PdfPCell cellpayDet2 = new PdfPCell(new Paragraph("Status"));
			// coloumn for Payment ID
			PdfPCell cellpayDet3 = new PdfPCell(new Paragraph("Payment ID"));
			// coloumn for Depostin Date
			PdfPCell cellpayDet4 = new PdfPCell(
					new Paragraph("Deposition Date"));
			// coloumn for Amount
			PdfPCell cellpayDet5 = new PdfPCell(new Paragraph("Amount"));

			payDetTable.setWidthPercentage(100.0f);
			payDetTable.addCell(cellpayDet1);
			payDetTable.addCell(cellpayDet2);
			payDetTable.addCell(cellpayDet3);
			payDetTable.addCell(cellpayDet4);
			payDetTable.addCell(cellpayDet5);

			// ///////////////////populating table Data
			for (Payment p : s.getPaymentsList()) {

				payDetTable.addCell("Type");
				payDetTable.addCell(p.getPaymentStatus() + "");
				payDetTable.addCell(p.getPaymentID() + "");
				payDetTable
						.addCell(p.getPaymentDetails().getPaymentDate() + "");
				payDetTable.addCell(p.getPaymentDetails().getDepositedAmount()
						+ "");

			}

			doc.add(payDetTable);

			// /////////////////////////////////////////////////////////
			// grand total bar
			LineSeparator line6 = new LineSeparator(1, 100, new BaseColor(255,
					122, 78), LineSeparator.ALIGN_CENTER, -2);

			// /craeeting grand total
			Paragraph grandTotal = new Paragraph("Grand Total : Rs 14576");
			grandTotal.setAlignment(Paragraph.ALIGN_RIGHT);

			doc.add(line6);
			doc.add(grandTotal);

			// cell1.setBorder(Rectangle.NO_BORDER);

			// table.addCell(cell1);
			// table.addCell(cell2);
			// table.addCell(cell3);
			//
			// table.setWidthPercentage(100.0f);
			//
			// doc.add(table);

			// LineSeparator line2 = new LineSeparator(1, 100, new
			// BaseColor(218,
			// 218, 218), LineSeparator.ALIGN_CENTER, -2);

			// under student/fee details line seprator
			LineSeparator line3 = new LineSeparator(1, 100, new BaseColor(0,
					78, 012), LineSeparator.ALIGN_CENTER, -2);

			// payment details bar top line
			LineSeparator line4 = new LineSeparator(1, 100, new BaseColor(255,
					0, 0), LineSeparator.ALIGN_CENTER, -2);
			// payment details bottom top line
			LineSeparator line5 = new LineSeparator(1, 100, new BaseColor(5,
					140, 55), LineSeparator.ALIGN_CENTER, -2);

			// terms and conditions bar
			LineSeparator line7 = new LineSeparator(1, 100, new BaseColor(242,
					242, 242), LineSeparator.ALIGN_CENTER, -2);

			// footer terms and conditions

			Paragraph termscondition = new Paragraph(
					"Information collected through this site is kept confidential and is not passed to third party organizations for marketing or promotional purposes.");

			doc.add(termscondition);

			Paragraph cmcurl = new Paragraph("cmcdelhi.com");
			cmcurl.setAlignment(Paragraph.ALIGN_RIGHT);

			doc.add(cmcurl);
			doc.add(line7);

			doc.close();

			inputStream = new ByteArrayInputStream(buffer.toByteArray());

		} catch (DocumentException e) {

			e.printStackTrace();
		}

		return SUCCESS;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
