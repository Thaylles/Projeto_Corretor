package controlador;

import modelo.Texto;
import persistencia.*;
import spark.*;

public class AdicionarTextoControlador implements Route {
	
	DAO<Texto> textos = new TextoDAO();
	
	public Object handle(Request req, Response res) throws Exception {
		String titulo = req.queryParams("titulo");
		String texto = req.queryParams("texto");
		String autor = req.queryParams("autor");
		textos.save(new Texto(titulo, texto, autor));
		return null;
	}
}
	


