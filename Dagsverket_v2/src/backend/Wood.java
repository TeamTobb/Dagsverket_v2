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
public class Wood {
    private String woodType;
    private int bagSize;
    private int price;

    public Wood(String woodType, int bagSize, int price) {
    	this.woodType = woodType;
    	this.bagSize = bagSize;
    	this.price = price;
    }

    public String getWoodType() {
    	return this.woodType;
    }

    public int getBagSize() {
    	return this.bagSize;
    }

    public int getPrice() {
    	return this.price;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public void setBagSize(int bagSize) {
        this.bagSize = bagSize;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    
}
