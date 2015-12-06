package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Palavras;
import modelo.Texto;

public class PalavrasDAO {

	public void save(Palavras obj) throws FileNotFoundException {
		File dir = new File("src/apresentacao/Sinonimos");
		if(! dir.exists()) 
			dir.mkdir();
		
		File file = new File("src/apresentacao/Sinonimos/Sinonimos.csv");
		if(file.exists() == false) {
			
			FileWriter writer;

			try { 
				writer = new FileWriter(file);
				writer.write(obj.toCSV());
				
				writer.flush();
				writer.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Palavras load(String palavra) {
		try {
			File arq = new File("src/apresentacao/Sinonimos/Sinonimos.csv");
			
			if (!arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			String[] sinonimos = new String[3];
			int j=0;
			while(scan.hasNextLine()){
				while(j < 3){
				if(palavra == colunas[0]){
					if(Integer.parseInt(colunas[2]) > -3){sinonimos[j] = colunas[1]; j++;}
					}
				if(palavra == colunas[1]){
				if(Integer.parseInt(colunas[2]) > -3){sinonimos[j] = colunas[0]; j++;}
					}
				}
			}
			
			Palavras f = new Palavras();
			f.fromCSV(sinonimos);
			
			scan.close();
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<Palavras> findAll() {
		ArrayList<Palavras> lista = new ArrayList<Palavras>();
		try {
			File dir = new File("src/apresentacao/Sinonimos");	
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { // for each
				Scanner scan = new Scanner(arq);
				String linha = scan.nextLine();
				String[] colunas = linha.split(";");
				Palavras f = new Palavras();
				f.fromCSV(linha);
				lista.add(f);
				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
