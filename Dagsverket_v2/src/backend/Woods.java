/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class Woods {
    private ArrayList<Wood> woods;
    private Database db;
    
    
    public Woods(Database db) {
    	this.woods = new ArrayList<Wood>();
        this.db = db;
    }
    
    public String[] getWoodsStringList(){
        String[] tempWoodList = new String[woods.size()];
        
        for (int i = 0; i<woods.size(); i ++){
            tempWoodList[i] = woods.get(i).getWoodType(); 
        }        
        
        return tempWoodList;
    }
    
    // updates the list of wood form the database.
    public void updateWoodList() {
        String sqlStatement = "Select woodtype, bagsize, price FROM wood";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {
            while(rs.next()) {
                woods.add(new Wood(
                    rs.getString("woodtype"),
                    rs.getInt("bagsize"),
                    rs.getInt("price")                                      
                    ));
            }
        } catch(SQLException e) {
            // perhaps not needed to handle errors here? not visible to user.
           showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        } finally {
            db.closeAll();            
        }
    }
    
    // add a type of wood to the database.
    public boolean addWood(String woodType, String bagSizeString, String priceString){
        int bagSize = 0;
        int price = 0;
        
        //Checks if the input is valid
        if ((woodType.equals(""))||(bagSizeString.equals(""))||(priceString.equals(""))){
            return false; 
        }
        
        try{
            bagSize = Integer.parseInt(bagSizeString.trim());
        } catch(NumberFormatException e){
            //System.out.println("error in bagSize" + e);
            return false;
        }
        
        try{
            price = Integer.parseInt(priceString.trim());
        } catch(NumberFormatException e){
            // System.out.println("error in price" + e);
            return false;
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
           showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        }
        
        return true;
     }
    
     public int getWoodTypePrice(String woodType){
        String sqlStatement = "Select price FROM wood WHERE woodtype ='"+woodType.trim()+"'";
        ResultSet rs = db.executeQuery(sqlStatement);
        int result =0; 
        try {
            while(rs.next()) {
                   result = rs.getInt("price");
            }
        } catch(SQLException e) {
           showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        } finally {
            db.closeAll();
            
        }
           
        return result;
     }
     
     public String getPrice(String woodTypeFromCombobox, String quantity){
        double cost = 0; 
        String costString = ""; 
        int woodTypePrice = getWoodTypePrice(woodTypeFromCombobox);
        int quanitityWood = 0; 
        
        //Check the values and Parse.  
        try{
            quanitityWood = Integer.parseInt(quantity.trim());
        } catch(NumberFormatException e){
             // no need for any error handling here, since its basicly handled when created.
        }
         
         cost = woodTypePrice*quanitityWood;
         
         if (cost==0.0){
             return costString;
         } else {
             costString = ""+cost;
         }
         
         return costString;
     }

    public ArrayList<Wood> getWoods() {
        return woods;
    }
    
    // test method.
    public static void main(String[] args) {
        Database db = new Database();
        Woods testWoods = new Woods(db);
        
        String[] listen = new String[2];
        
        testWoods.updateWoodList();
        
        listen = testWoods.getWoodsStringList();
        
        for (int i = 0; i<1;i++){
            System.out.println(listen[i]);            
        } 
    }
}

 

    
    