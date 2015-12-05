package controlador;

import modelo.Palavras;
import modelo.Texto;
import persistencia.DAO;
import persistencia.PalavrasDAO;
import persistencia.PalavrasDAO;
import persistencia.TextoDAO;
import spark.Request;
import spark.Response;
import spark.Route;

public class AdicionarSinonimosControlador implements Route {

	DAO<Palavras> sinonimos = new PalavrasDAO();
	public Object handle(Request req, Response res) throws Exception {
		String palavra = req.queryParams("palavra");
		//String[] sinonimo = req.queryParams("sinonimo");
		//sinonimos.save(new Palavras(palavra,sinonimo));
		res.redirect("/sinonimos");
		return null;
	}

}
