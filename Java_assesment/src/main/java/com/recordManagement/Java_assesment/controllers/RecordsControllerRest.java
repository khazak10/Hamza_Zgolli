package com.recordManagement.Java_assesment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recordManagement.Java_assesment.model.BookRecord;
import com.recordManagement.Java_assesment.servicesImpl.BookRecordsServiceImpl;

@RestController
public class RecordsControllerRest {
	@Autowired
	private BookRecordsServiceImpl service;
	@GetMapping("/getAllRecordsRest")
	public List<BookRecord> listPage() {
		return service.getAllRest();

	}
	@PostMapping("/addRecord")
	public BookRecord validateAddReccord(@Valid @ModelAttribute("bookRecord") BookRecord bookRecord, BindingResult result) {
			return service.save(bookRecord);
	}
}
