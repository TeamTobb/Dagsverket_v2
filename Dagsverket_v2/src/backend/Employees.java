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
    private ArrayList<Employee> employees;
    private Database db;
    public static final int WRONG_FIRSTNAME = 1; 
    public static final int WRONG_LASTNAME = 2;
    private String currentDate;

    public Employees() {
    	this.employees = new ArrayList<Employee>();
    	this.db = new Database();
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
    public void addToCase(int caseId, int employeeId){
        try{
            db.createConnection();
            PreparedStatement sqlStatement = db.getConnection().prepareStatement(
                                        "INSERT INTO events_has_employees VALUES(?, ?)");
            sqlStatement.setInt(1, caseId);
            sqlStatement.setInt(2, employeeId);            
            db.executeUpdate(sqlStatement);
        }catch(SQLException e){
            System.out.println("feil i addToCase: " + e);
        }
        finally{
            db.closeAll();
        }
    }
    
    public void setAntUtenZero(int employeeId){
        db.createConnection();
        try{
            PreparedStatement sqlStatement = db.getConnection().prepareStatement(
                                            "UPDATE employees SET attendanceWithoutWork = 0 "
                                                    + "WHERE employees.id = ?");
            sqlStatement.setInt(1, employeeId);
            db.executeUpdate(sqlStatement);
        }
        catch(SQLException e){
            System.out.println("feil i setAntUtenZero: " + e);
        }
        finally{
            db.closeAll();
        }
    }

    public void removeFromCase(int caseId, int employeeId){
        db.createConnection(); 
        try{
            PreparedStatement sqlStatement = db.getConnection().prepareStatement("DELETE FROM events_has_employees WHERE case_id = ? and employee_id = ?");
            sqlStatement.setInt(1, caseId);
            sqlStatement.setInt(2, employeeId);
            db.executeUpdate(sqlStatement);            
        }catch(SQLException e){
            System.out.println("feil i removeFromCase: " + e);
        }
        finally{
            db.closeAll(); 
        }
    }
    
    public void updateEmployeeAvailable(JTable left, JTable right, int caseId){
        currentDate = dateFormat.format(cal.getTime());           
        this.employees = new ArrayList<Employee>();
        String sqlStatement = "SELECT * FROM employees WHERE id NOT IN("
                             + "SELECT employees.id FROM employees INNER JOIN events_has_employees "
                             + "ON employees.id = events_has_employees.EMPLOYEE_ID WHERE case_id = " + caseId + ")"
                             + "AND lastRegDate = '" + currentDate + "'";
        ResultSet rs = db.executeQuery(sqlStatement);        
        
        try{
            while(rs.next()){
                this.employees.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("lastWorkDate"),
                    rs.getString("lastRegDate"),
                    rs.getInt("attendanceWithoutWork")));                                
            }
        }
        catch(SQLException e){
            System.out.println("feil i udateEmployeeAvailable: " + e);
        }
        finally{
            db.closeAll();
        }        
        DefaultTableModel modelLeft = (DefaultTableModel)left.getModel();
        modelLeft.setRowCount(0);
        
        Object[] insertTable = new Object[6];                
        for(int i = 0; i<this.employees.size(); i++){
            insertTable[0] = this.employees.get(i).getId();           
            insertTable[1] = this.employees.get(i).getFirstName();
            insertTable[2] = this.employees.get(i).getLastName();
            insertTable[5] = this.employees.get(i).getLastWorkDate();
            insertTable[3] = this.employees.get(i).getLastRegDate();
            insertTable[4] = this.employees.get(i).getAttendanceWithoutWork(); 
            modelLeft.insertRow(left.getRowCount(), insertTable);
        }          
        
        this.employees = new ArrayList<Employee>();
        sqlStatement = "SELECT * FROM employees INNER JOIN events_has_employees "
                       + "ON employees.id = events_has_employees.EMPLOYEE_ID WHERE case_id = " + caseId;
        ResultSet rs2 = db.executeQuery(sqlStatement);        
        
        try{
            while(rs2.next()){
                this.employees.add(new Employee(
                    rs2.getInt("id"),
                    rs2.getString("firstName"),
                    rs2.getString("lastName"),
                    rs2.getString("lastWorkDate"),
                    rs2.getString("lastRegDate"),
                    rs2.getInt("attendanceWithoutWork")));                                
            }
        }
        catch(SQLException e){
            System.out.println("feil i udateEmployeeAvailable: " + e);
        }
        finally{
            db.closeAll();
        }           
        DefaultTableModel modelRight = (DefaultTableModel)right.getModel();
        modelRight.setRowCount(0);
        
        insertTable = new Object[6];                
        for(int i = 0; i<this.employees.size(); i++){
            insertTable[0] = this.employees.get(i).getId();           
            insertTable[1] = this.employees.get(i).getFirstName();
            insertTable[2] = this.employees.get(i).getLastName();
            insertTable[5] = this.employees.get(i).getLastWorkDate();
            insertTable[3] = this.employees.get(i).getLastRegDate();
            insertTable[4] = this.employees.get(i).getAttendanceWithoutWork(); 
            modelRight.insertRow(right.getRowCount(), insertTable);
        }    
    }
    
    public void updateGUILists(JTable left, JTable right){ 
        currentDate = dateFormat.format(cal.getTime());   
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
    
    public void moveToAttended(int employeeId, JTable tableLeft, JTable tableRight){   
    currentDate = dateFormat.format(cal.getTime());           
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET lastRegDate='" + currentDate + 
                    "' WHERE id = " + employeeId); 
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
                    "UPDATE employees SET attendanceWithoutWork=attendanceWithoutWork +1 WHERE id = " + employeeId);
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
    
    public void moveToNotAttended(int employeeId, JTable tableLeft, JTable tableRight){
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET lastRegDate ='' WHERE id = " + employeeId); 
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
                    "UPDATE employees SET attendanceWithoutWork=attendanceWithoutWork -1 WHERE id = " + employeeId
                    + "AND attendanceWithoutWork >0");
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
}
