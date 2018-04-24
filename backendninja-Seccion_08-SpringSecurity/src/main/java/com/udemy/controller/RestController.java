package com.udemy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	/*
	@GetMapping("/checkrest")
	public ResponseEntity<String> checkRest(){
		return new ResponseEntity<String>("Ok!", HttpStatus.OK);
	}
	*/
	
	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel contactModel = new ContactModel(2, "Mikel", "Pérez", "123123123", "Sebastopol");
		return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
	}
}
