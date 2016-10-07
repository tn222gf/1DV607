package ws2.model.xml;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ws2.model.Boat;
import ws2.model.Member;

public class XmlListToDoc {

	private Document domDoc;
	
	public void parseMemberListToDocument(ArrayList<Member> memList, String fileUri) {
		
		//get an instance of factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//get an instance of builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//create an instance of DOM
			domDoc = db.newDocument();
			
			createDOMTree(memList);
			XmlWriteFile.parseToFile(domDoc, fileUri);

		} catch (ParserConfigurationException pce) {
			//dump it
			System.out.println("Error while trying to instantiate DocumentBuilder " + pce);
			System.exit(1);
		}
		
	}
	
	/**
	 * The real workhorse which creates the XML structure
	 */
	private void createDOMTree(ArrayList<Member> memList){

		//create the root element 

		Element rootEle = domDoc.createElement("Members");
		domDoc.appendChild(rootEle);

		//No enhanced for
		Iterator<Member> it  = memList.iterator();
		
		while(it.hasNext()) {
			
			Member m = (Member) it.next();
			
			//For each Member object create element and attach it to root
			Element memberEle = createMemberElement(m);
			rootEle.appendChild(memberEle);
		}
	}
	
	/**
	 * Helper method which creates a XML element 

	 * @param m The Member for which we need to create an xml representation
	 * @return XML element snippet representing a member
	 */
	private Element createMemberElement(Member m){

		Element memberEle = domDoc.createElement("Member");

		//create id element and id text node and attach it to memberElement
		Element idEle = domDoc.createElement("Id");
		Text idText = domDoc.createTextNode("" + m.getMemberID());
		idEle.appendChild(idText);
		memberEle.appendChild(idEle);

		//create name element and name text node and attach it to memberElement
		Element nameEle = domDoc.createElement("Name");
		Text nameText = domDoc.createTextNode(m.getFullName());
		nameEle.appendChild(nameText);
		memberEle.appendChild(nameEle);

		//create personalnumber element and personal number text node and attach it to memberElement
		Element pNumbEle = domDoc.createElement("PersonalNumber");
		Text pNumbText = domDoc.createTextNode(m.getPersonalNumber());
		pNumbEle.appendChild(pNumbText);
		memberEle.appendChild(pNumbEle);

		// Adding boats
		Element ownBoatsEle = domDoc.createElement("Boats");

		Iterator<Boat> it  = m.getBoats().iterator();

		while(it.hasNext()) {

			Boat b = (Boat) it.next();

			Element boatEle = domDoc.createElement("Boat");
			Element typeEle = domDoc.createElement("Type");
			Element lengthEle = domDoc.createElement("Length");
			
			Text typeText = domDoc.createTextNode(b.getType());
			Text lengthText = domDoc.createTextNode("" + b.getLength());
			
			typeEle.appendChild(typeText);
			lengthEle.appendChild(lengthText);
			
			boatEle.appendChild(typeEle);
			boatEle.appendChild(lengthEle);
			
			ownBoatsEle.appendChild(boatEle);
		}
		
		memberEle.appendChild(ownBoatsEle);
		
		return memberEle;
	}
	
}
