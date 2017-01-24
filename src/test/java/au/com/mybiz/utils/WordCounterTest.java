package au.com.mybiz.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Test;

import au.com.mybiz.helper.WordCounterHelper;

public class WordCounterTest {

	@Test
	public void testFileReader() throws URISyntaxException, IOException {

		String txtFileWithPath = "C://gsnworkspace//txt//lines.txt";
		WordCounterHelper.getOrderedWordCounter(txtFileWithPath);
	}

	public void testWritingToFile() throws IOException {

		String txtFileWithPath = "C://gsnworkspace//txt//lines.txt";
		String fileNameWithPath = "C://gsnworkspace//txt//output.csv";
		Map<String, Integer> currentMap = WordCounterHelper.getOrderedWordCounter(txtFileWithPath);
		WordCounterHelper.writeOrderCountResultToCVS(10, currentMap, fileNameWithPath);
	}

}
