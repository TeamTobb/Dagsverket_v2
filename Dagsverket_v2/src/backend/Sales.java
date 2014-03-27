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
        String sqlStatement = "Select  sales.ID, sales.QUANTITY, customers.FIRSTNAME, customers.LASTNAME, customers.PHONENUMBER, customers.ADDRESS, customers.POSTALCODE, customers.POSTPLACE, wood.WOODTYPE, wood.BAGSIZE, wood.PRICE "
                + "FROM sales NATURAL JOIN wood, customers";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {
            //System.out.println(rs.getInt("sales.ID"));
            while(rs.next()) {
                sales.add(new Sale(
                    rs.getInt("ID"),
                    rs.getInt("QUANTITY"),                   
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
    
    public static void main(String args[]){
        Database db = new Database();
        Sales allSales = new Sales(db);
        db.createConnection();
        
        
       allSales.createSale(50, 1, "Eik");
        allSales.updateSaleList();
        
       
        for(Sale d:allSales.getSales()) {
            System.out.println(d);
           
        }
        
        
    }
}

