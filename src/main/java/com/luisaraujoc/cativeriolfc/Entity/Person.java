package com.luisaraujoc.cativeriolfc.Entity;

import com.luisaraujoc.cativeriolfc.Enum.Role;

public class Person {

	private Long id;

	private String name;

	private char nome;

	private char CPF;

	private char Contato;

	private char tipo;

	public Person(long id, char nome, char cPF, char contato, char tipo) {
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		Contato = contato;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getNome() {
		return nome;
	}

	public void setNome(char nome) {
		this.nome = nome;
	}

	public char getCPF() {
		return CPF;
	}

	public void setCPF(char cPF) {
		CPF = cPF;
	}

	public char getContato() {
		return Contato;
	}

	public void setContato(char contato) {
		Contato = contato;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
}
