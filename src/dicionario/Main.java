package dicionario;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Dicionario dicionario = new Dicionario();
		
		System.out.println(dicionario.isCorrect("avi�o"));
		
		System.out.println(dicionario.next());
		
		System.out.println(dicionario.size());
		
	}

}
