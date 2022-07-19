import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLRead {
	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
		Document xml = null;
		try {
			xml = builder.build(new File("newFile.xml"));

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = xml.getRootElement();
		System.out.println("Root element of XML document is : " + root.getName());
		System.out.println("Number of books in this XML : " + root.getChildren().size());
	    List<Element> books = root.getChildren();
	    Iterator booksItr=books.iterator();
	    while(booksItr.hasNext()) {
	    	Element book=(Element) booksItr.next();
	    	//System.out.println( book.getName());
	    	System.out.println( book.getAttributeValue("id"));
	    	System.out.println(book.getChildText("author"));
	    }

		
	}

}
