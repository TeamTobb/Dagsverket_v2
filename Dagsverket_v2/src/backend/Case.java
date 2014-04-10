/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

public class Case {
    private int id;
    private String createdDate;
    private String address;
    private int postalCode;
    private String postPlace;
    private String subject;
    private String reqDate;
    private String reqTime;
    private String description;
    private int price;
    private String checkup_date;
    private String startDate;
    private String toolList;
    private String contactPerson;
    private String status;
    private int creatorId; // user which created the case, reference to id from "users" arraylist
    private int supervisorId; // user which is going attending the case, reference to id from "users" arraylist

    private Customer employer;

    public Case(int id, String createdDate, String address, int postalCode, String postPlace, String subject, String reqDate, String reqTime, String description, int price, String checkup_date, String startDate, String toolList, String contactPerson, String status, int creatorId, int supervisorId, int customerId, String customerFirstName, String customerLastName, int customerPhoneNumber) {
        this.id = id;
        this.createdDate = createdDate;
        this.address = address;
        this.postalCode = postalCode;
        this.postPlace = postPlace;
        this.subject = subject;
        this.reqDate = reqDate;
        this.reqTime = reqTime;
        this.description = description;
        this.price = price;
        this.checkup_date = checkup_date;
        this.startDate = startDate;
        this.toolList = toolList;
        this.contactPerson = contactPerson;
        this.status = status;
        this.creatorId = creatorId;
        this.supervisorId = supervisorId;
        this.employer = new Customer(customerId, customerFirstName, customerLastName, customerPhoneNumber);
    }

    public int getId() {
        return id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getPostPlace() {
        return postPlace;
    }

    public String getSubject() {
        return subject;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getReqTime() {
        return reqTime;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getCheckup_date() {
        return checkup_date;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getToolList() {
        return toolList;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getStatus() {
        return status;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public Customer getEmployer() {
        return employer;
    }
    
}
