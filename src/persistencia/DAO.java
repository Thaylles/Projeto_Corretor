package persistencia;

// geral ou abstrato
public interface DAO<T> {
	
	public void save(T obj);
	
	//public void delete(T obj);
	
	//public T load(String titulo);
	
	//public void update(T obj);
	
	//public ArrayList<T> findAll();
	
}
