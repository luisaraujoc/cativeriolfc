package com.luisaraujoc.cativeriolfc.Entity;


public class Baba {

	private long id;
	private String data;
	private Time time;

	// Constructor
	public Baba(long id, String data, Time time) {
		this.id = id;
		this.data = data;
		this.time = time;
	}

	
	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
