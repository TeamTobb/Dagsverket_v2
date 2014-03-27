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
public class Operator {
    private Database db; 
    private User user; 
    private Users users; 
    
    public Operator(User user){
        this.db = new Database(); 
        this.users = new Users(getDb()); 
        this.user = user;
        users.updateUserList();
    }    

    /**
     * @return the db
     */
    public Database getDb() {
        return db;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }        
}
