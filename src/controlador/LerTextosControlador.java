package controlador;
import spark.*;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Texto;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class LerTextosControlador implements TemplateViewRoute {
private TextoDAO dao = new TextoDAO();
	@Override
	public ModelAndView handle(Request arg0, Response arg1) {
		ArrayList<Texto> texto = dao.findAll();
		HashMap mapa = new HashMap();
		    //variavel html //variavel java
		mapa.put("texto", texto);
		// "filmes"= variavel que eu vou me orientar no html
		// filmes = variavel existente apenas no java
		
		//HashMap liga a pagina ao conteudo q tem o msm nome, smp q se referir a filmes na pagina se diz respeito a lista
		return new ModelAndView(mapa, "listaTextos.html");
	}

}
