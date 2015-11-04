package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Texto {
	

	private String texto;
	private int chave;
	
	public Texto(String texto) throws FileNotFoundException {
		super();
		this.texto = texto;
		File cont = new File("src/apresentacao/cont.csv");
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
	
	public Texto() {
		
	}

	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
	
	@Override
	public String toString() {
		return "Texto [ texto=" + texto  + "]";
	}
	public String toCSV() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(texto).append(";").append(chave + "").append("\n");
		return builder.toString();
	}
	
	public void fromCSV(String row) {
		
		String [] columns = row.split(";");
		this.setTexto(columns[0]);
		this.setChave(Integer.parseInt(columns[1]));
		
	}
}
