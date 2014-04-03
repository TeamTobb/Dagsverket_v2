/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorgen
 */
public class Operator {
    private Database db; 
    private User user; 
    private Users users; 
    private Cases cases;
    private Employees employees; 
    
    public Operator(User user){
        this.db = new Database(); 
        this.users = new Users(getDb()); 
        this.user = user;
        users.updateUserList();
        this.cases = new Cases(this.db);
        this.employees = new Employees(this.db);
    }    

    /**
     * @return the db
     */
    public Database getDb() {
        return db;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }        
    
    public Cases getCases(){
        return this.cases;
    }
    
    public void updateList(JTable table, String status){    
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       model.setRowCount(0);
       Object[] insertTable = new Object[3];
       this.getCases().updateCaseList(status);
       
       for(int i = 0; i<this.getCases().getCases().size(); i++){
           insertTable[0] = this.getCases().getCases().get(i).getEmployer().getFullName();
           insertTable[1] = this.getCases().getCases().get(i).getPostPlace();
           insertTable[2] = this.getCases().getCases().get(i).getReqTime();
           model.insertRow(table.getRowCount(), insertTable);          
       }    
    }

    public Employees getEmployees() {
        return employees;
    }
    
}
