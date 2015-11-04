package web;

import controlador.*;
import dicionario.Dicionario;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {

	public static void main(String[] args) throws Exception {
		Dicionario dicionario = new Dicionario();
		System.out.println(dicionario.isCorrect("banana"));
		Spark.staticFileLocation("/publico");
		
		MustacheTemplateEngine engine = new MustacheTemplateEngine("apresentacao");
		AdicionarTextoControlador adicionarTexto = new AdicionarTextoControlador();
		HomeControlador home = new HomeControlador();
		Spark.post("/adicionandoTexto", adicionarTexto);
		Spark.get("/home", home, engine);
		
	}

}
