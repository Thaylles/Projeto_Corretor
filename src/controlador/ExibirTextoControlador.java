package controlador;

import java.util.HashMap;

import modelo.Texto;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ExibirTextoControlador implements TemplateViewRoute {
	private TextoDAO dao = new TextoDAO();
	@Override
	public ModelAndView handle(Request arg0, Response arg1) {
		int chave = arg0.queryMap("chave").integerValue();
		Texto texto = dao.load(chave);
		HashMap mapa = new HashMap();
		mapa.put("texto",texto);
		return new ModelAndView(mapa, "exibirTexto.html");
	}

}
