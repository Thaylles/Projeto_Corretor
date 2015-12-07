package controlador;

import java.io.*;
import java.util.Scanner;

import modelo.Texto;
import persistencia.*;
import spark.*;

public class AdicionarTextoControlador implements Route {
	
	TextoDAO textos = new TextoDAO();
	
	public Object handle(Request req, Response res) throws Exception {
		String texto = req.queryParams("texto");
		Texto tx = new Texto();
		textos.save(new Texto( texto));
		res.redirect("/corrigindo/"+tx.getChave());
		return null;
	}
}
	


