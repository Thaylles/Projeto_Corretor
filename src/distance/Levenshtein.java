package distance;

import java.util.ArrayList;

import dicionario.Dicionario;

public class Levenshtein {

	public static int distance(String palavra) {
		String a = palavra.toLowerCase();
		Dicionario dicionario = new Dicionario();
		Object[][] aproximadas = new Object[2][1];
		String b = "";
		if (dicionario.isCorrect(palavra)) {
			return 0;
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
			}
		}

	return 0;	
	}
}