package examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.swing.JOptionPane;

public class WordCounter {

	public static void main(String[] args) {
		
		String text = JOptionPane.showInputDialog( "Ingresa el texto", "Texto de ejemplo con cero repeticiones");
		
		String[] words = text.split(" ");
		Map<String, Integer> myMap = new HashMap<>();
		
		Arrays.asList(words).stream()
			.map(Normalizer::normalize)
			.forEach(word -> {
				Integer count = myMap.get(word);
				if (Objects.nonNull(count)) {
					myMap.put(word, count + 1);
				} else {
					myMap.put(word, 1);
				}
			});
		
		System.out.println(myMap);
	}
	
	public static class Normalizer {
		public static String normalize(String word) {
			return word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		}
	}

}