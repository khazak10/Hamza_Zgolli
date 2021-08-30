package com.recordManagement.Java_assesment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recordManagement.Java_assesment.model.BookRecord;
import com.recordManagement.Java_assesment.servicesImpl.BookRecordsServiceImpl;

@Controller
public class RecordsController {
	@Autowired
	private BookRecordsServiceImpl service;
	private final int DEFAULT_SIZE = 5 ;
	@GetMapping("/")
	public String listPage(final Model model, 
			@RequestParam(value = "page", defaultValue = "0") final int pageNumber,
			@RequestParam(value = "size", defaultValue = DEFAULT_SIZE +"") final int pageSize) {
		Page<BookRecord> bookrecords = service.getAll(pageNumber, pageSize);
		final int currentPageNumber = bookrecords.getNumber();
		final int previousPageNumber = bookrecords.hasPrevious() ?  currentPageNumber -1 : -1;
		final int nextPageNumber = bookrecords.hasNext() ? currentPageNumber +1 : -1;
		model.addAttribute("previousPageNumber", previousPageNumber);
		model.addAttribute("nextPageNumber", nextPageNumber);
		model.addAttribute("bookRecords",bookrecords.getContent());
		return "listPage";

	}

	@GetMapping("/addRecord")
	public String addNewRecord(Model model) {
		model.addAttribute("bookRecord", new BookRecord());
		return "addRecord";
	}

	@PostMapping("/validateAddRecord")
	public String validateAddReccord(@Valid @ModelAttribute("bookRecord") BookRecord bookRecord, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "addRecord";
		} else {
			service.save(bookRecord);
			return "redirect:/";
		}
	}

}
