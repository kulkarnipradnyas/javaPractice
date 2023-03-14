package completetableFeatureExample;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReaderWriter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileOutputStream outputStream = null;
		try {
		
			System.out.println("Enter path of directory to create");
			String dir = sc.nextLine();
			File directory = new File(dir);
			if (directory.exists()) {
				System.out.println("Read File");
			} else {
				// create directory
				directory.mkdir();
			}
			System.out.println("Enter file name to be created ");
			String fileName = sc.nextLine();
			System.out.println("Dire Absolute Path: " + directory.getAbsoluteFile());
			File file = new File(directory.getAbsoluteFile() + "/" + fileName);
			if (file.exists()) {
				System.out.println("Read File Content: ");
				FileReader fr;

				fr = new FileReader(file);
			     int i;    
		          while((i=fr.read())!=-1)    
		          System.out.print((char)i);    
				//System.out.println("Content 943786: " + fr.read());
			} else {
				//

				file.createNewFile();

				file.canRead();
				file.canWrite();
				System.out.println(directory.getAbsoluteFile() + "/" + fileName +"directory.getPath() + \"/\" + fileName");
				String content="I am new file and save my content *************";
				FileWriter fw = new FileWriter(directory.getAbsoluteFile() + "/" + fileName);
				fw.write(content);
				fw.flush();
				fw.close();
				// add path to write
				Path pathToFile = Paths.get(directory.getPath() + "/" + fileName);
				//Files.write( pathToFile, content.getBytes());
				FileReader fr = new FileReader(file);
				System.out.println("FW: " + fr.read());
				System.out.println("Path: " + file.getPath());
				fr.close();

			}
			// close Scanner to prevent resource leak
			sc.close();
		} catch (IOException e) {
			sc.close();
			
			System.out.println("Close");
			
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	}

}
