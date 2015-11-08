package distance;

import java.util.ArrayList;

import dicionario.Dicionario;

public class Levenshtein {

	public static String distance(String palavra) {
		String a = palavra.toLowerCase();
		Dicionario dicionario = new Dicionario();
		String b = "";
		int contador=0;
		String[][] aproximadas = new String[3][3];
		int linhas = 0;
		int colunas = 0;

		if (dicionario.isCorrect(palavra)) {
			return null;
		} else {
			for (int t = 0; t < dicionario.size(); t++) {
				b = dicionario.next();
				int[] costs = new int[b.length() + 1];
				for (int j = 0; j < costs.length; j++)
					costs[j] = j;
				for (int i = 1; i <= a.length(); i++) {
					costs[0] = i;
					int nw = i - 1;
					for (int j = 1; j <= b.length(); j++) {
						int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),a.charAt(i - 1) == b.charAt(j - 1) ? nw: nw + 1);nw = costs[j];
						costs[j] = cj;
					}
				}
				/*if(costs[b.length()] <= 3){
	        		if(aproximadas[linhas][0] == null){
	        			System.out.println(b);
	        			System.out.println(costs[b.length()]);
	        			aproximadas[linhas][0] = costs[b.length()];
	        			aproximadas[linhas][colunas] = b;
	        			linhas++; colunas++;
	        			if(linhas == 3 && colunas == 3){ linhas=0; colunas=0;}
	        			}
	        		
	        		}*/
				/*for(int i=0; i< 3; i++){
					for(int j=0; j< 3; j++){
						if (costs[b.length()] <= 2) {
							if (aproximadas[i][0] == null) {
								System.out.println(b);
								System.out.println(costs[b.length()]);
								aproximadas[i][0] = costs[b.length()] + "";
								aproximadas[i][j] = b;
							}
						}
					}
				}*/
			}
		}

		return aproximadas[0][1]+", "+aproximadas[1][1]+", "+aproximadas[2][1]+".";
	}
}