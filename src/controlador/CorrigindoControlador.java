package controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import distance.Levenshtein;
import modelo.Erro;
import modelo.Palavras;
import modelo.Texto;
import persistencia.TextoDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CorrigindoControlador implements TemplateViewRoute {
	TextoDAO dao = new TextoDAO();
	Erro erros = new Erro();
	ArrayList palavras = new ArrayList(); 
	int i = 0;
	@Override
	public ModelAndView handle(Request req, Response resp) {
		try {
			if(i == 0){
			int parametro = Integer.parseInt(req.params("numero"));
			palavras = erros.contaErros(parametro);
			}
			System.out.println(palavras.toString());
			HashMap dados = new HashMap();
			
			dados.put("erro1", erros.get(i));//
			dados.put("erro2", erros.get(i+1));//1
			dados.put("erro3", erros.get(i+2));//2
			System.out.println(dados.toString());
			if(erros.get(i+=4)!= null){
			i+=4;
			}else{
				if(erros.get(i+=3)!= null){
					i+=3;
				}else{
					if(erros.get(i+=2)!=null)i+=2;
				}
			}
			return new ModelAndView(dados, "corrigindo.html");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView(null,"/home");
	}

}
