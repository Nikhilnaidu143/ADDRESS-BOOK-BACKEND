package com.bridgelabz.addressbook.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressbook.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookExceptionHandler {

	/***
	 * UC-4.2:- Provide User Friendly Error Response in case validation fails.
	 ***/

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMssg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while procession REST request.", errorMssg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> handleAddressBookException(
			AddressBookException exception) {
		ResponseDTO responseDTO = new ResponseDTO("Exception while procession REST request.", exception.getMessage());;
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
