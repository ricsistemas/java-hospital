package br.com.opet.contoller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.opet.model.Administrador;
import br.com.opet.model.Enfermeiros;
import br.com.opet.model.Especialidade;
import br.com.opet.model.Medicos;
import br.com.opet.model.Pessoas;
import br.com.opet.model.st;
import br.com.opet.view.TelaPessoas;

public class ControllerPessoas {

	private ArrayList<Pessoas> Lista_pessoas = new ArrayList<>();
	private ControllerEspecialidade ControlEsp;
	private TelaPessoas tPessoas = new TelaPessoas();

	public ControllerPessoas(ControllerEspecialidade ControlEsp) {

		this.ControlEsp = ControlEsp;

	}

	public void executar() throws Exception {
		int opcao_menu = -1;
		int tipo_cadastro = -1;
		Pessoas pes;
		// Escolheu cadastros
		opcao_menu = tPessoas.menu();
		switch (opcao_menu) {
		case 1:

			pes = tPessoas.adicionar(st.MDODO_INCLUSAO, ControlEsp);
			pes.setId(Lista_pessoas.size());
			Lista_pessoas.add(pes);
			break;

		case 2:
			// lista
			tPessoas.Listar(Lista_pessoas);
			break;

		case 3:

			// alterarao
			int index_pessoa = tPessoas.update(Lista_pessoas);
			
			pes = Lista_pessoas.get(index_pessoa);
			Pessoas pesNovo = tPessoas.adicionar(st.MDODO_ALTERACAO, ControlEsp);
			Lista_pessoas.remove(pes);
			Lista_pessoas.add(pesNovo);
			
			break;
		case 4:
			// Excluir
			int index_Excluir = tPessoas.remover(Lista_pessoas);
			Lista_pessoas.remove(index_Excluir);
			break;

		default:
			break;
		}

	}
}
