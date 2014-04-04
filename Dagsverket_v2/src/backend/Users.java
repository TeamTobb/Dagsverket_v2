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

    public boolean deleteUser() {
    	return false;
    }
       
    public void updateUserList(int status) {
        this.users = new ArrayList<User>();
        String sqlStatement = "Select * from users WHERE status = " + status;
        ResultSet rs = db.executeQuery(sqlStatement);
        try {
            while(rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"), 
                    rs.getInt("status")
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
            PreparedStatement sqlStatement = db.getConnection().prepareStatement("INSERT INTO users VALUES(DEFAULT, ?, ?, 1)");
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

    public ArrayList<User> getUsersArrayList() {
    	return this.users;
    }

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
    
    public User getUserById(int id){
        for(User u : users){
            if(u.getId()==id){
            return u;}
        }
        return null;
    }
    
    public User getUserByFullName(String fullName){
        for(User u : users){
            if(fullName.equals(u.toString())){
                return u;
            }
        }
        return null;
    }
    
    public int getUserIdByFullName(String fullName){
        for(User u : users){
            if(fullName.equals(u.toString())){
                return u.getId();
            }
        }
        // System.out.println("If this happens, give an error message?");
        return -1;
    }
}
