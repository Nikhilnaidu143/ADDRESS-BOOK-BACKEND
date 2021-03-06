package com.bridgelabz.addressbook.services;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.models.AddressBook;

public interface IAddressBookService {

	/*** UC-2.2 :- Introducing Services Layer in AddressBook App. ***/

	/*** Declaring methods. ***/
	public String sayHello();

	public List<AddressBook> getAllAddressBooksInList();

	public AddressBook getAddressBookDataById(long id) throws AddressBookException;

	public AddressBook createAddressBook(AddressBookDTO addressBookDTO);

	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id);

	public String deleteAddressBookById(long id);
}
