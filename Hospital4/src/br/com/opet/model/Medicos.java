package br.com.opet.model;

import java.util.Date;

public class Medicos extends Pessoas {
	public Medicos(String nome_completo, String cpf, String rg, Date dtnascimento, Especialidade esp) {
		super(nome_completo, cpf, rg, dtnascimento);

		this.especialidade = esp;

	}

	private Especialidade especialidade;

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public String getPerfil() {
		return "Medico";

	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public double getSalario() {
		return this.especialidade.getSalario();

	}
}
