package concatenateWAV;

import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class ConcatenateWAV {
	
	public static void soletrar(String palavra) {
		char [] letras = palavra.toCharArray();
		
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int index = 0; index < letras.length; index++) {
			switch (letras[index]) {      
	        	case 'á': temp.add("a");temp.add("´");break;
	        	case 'à': temp.add("a");temp.add("`");break;
	        	case 'ã': temp.add("a");temp.add("~");break;
	        	case 'â': temp.add("a");temp.add("^");break;
	        	case 'é': temp.add("e");temp.add("´");break;
	        	case 'ê': temp.add("e");temp.add("^");break;
	        	case 'í': temp.add("i");temp.add("´");break;
	        	case 'ó': temp.add("o");temp.add("´");break; 
	        	case 'õ': temp.add("o");temp.add("~");break;
	        	case 'ô': temp.add("o");temp.add("^");break;
	        	case 'ú': temp.add("u");temp.add("´");break;  
	        	case 'ç': temp.add("c");temp.add("ç");break;
	        	default: temp.add(letras[index] + "");
			}
		}

		AudioInputStream audio = null;
		
		if(temp.size() != 0) {
			for(int index = 1; index < temp.size(); index++) {
				if(index == 1){
					try {
						audio = AudioSystem.getAudioInputStream(new File("D:\\Projeto_Corretor\\src\\concatenateWAV\\Audios\\" + temp.get(0) + ".wav"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
				String dir = "D:\\Projeto_Corretor\\src\\concatenateWAV\\Audios\\" + temp.get(index) + ".wav";
				audio = concatenate(audio, dir);
			}
		} else {
			for(int index = 1; index < letras.length; index++) {
				if(index == 1){
					try {
						audio = AudioSystem.getAudioInputStream(new File("D:\\Projeto_Corretor\\src\\concatenateWAV\\Audios\\" + letras[0] + ".wav"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
				String dir = "D:\\Projeto_Corretor\\src\\concatenateWAV\\Audios\\" + letras[index] + ".wav";
				audio = concatenate(audio, dir);
			}
		}
		
		try {
			File dir = new File("D:\\Projeto_Corretor\\src\\concatenateWAV\\Palavras");
			if(dir.length() == 12)
				if(dir.delete())
					dir.mkdir();
			AudioSystem.write(audio, AudioFileFormat.Type.WAVE, new File("D:\\Projeto_Corretor\\src\\concatenateWAV\\Palavras\\"+ palavra +".wav"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    private static AudioInputStream concatenate(AudioInputStream wav1, String wavFile2) {
    	AudioInputStream appendedFiles = null;
	    try {
		    AudioInputStream wav2 = AudioSystem.getAudioInputStream(new File(wavFile2));

		    appendedFiles = new AudioInputStream(new SequenceInputStream(wav1, wav2), 
		    		wav1.getFormat(), wav1.getFrameLength() + wav2.getFrameLength());
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
	    return appendedFiles;
    }
}
