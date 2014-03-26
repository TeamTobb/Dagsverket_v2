/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.sql.*;

/**
 *
 * @author Jorgen
 */
public class Database {
    private Connection conn; 
    
    public Database(){
        this.conn = createConnection();
    }
    
    public Connection createConnection() {
        Connection conn_new = null;
        try {
            String databasenavn = "jdbc:derby://localhost:1527/Dagsverket;user=root;password=root"; // no username / pw
            conn_new  = DriverManager.getConnection(databasenavn);
        } catch (Exception e) {
            System.out.println("Feil i database.createConnection: " + e);
            System.exit(0); // ?? gjor noe annet...?
        }
        return conn_new;
    }

    public boolean endConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Feil i database.endConnection: " + e);            
        }
        return false;            
    }
    
    public ResultSet executeQuery(String sqlStatement){
        ResultSet res = null;
        try{
            Statement stm = this.conn.createStatement();
            res = stm.executeQuery(sqlStatement);
        }   
        catch(SQLException e){
            System.out.println("feil i database.executeQuery: " + e);
        }                
        return res;
    }
    
    public boolean closeStatement(Statement stm){
        try{
            stm.close();
            return true;
        }
        catch(SQLException e){
            System.out.println("feil i database.closeStatement: " + e);            
        }
        return false;
    }
    
    public boolean rollBack(){
        try{
            this.conn.rollback();
            return true;
        }
        catch(SQLException e){
            System.out.println("feil i database.rollback: " + e);
        }
        return false;
    }
    
    public boolean closeResultSet(ResultSet res){
        try{
            res.close();
            return true;
        }
        catch(SQLException e){
            System.out.println("feil i database.closeResultSet" + e);
        }
        return false;
    }
}
