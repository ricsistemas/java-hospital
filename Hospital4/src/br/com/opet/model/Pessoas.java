package br.com.opet.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pessoas {

    private int id;
	private String nome_completo;
	private String cpf;
	private String rg;
	private Date dtnascimento;


	
	public Pessoas(String nome_completo, String cpf, String rg) {
		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.rg = rg;


		}
		
	
	public Pessoas(String nome_completo, String cpf, String rg, Date dtnascimento) {

		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.rg = rg;
		this.dtnascimento = dtnascimento;
	}

	

	public Pessoas() {
		// TODO Auto-generated constructor stub
	}



	public double getSalario() {
		return 0.0;

	}
	
	

	public String getPerfil() {
		return "Pessoa";

	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public int getIdade() {

		int idade = 1;
		SimpleDateFormat anoMask = new SimpleDateFormat("yyyy");
		SimpleDateFormat mesMask = new SimpleDateFormat("MM");
		SimpleDateFormat diaMask = new SimpleDateFormat("dd");

		Date dataAtual = new Date();
		int anoNasc = Integer.parseInt(anoMask.format(this.dtnascimento));
		int mesNasc = Integer.parseInt(mesMask.format(this.dtnascimento));
		int diaNasc = Integer.parseInt(diaMask.format(this.dtnascimento));

		int anoAtual = Integer.parseInt(anoMask.format(dataAtual));
		int mesAtual = Integer.parseInt(mesMask.format(dataAtual));
		int diaAtual = Integer.parseInt(diaMask.format(dataAtual));

		idade = anoAtual - anoNasc;

		if (mesAtual < mesNasc)
			idade--;
		else if (mesAtual == mesNasc)
			if (diaAtual < diaNasc)
				idade--;

		return idade;

	}

	public static void Listar_Cadastros(ArrayList<Pessoas> lista_pessoas) {
		SimpleDateFormat dtNascMask = new SimpleDateFormat("dd/MM/YY");

		if (lista_pessoas.isEmpty())
			st.Tecle_Algo("Sem Cadastro para mostrar até a o Momento");
		else {

			for (int item = 0; item < lista_pessoas.size(); item++) {

				Pessoas p;
				p = lista_pessoas.get(item);

				if (p instanceof Medicos) {
					Medicos med = (Medicos) lista_pessoas.get(item);
					System.out.println("============ " + med.getPerfil() + " - " + med.getEspecialidade().getDescricao()
							+ " =================");
				} else {
					System.out.println("============ " + p.getPerfil() + " =================");
				}
				System.out.println("Nome:" + p.getNome_completo());
				System.out.println("CPF:" + p.getCpf());
				System.out.println("Data Nasc.:" + dtNascMask.format(p.getDtnascimento()));
				System.out.println("Idade:" + p.getIdade());
				System.out.println("Salario:" + p.getSalario());
				System.out.println(st.BARRA_RODAPE);
			}
		}
	}

	public static void Excluir_Cadastro(ArrayList<Pessoas> lista_pessoas) {

		if (lista_pessoas.isEmpty()) {
			st.Tecle_Algo("** Sem Cadastros para excluir **");

		} else {

			Mostrar_pessoas(lista_pessoas);

			int resp = st.Selecione_Item(lista_pessoas.size());
			if (resp != 0)
				lista_pessoas.remove(resp - 1);
			st.Tecle_Algo("Cadastro removido com suscesso");

		}
	}

	private static void Mostrar_pessoas(ArrayList<Pessoas> lista_pessoas) {

		System.out.println(st.BARRA_TOP);
		for (Pessoas pes : lista_pessoas) {
			System.out.println(lista_pessoas.indexOf(pes) + 1 + " - " + pes.getNome_completo());
		}
		System.out.println(st.BARRA_RODAPE);

	}

	public static void Alterar_Cadastros(ArrayList<Pessoas> lista_pessoas) {

		if (lista_pessoas.isEmpty()) {
			st.Tecle_Algo("** Sem Cadastros para alterar **");
		} else {

			Mostrar_pessoas(lista_pessoas);
			Pessoas pes = null;

			int resp = st.Selecione_Item(lista_pessoas.size());
			if (resp != 0)

			{
				resp--;
		//		st.tdados dados = new st.tdados();
				pes = lista_pessoas.get(resp);

				pes.setNome_completo(st.ValidaCampos("Nome", pes.getNome_completo()));
				pes.setCpf(st.ValidaCampos("CPF", pes.getCpf()));
				pes.setRg(st.ValidaCampos("RG", pes.getRg()));

			}

			lista_pessoas.set(resp, pes);
			st.Tecle_Algo("Cadastro alterado com suscesso");

		}

	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

}
