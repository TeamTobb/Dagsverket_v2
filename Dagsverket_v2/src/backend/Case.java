/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Jorgen
 */
public class Case {
	private int id;
	private String address;
	private int postalCode;
	private Customer employer;
	private String status;
	private String reqDate;
	private String inspectDate;
	private String startDate;

	// public Case(int id, String address, int postalCode, String firstname, String lastname, int phoneNumber, String customerAddress, int customerPostalCode, String customerPostPlace, String status, String reqDate, String inspectDate, String startDate) {
    public Case(int id, int creator, String customerFirstName, String customerLastName, String caseAddress, 
                                            String postalCode, String postPlace, String phoneNumber, String subject, 
                                            String reqDate, String reqTime, String description, int supervisor,
                                            String price, String checkupDate, String startDate, String toolList,
                                            String contactPerson, String status) {
		this.id = id;
		this.address = address;
		this.postalCode = postalCode;
		//this.employer = new Customer(firstname, lastname, phoneNumber, customerAddress, customerPostalCode, customerPostPlace);
        this.employer = new Customer()
		this.status = status;
		this.reqDate = reqDate;
		this.inspectDate = inspectDate;
		this.startDate = startDate;
	}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @return the employer
     */
    public Customer getEmployer() {
        return employer;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the reqDate
     */
    public String getReqDate() {
        return reqDate;
    }

    /**
     * @return the inspectDate
     */
    public String getInspectDate() {
        return inspectDate;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }
}
