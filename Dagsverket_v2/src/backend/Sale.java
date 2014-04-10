/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

public class Sale {
    private int id;
    private int quantity;
    private Customer buyer;
    private Wood wood;
    private String address;
    private int postalCode;
    private String postPlace;
    private String status;

    public Sale(int id, int quantity, int customerId, String firstname, String lastname, int phoneNumber, String address, int postalCode, String postPlace, String woodType, int bagSize, int price, String status) {
    	this.id = id;
    	this.quantity = quantity;
    	this.buyer = new Customer(customerId, firstname, lastname, phoneNumber);
    	this.wood = new Wood(woodType, bagSize, price);
        this.address = address;
        this.postalCode = postalCode;
        this.postPlace = postPlace;
        this.status = status;
    }

    public int getId() {
    	return this.id;
    }

    public int getQuantity() {
    	return this.quantity;
    }

    public Customer getBuyer() {
    	return this.buyer;
    }

    public Wood getWood() {
    	return this.wood;
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

    public String getStatus() {
        return status;
    }
    
    public String toString(){
        return id + ", " + quantity + ", "+ buyer + ", "+ wood;
    }
}
