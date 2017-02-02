package ordem.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import br.com.ltn4java.transformation.NumberForLetter;

public class CodeOS {

	Collection<String> colecao = new ArrayList<String>(9);
	Collection<String> code = new HashSet<String>();
	Random ra = new Random();
	NumberForLetter ln = new NumberForLetter();
	int number;
	String letra;

	public Collection<String> gerarCodeAleatorio() {
		for (int i = 0; i < 8; i++) {
			if (colecao.size() > 8) {
				colecao.clear();
			}
			if (i % 2 == 0) {
				number = ra.nextInt(9);
				System.out.println("Par: " + number);
				while (number < 0 || number > 26) {
					number = ra.nextInt(9);
				}
				letra = String.valueOf(number);

				colecao.add(letra);
			}

			if (i % 2 != 0) {
				number = ra.nextInt(26);
				while (number < 0 || number > 26) {
					number = ra.nextInt(26);
				}
				letra = String.valueOf(ln.number4Letter(number));
				colecao.add(letra);
			}
		}
		code.addAll(colecao);
		return code;
	}

	public String valorCode(Collection<String> code) {
		String codigo = "";
		List<String> novo = new ArrayList<String>(code);
		for (int z = 0; z < code.size(); z++) {
			codigo += novo.get(z);
		}
		return codigo;
	}

}
