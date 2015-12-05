package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Palavras {
	
	private String palavra;
	private String[] sinonimos;
	private int chave;
	private String sinonimosBuilder = "";

	public String[] getSinonimos() {
		return sinonimos;
	}

	public void setSinonimos(String[] columns) {
		for(int i=0; i < columns.length; i++){
			sinonimos[i] = columns[i]; 
		}
	}
	
	public Palavras() {
		
	}
	public Palavras(String palavra, String[] sinonimos) throws FileNotFoundException {
		super();
		this.palavra = palavra;
		this.sinonimos = sinonimos;
		File cont = new File("src/apresentacao/contadorSinonimos.csv");
		Scanner scan = new Scanner(cont);
		String linha = scan.nextLine();
		int index = Integer.parseInt(linha);
		this.chave = index;
		
		//adiciona +1 no cont.csv
		Writer writer2;
		try {
			writer2 = new FileWriter(cont);
			writer2.write((index + 1) + "");
		
			writer2.flush();
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String toCSV() {
		
		StringBuilder builder = new StringBuilder();
		for(int i=0; i < sinonimos.length ; i++) sinonimosBuilder = sinonimos[i]+","+sinonimosBuilder; 
		builder.append(palavra).append(";").append(sinonimosBuilder).append(";").append(chave + "").append("\n");
		return builder.toString();
	}
	
	public void fromCSV(String row) {
		
		String[] columns = row.split(";");
		this.setPalavra(columns[0]);
		this.setSinonimosBuilder(columns[1]);
		this.setChave(Integer.parseInt(columns[2]));
		
	}

	public String getSinonimosBuilder() {
		return sinonimosBuilder;
	}

	public void setSinonimosBuilder(String sinonimosBuilder) {
		this.sinonimosBuilder = sinonimosBuilder;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
	public static void main(String[] args) {
		String a = "avião";
		String[] b = {"teco-teco", "jato"};
		
		Palavras(a,b);
	}
}
