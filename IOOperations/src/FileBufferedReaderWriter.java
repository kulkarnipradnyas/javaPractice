import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBufferedReaderWriter {
	public static void main(String[] args) {
		Path currentRelativePath = Paths.get("");
		String currentPath = currentRelativePath.toAbsolutePath().toString();
		System.out.println(currentPath + "/ReadTextFileFolder/read.txt" + " : current path of file");
		FileWriter writer;
		try {
			writer = new FileWriter(currentPath + "/ReadTextFileFolder/read.txt");
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write("Welcome to javaTpoint.");
			buffer.close();
			System.out.println("Success");
			FileReader read=new FileReader(currentPath + "/ReadTextFileFolder/read.txt");
			BufferedReader bufferReader = new BufferedReader(read);
			 int i;    
			 while(( i=bufferReader.read())!=-1){  
		          System.out.print((char)i);  
		          }  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
