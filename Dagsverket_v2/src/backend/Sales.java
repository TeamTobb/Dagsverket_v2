/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;
import java.sql.*;



public class Sales {
    private ArrayList<Sale> sales;
    private Database db;
    
    public Sales(Database db) {
    	this.sales = new ArrayList<Sale>();
        this.db = db;
    }

    public ArrayList<Sale> getSales() {
    	return this.sales;
    }

    public boolean createSale(int quantity, int customer, String wood) {
        int error = 0; 
        db.createConnection();
        
        try{
            PreparedStatement sqlStatement = db.getConnection().prepareStatement("INSERT INTO sales VALUES(DEFAULT, ?, ?, ?)");
            sqlStatement.setString(1, String.valueOf(quantity));   
            sqlStatement.setString(2, String.valueOf(customer));
            sqlStatement.setString(3, wood);
            error = db.executeUpdate(sqlStatement);
        }        
        catch(SQLException e){
            System.out.println("feil i createSale preparedStatement: " + e);
            return false;
        }     
        finally{
            db.closeAll();
        }
        
    	return true;
    }

    public void updateSaleList() {
        String sqlStatement = "Select  sales.ID, sales.QUANTITY, customers.FIRSTNAME," +
        "customers.LASTNAME, customers.PHONENUMBER," +
        "customers.ADDRESS, customers.POSTALCODE, customers.POSTPLACE," +
        "wood.WOODTYPE, wood.BAGSIZE, wood.PRICE" +
        "from sales NATURAL JOIN wood, customers;";
        ResultSet rs = db.executeQuery(sqlStatement);
        try {
            while(rs.next()) {
                sales.add(new Sale(
                    rs.getInt("sales.ID"),
                    rs.getInt("sales.QUANTITY"),                   
                    rs.getString("customers.FIRSTNAME"),
                    rs.getString("customers.LASTNAME"),
                    rs.getInt("customers.PHONENUMBER"),
                    rs.getString("customers.ADDRESS"),
                    rs.getInt("customers.POSTALCODE"),
                    rs.getString("customers.POSTPLACE"),
                    rs.getString("wood.WOODTYPE"),
                    rs.getInt("wood.BAGSIZE"),                    
                    rs.getInt("wood.PRICE")                     
                    ));
            }
        } catch(SQLException e) {
            System.out.println("SQLError: " + e);
        } finally {
            db.closeAll();
        }
    }
    
    public static void main(String args[]){
        Database db = new Database();
        Sales sales = new Sales(db);
        db.createConnection();
        
        
        sales.createSale(10, 1, "Eik");
       // sales.updateSaleList();
        
        
    }
}

