package com.bridgelabz.addressbook.exceptions;

/**
 * UC-4.3:- Ability to throw User Friendly Errors in case Address Book Id is not
 * found in Address Book App.
 **/

public class AddressBookException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressBookException(String message) {
		super(message);
	}
}
