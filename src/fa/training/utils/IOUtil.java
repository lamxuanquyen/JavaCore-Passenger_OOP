package fa.training.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class IOUtil {

	public static List<String> readDataInFile(String pathFile) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		List<String> lineDataList = new ArrayList<>();
		try {
			fr = new FileReader(pathFile);
			br = new BufferedReader(fr);
			String line = "";
			br.readLine();//giải thích dòng này
			while ((line = br.readLine()) != null) {
				lineDataList.add(line);
			}
		} finally {
			if (br != null) {
				br.close();
			}
			if (fr != null) {
				fr.close();
			}
		}
		
		return lineDataList;
	}
	
	public static void writeFile(String path, String str) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(path, true);
			
			writer.write( str+ "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
