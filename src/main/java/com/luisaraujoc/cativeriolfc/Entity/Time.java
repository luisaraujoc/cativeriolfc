package com.luisaraujoc.cativeriolfc.Entity;

import java.util.ArrayList;
import java.util.List;

public class Time {

	private String nome;
	private List<Person> jogadores;

	public Time(String nome) {
		this.nome = nome;
		this.jogadores = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Person> getJogadores() {
		return jogadores;
	}

	// Method to add a player
	public void addJogador(Person jogador) {
		if (jogadores.size() < 6) {
			jogadores.add(jogador);
		} else {
			throw new IllegalArgumentException("Cannot add more than 6 players.");
		}
	}

	// Method to remove a player
	public void removeJogador(Person jogador) {
		if (jogadores.size() > 4) {
			jogadores.remove(jogador);
		} else {
			throw new IllegalArgumentException("Cannot have less than 4 players.");
		}
	}

	// Validate the number of players
	public void validateJogadores() {
		if (jogadores.size() < 4 || jogadores.size() > 6) {
			throw new IllegalStateException("Time must have between 4 and 6 players.");
		}
	}
}
