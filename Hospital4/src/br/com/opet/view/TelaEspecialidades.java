package br.com.opet.view;

import java.util.HashMap;

import com.opet.util.Reader;

import br.com.opet.contoller.ControllerEspecialidade;
import br.com.opet.model.Especialidade;
import br.com.opet.model.st;

public class TelaEspecialidades {

	public void listar(HashMap<Integer, Especialidade> lista_especialidade) {
		if (lista_especialidade.isEmpty())
			st.Tecle_Algo("Sem Especialidades para mostrar até a o Momento");
		else {

			System.out.println(st.BARRA_TOP);

			for (Especialidade e : lista_especialidade.values()) {
				System.out.println(e.getId() + " - " + e.getDescricao());

			}
			System.out.println(st.BARRA_RODAPE);

		}
	}

	public int menu() {

		int opcao_selecionada = 1;

		do {
			System.out.printf(st.BARRA_TOP_TEXTO, "Especialidades");
			System.out.println(" 1. Nova Especialidade");
			System.out.println(" 2. Listar");
			System.out.println(" 3. Alterar");
			System.out.println(" 4. Excluir");
			System.out.println(" 0. Menu Principal");
			System.out.printf(st.BARRA_TOP_TEXTO, "Especialidades");
			opcao_selecionada = st.Selecione_Item(5);

		} while (opcao_selecionada < 0 || opcao_selecionada > 4);
		return opcao_selecionada;

	}

	public Especialidade adicionar(int id) throws Exception {
		System.out.printf(st.BARRA_TOP_TEXTO, "Cadastro Especialidades");
		System.out.print("Descricao:");
		String descricao = Reader.readString();
		System.out.print("Salario:");

		double salario = Reader.readDouble();

		Especialidade esp = new Especialidade(id, descricao, salario);
		return esp;

	}

	public int remover(HashMap<Integer, Especialidade> lista_especialidade) {

		listar(lista_especialidade);
		int item_selecionado = st.Selecione_Item(lista_especialidade.size());
		return item_selecionado;
	}
	

	
	
	public Especialidade update(HashMap<Integer, Especialidade> lista_especialidade) throws Exception {
		Especialidade esp = null;
	
		listar(lista_especialidade);
		int item_selecionado = st.Selecione_Item(lista_especialidade.size());
		esp = lista_especialidade.get(item_selecionado);
    
		System.out.println("Especialidade:"+ esp.getDescricao() + "=>") ;
		String desc = Reader.readString();
        System.out.println("Salário: "+ esp.getSalario()+ "=>: " );
		double salario  = Reader.readDouble() ;
    	esp.setDescricao(desc); 
		esp.setSalario(salario);
		
		return esp;
		
	}

	public int getEspecialidade(HashMap<Integer, Especialidade> lista_especialidade) {
		listar(lista_especialidade);
		int item_selecionado = st.Selecione_Item(lista_especialidade.size());
		return item_selecionado;

	}

}
