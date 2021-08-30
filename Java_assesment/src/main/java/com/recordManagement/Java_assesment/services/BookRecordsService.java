package com.recordManagement.Java_assesment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.recordManagement.Java_assesment.model.BookRecord;
import com.recordManagement.Java_assesment.repositorys.BookRecordsRepository;
import com.recordManagement.Java_assesment.servicesImpl.BookRecordsServiceImpl;

@Service
public class BookRecordsService implements BookRecordsServiceImpl {
	@Autowired
	private BookRecordsRepository repository;

	public Page<BookRecord> getAll(final int pageNumber, final int pageSize) {
		return repository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	public List<BookRecord> getAllRest() {
		return repository.findAll();
	}

	public BookRecord save(BookRecord bookRecord) {
		return repository.save(bookRecord);
	}

	public void deletAll() {
		repository.deleteAll();
	}

}
