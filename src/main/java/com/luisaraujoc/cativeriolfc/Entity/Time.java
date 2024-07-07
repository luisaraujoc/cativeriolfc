package com.luisaraujoc.cativeriolfc.Entity;

public class Time {

	private char nome;

	private Person jogador;

	public Time(char nome, Person jogador) {
		this.nome = nome;
		this.jogador = jogador;
	}

	public char getNome() {
		return nome;
	}

	public void setNome(char nome) {
		this.nome = nome;
	}

	public Person getJogador() {
		return jogador;
	}

	public void setJogador(Person jogador) {
		this.jogador = jogador;
	}

	
}
