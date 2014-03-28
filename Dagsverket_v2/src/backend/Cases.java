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
public class Cases {
    public static int NO_CONTRACTOR_FIRSTNAME = 1;
    public static int NO_CONTRACTOR_LASTNAME = 2;
    public static int NO_CONTACT_INFO = 3;
    public static int NO_SUBJECT = 4;
    public static int WRONG_PHONE_FORMAT = 5;
    public static int WRONG_POSTALCODE_FORMAT = 6;
    public static int WRONG_PRICE_FORMAT = 7;
    private Database db; 
	private ArrayList<Case> cases;

	public Cases(int max, Database db) { // remove max
            this.db = db;
            this.cases = new ArrayList<Case>();
	}

	// public boolean updateCaseList(String status, int start, int end) {
	// 	this.cases = new ArrayList<Case>();
 //        // UPDATE WHOLE LIST FROM DB WITH CORRECT STATUS...
	// 	// FROM START TO END?
	// 	return false;
	// }

	// DETTE ER LURT, SLIK AT NAAR VI SKAL SE PAA DETALJER SAA KAN VI HENTE EN CASE FRA LISTEN.

	// public ResultSet getCasesFromDatabase(int max) {
	// 	// hent all data fra database
	// 	// MAX angir hvor mange du vil hente
	// 	Statement setning = this.conn.createStatement();
    //  String SQL = "select * from events";
    //  ResultSet test123 = setning.executeQuery(SQL);
    //  DETTE SKAL EGENTLIG GJORES I DATABASE
	// 	return test123;

    // select * from cases natural join customers;

    //  public void updateUserList() {
    //     this.users = new ArrayList<User>();
    //     String sqlStatement = "Select * from users";
    //     ResultSet rs = db.executeQuery(sqlStatement);
    //     try {
    //         while(rs.next()) {
    //             users.add(new User(
    //                 rs.getInt("id"),
    //                 rs.getString("firstName"),
    //                 rs.getString("lastName")
    //                 ));
    //         }            
    //     } catch(SQLException e) {
    //         System.out.println("SQLError: " + e);
    //     } 
    //     finally{
    //         db.closeAll();
    //     }
    // }

    public Case getCaseById(int id) {
        if(id <= this.cases.size() && id != 0) {
            return this.cases.get(id);
        }
        return null;
    }

    public void updateCaseList() {
        this.cases = new ArrayList<Case>();
        String sqlStatement = "select * from cases natural join customers";
        ResultSet rs = db.executeQuery(sqlStatement);
        try {
            while(rs.next()) {
                this.cases.add(new Case(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getInt("postalcode"),
                        rs.getString("postplace"),
                        rs.getString("subject"),
                        rs.getString("req_date"),
                        rs.getString("req_time"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getString("checkup_date"),
                        rs.getString("startdate"),
                        rs.getString("toollist"),
                        rs.getString("contactperson"),
                        rs.getString("status"),
                        rs.getInt("creator"),
                        rs.getInt("supervisor"),
                        rs.getInt("customer"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("phonenumber")
                    ));
            }
        } catch(SQLException e) {
            System.out.println("SQLError: " + e);
        } finally {
            db.closeAll();
        }
    }

	public ArrayList<Case> getCases() {
		return this.cases;
	}

	public ArrayList<Integer> createCase(int creator, String customerFirstName, String customerLastName, String caseAddress, 
                                            String postalCode, String postPlace, String phoneNumber, String subject, 
                                            String reqDate, String reqTime, String description, int supervisor,
                                            String price, String checkupDate, String startDate, String toolList,
                                            String contactPerson, String status) {                                           
            int phoneNumberInt = 0;
            int priceInt = 0; 
            int postalCodeInt = 0;
            int customerId = 0; 
            ArrayList<Integer> errors = new ArrayList<Integer>();           
            try{
                priceInt = Integer.parseInt(price);
            }
            catch(NumberFormatException e){
                System.out.println("feil i price parseint" + e);
                errors.add(WRONG_PRICE_FORMAT);
            }            
            try{
                postalCodeInt = Integer.parseInt(postalCode);
            }
            catch(NumberFormatException e){
                System.out.println("feil i postalcode parseint" + e);
                errors.add(WRONG_POSTALCODE_FORMAT);                
            }            
              try{
                phoneNumberInt = Integer.parseInt(phoneNumber);
            }
            catch(NumberFormatException e){
                System.out.println("feil i phonenumber parseint" + e);
                errors.add(WRONG_PHONE_FORMAT);                
            }
            errors.addAll(checkFields(customerFirstName, customerLastName, phoneNumberInt, subject));
            
            if(errors.size()==0){
                System.out.println("errors == null");
                 String sqlStatement = "SELECT id FROM customers WHERE firstName = '" + customerFirstName +
                                       "' AND lastName = '" + customerLastName + "' AND phoneNumber = " + phoneNumberInt;
                ResultSet rs = this.db.executeQuery(sqlStatement);
                try{
                    if(rs.next()){                        
                                customerId = rs.getInt("id");
                    }
                    else{
                        this.db.createConnection();                        
                        PreparedStatement insertCustomerStatement = this.db.getConnection().prepareStatement(
                                "INSERT INTO customers VALUES(DEFAULT, ?, ?, ?)");
                        insertCustomerStatement.setString(1, customerFirstName);
                        insertCustomerStatement.setString(2, customerLastName); 
                        insertCustomerStatement.setInt(3, phoneNumberInt);                         
                        insertCustomerStatement.executeUpdate();
                        db.closeAll();                        
                        ResultSet res = this.db.executeQuery(sqlStatement);
                        
                        try{
                            while(res.next()){
                                customerId = res.getInt("id");
                            }                        
                        }
                        catch(SQLException e){
                            System.out.println("feil 1 " + e);                            
                        }
                    }
                }catch(SQLException e){
                    System.out.println("feil 2 " + e);
                }
                finally{                    
                    db.closeAll();
                }
                this.db.createConnection();
                try{
                    PreparedStatement insertCaseStatement = db.getConnection().prepareStatement("INSERT INTO cases VALUES("
                                                        + "DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    insertCaseStatement.setString(1, caseAddress);
                    insertCaseStatement.setInt(2, postalCodeInt);
                    insertCaseStatement.setString(3, postPlace);
                    insertCaseStatement.setString(4, subject);
                    insertCaseStatement.setString(5, reqDate);
                    insertCaseStatement.setString(6, reqTime);
                    insertCaseStatement.setString(7, description);
                    insertCaseStatement.setInt(8, priceInt);
                    insertCaseStatement.setString(9, checkupDate);
                    insertCaseStatement.setString(10, startDate);
                    insertCaseStatement.setString(11, toolList);
                    insertCaseStatement.setString(12, contactPerson);
                    insertCaseStatement.setString(13, status);
                    insertCaseStatement.setInt(14, creator);
                    insertCaseStatement.setInt(15, supervisor);
                    insertCaseStatement.setInt(16, customerId);
                    
                    insertCaseStatement.executeUpdate();
                    
                }catch(SQLException e){
                    System.out.println("feil i insertCase: " + e);
                }     
                finally{
                    db.closeAll();
                }
            }
            return errors;
	}

	private ArrayList<Integer> checkFields(String customerFirstName, String customerLastName, int phoneNumber, String subject) {
		ArrayList<Integer> errors = new ArrayList<Integer>();
                
        // important: contractor, phone / mail, subject
        if(customerFirstName == null || customerFirstName.trim().equals("")) {
    		errors.add(NO_CONTRACTOR_FIRSTNAME);
    	}                
    	if(customerLastName == null || customerLastName.trim().equals("")) {
    		errors.add(NO_CONTRACTOR_LASTNAME);
    	} 
        if(phoneNumber <= 0) {
            errors.add(NO_CONTACT_INFO);
        }
        if(subject == null || subject.trim().equals("")) {
            errors.add(NO_SUBJECT);
        }
        return errors;
	}

    public static void main(String[] args) {
        Database db = new Database();
        Cases c = new Cases(30, db);
        c.updateCaseList();
        Case n1 = c.getCaseById(4);
        if(n1 != null) {
            System.out.println("Description: " + n1.getDescription());
            System.out.println("Price: " + n1.getPrice());
        }
    }
}
