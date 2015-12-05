package persistencia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface DAO<T> {
	
	public void save(T obj) throws FileNotFoundException;
	
	public T load(int chave);
	
	public T load(String palavra);
	
	public ArrayList<T> findAll();
	
	public void delete(int chave);
	
}
