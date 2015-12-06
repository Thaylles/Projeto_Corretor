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


public class AdicionarSinonimosControlador implements TemplateViewRoute, Route {


	PalavrasDAO sinonimos = new PalavrasDAO();
	public ModelAndView handle(Request req, Response res) {
		String palavra = req.queryParams("palavra");
		String sinonimo = req.queryParams("sinonimos");
		try {
			sinonimos.save(new Palavras(palavra,sinonimo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		res.redirect("/lista");	
		return new ModelAndView(null, "lista.html");	
	}
	

}



	

