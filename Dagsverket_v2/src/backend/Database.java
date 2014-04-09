/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

import java.sql.*;

public class Database {
    private Connection conn; 
    private ResultSet rs; 
    private Statement stm; 
    
    public Database(){
        this.conn = null;
        this.rs = null; 
        this.stm = null;
    }
    
    public void createConnection() {
        try {
            String databasenavn = "jdbc:derby://localhost:1527/Dagsverket;user=root;password=root"; // no username / pw
            this.conn  = DriverManager.getConnection(databasenavn);
        } catch (Exception e) {
            System.out.println("Feil i database.createConnection: " + e);
        }
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
        createConnection();
        try{
            stm = this.conn.createStatement();
            rs = stm.executeQuery(sqlStatement);
        }   
        catch(SQLException e){
            System.out.println("feil i database.executeQuery: " + e);
        }
        return rs;
    }
    
    public int executeUpdate(PreparedStatement sqlStatement){
        int result = 0;
        try{
            result = sqlStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("feil i database.executeUpdate: " + e);
        }
        finally{
            try{
                sqlStatement.close();
            }
            catch(SQLException e){
                System.out.println("feil i database.executeUpdate (close preparedstatement)" + e);
            }
        }
        return result;        
    }
    public void closeAll(){
        try{
            if(this.rs!=null){
                this.rs.close();
                //this.rs = null; 
            }
        }
        catch(SQLException e){
            System.out.println("feil i close resultset: " + e);
        }        
        
        try{
            if(this.stm!=null){
                this.stm.close();
                //this.stm = null;
            }
        }
        catch(SQLException e){
            System.out.println("feil i statement close: " + e);
        }
        
        try{
            if(this.conn!= null){
                this.conn.close();
                //this.conn = null;
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
    
    public Connection getConnection(){
        return this.conn; 
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