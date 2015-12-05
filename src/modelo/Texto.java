package modelo;

import java.io.*;
import java.util.Scanner;

public class Texto {

	private String texto;
	private int chave;
	
	public Texto(String texto) throws FileNotFoundException {
		this.texto = texto;
		File cont = new File("src/apresentacao/cont.csv");
		Scanner scan = new Scanner(cont);
		chave = Integer.parseInt(scan.nextLine());
		
		//adiciona +1 no cont.csv
		Writer writer2;
		try {
			writer2 = new FileWriter(cont);
			writer2.write((chave + 1) + "");
		
			writer2.flush();
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Texto() throws Exception {	
		
		File cont = new File("src/apresentacao/cont.csv");
		Scanner scan = new Scanner(cont);
		chave = Integer.parseInt(scan.nextLine());
		
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
	
	private void setChave(int chave) {
		this.chave = chave;
	}
	
	@Override
	public String toString() {
		return texto;
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
