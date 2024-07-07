package com.luisaraujoc.cativeriolfc.Entity;

public class Scout {

	private long id;

	private Person jogador;

	private Jogo jogo;

	private int cartaoAmarelo;

	private int cartaoVermelho;

	private int gols;

	private int assistencias;

	public Scout(long id, Person jogador, Jogo jogo, int cartaoAmarelo, int cartaoVermelho, int gols, int assistencias) {
		this.id = id;
		this.jogador = jogador;
		this.jogo = jogo;
		this.cartaoAmarelo = cartaoAmarelo;
		this.cartaoVermelho = cartaoVermelho;
		this.gols = gols;
		this.assistencias = assistencias;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getJogador() {
        return jogador;
    }

    public void setJogador(Person jogador) {
        this.jogador = jogador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(int cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public int getCartaoVermelho() {
        return cartaoVermelho;
    }

    public void setCartaoVermelho(int cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

	

}
