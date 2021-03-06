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
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static javax.swing.JOptionPane.*;

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

    // updates the list of employees from the database, that way the user can access the employees from the object.
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
                        rs.getString("removedFromAttendance"),
                        rs.getString("lastRegDate"),
                        rs.getInt("attendanceWithoutWork")
                ));
            }
        } catch(SQLException e) {
            // System.out.println("SQLError: " + e);
            // No need for error handling here since its not visible to the user.
        } finally {
            db.closeAll();
        }
    }

    // adds an employee to a case.
    public void addToCase(int caseId, int employeeId){
        try{
            db.createConnection();
            PreparedStatement sqlStatement = db.getConnection().prepareStatement(
                                        "INSERT INTO events_has_employees VALUES(?, ?)");
            sqlStatement.setInt(1, caseId);
            sqlStatement.setInt(2, employeeId);            
            db.executeUpdate(sqlStatement);
        }catch(SQLException e){
            // System.out.println("feil i addToCase: " + e);
            showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
            // this should be handled by GUI, and not in the backend, but because of time limits we have to do it this way for the time beeing
        }
        finally{
            db.closeAll();
        }
    }
    
    // method to reset the ant uten field in the database incase the user moved the wrong employee.
    public void resetAntUten(int employeeId){
        currentDate = dateFormat.format(cal.getTime());           
        db.createConnection();
        Employee employee = this.getEmployeeById(employeeId);
        if(!employee.getRemovedFromAttendance().equals("true")) {
            try{
                PreparedStatement sqlStatement = db.getConnection().prepareStatement(
                                                "UPDATE employees SET "
                                                        + "attendanceWithoutWork = attendanceWithoutWorkBackup "
                                                        + "WHERE employees.id = ?");
                sqlStatement.setInt(1, employeeId);
                db.executeUpdate(sqlStatement);
            }
            catch(SQLException e){
                // System.out.println("feil i setAntUtenZero: " + e);
                // No need to display errors for the user here.
                // might need to be handled differently if error caused here. Time limit.
            }
            finally{
                db.closeAll();
            }                    
            
        }else{
            try{
                PreparedStatement sqlStatement = db.getConnection().prepareStatement(
                                                "UPDATE employees SET "
                                                        + "attendanceWithoutWork = attendanceWithoutWorkBackup -1 "
                                                        + "WHERE employees.id = ?");
                sqlStatement.setInt(1, employeeId);
                db.executeUpdate(sqlStatement);
            }
            catch(SQLException e){
                // System.out.println("feil i setAntUtenZero: " + e);
                // same as previous comment.
            }
            finally{
                db.closeAll();
            }        
        }
    }
    
    // sets attendance without work field in the database back to 0 and adds a backup of previous number when an employee got work
    public void setAntUtenZero(int employeeId){
        db.createConnection();
        try{
            PreparedStatement sqlStatement = db.getConnection().prepareStatement(
                                            "UPDATE employees SET "
                                                    + "attendanceWithoutWorkBackup = attendanceWithoutWork, "
                                                    + "attendanceWithoutWork = 0 "
                                                    + "WHERE employees.id = ?");
            sqlStatement.setInt(1, employeeId);
            db.executeUpdate(sqlStatement);
        }
        catch(SQLException e){
            // System.out.println("feil i setAntUtenZero: " + e);
            // same as comments in previous method
        }
        finally{
            db.closeAll();
        }
    }

    // removes an employee of a case
    public void removeFromCase(int caseId, int employeeId){
        db.createConnection(); 
        try{
            PreparedStatement sqlStatement = db.getConnection().prepareStatement("DELETE FROM events_has_employees WHERE case_id = ? and employee_id = ?");
            sqlStatement.setInt(1, caseId);
            sqlStatement.setInt(2, employeeId);
            db.executeUpdate(sqlStatement);            
        }catch(SQLException e){
            // System.out.println("feil i removeFromCase: " + e);
            // no need for error handling here.
        }
        finally{
            db.closeAll(); 
        }
    }
    
    // method to update 2 JTables with employees
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
                    rs.getString("removedFromAttendance"),
                    rs.getString("lastRegDate"),
                    rs.getInt("attendanceWithoutWork")));                                
            }
        }
        catch(SQLException e){
            // System.out.println("feil i udateEmployeeAvailable: " + e);
            // no need for error handling here.
        }
        finally{
            db.closeAll();
        }        
        DefaultTableModel modelLeft = (DefaultTableModel)left.getModel();
        modelLeft.setRowCount(0);
        
        Object[] insertTable = new Object[6];                
        for (Employee employee : this.employees) {
            insertTable[0] = employee.getId();
            insertTable[1] = employee.getFirstName();
            insertTable[2] = employee.getLastName();
            insertTable[5] = employee.getRemovedFromAttendance();
            insertTable[3] = employee.getLastRegDate();
            insertTable[4] = employee.getAttendanceWithoutWork(); 
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
                    rs2.getString("removedFromAttendance"),
                    rs2.getString("lastRegDate"),
                    rs2.getInt("attendanceWithoutWork")));                                
            }
        }
        catch(SQLException e){
            // System.out.println("feil i udateEmployeeAvailable: " + e);
            // no need for error handling here since its not visible to the user.
        }
        finally{
            db.closeAll();
        }           
        DefaultTableModel modelRight = (DefaultTableModel)right.getModel();
        modelRight.setRowCount(0);
        
        insertTable = new Object[6];                
        for (Employee employee : this.employees) {
            insertTable[0] = employee.getId();
            insertTable[1] = employee.getFirstName();
            insertTable[2] = employee.getLastName();
            insertTable[5] = employee.getRemovedFromAttendance();
            insertTable[3] = employee.getLastRegDate();
            insertTable[4] = employee.getAttendanceWithoutWork(); 
            modelRight.insertRow(right.getRowCount(), insertTable);
        }    
    }
    
    // method to update 2 JTables in the GUI with employees.
    public void updateGUILists(JTable left, JTable right){ 
        currentDate = dateFormat.format(cal.getTime());   
        DefaultTableModel modelLeft = (DefaultTableModel) left.getModel();
        DefaultTableModel modelRight = (DefaultTableModel) right.getModel();
        modelLeft.setRowCount(0);
        modelRight.setRowCount(0);
        Object[] insertTable = new Object[6];
        updateEmployeeList();
        
        for (Employee employee : this.employees) {
            insertTable[0] = employee.getId();
            insertTable[1] = employee.getFirstName();
            insertTable[2] = employee.getLastName();
            insertTable[5] = employee.getRemovedFromAttendance();
            insertTable[3] = employee.getLastRegDate();
            insertTable[4] = employee.getAttendanceWithoutWork();
            if (employee.getLastRegDate().equals(currentDate)) {
                modelRight.insertRow(right.getRowCount(), insertTable);
            } else {
                modelLeft.insertRow(left.getRowCount(), insertTable);
            }
        }    
    }
    
    // moves an employee to attended both in the GUI and in the database.
    public void moveToAttended(int employeeId, JTable tableLeft, JTable tableRight){   
    currentDate = dateFormat.format(cal.getTime());           
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET lastRegDatebackup = lastRegDate, lastRegDate='" + currentDate + 
                    "', removedFromAttendance = 'false' WHERE id = " + employeeId); 
            this.db.executeUpdate(updateEmployeeRegDate);
        }
        catch(SQLException e){
            // System.out.println("feil i attendancetab.move" + e);
            // no need for error handling here.
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
            // System.out.println("feil i attendancetab.move" + e);
            // no need for error handling here.
        }
        finally{
            this.updateGUILists(tableLeft, tableRight);
            this.db.closeAll();
        }     
    }
    
    // removed an employee from attended both in the GUI and in the database.
    public void moveToNotAttended(int employeeId, JTable tableLeft, JTable tableRight){
        try{
            this.db.createConnection();            
            PreparedStatement updateEmployeeRegDate = this.db.getConnection().prepareStatement(
                    "UPDATE employees SET lastRegDate = lastRegDateBackup, removedFromAttendance = 'true' WHERE id = " + employeeId); 
            this.db.executeUpdate(updateEmployeeRegDate);
        }
        catch(SQLException e){
            // System.out.println("feil i attendancetab.move" + e);
            showMessageDialog(null, "Noe gikk galt under kontakt med databasen. \nPrøv på nytt, om feilen gjenoppstår kontakt system ansvarlig.");
            // this should be handled by GUI, and not in the backend, but because of time limits we have to do it this way for the time beeing
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
            // System.out.println("feil i attendancetab.move" + e);
            // no need for error handling here.
        }
        finally{
            this.updateGUILists(tableLeft, tableRight);
            this.db.closeAll();
        }         
    }

    public ArrayList<Employee> getEmployees() {
    	return this.employees;
    }

    // method to creat a new employee and add it to the database.
    public ArrayList<Integer> createEmployee(String firstName, String lastName) {
    	// check for errors, return them, or add a new employee to database
    	ArrayList<Integer> errors = checkFields(firstName, lastName);

    	if(errors.isEmpty()) {
            try{
                this.db.createConnection();
                PreparedStatement insertEmployeeStatement = this.db.getConnection().prepareStatement(
                                "INSERT INTO employees VALUES(DEFAULT, ?, ?, ' ', ' ', 0, ' ', 0)");   
                insertEmployeeStatement.setString(1, firstName);
                insertEmployeeStatement.setString(2, lastName);                
                db.executeUpdate(insertEmployeeStatement);                
            }
            catch(SQLException e){
                // System.out.println("feil i employees.createEmployee" + e);
                // no need for errorhandling here?
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
