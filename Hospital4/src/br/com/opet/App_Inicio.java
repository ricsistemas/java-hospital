package br.com.opet;

import br.com.opet.contoller.ControllerEspecialidade;
import br.com.opet.contoller.ControllerPessoas;
import br.com.opet.model.Especialidade;
import br.com.opet.model.st;

public class App_Inicio {

	public static void main(String[] args) throws Exception {

		ControllerEspecialidade controllerEsp = new ControllerEspecialidade();
		ControllerPessoas controllerPessoas = new ControllerPessoas(controllerEsp);

		Especialidade esp = new Especialidade(0, "Clinico Geral", 1500.00);
		controllerEsp.Esp_Add(esp);
		esp = new Especialidade(1, "Cirrugião", 3800.00);
		controllerEsp.Esp_Add(esp);

		int Opcao_selecionada = -1;

		do {
			System.out.println(st.BARRA_TOP);
			System.out.println("1. Cadastros Gerais");
			System.out.println("2. Especialidades");
			System.out.println("0. Sair");
			System.out.println(st.BARRA_RODAPE);
			Opcao_selecionada = st.Selecione_Item(2);
			switch (Opcao_selecionada) {
			case 0:
				break;
			case 1:
				controllerPessoas.executar();
				break;
			case 2:
				controllerEsp.executar();
				break;

			default:
				System.err.println("opção invalida");
				break;

			}

		} while (Opcao_selecionada != 0);

		System.out.println("** Fim de jogo ***");

	}

}
