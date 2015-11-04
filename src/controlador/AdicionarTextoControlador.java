package controlador;

import modelo.Texto;
import persistencia.*;
import spark.*;

public class AdicionarTextoControlador implements Route {
	
	DAO<Texto> textos = new TextoDAO();
	
	public Object handle(Request req, Response res) throws Exception {
		String texto = req.queryParams("texto");
		textos.save(new Texto( texto));
		res.redirect("/home");
		return null;
	}
}
	


