/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;

/**
 *
 * @author Jorgen
 */
public class Sales {
    private ArrayList<Sale> sales;

    public Sales() {
    	this.sales = new ArrayList<Sale>();
    }

    public ArrayList<Sale> getSales() {
    	return this.sales;
    }

    public boolean createSale() {
    	return false;
    }

    public void updateSaleList() {
    	// update sales
    }
}
