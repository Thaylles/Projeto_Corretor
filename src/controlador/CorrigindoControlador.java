package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CorrigindoControlador implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request arg0, Response arg1) {
		// TODO Auto-generated method stub
		return new ModelAndView(null,"corrigindo.html");
	}

}
