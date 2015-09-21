package persistencia;

import java.io.*;

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
}

	