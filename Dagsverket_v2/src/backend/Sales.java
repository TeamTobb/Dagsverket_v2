/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

import frontend.MoreInfoOnSale;

import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sales {
    public static final int WRONG_PHONE_FORMAT = 1;
    public static final int WRONG_POSTALCODE_FORMAT = 2;
    public static final int WRONG_QUANTITY_FORMAT = 3;
    public static final int NO_CUSTOMER_FIRSTNAME = 4;
    public static final int NO_CUSTOMER_LASTNAME = 5;
    public static final int NO_ADDRESS_INFO = 6;
    public static final int NO_QUANTITY = 7; 
    public static final int NO_POSTNUMBER = 8; 
    public static final int NO_WOODTYPE = 9; 
    public static final int NO_PHONENUMBER = 10;
    public static final int WRONG_POSTNUMBER = 11; 
    
    public static final int ALLDELIVERIESVIEW = 1; 
    public static final int NOTDELIVEREDVIEW = 2;
    public static final int DELIVEREDVIEW = 3;
    
    private ArrayList<Sale> sales;
    private Database db;
    
    public Sales() {
    	this.sales = new ArrayList<Sale>();
        this.db = new Database();
    }

    public ArrayList<Sale> getSales() {
    	return this.sales;
    }
    
    //method to delete a sale of wood. 
    public void deleteSale(String idString){
        try{
            this.db.createConnection();            
            PreparedStatement deleteTuple = this.db.getConnection().prepareStatement(
                    "DELETE FROM sales " +
                    "WHERE id="+ idString); 
            this.db.executeUpdate(deleteTuple);
        } catch(SQLException e){
           showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        }
        finally{
            this.db.closeAll();
        }       
        
    }   
    //method to create a new sale of wood.
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
            
            errors.add(WRONG_PHONE_FORMAT);
        }
        
        try{
            postCode = Integer.parseInt(postnr.trim());
        }
        catch(NumberFormatException e){
            
            errors.add(WRONG_POSTALCODE_FORMAT);
        }
        
        try{
            quantityNr = Integer.parseInt(quantity.trim());
        }
        catch(NumberFormatException e){
           
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
               showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
            }     
            finally{
                db.closeAll();
            }       

            }
        return errors;
    }
    //method to update the sale of wood arrayList called sales.
    public void updateSaleList() {
        sales = new ArrayList<Sale>();
        String sqlStatement = "Select sales.ID, sales.QUANTITY, sales.CUSTOMER, customers.FIRSTNAME, customers.LASTNAME, customers.PHONENUMBER, sales.ADDRESS, sales.POSTALCODE, sales.POSTPLACE, wood.WOODTYPE, wood.BAGSIZE, wood.PRICE, sales.STATUS FROM sales inner join customers on sales.CUSTOMER = customers.id INNER JOIN WOOD ON sales.WOOD = WOOD.WOODTYPE";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {            
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
                    rs.getInt("PRICE"),                     
                    rs.getString("STATUS")));
            }
        } catch(SQLException e) {
            showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        } finally {
            db.closeAll();            
        }
    }
    
    
    
    //method to check all the inputs to see if they are blank or is invalid. 
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
     
     /*method to add customers to the Database. First it checks if the customer exists,
     if it existed it uses the old customer, if it does not exist it creates a new customer in the DB. 
     */
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
                           showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");                           
                        }
                    }
                }catch(SQLException e){
                    showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
                }
                finally{                    
                    db.closeAll();
                }
         return customerId;
     }
      //method to update the table with all wood sale.
      public void updateWoodSaleList(JTable table){
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
      
      //method to create a new frame that gives the user addition information about the selected sale.
      public boolean getMoreInfoFromSale(String saleId){
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
      //method to the index in the arraylist when we have the ID of the sale. 
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
      //method to set the wood sale as delivered. 
      public boolean deliverWood(String idString){
          
         try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE sales SET status ='" + "levert" + 
                    "' WHERE id = " + idString); 
            this.db.executeUpdate(updateEmployeeRegDate);
        } catch(SQLException e){
            showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        }
        finally{
            this.db.closeAll();
        }       
        
          
          
          return true;
      }
     
     
     /*method to update wood sale table. This takes the sort as a parameter. 
        Sort will decide if the table will display delivered sales or
        not delivered sales. 
      */
      public void updateWoodSaleListDelivered(JTable table, String sort){        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        updateSaleListWhere(sort);
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
     //method to update arraylist to either delivered or not delivered.
     public void updateSaleListWhere(String sort){
        sales = new ArrayList<Sale>();
        String sqlStatement = "Select sales.ID, sales.QUANTITY, sales.CUSTOMER, "
                + "customers.FIRSTNAME, customers.LASTNAME, customers.PHONENUMBER, sales.ADDRESS, "
                + "sales.POSTALCODE, sales.POSTPLACE, wood.WOODTYPE, wood.BAGSIZE, wood.PRICE, sales.STATUS "
                + "FROM sales inner join customers on sales.CUSTOMER = customers.id "
                + "INNER JOIN WOOD ON sales.WOOD = WOOD.WOODTYPE WHERE sales.STATUS = '"
                + sort
                + "'";
        ResultSet rs = db.executeQuery(sqlStatement);
        
        try {            
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
                    rs.getInt("PRICE"),                     
                    rs.getString("STATUS")));
            }
        } catch(SQLException e) {
           showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
        } finally {
            db.closeAll();            
        }
    }
     
    public void updateSaleWoodTable(JTable table, int currentView){
        switch (currentView){
            case ALLDELIVERIESVIEW: updateWoodSaleList(table);
                break;
            case NOTDELIVEREDVIEW: updateWoodSaleListDelivered(table, "Ikke levert");                
                break;
            case DELIVEREDVIEW: updateWoodSaleListDelivered(table,"levert");
                break;
            default:                    
        }
    }
    
   
     
    
    public static void main(String args[]){
        Database db = new Database();
        Sales allSales = new Sales();
        db.createConnection();
      
        allSales.updateSaleList();
        
        
       
      
    }
    
    
   
}