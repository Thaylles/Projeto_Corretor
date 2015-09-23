package persistencia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

// geral ou abstrato
public interface DAO<T> {
	
	public void save(T obj) throws FileNotFoundException;
	
	//public void delete(T obj);
	
	public T load(int chave);
	
	//public void update(T obj);
	
	public ArrayList<T> findAll();
	
}
