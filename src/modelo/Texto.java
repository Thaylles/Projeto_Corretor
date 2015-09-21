package modelo;

public class Texto {
	
	private String titulo;
	private String autor;
	private String texto;
	
	public Texto(String titulo, String texto, String autor) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
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
	
	@Override
	public String toString() {
		return "Texto [titulo=" + titulo + ", texto=" + texto + ", autor=" + autor + "]";
	}
	public String toCSV() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(titulo).append(";").append(texto).append(";").append(autor).append("\n");
		return builder.toString();
	}
	
	public void fromCSV(String row) {
		
		String [] columns = row.split(";");
		this.setTitulo(columns[0]);
		this.setTexto(columns[1]);
		this.setAutor(columns[2]);
		
	}
}
