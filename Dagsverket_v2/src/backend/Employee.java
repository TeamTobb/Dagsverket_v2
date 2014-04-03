/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

/**
 *
 * @author borgarlie
 */
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String lastWorkDate;
	private String lastRegDate;
	private int attendanceWithoutWork; // legg til denne i databasen

            public Employee(int id, String firstName, String lastName, String lastWorkDate, String lastRegDate, int attendanceWithoutWork) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastWorkDate = lastWorkDate;
		this.lastRegDate = lastRegDate;
		this.attendanceWithoutWork = attendanceWithoutWork;
	}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastWorkDate() {
        return lastWorkDate;
    }

    public String getLastRegDate() {
        return lastRegDate;
    }

    public int getAttendanceWithoutWork() {
        return attendanceWithoutWork;
    }

    public String toString() {
    	return this.firstName + " " + this.lastName;
    }
    
}
