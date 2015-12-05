package controlador;

import java.io.File;
import java.util.ArrayList;
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
	@Override
	public ModelAndView handle(Request req, Response resp) {
		try {
			int parametro = Integer.parseInt(req.params("numero"));
			palavras = erros.contaErros(parametro);
			System.out.println(palavras.toString());
		/*	tx = new Texto();
			 tx = dao.load(Integer.parseInt(req.params("numero")));
				File arq = new File("src/apresentacao/Textos/" + Integer.parseInt(req.params("numero")) + ".csv");
				if (!arq.exists()) return null;
				
				Scanner scan = new Scanner(arq);
				String linha = scan.nextLine();
				String[] colunas = linha.split(" ");
				scan.close();
				
				for(int i = 0; i<colunas.length;i++){
					System.out.println(colunas[i]);
				}
				
			*/
			 
				
				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView(null,"corrigindo.html");
	}

}
