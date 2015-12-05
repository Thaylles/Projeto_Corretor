package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Palavras;
import modelo.Texto;

public class PalavrasDAO implements DAO<Palavras> {

	@Override
	public void save(Palavras obj) throws FileNotFoundException {
		File dir = new File("src/apresentacao/Sinonimos");
		if(! dir.exists()) 
			dir.mkdir();
		
		File file = new File("src/apresentacao/Sinonimos/" + obj.getPalavra() + ".csv");
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

	@Override
	public Palavras load(int chave) {
		return null;
	}

	@Override
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
				f.setPalavra(colunas[0]);
				f.setSinonimosBuilder(colunas[1]);
				f.setChave(Integer.parseInt(colunas[2]));
				lista.add(f);
				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void delete(int chave) {
		File a = new File("src/apresentacao/Textos/" + chave + ".csv");
		if(a.exists())a.delete();
	}

	@Override
	public Palavras load(String palavra) {
		try {
			File arq = new File("src/apresentacao/Sinonimos/" + palavra + ".csv");
			
			if (!arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			Palavras f = new Palavras();
			f.setPalavra(colunas[0]);
			f.setSinonimosBuilder(colunas[1]);
			f.setChave(Integer.parseInt(colunas[2]));
			
			scan.close();
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
