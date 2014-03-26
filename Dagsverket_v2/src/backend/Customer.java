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
public class Customer {
	private int id; // dont need id here? just in database?
	private String firstname;
	private String lastname;
	private int phoneNumber;
	private String address;
	private int postalCode;
	private String postPlace;

	public Customer(int id, String firstname, String lastname, int phoneNumber, String address, int postalCode, String postPlace) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.postPlace = postPlace;
	}

    // ALWAYS GET FROM DATABASE AND NOT ON REGISTER???

	// No ID field, from registerCase.
	public Customer(String firstname, String lastname, int phoneNumber, String address, int postalCode, String postPlace) {
		this.id = 0; // ?
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.postPlace = postPlace;
	}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @return the postPlace
     */
    public String getPostPlace() {
        return postPlace;
    }
    
}
