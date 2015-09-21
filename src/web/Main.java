package web;

import controlador.*;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {

	public static void main(String[] args) {
		
		Spark.staticFileLocation("/publico");
		
		MustacheTemplateEngine engine = new MustacheTemplateEngine("apresentacao");
		
		AdicionarTextoControlador adicionarTexto = new AdicionarTextoControlador();
		
		AdicionarTextoControladorP adicionarTextoP = new AdicionarTextoControladorP();
		
		Spark.post("/adicionandoTexto", adicionarTexto);
		
		Spark.get("/novoTexto", adicionarTextoP, engine);
		
	}

}
