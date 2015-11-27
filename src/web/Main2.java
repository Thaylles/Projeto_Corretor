package web;

import java.applet.*;
import java.io.File;
import java.net.*;
import java.util.regex.Pattern;

import concatenateWAV.ConcatenateWAV;
import distance.Levenshtein;

public class Main2 {

	public static void main(String[] args) throws InterruptedException {

		String palavra = "instansia";
		palavra = Levenshtein.distance(palavra);
		if (palavra != null) {
			String[] t = palavra.split(Pattern.quote(" "));

			for (int i = 0; i < t.length; i++) {
				System.out.println(t[i]);
				ConcatenateWAV.soletrar(t[i]);
				;
				/*
				 * try { File file = new File ("Palavras/"+t[i]+".wav");
				 * AudioClip clip = Applet.newAudioClip((file).toURL);
				 * System.out.println(file.exists()); clip.play();
				 * Thread.sleep(10000); } catch (MalformedURLException murle) {
				 * System.out.println(murle); }
				 */
			}
		}
	}
}
