/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String removedFromAttendance;
	private String lastRegDate;
	private int attendanceWithoutWork;

    public Employee(int id, String firstName, String lastName, String removedFromAttendance, String lastRegDate, int attendanceWithoutWork) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.removedFromAttendance = removedFromAttendance;
		this.lastRegDate = lastRegDate;
		this.attendanceWithoutWork = attendanceWithoutWork;
	}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRemovedFromAttendance() {
        return removedFromAttendance;
    }

    public String getLastRegDate() {
        return lastRegDate;
    }

    public int getAttendanceWithoutWork() {
        return attendanceWithoutWork;
    }

    public String toString() {
    	return this.firstName + " " + this.lastName;
    }
    
}
