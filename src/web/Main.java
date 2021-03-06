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
		Spark.get("/corrigindo/:numero",corrigindo, engine);
		
		ListaControlador lista = new ListaControlador();
		Spark.get("/lista", lista, engine);
		NovoSinonimoControlador novo = new NovoSinonimoControlador();
		Spark.get("/novoSinonimo", novo, engine);
		AdicionarSinonimosControlador adicionarSinonimos = new AdicionarSinonimosControlador();
<<<<<<< HEAD
		Spark.get("/sinonimo",adicionarSinonimos,engine);
		Spark.get("corrigindo:/numero:/numero2", corrigindo, engine);
=======
		Spark.post("/adicionaSinonimos",adicionarSinonimos);
>>>>>>> 021f7b70850d5f1c3a28de4594a7dabcf1be42ce

		
	}

}
