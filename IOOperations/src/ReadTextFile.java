import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReadTextFile {
	public static void main(String[] args) {
		List<String> lines = Collections.emptyList();
		try {
			Path currentRelativePath = Paths.get("");
			String currentPath = currentRelativePath.toAbsolutePath().toString();
			System.out.println(currentPath + "/ReadTextFileFolder/read.txt" + " : current path of file");
			lines = Files.readAllLines(Paths.get(currentPath +"/ReadTextFileFolder/read.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i=0;
		while(lines.size() > i) {
			  System.out.println(lines.get(i)+ "lines from file");
			  i++;
			
		}
    
	}

}
