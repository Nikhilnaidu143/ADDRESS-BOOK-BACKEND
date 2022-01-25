package com.bridgelabz.addressbook.services;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.models.AddressBook;

@Service
public class AddressBookService implements IAddressBookService {

	/*** UC-2.2 :- Introducing Services Layer in AddressBook App. ***/

	/*** Defining implemented methods from IAddressBookService interface. ***/
	@Override
	public String sayHello() {
		String helloMessage = "Hello Nikhil, Welcome to address book backend application..!";
		return helloMessage;
	}

	@Override
	public AddressBook getAddressBookDataById(long id) {
		AddressBook addressBook = new AddressBook(1, new AddressBookDTO("Nikhil", "ongole"));
		return addressBook;
	}

	@Override
	public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
		AddressBook addressBook = new AddressBook(1, addressBookDTO);
		return addressBook;
	}

	@Override
	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id) {
		AddressBook addressBook = new AddressBook(Long.parseLong(id), addressBookDTO);
		return addressBook;
	}

	@Override
	public String deleteAddressBookById(long id) {
		String message = "Deleted id :- " + id;
		return message;
	}
}
