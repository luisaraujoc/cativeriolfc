package com.luisaraujoc.cativeriolfc.Entity;

import com.luisaraujoc.cativeriolfc.Util.Cryptography;

public class User {

	private long id;

	private String username;

	private String password;

	private boolean status;

	private Person person;

	public User(long id, String username, String password, boolean status, Person person) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Cryptography.encrypt(password);
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
