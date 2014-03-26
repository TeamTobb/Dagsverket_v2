/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Jorgen
 */
public class Users {
	private ArrayList<User> users;
    private Database db;

	public Users(Database db) {
		this.users = new ArrayList<User>();
        this.db = db;
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
        String sqlStatement = "Select * from users";
        ResultSet rs = db.executeQuery(sqlStatement);
        while(rs.next()) {
            users.add(new User(
                rs.getInt("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                ))
        }
    }

    public void createUser(String firstname, String lastname) {
    	// send a user to database
    	// return error if already exists?
    }

    public ArrayList<User> getUsers() {
    	return this.users;
    }

}
