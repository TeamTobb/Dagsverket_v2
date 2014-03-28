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
    private String postPlace;
    private String subject;
    private String reqDate;
    private String reqTime;
    private String description;
    private int price;
    private String checkup_date;
    private String startDate;
    private String toolList;
    private String contactPerson;
    private String status;
    private int creatorId; // user which created the case, reference to id from "users" arraylist
    private int supervisorId; // user which is going attending the case, reference to id from "users" arraylist

    // last variables for customer
    // customerId
    // customerFirstName
    // customerLastName
    // customerPhoneNumber

    private Customer employer;

    public Case(int id, String address, int postalCode, String postPlace, String subject, String reqDate, String reqTime, String description, int price, String checkup_date, String startDate, String toolList, String contactPerson, String status, int creatorId, int supervisorId, int customerId, String customerFirstName, String customerLastName, int customerPhoneNumber) {
        this.id = id;
        this.address = address;
        this.postalCode = postalCode;
        this.postPlace = postPlace;
        this.subject = subject;
        this.reqDate = reqDate;
        this.reqTime = reqTime;
        this.description = description;
        this.price = price;
        this.checkup_date = checkup_date;
        this.startDate = startDate;
        this.toolList = toolList;
        this.contactPerson = contactPerson;
        this.status = status;
        this.creatorId = creatorId;
        this.supervisorId = supervisorId;
        this.employer = new Customer(int customerId, String customerFirstName, String customerLastName, int customerPhoneNumber);
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
