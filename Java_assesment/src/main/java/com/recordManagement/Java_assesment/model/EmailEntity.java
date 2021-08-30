package com.recordManagement.Java_assesment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;
@Entity
@Data
public class EmailEntity {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@Column(name = "first_Name")
	private String firstName;
	@NotNull
	@Column(name = "subject")
	private String subject;
	@NotNull
	@Column(name ="message")
	private String message ; 
	@Column(name = "sent")
	private boolean sent;
	public EmailEntity() {
		
	}
	public EmailEntity(String firstName, String subject, String message ) {
		super();
		this.firstName = firstName;
		this.subject = subject;
		this.message =message;
		this.sent = false;
	}
	public boolean isSent() {
		return sent;
	}
	public void setSent(Boolean sent) {
		this.sent = sent;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
}
