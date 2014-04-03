/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import static backend.Sales.WRONG_PHONE_FORMAT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoxmark
 */
public class Woods {
    private ArrayList<Wood> woods;
    private Database db;
    
    
    public Woods(Database db) {
    	this.woods = new ArrayList<Wood>();
        this.db = db;
    }
    
    public String[] getWoodsStringList(){
        System.out.println("getWoodStringList");

        String[] tempWoodList = new String[woods.size()];
        
        for (int i = 0; i<woods.size(); i ++){
            tempWoodList[i] = woods.get(i).getWoodType(); 
            System.out.println(tempWoodList[i]);
        }        
        
        return tempWoodList;
    }
    
    public void updateWoodList() {
        System.out.println("Updating woodList");
        String sqlStatement = "Select woodtype, bagsize, price FROM wood";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {
            //System.out.println(rs.getInt("sales.ID"));
            while(rs.next()) {
                woods.add(new Wood(
                    rs.getString("woodtype"),
                    rs.getInt("bagsize"),
                    rs.getInt("price")                                      
                    ));
            }
        } catch(SQLException e) {
            System.out.println("SQLError: " + e);
        } finally {
            db.closeAll();
            System.out.println("ok");
            
        }
    }
    
    
    
    public void addWood(String woodType, String bagSizeString, String priceString){
        int bagSize = 0;
        int price = 0;
        
        try{
            bagSize = Integer.parseInt(bagSizeString.trim());
        } catch(NumberFormatException e){
            System.out.println("Feil bag Size. Bare tall" + e);
           
        }
        
        try{
            price = Integer.parseInt(priceString.trim());
        } catch(NumberFormatException e){
            System.out.println("Feil price. Bare tall" + e);
           
        }
        
        try{
        this.db.createConnection();      
        PreparedStatement addWoodStatement = this.db.getConnection().prepareStatement(
                "INSERT INTO wood VALUES(?,?,?)");
        addWoodStatement.setString(1, woodType);
        addWoodStatement.setInt(2, bagSize); 
        addWoodStatement.setInt(3, price); 

        addWoodStatement.executeUpdate();
        db.closeAll();                        
        } catch(SQLException e){
             System.out.println("add wood error" + e);
                
        }
        
        
        
     }
    
    public static void main(String[] args) {
        Database db = new Database();
        Woods testWoods = new Woods(db);
        
        String[] listen = new String[2];
        
        testWoods.updateWoodList();
        
        listen = testWoods.getWoodsStringList();
        
        for (int i = 0; i<1;i++){
            System.out.println(listen[i]);            
        }
        testWoods.addWood("Bjørk", "11", "100");
        
    }
    
}

 

    
    