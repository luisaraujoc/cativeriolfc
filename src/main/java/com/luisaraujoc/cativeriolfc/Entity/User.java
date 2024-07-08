package com.luisaraujoc.cativeriolfc.Entity;

public class User {

	private long id;

	private char username;

	private char passoword;

	private boolean status;

	private Person person;

	public User(long id, char username, char passoword, boolean status, Person person) {
		this.id = id;
		this.username = username;
		this.passoword = passoword;
		this.status = status;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getUsername() {
		return username;
	}

	public void setUsername(char username) {
		this.username = username;
	}

	public char getPassoword() {
		return passoword;
	}

	public void setPassoword(char passowrd) {
		this.passoword = passowrd;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
