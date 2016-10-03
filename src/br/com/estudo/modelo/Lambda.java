package br.com.estudo.modelo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda {

	public static void main(String[] args) {

		ArrayList<String> palavra = new ArrayList<>();
		palavra.add("alura online");
		palavra.add("editora casa do codigo");
		palavra.add("caelum");

		Comparator<String> comparador = new ComparadorPorTamanho();

		// Collections.sort(palavra, comparador);
		palavra.sort(comparador);
		System.out.println(palavra);
		
	/*	palavra.sort(new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;

				return 0;
			}
			
		});
		*/
		palavra.sort((s1, s2) -> {
			return Integer.compare(s1.length(), s2.length());
		});
		
		Consumer<String> impressor = s -> System.out.println(s);
		palavra.forEach(impressor);
		
		palavra.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
			
		/*
		 * for (String p : palavra) { System.out.println(p); }
		 */

		/*
		 * Consumer<String> consumidor = new Consumer<String>() { //new ImprimenaLinha()
		 * 
		 * @Override public void accept(String s) {
		 * 	System.out.println(s);
		 * 
		 * } };
		 */

		palavra.forEach(s -> System.out.println(s));
	}
	
	
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);

	}
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;

		return 0;
	}

}
