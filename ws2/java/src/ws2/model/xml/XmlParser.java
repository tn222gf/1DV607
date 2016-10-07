package ws2.model.xml;

import java.util.ArrayList;

import ws2.model.Member;

/**
 * Allows the program to parse XML to arrayList with Members
 * And parse ArrayList with Members to XML
 * @author tn222gf
 *
 */
public class XmlParser {
		
	private String fUri;
	
	public XmlParser(String fileUri) {
		fUri = fileUri;
	}
	
	public void saveMemberList(ArrayList<Member> memList) {
		
		XmlListToDoc save = new XmlListToDoc();
		
		save.parseMemberListToDocument(memList, fUri);
	}
	
	public ArrayList<Member> readMemberList() {
		
		XmlDocToList open = new XmlDocToList();
		
		return open.parseDocumentToMemberList(fUri);
	}
	
}
