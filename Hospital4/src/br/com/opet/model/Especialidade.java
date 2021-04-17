package br.com.opet.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.opet.util.Reader;

public class Especialidade<Especilidade> {
	private int id;
	private Especialidade especialidade;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String descricao;
	private double salario;

	public Especialidade(int id, String descricao, double salario) {

		this.id = id;
		this.descricao = descricao;
		this.salario = salario;

	}

	public Especialidade() {

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private static String geraDataNasc() {
		int min = 1970;
		int max = 1988;
		double DifeAno = Math.random() * (max - min + 1) + min;

		LocalDate localDateNovo = LocalDate.of((int) DifeAno, 1, 1);
		SimpleDateFormat dtMask = new SimpleDateFormat("dd/MM/yyyy");

		// Date dtnasc = dtMask.parse(strdataNasc);
		return " ";

	}



	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}
