package com.luisaraujoc.cativeriolfc.Entity;

public class Baba {

	private long id;
	private Time time;
	private String data;
	private Scout scouts;
	
	public Baba(long id, Time time, String data, Scout scouts) {
		this.id = id;
		this.time = time;
		this.data = data;
		this.scouts = scouts;
	}
	
	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Scout getScouts() {
		return scouts;
	}

	public void setScouts(Scout scouts) {
		this.scouts = scouts;
	}

}
