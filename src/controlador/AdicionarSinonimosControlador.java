package controlador;

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


public class AdicionarSinonimosControlador implements TemplateViewRoute {


	DAO<Palavras> sinonimos = new PalavrasDAO();
	public ModelAndView handle(Request req, Response arg1) {
		Object a = req.queryParams("word");
		System.out.println(a);
		//String[] sinonimo = req.queryParams("sinonimo");
		//sinonimos.save(new Palavras(palavra,sinonimo));
		//res.redirect("/sinonimos");	
		return new ModelAndView(null, "novoSinonimo.html");	
	}
	

}



	

