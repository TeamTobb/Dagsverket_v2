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
    private ResultSet rs; 
    private Statement stm; 
    
    public Database(){
        this.conn = null;
        this.rs = null; 
        this.stm = null;
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

    
    //perhaps not needed cause of previously declared closeAll-method.
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
        this.conn = createConnection();
        try{
            stm = this.conn.createStatement();
            rs = stm.executeQuery(sqlStatement);
        }   
        catch(SQLException e){
            System.out.println("feil i database.executeQuery: " + e);
        }
        return rs;
    }
    
    public void closeAll(){
        try{
            if(this.rs!=null){
                this.rs.close();
                this.rs = null; 
            }
        }
        catch(SQLException e){
            System.out.println("feil i close resultset: " + e);
        }        
        
        try{
            if(this.stm!=null){
                this.stm.close();
                this.stm = null;
            }
        }
        catch(SQLException e){
            System.out.println("feil i statement close: " + e);
        }
        
        try{
            if(this.conn!= null){
                this.conn.close();
                this.conn = null;
            }
        }
        catch(SQLException e){
            System.out.println("feil i connection close: " + e);
        }
    }
    
    //perhaps not needed cause of previously declared closeAll-method.
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
    
    //perhaps not needed cause of previously declared closeAll-method.
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
