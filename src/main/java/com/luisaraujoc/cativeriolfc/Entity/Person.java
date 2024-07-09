package com.luisaraujoc.cativeriolfc.Entity;

public class Person {

	private Long id;

	private String name;

	private String cpf;

	private String tel;

	private String kindUser;

	public Person() {
	}

	public Person(Long id, String name, String cpf, String tel, String kindUser) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.tel = tel;
		this.kindUser = kindUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getKindUser() {
		return kindUser;
	}

	public void setKindUser(String kindUser) {
		this.kindUser = kindUser;
	}
}
