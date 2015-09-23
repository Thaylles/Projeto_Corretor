package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Texto {
	
	private String titulo;
	private String autor;
	private String texto;
	private int chave;
	
	public Texto(String titulo, String texto, String autor) throws FileNotFoundException {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		
		File cont = new File("src/apresentacao/cont.csv");
		Scanner scan = new Scanner(cont);
		String linha = scan.nextLine();
		int index = Integer.parseInt(linha);
		this.chave = index;
		
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

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		return "Texto [titulo=" + titulo + ", texto=" + texto + ", autor=" + autor + "]";
	}
	public String toCSV() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(titulo).append(";").append(texto).append(";").append(autor).append(";").append(chave + "").append("\n");
		return builder.toString();
	}
	
	public void fromCSV(String row) {
		
		String [] columns = row.split(";");
		this.setTitulo(columns[0]);
		this.setTexto(columns[1]);
		this.setAutor(columns[2]);
		this.setChave(Integer.parseInt(columns[3]));
		
	}
}
