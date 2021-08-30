package com.recordManagement.Java_assesment.servicesImpl;

import java.util.List;

import org.springframework.data.domain.Page;

import com.recordManagement.Java_assesment.model.BookRecord;

public interface BookRecordsServiceImpl {

	public Page<BookRecord> getAll(final int pageNumber, final int pageSize);
	public List<BookRecord> getAllRest();
	public BookRecord save(BookRecord bookRecord);
	public void deletAll();
}
