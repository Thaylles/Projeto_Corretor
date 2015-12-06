package controlador;

import java.io.FileNotFoundException;

import modelo.Palavras;
import modelo.Texto;
import persistencia.DAO;
import persistencia.PalavrasDAO;
import persistencia.PalavrasDAO;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;


public class AdicionarSinonimosControlador implements Route {


	PalavrasDAO sinonimos = new PalavrasDAO();
	public ModelAndView handle(Request req, Response res) throws FileNotFoundException {
		String palavra = req.queryParams("palavra");
		String sinonimo = req.queryParams("sinonimo");
		sinonimos.save(new Palavras(palavra,sinonimo));
		res.redirect("/lista");	
		return null;	
	}
	

}



	

