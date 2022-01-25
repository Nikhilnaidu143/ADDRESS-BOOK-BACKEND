package com.bridgelabz.addressbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.models.AddressBook;

@Service
public class AddressBookService implements IAddressBookService {

	/**
	 * UC-2.3 :- Ability for the Services Layer to store the AddressBook Data.
	 **/
	static List<AddressBook> addressBookList = new ArrayList<AddressBook>();

	private static final AtomicLong COUNTER = new AtomicLong(); // to auto increment the id.

	/** Returning address book for crud operations. **/
	private static AddressBook returnAddressBookById(long id) {
		for (AddressBook addressBook : addressBookList) {
			long addressBookID = addressBook.getId();
			if (addressBookID == id) {
				System.out.println(addressBook);
				return addressBook;
			} else {
				continue;
			}
		}
		return null;
	}

	/*** Defining implemented methods from IAddressBookService interface. ***/
	@Override
	public String sayHello() {
		String helloMessage = "Hello Nikhil, Welcome to address book backend application..!";
		return helloMessage;
	}

	/*** Get All address books in the list. ***/
	public List<AddressBook> getAllAddressBooksInList() {
		List<AddressBook> allAddressBooks = addressBookList;
		return allAddressBooks;
	}

	/*** Getting addressBook by ID. ***/
	@Override
	public AddressBook getAddressBookDataById(long id) {
		AddressBook addressBook = returnAddressBookById(id); // returning addressBook.
		return addressBook;
	}

	/*** Creating address book. ***/
	@Override
	public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
		AddressBook addressBook = new AddressBook(COUNTER.incrementAndGet(), addressBookDTO);
		addressBookList.add(addressBook);
		return addressBook;
	}

	/*** Updating address book by id. ***/
	@Override
	public AddressBook updateAddressBookById(AddressBookDTO addressBookDTO, String id) {
		AddressBook addressBookById = returnAddressBookById(Long.parseLong(id));
		addressBookById.setName(addressBookDTO.name);
		addressBookById.setAddress(addressBookDTO.address);
		return addressBookById;
	}

	/*** Delete address book by id. ***/
	@Override
	public String deleteAddressBookById(long id) {
		addressBookList.remove(returnAddressBookById(id));
		String message = "Deleted id :- " + id;
		return message;
	}
}
