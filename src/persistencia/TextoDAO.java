package persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Texto;

public class TextoDAO{
	
	public void save(Texto obj) throws FileNotFoundException {
		File dir = new File("src/apresentacao/Textos");
		if(! dir.exists()) 
			dir.mkdir();
		
		File file = new File("src/apresentacao/Textos/" + obj.getChave() + ".csv");
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

	public Texto load(int chave) {		

		try {
			File arq = new File("src/apresentacao/Textos/" + chave + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			
			Texto f = new Texto();
			f.fromCSV(linha);
			
			scan.close();
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
				Texto f = new Texto();
				f.fromCSV(linha);
				lista.add(f);
				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void delete(int chave){
		File a = new File("src/apresentacao/Textos/" + chave + ".csv");
		if(a.exists())a.delete();
	}
}

	