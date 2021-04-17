package br.com.opet.model;

import java.util.Date;

public class Administrador extends Pessoas {
	private double salario;

	public double getSalario() {
		return this.salario;
	}

	public String getPerfil() {
		return "Administrativo";

	}

	public Administrador(String nome_completo, String cpf, String rg, Date dtnascimento, double salario) {
		super(nome_completo, cpf, rg, dtnascimento);

		this.salario = salario;

	}

}
