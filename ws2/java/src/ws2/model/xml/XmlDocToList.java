package ws2.model.xml;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ws2.model.Boat;
import ws2.model.Member;

public class XmlDocToList {

	public ArrayList<Member> parseDocumentToMemberList(String fileUri) {

		Document domDoc = XmlReadFile.parseXmlFile(fileUri);

		ArrayList<Member> myMembers = new ArrayList<Member>();

		// get the root element
		Element docEle = domDoc.getDocumentElement();

		// get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("Member");

		if (nl != null && nl.getLength() > 0) {

			for (int i = 0; i < nl.getLength(); i++) {

				// get the employee element
				Element el = (Element) nl.item(i);

				// get the Employee object
				Member m = getMember(el);

				// add it to list
				myMembers.add(m);
			}
		}

		return myMembers;
	}

	/**
	 * I take an member element and read the values in, create an member object
	 * and return it
	 */
	private Member getMember(Element memberEl) {

		// for each <member> element get text or int values of
		// name ,id, personalNumber, boats
		String name = getTextValue(memberEl, "Name");
		int id = getIntValue(memberEl, "Id");
		String pNumber = getTextValue(memberEl, "PersonalNumber");

		ArrayList<Boat> ownBoats = getBoatsValue(memberEl, "Boats");

		// Create a new Employee with the value read from the xml nodes
		Member m = new Member(id, name, pNumber, ownBoats);

		return m;
	}

	private ArrayList<Boat> getBoatsValue(Element ele, String tagName) {

		ArrayList<Boat> boatsVal = new ArrayList<Boat>();
		NodeList nl = ele.getElementsByTagName(tagName);

		if (nl != null && nl.getLength() > 0) {

			Element ownBoatsEl = (Element) nl.item(0);
			NodeList boatNl = ownBoatsEl.getElementsByTagName("Boat");

			for (int i = 0; i < boatNl.getLength(); i++) {

				Element boatEl = (Element) boatNl.item(i);

				String type = getTextValue(boatEl, "Type");
				int length = getIntValue(boatEl, "Length");

				boatsVal.add(new Boat(type, length));
			}
		}

		return boatsVal;
	}

	private String getTextValue(Element ele, String tagName) {

		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);

		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	/**
	 * Calls getTextValue and returns a int value
	 */
	private int getIntValue(Element ele, String tagName) {

		return Integer.parseInt(getTextValue(ele, tagName));
	}

}
