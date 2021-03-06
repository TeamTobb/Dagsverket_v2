/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

import java.util.*;
import java.sql.*;

public class Users {
    private ArrayList<User> users;
    private Database db;
    public static User currentUser;

    public Users() {
        this.users = new ArrayList<User>();
        this.db = new Database();        
        updateUserListByStatus(1);
    }
    
    public void setCurrentUser(User newCurrentUser){
        currentUser = newCurrentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public boolean deleteUser() {
    	return false;
    }
    
    public void updateUserListByStatus(int status){
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
            // System.out.println("SQLError: " + e);
            // no need to handle errors here since its not visible to the user.
            // altough, the user wont see any users at all. Might need to say something? Time limit.
        } 
        finally{
            db.closeAll();
        }
    }
    
    
    // updates the arraylist of users from database.
    // status 1 = active, other then 1 is deleted user.
    public void updateUserList() {
        this.users = new ArrayList<User>();
        String sqlStatement = "Select * from users";        
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
            // System.out.println("SQLError: " + e);
            // no need to handle errors here since its not visible to the user.
            // altough, the user wont see any users at all. Might need to say something? Time limit.
        } 
        finally{
            db.closeAll();
        }
    }

    // creates a new user and add it to the database.
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

    // returns the list of users with firstname + lastname as a string table.
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
