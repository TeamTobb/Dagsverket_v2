/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

/**
 *
 * @author Jorgen
 */
public class User {
	private int id;
	private String firstname;
    private String lastname;
    private int status;

    public User(int id, String firstname, String lastname, int status) {
    	this.id = id;
    	this.firstname = firstname;
    	this.lastname = lastname;
        this.status = status;
    }

    public int getId() {
    	return this.id;
    }

    public String getFirstname() {
    	return this.firstname;
    }

    public String getLastname() {
    	return this.lastname;
    }

    public int getStatus() {
        return status;
    }        
    
    public String toString(){
        return this.firstname + " " + this.lastname;
    }
}
