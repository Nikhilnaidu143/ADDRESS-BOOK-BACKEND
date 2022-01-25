package com.bridgelabz.addressbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.models.AddressBook;

@RestController
@RequestMapping("/address")
public class AddressBookController {

	/***
	 * UC-1 :- Create a Address Book Spring Project to cater to REST Request from
	 * Address Book UI.
	 ***/
	@GetMapping(value = { "", "/", "book" })
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Hello Nikhil...!", HttpStatus.OK);
	}

	/***
	 * UC-2 :- Create a Rest Controller to demonstrate the various HTTP Methods.
	 ***/

	/*** UC-2.1 :- Introducing DTO and Model to AddressBook App. ***/

	/*** get addressBook by using ID . ***/
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable String id) {
		AddressBook addressBook = new AddressBook(1, new AddressBookDTO("Nikhil", "ongole"));
		ResponseDTO responseDTO = new ResponseDTO("Get Request Successfull...!", addressBook);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Creating AddressBook by using POST request. ***/
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBook addressBookData = new AddressBook(1, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Post Request Successfull...!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Updating already existing address book details ***/
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@RequestBody AddressBookDTO addressBookDTO,
			@PathVariable String id) {
		AddressBook addressBookData = new AddressBook(Long.parseLong(id), addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Put Request Successfull...!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Delete Address Book by using delete Request. ***/
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable Long id) {
		ResponseDTO responseDTO = new ResponseDTO("Delete Request Successfull...!", "Deleted id :- " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
