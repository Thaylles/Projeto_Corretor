package distance;

import java.util.ArrayList;

import dicionario.Dicionario;

public class Levenshtein {

	public static Object distance(String palavra) {
		String a = palavra.toLowerCase();
		Dicionario dicionario = new Dicionario();
		Object[][] aproximadas = new Object[3][3];
		String b = "";
		int linhas=0;
		int colunas=0;
		
		if (dicionario.isCorrect(palavra)) {
			return aproximadas;
		} else {
			for (int t = 0; t < dicionario.size(); t++) {
				b = dicionario.next();
				int [] costs = new int [b.length() + 1];
			        for (int j = 0; j < costs.length; j++)
			            costs[j] = j;
			        for (int i = 1; i <= a.length(); i++) {
			            // j == 0; nw = lev(i - 1, j)
			            costs[0] = i;
			            int nw = i - 1;
			            for (int j = 1; j <= b.length(); j++) {
			                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
			                nw = costs[j];
			                costs[j] = cj;
					}
				}
			        if(costs[b.length()] <= 3){
			        		if(aproximadas[linhas][0] == null){
			        			System.out.println(b);
			        			System.out.println(costs[b.length()]);
			        			aproximadas[linhas][0] = costs[b.length()];
			        			aproximadas[linhas][colunas] = b;
			        			linhas++; colunas++;
			        			if(linhas == 3 && colunas == 3){ linhas=0; colunas=0;}
			        			}
			        		
			        		}
			        	}
			        }

	return aproximadas;	
	}
}