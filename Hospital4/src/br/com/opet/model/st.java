package br.com.opet.model;

import java.text.SimpleDateFormat;

import com.opet.util.Reader;

public interface st {
	public static final String BARRA_TOP = "\n===============================";
	public static final String BARRA_TOP_TEXTO = "\n=====  %s  ====\n";
	
	
	public static final String BARRA_RODAPE = "===============================\n";
	public static final String ATUALIZADO = "Atulizado com sucesso";
	public static final String ATUALIZACAO_CANCELADA = "O item  não foi atualizado";
	public static final String SEPARADOR_UPDATE = " = >: ";

	final int CADASTRO_MEDICOS = 1;
	final int CADASTRO_ADMINISTRADOR = 2;
	final int CADASTRO_ENFERMEIROS = 3;
	final int MDODO_INCLUSAO = 1;
	final int MDODO_ALTERACAO = 2;
	
	final SimpleDateFormat ANO_MASK = new SimpleDateFormat("yyyy");
	final SimpleDateFormat DT_MASK = new SimpleDateFormat("dd/MM/YY");
	
	public static int Selecione_Item(int item_maximo) {
		int opcao_selecionada = 99;
	
		do {	
				System.out.print("Qual a sua Opção:");
			try {
				opcao_selecionada = Reader.readInt();
			} catch (Exception e) {

				opcao_selecionada = -1;
				System.err.println("invalido tente novamente");
			}
			

	}	while( opcao_selecionada ==-1);
	
		return opcao_selecionada;
	}

	public static void Tecle_Algo(String mensagem) {
		System.out.println(mensagem);
		System.out.println("< Tecle Algo >");
		Reader.readString();
	}

	public static String ValidaCampos(String campo, String origem) {

		System.out.print(campo + ":");
		String destino = Reader.readString();
		boolean isvalido = destino.length() > 2 && origem != destino;

		if (isvalido) {

			System.out.println(origem + st.SEPARADOR_UPDATE + destino);
			System.out.println(ATUALIZADO);

		} else {

			destino = origem;
			System.out.println(ATUALIZACAO_CANCELADA);

		}

		return destino;

	}

}
