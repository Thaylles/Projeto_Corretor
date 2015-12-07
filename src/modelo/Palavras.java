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
	private String sinonimo;
	private String[] sinonimos;
	private int curtidas;
	
	public String getSinonimo() {
		return sinonimo;
	}

	public void setSinonimo(String sinonimo) {
		this.sinonimo = sinonimo;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	
	public Palavras() {
		
	}
	public Palavras(String palavra, String sinonimo) throws FileNotFoundException {
		super();
		this.palavra = palavra;
		this.sinonimo = sinonimo;
	}
	
	public String toCSV() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(palavra).append(";").append(sinonimo).append(";").append(""+curtidas).append("\n");
		return builder.toString();
	}
	
	public void fromCSV(String row) {
		
		String[] columns = row.split(";");
		this.setPalavra(columns[0]);
		this.setSinonimo(columns[1]);
		this.setCurtidas(Integer.parseInt(columns[2]));
		
	}
	public String[] getSinonimos() {
		return sinonimos;
	}

	public void setSinonimos(String[] sinonimos) {
		this.sinonimos = sinonimos;
	}

	public void fromCSV(String[] a){
		this.setSinonimos(a);
	}


	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
}
