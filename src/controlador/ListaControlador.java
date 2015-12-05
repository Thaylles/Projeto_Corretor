package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Texto;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ListaControlador implements TemplateViewRoute {

	private TextoDAO dao = new TextoDAO();
	
	public ModelAndView handle(Request req, Response resp) {
		ArrayList<Texto> sinonimos = dao.findAll();
		HashMap mapa = new HashMap();
		mapa.put("sinonimos", sinonimos);		
		return new ModelAndView(mapa, "lista.html");
	}

}
