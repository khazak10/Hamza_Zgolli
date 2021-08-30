package com.recordManagement.Java_assesment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "Book_Records")
@Data
public class BookRecord {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@Pattern(regexp = "[A][A-Za-z]+(\\\\s|$)" )
	@Column(name = "first_Name")
	private String firstName;
	@NotNull
	@Pattern(regexp = "[A][A-Za-z]+(\\\\s|$)" )
	@Column(name = "last_Name")
	private String lastName;
	@NotNull
	@Column(name = "title")
	private String title;
	@NotNull
	@Column(name = "isbn")
	private String isbn;
	public BookRecord() {
		
	}
	public BookRecord(String firstName, String lastName, String title, String isbn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.isbn = isbn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getId() {
		return id;
	}

}
