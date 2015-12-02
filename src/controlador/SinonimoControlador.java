package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Texto;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SinonimoControlador implements TemplateViewRoute {

	private TextoDAO dao = new TextoDAO();
	
	public ModelAndView handle(Request req, Response resp) {
		ArrayList<Texto> sinonimos = dao.findAll();
		HashMap mapa = new HashMap();
		mapa.put("sinonimo", sinonimos);		
		return new ModelAndView(mapa, "sinonimo.html");
	}

}
