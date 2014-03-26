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

    public User(int id, String firstname, String lastname) {
    	this.id = id;
    	this.firstname = firstname;
    	this.lastname = lastname;
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
}
