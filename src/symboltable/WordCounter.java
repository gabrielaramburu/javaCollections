package symboltable;
import java.io.*;
import java.util.*;

public class WordCounter{
	public static void main(String[] args) throws IOException {
		Map<String, Integer> counter = new HashMap<String, Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while (line != null) {
			for (String word: line.split(" ")) {
				if (counter.containsKey(word)) {
					counter.put(word, counter.get(word) + 1);
				} else {
					counter.put(word, 1);
				}
			}
			line = br.readLine();
		}

		for (String key: counter.keySet()) {
			System.out.format("%20s %d \n", key, counter.get(key));
		}
	}
}