package com.bridgelabz.addressbook.dto;

/*** UC-2.1 :- Introducing DTO and Model to AddressBook App. ***/
public class AddressBookDTO {
	/** variables. **/
	public String name;
	public String address;

	/** Parameterized constructor. **/
	public AddressBookDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
