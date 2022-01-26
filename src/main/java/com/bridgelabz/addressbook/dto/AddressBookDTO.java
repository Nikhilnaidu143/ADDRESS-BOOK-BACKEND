package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/*** UC-2.1 :- Introducing DTO and Model to AddressBook App. ***/
public class AddressBookDTO {
	/***
	 * UC-4.1:- Add Validation to Name Field so the REST call can be validated.
	 ***/

	/** variables. **/
	@NotEmpty(message = "Name cannot be null..!")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name validation failed..!")
	public String name;
	@NotEmpty(message = "Address cannot be null...!")
	public String address;

	/** Parameterized constructor. **/
	public AddressBookDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
