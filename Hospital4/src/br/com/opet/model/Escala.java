package br.com.opet.model;

import java.util.ArrayList;

import com.opet.util.Reader;

public class Escala {
	private String descricao;
	private int horas;
	private int id;

	public Escala(int id, String descricao, int horas) {
		this.id = id;
		this.descricao = descricao;
		this.horas = horas;
	}

	public Escala() {
	};

	public Escala getEscala() throws Exception {

		ArrayList<Escala> lista_Escala = new ArrayList<>();
		lista_Escala.add(new Escala(1, "30h ", 30));
		lista_Escala.add(new Escala(2, "36h", 36));
		lista_Escala.add(new Escala(3, "40", 44));
		lista_Escala.add(new Escala(4, "44h", 44));
		lista_Escala.add(new Escala(5, "12x36", 12));
		lista_Escala.add(new Escala(6, "12x60", 12));

		do {
			System.out.println("====================================");
			for (int item = 0; item < lista_Escala.size(); item++) {
				Escala Esc = lista_Escala.get(item);
				System.out.println(Esc.getId() + " - " + Esc.getDescricao());
			}
			System.out.println("====================================");
			System.out.println("Qual a sua Opção:");
			int opcao_escolhida = Reader.readInt();

			for (int item = 0; item < lista_Escala.size(); item++) {

				Escala Esc = lista_Escala.get(item);

				if (Esc.getId() == opcao_escolhida)
					return Esc;

			}
			System.out.println("Opcão invalida");

		} while (true);

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorasmes() {

		return horas * 1000;
	}

}
