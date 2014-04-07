package backend;

import frontend.MoreInfoOnSale;
import java.awt.Color;
import java.util.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



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
    
    public Sales() {
    	this.sales = new ArrayList<Sale>();
        this.db = new Database();
    }

    public ArrayList<Sale> getSales() {
    	return this.sales;
    }
    
    public void deleteSale(){
        //add delete data TODO
    }   

    public ArrayList<Integer> createSale(String customerFirstName, String customerLastName, String phoneNumber, String woodType, 
                                         String postnr, String address, String quantity, String postalPlace, String status) {
        ArrayList<Integer> errors = new ArrayList<Integer>(); 
        int telephone = 0;
        int quantityNr = 0;
        int postCode = 0; 
        int customerId = 0;
        
        
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
        
       //fills up the arraylist "errors" with the the value of the issue. 
        errors.addAll(checkFields(customerFirstName, customerLastName, telephone, woodType, postCode, address, quantityNr));
        
        //return errors;
        if (errors.isEmpty()==true){
        
            //legg til Customer DB eller/og hent ut customer ID. 
            customerId = addCustomer(customerFirstName, customerLastName, telephone);


            db.createConnection();
            try{
                PreparedStatement sqlStatement = db.getConnection().prepareStatement("INSERT INTO sales VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?)");
                sqlStatement.setString(1, String.valueOf(quantity));   
                sqlStatement.setInt(2, customerId);
                sqlStatement.setString(3, woodType);
                sqlStatement.setInt(4, postCode);
                sqlStatement.setString(5, postalPlace);
                sqlStatement.setString(6, address);
                sqlStatement.setString(7, status);
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
        sales = new ArrayList<Sale>();
        String sqlStatement = "Select DISTINCT sales.ID, sales.QUANTITY, sales.CUSTOMER, customers.FIRSTNAME, customers.LASTNAME, customers.PHONENUMBER, sales.ADDRESS, sales.POSTALCODE, sales.POSTPLACE, wood.WOODTYPE, wood.BAGSIZE, wood.PRICE, sales.STATUS FROM sales inner join customers on sales.CUSTOMER = customers.id INNER JOIN WOOD ON sales.WOOD = WOOD.WOODTYPE";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {
            //System.out.println(rs.getInt("sales.ID"));
            while(rs.next()) {
                System.out.println("en Next i UpdateSaleList");
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
                    rs.getInt("PRICE"),                     
                    rs.getString("STATUS")));
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
     
      public void updateWoodSaleList(JTable table){
          System.out.println(sales.size());
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       model.setRowCount(0);
       
       updateSaleList();
       if (!sales.isEmpty()){
            Object[] insertTable = new Object[4];




            for(int i = 0; i<this.sales.size(); i++){

                insertTable[0] = this.sales.get(i).getId();          
                insertTable[1] = this.sales.get(i).getBuyer().getFullName();          
                insertTable[2] = this.sales.get(i).getQuantity();
                insertTable[3] = this.sales.get(i).getStatus();
                model.insertRow(table.getRowCount(), insertTable);                     
            } 
       }
    }
      
      
      public boolean getMoreInfoFromSale(String saleId){
          
          System.out.println("saleId = "+saleId);
          int index = getIndexFromId(saleId);
          
          
          
          MoreInfoOnSale moreInfoView = new MoreInfoOnSale(
                  sales.get(index).getBuyer().getFirstname(),
                  sales.get(index).getBuyer().getLastname(),
                  ""+sales.get(index).getBuyer().getPhoneNumber(),
                  sales.get(index).getWood().getWoodType(),                    
                  ""+sales.get(index).getPostalCode(),  
                  sales.get(index).getAddress(), 
                   ""+sales.get(index).getQuantity(), 
                  sales.get(index).getPostPlace());
          moreInfoView.setVisible(true);
          
          
          return true;
      }
      
      private int getIndexFromId(String idString){
          int id = 0;
          id = Integer.parseInt(idString);
          
         for (int i =0; i < sales.size(); i++){
             if (sales.get(i).getId()==id){
                 return i;
             }
             
         }
          return -1;
      }
     
     
     
     
    
    public static void main(String args[]){
        Database db = new Database();
        Sales allSales = new Sales();
        db.createConnection();
        

        
      
        allSales.updateSaleList();
        
        
        for(Sale d:allSales.getSales()) {
            System.out.println(d);
           
        }
      
    }
    
    
   
}