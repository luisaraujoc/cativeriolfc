package com.luisaraujoc.cativeriolfc.Entity;

public class Convidado {

	private long id;
	private User user;
	private String nome;

	public Convidado(long id, User user, String nome) {
		this.id = id;
		this.user = user;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
