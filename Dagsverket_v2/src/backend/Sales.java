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
    
    public Sales() {
    	this.sales = new ArrayList<Sale>();
    }

    public ArrayList<Sale> getSales() {
    	return this.sales;
    }

    public boolean createSale() {
        
        
    	return false;
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
}
