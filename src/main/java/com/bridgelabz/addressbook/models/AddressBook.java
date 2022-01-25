package com.bridgelabz.addressbook.models;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

public class AddressBook {

	/** Private variables. **/
	private long id;
	private String name;
	private String address;

	/*** Default constructor. ***/
	public AddressBook() {
	}

	/** Parameterized Constructor. **/
	public AddressBook(long id, AddressBookDTO addressBookDTO) {
		this.id = id;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
	}

	/*** getter and setter methods. **/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
