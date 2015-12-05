package controlador;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class NovoSinonimoControlador
	implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request req, Response resp) {		
		HashMap mapa = new HashMap();
		if (req.queryParams("erro") != null) { // existe um par�metro erro
			mapa.put("erro", req.queryParams("erro"));
		}
		return new ModelAndView(mapa, "novoSinonimo.html");
	}

}