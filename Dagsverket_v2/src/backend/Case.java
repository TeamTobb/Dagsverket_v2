/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Jorgen
 */
public class Case {
    private int phone;
	private String employer;
	private String address;
	private int postnr;
	private String postplace;

	public Case(int phone, String employer, String address, int postnr, String postplace) {
		this.phone = phone;
		this.employer = employer;
		this.address = address;
		this.postnr = postnr;
		this.postplace = postplace;
	}

	public boolean INSERT_TO_DB() {
		// INSERT HERE, use DATABASE
		return false;
	}

	public boolean UPDATE_CASE_IN_DB() {
		// UPDATE HERE, use DATABASE
		return false;
	}

	// registrer case, endre case, osv.	
}
