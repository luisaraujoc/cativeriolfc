package com.luisaraujoc.cativeriolfc.Entity;

public class Time {

	private String nome;

	private Person jogador;

	public Time(String nome, Person jogador) {
		this.nome = nome;
		this.jogador = jogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Person getJogador() {
		return jogador;
	}

	public void setJogador(Person jogador) {
		this.jogador = jogador;
	}

	
}
