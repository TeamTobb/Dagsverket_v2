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
public class Sale {
    private int id;
    private int quantity;
    private Customer buyer;
    private Wood wood;

    // firstname -> postPlace = customer data
    public Sale(int id, int quantity, String firstname, String lastname, int phoneNumber, String address, int postalCode, String postPlace, String woodType, int bagSize, int price) {
    	this.id = id;
    	this.quantity = quantity;
    	this.buyer = new Customer(firstname, lastname, phoneNumber, address, postalCode, postPlace);
    	this.wood = new Wood(woodType, bagSize, price);
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
    
    public String toString(){
        return id + ", " + quantity + ", "+ buyer + ", "+ wood;
    }
}
