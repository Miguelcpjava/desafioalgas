package ordem.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import br.com.ltn4java.transformation.NumberForLetter;

public class CodeOS {

	Collection<String> colecao = new ArrayList<String>(9);
	Collection<String> code;
	Random ra = new Random();
	NumberForLetter ln = new NumberForLetter();
	int number;
	String letra;

		
	public String codeGear(){
	int i = 0 ;
	String geral ="";
	code = new HashSet<String>(9);
	System.out.println("Tamanho do Code: "+code.size());
	while (i < code.size()){
		System.out.println("Position: "+i);
			if (i % 2 == 0) {
				number = ra.nextInt(9);
				while (number < 0 || number > 26) {
					number = ra.nextInt(9);
				}
				System.out.println("Par: " + number);
				letra = String.valueOf(number);
	
				code.add(letra);
			}
	
			if (i % 2 != 0) {
				number = ra.nextInt(26);
				while (number < 0 || number > 26) {
					number = ra.nextInt(26);
				}
				
				letra = String.valueOf(ln.number4Letter(number));
				System.out.println("Ímpar: "+number+" = "+letra);
				code.add(letra);
			}
			i++;
		}
		System.out.println("Inicializado: "+code);
		for (String pos : code) {
			geral += pos;
		}
		System.out.println("Finalizado: "+geral);
		return geral;
	}
	
	public Collection<String> gerarCodeAleatorio() {
		System.out.println(colecao);
		for (int i = 0; i < 8; i++) {
			if (colecao.size() > 8) {
				colecao.clear();
			}
			if (i % 2 == 0) {
				number = ra.nextInt(9);
				//System.out.println("Par: " + number);
				while (number < 0 || number > 26) {
					number = ra.nextInt(9);
				}
				letra = String.valueOf(number);
				//if(colecao.contains(letra))
				while(colecao.contains(letra) || letra == " "){
					number = ra.nextInt(9);
					//System.out.println("Par: " + number);
					while (number < 0 || number > 26) {
						number = ra.nextInt(9);
					}
					letra = String.valueOf(number);
				}
				System.out.println("..Par: " + number + " Numero: " + letra);
				colecao.add(letra);
			}

			if (i % 2 != 0) {
				number = ra.nextInt(26);
				
				while (number < 0 || number > 26) {
					number = ra.nextInt(26);
				}
				letra = String.valueOf(ln.number4Letter(number));
				while(colecao.contains(letra) || letra == " "){
					number = ra.nextInt(26);
					
					while (number < 0 || number > 26) {
						number = ra.nextInt(26);
					}
					letra = String.valueOf(ln.number4Letter(number));
				}
				System.out.println("Impar: " + number + " Letra.: " + letra);
				colecao.add(letra);
			}
		}
		System.out.println(colecao);
		return colecao;
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
