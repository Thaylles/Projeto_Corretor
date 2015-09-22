package persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Texto;

public class TextoDAO implements DAO<Texto> {
	
	public void save(Texto obj) {
		File dir = new File("src/apresentacao/Textos");
		if(! dir.exists()) 
			dir.mkdir();
		
		File file = new File("src/apresentacao/Textos/" + obj.getTitulo() + ".csv");
		if(file.exists() == false) {
			
			FileWriter writer;
			try {
				
				writer = new FileWriter(file);
				writer.write(obj.toCSV());
				
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Texto load(String nome) {		
		try {
			File arq = new File("src/apresentacao/Textos/" + nome + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			Texto f = new Texto();
			f.setTitulo(nome);
			f.setTexto(colunas[1]);
			f.setAutor(colunas[2]);
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public ArrayList<Texto> findAll() {
		ArrayList<Texto> lista = new ArrayList<Texto>();
		try {
			File dir = new File("src/apresentacao/Textos");	
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { // for each
				Scanner scan = new Scanner(arq);
				String linha = scan.nextLine();
				String[] colunas = linha.split(";");
				Texto f = new Texto();
				f.setTitulo(colunas[0]);
				f.setTexto(colunas[1]);
				f.setAutor(colunas[2]);
				lista.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}

	