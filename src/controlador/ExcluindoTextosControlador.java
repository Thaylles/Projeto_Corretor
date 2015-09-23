package controlador;

import modelo.Texto;
import persistencia.DAO;
import persistencia.TextoDAO;
import spark.Request;
import spark.Response;
import spark.Route;

public class ExcluindoTextosControlador implements Route{

	DAO<Texto> textos = new TextoDAO();
	
	public Object handle(Request req, Response resp) throws Exception {
		textos.delete(Integer.parseInt(req.queryParams("numero")));
		resp.redirect("/lista");
		return null;
	}

}
