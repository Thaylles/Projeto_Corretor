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


<<<<<<< HEAD
	DAO<Palavras> sinonimos = new PalavrasDAO();
	public ModelAndView handle(Request req, Response arg1) {
		Object a = req.queryParams("word");
		System.out.println(a);
		//String[] sinonimo = req.queryParams("sinonimo");
		//sinonimos.save(new Palavras(palavra,sinonimo));
		//res.redirect("/sinonimos");	
		return new ModelAndView(null, "novoSinonimo.html");	
=======
	PalavrasDAO sinonimos = new PalavrasDAO();
	public ModelAndView handle(Request req, Response res) throws FileNotFoundException {
		String palavra = req.queryParams("palavra");
		String sinonimo = req.queryParams("sinonimo");
		sinonimos.save(new Palavras(palavra,sinonimo));
		res.redirect("/lista");	
		return null;	
>>>>>>> 021f7b70850d5f1c3a28de4594a7dabcf1be42ce
	}
	

}



	

