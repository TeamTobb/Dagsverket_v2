/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;

/**
 *
 * @author borgarlie
 */
public class Employees {
    private ArrayList<Employee> employees;
    private Database db;

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
    	// add to employee arraylist
    }

    public ArrayList<Employee> getEmployees() {
    	return this.employees;
    }

    public ArrayList<Integer> createEmployee(String firstName, String lastName) { // what should be input first time to employee?
    	// check for errors, return them, or add a new employee to database
    	ArrayList<Integer> errors = checkFields(firstName, lastName);

    	if(errors == null) {
    		// add new employee

    		// standard null for lastworkdate, lastregdate etc?

    	}

    	return errors;
    }

    private ArrayList<Integer> checkFields(String firstName, String lastName) {
    	// return errorlist
    	return null;
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
