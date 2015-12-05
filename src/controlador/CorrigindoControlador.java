package controlador;

import modelo.Texto;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CorrigindoControlador implements TemplateViewRoute {
	TextoDAO dao = new TextoDAO();
	@Override
	public ModelAndView handle(Request req, Response resp) {
		Texto tx;
		try {
			tx = new Texto();
			 tx = dao.load(Integer.parseInt(req.params("numero")));
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView(null,"corrigindo.html");
	}

}
