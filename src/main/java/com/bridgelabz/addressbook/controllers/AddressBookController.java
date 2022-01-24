package com.bridgelabz.addressbook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressBookController {

	/***
	 * UC-1 :- Create a Address Book Spring Project to cater to REST Request from
	 * Address Book UI.
	 ***/
	@GetMapping(value = { "", "/", "book" })
	public String sayHello() {
		return "Hello Nikhil, Welcome To Address Book Backend Application...!";
	}
}
