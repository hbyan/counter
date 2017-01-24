package au.com.mybiz.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounterHelper {
	
	public static void writeOrderCountResultToCVS(int number, Map<String, Integer> currentMap, String fileNameWithPath) {
		
		try {
			Path path = Paths.get(fileNameWithPath);
			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
				int lineToWrite = 1;
				for (Map.Entry<String, Integer> entry : currentMap.entrySet()) {
					if(lineToWrite == number){
						break;
					}
					String key = entry.getKey();
					Integer value = entry.getValue();
					writer.write(key + "," + value);
					writer.newLine();
					lineToWrite++;
				}
			}
			
		} catch (IOException e) {
			
		}
	}
	
	public static Map<String, Integer> getOrderedWordCounter(String fileName) throws IOException {
		
		Map<String, Integer> counterMap = new HashMap<String,Integer>();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()){
				String line = scanner.nextLine();
				populateWordCountMap(counterMap, line );
			}
			scanner.close();

		} catch (IOException e) {
			throw e;
		}
		
		Map<String, Integer> result = new LinkedHashMap<>();
		counterMap.entrySet().stream()
               .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
               .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		
		return result;
		
	}
	
	private static void populateWordCountMap(Map<String,Integer> currentMap, String line ){
		if(line == null || line.trim().equals("")){
			return;
		}
		String[] arr = line.split("[^a-zA-Z]+");
		for(int i = 0; i < arr.length; i += 1)
		{
		     String word = arr[i];
		     if(word==null || word.trim().length()==0){
		    	 continue;
		     }
		     if(currentMap.containsKey(word)){
		    	 Integer value = currentMap.get(word);
		    	 Integer newValue = value.intValue()+1;
		    	 currentMap.remove(word);
		    	 currentMap.put(word, newValue);
		     }
		     else{
		    	 currentMap.put(word, new Integer(1));
		     }
		}
		
	}

}
