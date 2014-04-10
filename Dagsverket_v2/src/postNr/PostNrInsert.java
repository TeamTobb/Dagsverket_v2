/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package postNr;

import java.io.*;
import java.sql.*;

public class PostNrInsert {
	public static Connection getConnection() throws Exception {
	    String databasenavn = "jdbc:derby://localhost:1527/Dagsverket;user=root;password=root";
	    Connection conn = DriverManager.getConnection(databasenavn);
	    return conn;
	}

	public static void main(String[] args) throws Exception {
	    String fileName = "Postnummerregister_ansi.txt";
	    // Open the file
		FileInputStream fstream = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			// get postnr and postadresse from fileline
			String temp[] = strLine.split("\t", -1);
			String postNr = temp[0];
			String postAdresse = temp[1];
			// database stuff
			PreparedStatement pstmt = null;
		    Connection conn = null;
		    try {
				conn = getConnection();
				// conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("insert into postnr(id, postnr, postadresse) values (DEFAULT, ?, ?)");
				pstmt.setString(1, postNr);
				pstmt.setString(2, postAdresse);
				pstmt.executeUpdate();
		    } catch (Exception e) {
		    	System.err.println("Error: " + e.getMessage());
		    	e.printStackTrace();
		    } finally {
				pstmt.close();
				conn.close();
		    }
		}

		//Close the input stream
		br.close();
	}
}
