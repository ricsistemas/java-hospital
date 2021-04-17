package br.com.opet.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opet.util.Reader;

import br.com.opet.contoller.ControllerEspecialidade;
import br.com.opet.model.Administrador;
import br.com.opet.model.Enfermeiros;
import br.com.opet.model.Especialidade;
import br.com.opet.model.Medicos;
import br.com.opet.model.Pessoas;
import br.com.opet.model.st;

public class TelaPessoas {

	public int menu() {
		int opcao_selecionada = 1;

		do {
			System.out.printf(st.BARRA_TOP_TEXTO, "Cadastros");
			System.out.println(" 1. Novo Cadastro");
			System.out.println(" 2. Listar");
			System.out.println(" 3. Alterar");
			System.out.println(" 4. Excluir");
			System.out.println(" 0. Menu Principal");
			System.out.printf(st.BARRA_TOP_TEXTO, "Cadastros");
			opcao_selecionada = st.Selecione_Item(3);

		} while (opcao_selecionada < 0 || opcao_selecionada > 4);
		return opcao_selecionada;

	}

	public Pessoas adicionar(int modo_cadastro, ControllerEspecialidade controllerEsp) throws Exception {
		Pessoas pes = null;
		Especialidade esp = null;

		String med[] = { "Médicos", "Administradores", "Enfermeiros" };

		int tipo_cadastro = SelectPerfil();

		if (modo_cadastro == st.MDODO_INCLUSAO)
			System.out.printf(st.BARRA_TOP_TEXTO, "Cadastro de " + med[tipo_cadastro - 1]);
		else {

			System.out.printf(st.BARRA_TOP_TEXTO, "Alteração de " + med[tipo_cadastro - 1]);
		}

		System.out.print("Nome Completo:");
		String nome = Reader.readString();
		System.out.print("CPF:");
		String cpf = Reader.readString();
		System.out.print("RG:");
		String rg = Reader.readString();
		Date dtnasc = null;
		int Evalido = 0;
		do {
			System.out.print("Data de Nascimento:");
			String strdataNasc = Reader.readString();
			
			try {

			    dtnasc = st.DT_MASK.parse(strdataNasc);
				Evalido = 1;
			} catch (Exception e) {
				Evalido = 0;
				System.err.println("Esta data nãoe valida!");
			}

		} while (Evalido != 1);

		// String strdataNasc = "25/06/1980";

		switch (tipo_cadastro) {
		case st.CADASTRO_MEDICOS:
			esp = controllerEsp.selectEspecialidade();
			if (esp == null) {
				st.Tecle_Algo("Este cadastro foi cancelado, por falta de especilidade ");
				break;
			}
			pes = new Medicos(nome, cpf, rg, dtnasc, esp);
			break;
		case st.CADASTRO_ADMINISTRADOR:
			System.out.print("Informe o salário:");

			double salario = Reader.readDouble();
			pes = new Administrador(nome, cpf, rg, dtnasc, salario);
			break;
		case st.CADASTRO_ENFERMEIROS:

			pes = new Enfermeiros(nome, cpf, rg, dtnasc, 1);
			break;

		default:
			break;
		}

		return pes;

	}

	public int update(ArrayList<Pessoas> lista_pes) {
		selectPessoas(lista_pes);
		int Item_Selecionado = st.Selecione_Item(lista_pes.size());
		return Item_Selecionado;

	}

	public int remover(ArrayList<Pessoas> lista_pes) {

		int opcao_selecionada = -1;

		selectPessoas(lista_pes);
		opcao_selecionada = st.Selecione_Item(lista_pes.size());

		return opcao_selecionada;

	}

	public void Listar(ArrayList<Pessoas> lista_pes) {
		if (lista_pes.isEmpty())
			st.Tecle_Algo("Sem Cadastro para mostrar até a o Momento");
		else {

			for (int item = 0; item < lista_pes.size(); item++) {

				Pessoas p;
				p = lista_pes.get(item);

				if (p instanceof Medicos) {

					Medicos med = (Medicos) lista_pes.get(item);

					System.out.println("============ " + med.getPerfil() + " - " + med.getEspecialidade().getDescricao()
							+ " =================");
				} else {
					System.out.println("============ " + p.getPerfil() + " =================");
				}
				System.out.println("Nome:" + p.getNome_completo());
				System.out.println("CPF:" + p.getCpf());
				System.out.println("Data Nasc.:" + st.DT_MASK.format(p.getDtnascimento()));
				System.out.println("Idade:" + p.getIdade());
				System.out.println("Salario:" + p.getSalario());
				System.out.println(st.BARRA_RODAPE);
			}
		}
	}

	public int SelectPerfil() {

		System.out.println(st.BARRA_TOP);
		System.out.println(" 1. Medicos");
		System.out.println(" 2. Administ0rador");
		System.out.println(" 3. Enfermeiros");
		System.out.println(st.BARRA_RODAPE);
		int opcao_selecionada = st.Selecione_Item(3);
		return opcao_selecionada;

	}

	public void selectPessoas(ArrayList<Pessoas> lista_pes) {
		System.out.println(st.BARRA_TOP);
		for (Pessoas pes : lista_pes) {

			System.out.println(pes.getId() + " - " + pes.getNome_completo() + " CPF:" + pes.getCpf());

		}
		System.out.println(st.BARRA_RODAPE);

	}

}
