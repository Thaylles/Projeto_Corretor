package modelo;

import java.util.*;
import java.io.*;

import distance.*;
import persistencia.TextoDAO;

public class Erro {
	protected ArrayList erros = new ArrayList();
	public Erro(){
		
	}
	public ArrayList contaErros(int parametro) throws Exception{
		TextoDAO dao = new TextoDAO();
		Texto tx = new Texto();
	 	tx = dao.load(parametro);
		File arq = new File("src/apresentacao/Textos/" + parametro + ".csv");
		
		Scanner scan = new Scanner(arq);
		String linha = scan.nextLine();
		String[] colunas = linha.split(" ");
		scan.close();
		for(int i = 0; i<colunas.length;i++){
			if(Levenshtein.distance(colunas[i]) != null){
				if(i!=colunas.length-1){//teste para rejeitar a chave presente nas colunas
					erros.add(colunas[i]);
				}else{
				colunas[i] = colunas[i].substring(0,colunas[i].length()-3);
				erros.add(colunas[i]);
				}
			}
		}
			
		
		return erros;
	}

	public ArrayList getErros() {
		return erros;
	}
		
}
