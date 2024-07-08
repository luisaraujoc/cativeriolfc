package com.luisaraujoc.cativeriolfc.Entity;

import com.luisaraujoc.cativeriolfc.Enum.Role;

public class Person {

	private long id;

	private String nome;

	private String CPF;

	private String Contato;

	private Role kindUser;

	public Person(long id, String nome, String cPF, String contato, Role kindUser) {
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		Contato = contato;
		this.kindUser = kindUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getContato() {
		return Contato;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	public Role getKindUser() {
		return kindUser;
	}

	public void setKindUser(Role kindUser) {
		this.kindUser = kindUser;
	}
}
