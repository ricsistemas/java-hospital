package br.com.opet.contoller;

import java.util.HashMap;

import com.opet.util.Reader;

import br.com.opet.model.Especialidade;
import br.com.opet.model.st;
import br.com.opet.view.TelaEspecialidades;
import br.com.opet.view.TelaPessoas;

public class ControllerEspecialidade {

	private HashMap<Integer, Especialidade> lista_especialidade = new HashMap();;
	private TelaEspecialidades tEspecialidades = new TelaEspecialidades();

	public void Esp_Add(Especialidade esp) {
		lista_especialidade.put(esp.getId(), esp);

	}

	public Especialidade selectEspecialidade() {

		int item_Selecionado = tEspecialidades.getEspecialidade(lista_especialidade);
		Especialidade esp = lista_especialidade.get(item_Selecionado);
		return esp;
	}

	public void executar() throws Exception {
		Especialidade esp;

		int Item_selecionado = tEspecialidades.menu();

		switch (Item_selecionado) {
		case 1:
			// adicionar
			esp = tEspecialidades.adicionar(lista_especialidade.size());
			lista_especialidade.put(esp.getId(), esp);
			break;
		case 2:
			tEspecialidades.listar(lista_especialidade);
			break;
		case 3:
			// alteração
			esp = tEspecialidades.update(lista_especialidade);
			lista_especialidade.replace(esp.getId(), esp);
			break;
		case 4:
			// Excluir
			int idExcluir = tEspecialidades.remover(lista_especialidade);
			lista_especialidade.remove(idExcluir);
			st.Tecle_Algo("Especilidade excluida");
			break;
		default:
			break;
		}

	}

}
