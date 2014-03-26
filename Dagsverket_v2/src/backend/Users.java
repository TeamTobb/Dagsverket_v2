/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;

/**
 *
 * @author Jorgen
 */
public class Users {
	private ArrayList<User> users;

	public Users() {
		this.users = new ArrayList<User>();
	}

    public boolean registerUser() {
    	return false;
    }

    public boolean deleteUser() {
    	return false;
    }

    public void updateUserList() {
    	// get resultset from database
    	// for loop in resultset
    	// create "User" for each in resultset
    	// add each user to "users" arraylist
    	// end
    }

    public void createUser(String firstname, String lastname) {
    	// send a user to database
    	// return error if already exists?
    }

    public ArrayList<User> getUsers() {
    	return this.users;
    }

}
