/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.awt.Color;
import java.util.*;
import java.sql.*;



public class Sales {
    public static int WRONG_PHONE_FORMAT = 1;
    public static int WRONG_POSTALCODE_FORMAT = 2;
    public static int WRONG_QUANTITY_FORMAT = 3;
    public static int NO_CUSTOMER_FIRSTNAME = 4;
    public static int NO_CUSTOMER_LASTNAME = 5;
    public static int NO_ADDRESS_INFO = 6;
    public static int NO_QUANTITY = 7; 
    public static int NO_POSTNUMBER = 8; 
    public static int NO_WOODTYPE = 9; 
    public static int NO_PHONENUMBER = 10;
    public static int WRONG_POSTNUMBER = 11; 
    
    private ArrayList<Sale> sales;
    private Database db;
    
    public Sales(Database db) {
    	this.sales = new ArrayList<Sale>();
        this.db = db;
    }

    public ArrayList<Sale> getSales() {
    	return this.sales;
    }
    
    public void deleteSale(){
        //add delete data TODO
    }   

    public ArrayList<Integer> createSale(String customerFirstName, String customerLastName, String phoneNumber, String woodType, 
                                         String postnr, String address, String quantity, String postalPlace) {
        ArrayList<Integer> errors = new ArrayList<Integer>(); 
        int telephone = 0;
        int quantityNr = 0;
        int postCode = 0; 
        int customerId = 0;
        System.out.println("Lager en");
        try{
            telephone = Integer.parseInt(phoneNumber.trim());
        } catch(NumberFormatException e){
            System.out.println("Feil telefonnumer. Bare tall" + e);
            errors.add(WRONG_PHONE_FORMAT);
        }
        
        try{
            postCode = Integer.parseInt(postnr.trim());
        }
        catch(NumberFormatException e){
            System.out.println("Feil postnummer. Bare tall"+e);
            errors.add(WRONG_POSTALCODE_FORMAT);
        }
        
        try{
            quantityNr = Integer.parseInt(quantity.trim());
        }
        catch(NumberFormatException e){
            System.out.println("Feil antall. Bare tall"+e);
            errors.add(WRONG_QUANTITY_FORMAT);
        }
        
       //fyll opp denne med alt
        errors.addAll(checkFields(customerFirstName, customerLastName, telephone, woodType, postCode, address, quantityNr));
        
        //return errors;
        if (errors.isEmpty()==true){
        
        //legg til Customer DB eller/og hent ut customer ID. 
            customerId = addCustomer(customerFirstName, customerLastName, telephone);


            db.createConnection();
            try{
                PreparedStatement sqlStatement = db.getConnection().prepareStatement("INSERT INTO sales VALUES(DEFAULT, ?, ?, ?, ?, ?, ?)");
                sqlStatement.setString(1, String.valueOf(quantity));   
                sqlStatement.setInt(2, customerId);
                sqlStatement.setString(3, woodType);
                sqlStatement.setInt(4, postCode);
                sqlStatement.setString(5, postalPlace);
                sqlStatement.setString(6, address);

                db.executeUpdate(sqlStatement);
            }        
            catch(SQLException e){
                System.out.println("feil i createSale preparedStatement: " + e);

            }     
            finally{
                db.closeAll();
            }       

            }
        return errors;
    }

    public void updateSaleList() {
        String sqlStatement = "Select  sales.ID, sales.QUANTITY, sales.CUSTOMER, customers.FIRSTNAME, "
                + "customers.LASTNAME, customers.PHONENUMBER, sales.ADDRESS, "
                + "sales.POSTALCODE, sales.POSTPLACE, wood.WOODTYPE, wood.BAGSIZE, wood.PRICE "
                + "FROM sales NATURAL JOIN wood, customers";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {
            //System.out.println(rs.getInt("sales.ID"));
            while(rs.next()) {
                sales.add(new Sale(
                    rs.getInt("ID"),
                    rs.getInt("QUANTITY"),
                    rs.getInt("CUSTOMER"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getInt("PHONENUMBER"),
                    rs.getString("ADDRESS"),
                    rs.getInt("POSTALCODE"),
                    rs.getString("POSTPLACE"),
                    rs.getString("WOODTYPE"),
                    rs.getInt("BAGSIZE"),                    
                    rs.getInt("PRICE")                     
                    ));
            }
        } catch(SQLException e) {
            System.out.println("SQLError: " + e);
        } finally {
            db.closeAll();
            System.out.println("ok");
        }
    }
    
    
    
    
     private ArrayList<Integer> checkFields(String customerFirstName, String customerLastName, int phoneNumber, 
                                            String woodType, int postnr, String adresse, int quantity) {
        ArrayList<Integer> errors = new ArrayList<Integer>();
                
        
        if(customerFirstName == null || customerFirstName.trim().equals("")) {
            errors.add(NO_CUSTOMER_FIRSTNAME);
    	}                
    	if(customerLastName == null || customerLastName.trim().equals("")) {
            errors.add(NO_CUSTOMER_LASTNAME);
    	} 
        if(woodType == null || woodType.trim().equals("")) {
            errors.add(NO_WOODTYPE);
    	}      
        if(adresse == null || adresse.trim().equals("")) {
            errors.add(NO_ADDRESS_INFO);
    	}      
        if(phoneNumber <= 0) {
            errors.add(NO_PHONENUMBER);
        }
        if(quantity<0) {
            errors.add(NO_QUANTITY);
            
        }
        if((postnr <0) || (postnr>10000)){
            errors.add(WRONG_POSTNUMBER);
        }
        
        return errors;
	}
     
     
     private int addCustomer(String customerFirstName, String customerLastName, int telephone){
        int customerId =0;
                
         String sqlStatement = "SELECT id FROM customers WHERE firstName = '" + customerFirstName +
                                       "' AND lastName = '" + customerLastName + "' AND phoneNumber = " + telephone;
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
                        insertCustomerStatement.setInt(3, telephone); 
                        
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
         return customerId;
     }
     
     
    
    public static void main(String args[]){
        Database db = new Database();
        Sales allSales = new Sales(db);
        db.createConnection();
        

        
      
        //allSales.updateSaleList();
        
        /*
        for(Sale d:allSales.getSales()) {
            System.out.println(d);
           
        }
        
        for(int d:allSales.createSale("BJørn", "Hox", "91323324", "Eik", "1400", "Humlevien", "15", "Ski")){
            System.out.println(d);
        }
        
        */      
    }
    
    
   
}

