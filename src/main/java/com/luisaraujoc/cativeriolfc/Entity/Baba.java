package com.luisaraujoc.cativeriolfc.Entity;

public class Baba {

	private long id;
	private Time time;
	private char data;
	private Scout scouts;
	private Person jogadoresConfirmados;
	private Person jogadoresPresentes;
	
	public Baba(long id, Time time, char data, Scout scouts, Person jogadoresConfirmados, Person jogadoresPresentes) {
		this.id = id;
		this.time = time;
		this.data = data;
		this.scouts = scouts;
		this.jogadoresConfirmados = jogadoresConfirmados;
		this.jogadoresPresentes = jogadoresPresentes;
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

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Scout getScouts() {
		return scouts;
	}

	public void setScouts(Scout scouts) {
		this.scouts = scouts;
	}

	public Person getJogadoresConfirmados() {
		return jogadoresConfirmados;
	}

	public void setJogadoresConfirmados(Person jogadoresConfirmados) {
		this.jogadoresConfirmados = jogadoresConfirmados;
	}

	public Person getJogadoresPresentes() {
		return jogadoresPresentes;
	}

	public void setJogadoresPresentes(Person jogadoresPresentes) {
		this.jogadoresPresentes = jogadoresPresentes;
	}
}
