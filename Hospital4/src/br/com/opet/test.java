package br.com.opet;

import java.util.HashMap;

class Bichos {
	int id;
	String desc;

	public Bichos(int id, String desc) {
		this.id = id;
		this.desc = desc;

	}
}

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a HashMap object called people
		HashMap<Integer, Bichos> bicho = new HashMap<Integer, Bichos>();
		Bichos meupato1 = new Bichos(1, "cao");
		Bichos meupato2 = new Bichos(2, "gato");
		Bichos meupato3 = new Bichos(3, "canario");

		// Add keys and values (Name, Age)
		bicho.put(1, meupato1);
		bicho.put(2, meupato2);
		bicho.put(3, meupato3);

		boolean achei = false;
		for (Integer i : bicho.keySet()) {
			achei = (bicho.get(i).desc == "canario");
			if (achei)
				break;

			System.out.println("chave: " + i + " Valor: " + bicho.get(i).desc);

		}

		if (achei)
			System.out.println("Achei o gato");
		else
			System.out.println("Não achei nada");

	}

}
