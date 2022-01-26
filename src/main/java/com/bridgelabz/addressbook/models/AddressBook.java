package com.bridgelabz.addressbook.models;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import lombok.Data;

public @Data class AddressBook {

	/** Private variables. **/
	private long id;
	private String name;
	private String address;

	/** Parameterized Constructor. **/
	public AddressBook(long id, AddressBookDTO addressBookDTO) {
		this.id = id;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
	}
}
