package com.bridgelabz.addressbook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.models.AddressBook;
import com.bridgelabz.addressbook.services.AddressBookService;

@RestController
@RequestMapping("/address")
public class AddressBookController {

	/*** UC-2.2 :- Introducing Services Layer in AddressBook App. ***/
	@Autowired // AutoWired annotation is used for automatic dependency injection.
	private AddressBookService addressBookService;

	/***
	 * UC-1 :- Create a Address Book Spring Project to cater to REST Request from
	 * Address Book UI.
	 ***/
	@GetMapping(value = { "", "/", "book" })
	public ResponseEntity<String> sayHello() {
		String message = addressBookService.sayHello();
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	/***
	 * UC-2 :- Create a Rest Controller to demonstrate the various HTTP Methods.
	 ***/

	/*** UC-2.2 :- Introducing Services Layer in AddressBook App. ***/

	/*** get all addressBooks. ***/
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBooks() {
		List<AddressBook> addressBook = addressBookService.getAllAddressBooksInList();
		ResponseDTO responseDTO = new ResponseDTO("Get All Request Successfull...!", addressBook);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** get addressBook by using ID . 
	 * @throws AddressBookException 
	 * @throws NumberFormatException ***/
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable String id) throws NumberFormatException, AddressBookException {
		AddressBook addressBook = addressBookService.getAddressBookDataById(Long.parseLong(id));
		ResponseDTO responseDTO = new ResponseDTO("Get Request Successfull...!", addressBook);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Creating AddressBook by using POST request. ***/
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBook addressBookData = addressBookService.createAddressBook(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Post Request Successfull...!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Updating already existing address book details ***/
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO,
			@PathVariable String id) {
		AddressBook addressBookData = addressBookService.updateAddressBookById(addressBookDTO, id);
		ResponseDTO responseDTO = new ResponseDTO("Put Request Successfull...!", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Delete Address Book by using delete Request. ***/
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable long id) {
		String message = addressBookService.deleteAddressBookById(id);
		ResponseDTO responseDTO = new ResponseDTO("Delete Request Successfull...!", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
