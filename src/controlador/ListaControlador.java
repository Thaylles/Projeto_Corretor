package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Palavras;
import modelo.Texto;
import persistencia.PalavrasDAO;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ListaControlador implements TemplateViewRoute {

	private PalavrasDAO dao = new PalavrasDAO();
	
	public ModelAndView handle(Request req, Response resp) {
		ArrayList<Palavras> sinonimos = dao.findAll();
		HashMap mapa = new HashMap();
		mapa.put("sinonimos", sinonimos);		
		return new ModelAndView(mapa, "lista.html");
	}

}
