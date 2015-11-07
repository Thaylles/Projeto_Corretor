package distance;

public class Main {

	public static void main(String[] args) {
		
		String palavra = "ander";
		Object [][] ue = new Object [2][2];
		
		System.out.println(Levenshtein.distance(palavra));
	}

}
