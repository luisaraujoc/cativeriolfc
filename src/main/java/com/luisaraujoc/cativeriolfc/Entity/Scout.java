package com.luisaraujoc.cativeriolfc.Entity;

public class Scout {

	private long id;

	private Person jogador;

	private Jogo jogo;

	private int gols;

	private int assistencias;

	public Scout(long id, Person jogador, Jogo jogo, int gols, int assistencias) {
		this.id = id;
		this.jogador = jogador;
		this.jogo = jogo;
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
