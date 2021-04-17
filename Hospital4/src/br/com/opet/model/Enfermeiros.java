package br.com.opet.model;

import java.util.Date;

public class Enfermeiros extends Pessoas {

	private int cargaHoraria;
	private int escala;

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public String getPerfil() {
		return "Enfermeiro";

	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Enfermeiros(String nome_completo, String cpf, String rg, Date dtnascimento, int escala) {
		super(nome_completo, cpf, rg, dtnascimento);
		this.escala = escala;

	}

	public double getSalario() {

		return 24;

	}

	public int getEscala() {
		return escala;
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}

}
