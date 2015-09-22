package persistencia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

// geral ou abstrato
public interface DAO<T> {
	
	public void save(T obj) throws FileNotFoundException;
	
	//public void delete(T obj);
	
	public T load(String titulo);
	
	//public void update(T obj);
	
	public ArrayList<T> findAll();
	
}
