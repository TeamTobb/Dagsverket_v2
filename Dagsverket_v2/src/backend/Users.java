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
        this.users = new ArrayList<User>();
        String sqlStatement = "Select * from users";
        ResultSet rs = db.executeQuery(sqlStatement);
        try {
            while(rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName")
                    ));
            }            
        } catch(SQLException e) {
            System.out.println("SQLError: " + e);
        } 
        finally{
            db.closeAll();
        }
    }

    public int createUser(String firstname, String lastname) {
        int error = 0; 
        db.createConnection();
        try{
            PreparedStatement sqlStatement = db.getConnection().prepareStatement("INSERT INTO users VALUES(DEFAULT, ?, ?)");
            sqlStatement.setString(1, firstname);
            sqlStatement.setString(2, lastname);       
            error = db.executeUpdate(sqlStatement);
        }        
        catch(SQLException e){
            System.out.println("feil i createUser preparedStatement: " + e);
            return 0;
        }     
        finally{
            db.closeAll();
        }
        return error;
    }

    // public ArrayList<User> getUsers() {
    // 	return this.users;
    // }

    public String[] getUsers() {
        String[] tempUsers = new String[users.size()];
        for (int i = 0; i < this.users.size(); i++) {
            tempUsers[i] = this.users.get(i).getFirstname() + " " + this.users.get(i).getLastname();
        }
        return tempUsers;
    }

    public User getUserByIndex(int i) {
        return this.users.get(i);
    }
    /*
    public User getUserByFullName(String fullName){
        for(User u : users){
            System.out.println("forloop");
            if(fullName.equals(u)){
                return u;
            }
        }
        System.out.println("haiiaiiiiadifiasd");
        return null;
    }
    */
    public int getUserIdByFullName(String fullName){
        for(User u : users){
            if(fullName.equals(u.toString())){
                return u.getId();
            }
        }
        System.out.println("If this happens, give an error message?");
        return -1;
    }

    // GET USER FROM INDEX IN LIST ....



}
