package ws2.model.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.*;

public class XmlWriteFile {

	/**
	 * This method uses Xerces specific classes
	 * prints the XML document to file.
     */
	static void parseToFile(Document domDoc, String fileUri){

		try
		{
			//print
			OutputFormat format = new OutputFormat(domDoc);
			format.setIndenting(true);

			//to generate output to console use this serializer
			//XMLSerializer serializer = new XMLSerializer(System.out, format);


			//to generate a file output use fileoutputstream instead of system.out
			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(fileUri)), format);
			serializer.serialize(domDoc);
			
		} catch(IOException ie) {
		    ie.printStackTrace();
		}
	}
	
}
