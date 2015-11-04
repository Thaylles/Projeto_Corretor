package controlador;

import spark.*;

public class HomeControlador implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request arg0, Response arg1) {
		return new ModelAndView(null, "novoTexto.html");
	}
	
}
