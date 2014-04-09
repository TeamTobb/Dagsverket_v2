package backend;
/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
public class User {
	private int id;
	private String firstname;
    private String lastname;
    private int status;

    public User(int id, String firstname, String lastname, int status) {
    	this.id = id;
    	this.firstname = firstname;
    	this.lastname = lastname;
        this.status = status;
    }

    public int getId() {
    	return this.id;
    }

    public String getFirstname() {
    	return this.firstname;
    }

    public String getLastname() {
    	return this.lastname;
    }

    public int getStatus() {
        return status;
    }        
    
    public String toString(){
        return this.firstname + " " + this.lastname;
    }
}
