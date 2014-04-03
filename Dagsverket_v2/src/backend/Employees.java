/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author borgarlie
 */
public class Employees {
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    Calendar cal = Calendar.getInstance();
    String currentDate = dateFormat.format(cal.getTime());   
    private ArrayList<Employee> employees;
    private Database db;
    public static final int WRONG_FIRSTNAME = 1; 
    public static final int WRONG_LASTNAME = 2;

    public Employees(Database db) {
    	this.employees = new ArrayList<Employee>();
    	this.db = db;
    }

    public Employee getEmployeeById(int id) {
    	for (Employee e: this.employees) {
    		if(e.getId() == id) {
    			return e;
    		}
    	}
    	return null; // treat nulls in GUI etc... incase of null pointer ---> if(e != null)) {}
    }

    public void updateEmployeeList() {
    	this.employees = new ArrayList<Employee>();
        String sqlStatement = "SELECT * from employees";
        ResultSet rs = db.executeQuery(sqlStatement);
        try {
            while(rs.next()) {
                this.employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("lastWorkDate"),
                        rs.getString("lastRegDate"),
                        rs.getInt("attendanceWithoutWork")
                ));
            }
        } catch(SQLException e) {
            System.out.println("SQLError: " + e);
        } finally {
            db.closeAll();
        }
    }
    
    public void updateGUILists(JTable left, JTable right){    
        DefaultTableModel modelLeft = (DefaultTableModel) left.getModel();
        DefaultTableModel modelRight = (DefaultTableModel) right.getModel();
        modelLeft.setRowCount(0);
        modelRight.setRowCount(0);
        Object[] insertTable = new Object[6];
        updateEmployeeList();
        
        for(int i = 0; i<this.employees.size(); i++){
                insertTable[0] = this.employees.get(i).getId();           
                insertTable[1] = this.employees.get(i).getFirstName();
                insertTable[2] = this.employees.get(i).getLastName();
                insertTable[5] = this.employees.get(i).getLastWorkDate();
                insertTable[3] = this.employees.get(i).getLastRegDate();
                insertTable[4] = this.employees.get(i).getAttendanceWithoutWork(); 
                if(this.employees.get(i).getLastRegDate().equals(currentDate)){
                    modelRight.insertRow(right.getRowCount(), insertTable);   
                }
                else{
                    modelLeft.insertRow(left.getRowCount(), insertTable);
                }
       }    
    }
    
    public void moveToAttended(String firstName, String lastName, JTable tableLeft, JTable tableRight){      
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET lastRegDate='" + currentDate + 
                    "' WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "'"); 
            this.db.executeUpdate(updateEmployeeRegDate);
        }
        catch(SQLException e){
            System.out.println("feil i attendancetab.move" + e);
        }
        finally{
            this.db.closeAll();
        }       
        
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET attendanceWithoutWork=attendanceWithoutWork +1 WHERE firstName = '"
                            + firstName + "' AND lastName = '" + lastName + "'"); 
            this.db.executeUpdate(updateEmployeeRegDate);
        }
        catch(SQLException e){
            System.out.println("feil i attendancetab.move" + e);
        }
        finally{
            this.updateGUILists(tableLeft, tableRight);
            this.db.closeAll();
        }     
    }
    
    public void moveToNotAttended(String firstName, String lastName, JTable tableLeft, JTable tableRight){
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET lastRegDate ='' WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "'"); 
            this.db.executeUpdate(updateEmployeeRegDate);
        }
        catch(SQLException e){
            System.out.println("feil i attendancetab.move" + e);
        }
        finally{
            this.db.closeAll();
        }       
        
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET attendanceWithoutWork=attendanceWithoutWork -1 WHERE firstName = '"
                            + firstName + "' AND lastName = '" + lastName + "'"); 
            this.db.executeUpdate(updateEmployeeRegDate);
        }
        catch(SQLException e){
            System.out.println("feil i attendancetab.move" + e);
        }
        finally{
            this.updateGUILists(tableLeft, tableRight);
            this.db.closeAll();
        }         
    }

    public ArrayList<Employee> getEmployees() {
    	return this.employees;
    }

    public ArrayList<Integer> createEmployee(String firstName, String lastName) { // what should be input first time to employee?
    	// check for errors, return them, or add a new employee to database
    	ArrayList<Integer> errors = checkFields(firstName, lastName);

    	if(errors.isEmpty()) {
            try{
                this.db.createConnection();
                PreparedStatement insertEmployeeStatement = this.db.getConnection().prepareStatement(
                                "INSERT INTO employees VALUES(DEFAULT, ?, ?, ' ', ' ', 0)");   
                insertEmployeeStatement.setString(1, firstName);
                insertEmployeeStatement.setString(2, lastName);                
                db.executeUpdate(insertEmployeeStatement);
                
            }
            catch(SQLException e){
                System.out.println("feil i employees.createEmployee" + e);
            }
            finally{
                db.closeAll();
            }
    	}

    	return errors;
    }

    private ArrayList<Integer> checkFields(String firstName, String lastName) {
        ArrayList<Integer> errors = new ArrayList<Integer>();
    	if(firstName.trim().equals("")){
            errors.add(WRONG_FIRSTNAME);
        }
        if(lastName.trim().equals("")){
            errors.add(WRONG_LASTNAME);
        }
    	return errors;
    }


    // HOW SHOULD WE HANDLE ATTEND AND REMOVE ATTEND?

    public boolean attend() {
    	// update for todays date
    	return false;
    }

    public boolean removeAttend() {
    	// reset update? how? keep track of old attend?
    	// add LastAttend backup in database?
    	return false;
    }
}
