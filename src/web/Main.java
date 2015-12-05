package web;

import controlador.*;
import dicionario.Dicionario;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {

	public static void main(String[] args) throws Exception {
		Dicionario dicionario = new Dicionario();
		Spark.staticFileLocation("/publico");
		
		MustacheTemplateEngine engine = new MustacheTemplateEngine("apresentacao");
		AdicionarTextoControlador adicionarTexto = new AdicionarTextoControlador();
		HomeControlador home = new HomeControlador();
		Spark.post("/adicionandoTexto", adicionarTexto);
		Spark.get("/home", home, engine);
		CorrigindoControlador corrigindo = new CorrigindoControlador();
		Spark.get("/corrigindo",corrigindo, engine);
		ListaControlador sinonimo = new ListaControlador();
		NovoSinonimoControlador novo = new NovoSinonimoControlador();
		Spark.get("/novoSinonimo", novo, engine);
		AdicionarSinonimosControlador adicionarSinonimos = new AdicionarSinonimosControlador();
		Spark.get("/sinonimo",adicionarSinonimos,engine);

		
	}

}
