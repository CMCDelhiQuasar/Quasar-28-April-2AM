package com.cmcdelhi.quasar.action;

import java.util.ArrayList;

import com.cmcdelhi.quasar.service.GraphingService;
import com.opensymphony.xwork2.ActionSupport;

public class GraphingAction extends ActionSupport {

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}

	public ArrayList<Integer> getNoOfRegistration() {

		GraphingService gs = new GraphingService();

		ArrayList<Integer> pointsList = new ArrayList<Integer>();

		for (int i = 1; i <= 30; i++) {
			pointsList
					.add(gs.getTotalStudentNoOfStudentRegisteredOnADate("2014-04-"
							+ i));
		}

		return pointsList;

	}
}
