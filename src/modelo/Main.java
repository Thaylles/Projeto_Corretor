package modelo;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "avião";
		String[] b = {"teco-teco", "jato"};
		
		try {
			Palavras palavra = new Palavras(a,b[1]);
			System.out.println(palavra.getPalavra());
			String[] c = palavra.getSinonimos();
			System.out.println(c[0]);
			System.out.println(c[1]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
