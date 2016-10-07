package ws2.model;

import java.util.ArrayList;
import java.util.Iterator;

import ws2.model.xml.XmlParser;

/**
 * Massive class with functions to read/write/remove members and boats
 * At the moment very disorganized
 * @author tobbe
 *
 */
public class Crud {

	// ArrayList for keeping all our members
	private ArrayList<Member> m_listOfMembers;
	private XmlParser m_XmlParser;
	
	// Constructor with file url as parameter for initiating the xmlParser.
	public Crud(String fileUri) {
		m_XmlParser = new XmlParser(fileUri);
		readMembersData();
	}
	
	// Read from XML adding scanned members to our ArrayList
	private void readMembersData() {
		m_listOfMembers = m_XmlParser.readMemberList();
	}
	
	// updates our XML "datasheet" with changes
	private void writeMembersData() {
		m_XmlParser.saveMemberList(m_listOfMembers);
	}
	
	public boolean isListEmpty() {
		return m_listOfMembers.isEmpty();
	}
	
	// Return a string of all members as a compact list
	public String listMembersCompact() {

		StringBuilder sb = new StringBuilder("Total Members: ");
		sb.append(m_listOfMembers.size() + "\n");
		
		Iterator<Member> it = m_listOfMembers.iterator();
		
		while(it.hasNext()) {
			Member m = (Member) it.next();
			
			sb.append("Name: " + m.getFullName() + ",\t Id: " + m.getMemberID() + ",\t Number of Boats: " + m.getNumberOfBoats() + "\n");
		}
		
		return sb.toString();
	}
	
	// Return a string of all members as a verbose list
	public String listMembersVerbose() {

		StringBuilder sb = new StringBuilder("Total Members: ");
		sb.append(m_listOfMembers.size() + "\n");
		
		Iterator<Member> it = m_listOfMembers.iterator();
		
		while(it.hasNext()) {
			Member m = (Member) it.next();
			
			sb.append("Name: " + m.getFullName() + "\t Personal Number: " + m.getPersonalNumber() + "\t Id: " + m.getMemberID());
			sb.append("\n\tBoats: ");
			
			// Iterate over the members boats
			for (int i = 0; i < m.getBoats().size(); i++) {
				sb.append((i + 1) + ". " + m.getBoats().get(i).getType() + ",\t" + m.getBoats().get(i).getLength() + "m \t");
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	// Return a string of a members as a verbose "list"
	public String viewMember(int id) {
		StringBuilder sb = new StringBuilder("Total Members: ");
		
		Iterator<Member> it = m_listOfMembers.iterator();
		
		while(it.hasNext()) {
			Member m = (Member) it.next();
			
			if (m.getMemberID() == id) {
				
				sb.append("Name: " + m.getFullName() + "\t Personal Number: " + m.getPersonalNumber() + "\t Id: " + m.getMemberID());
				sb.append("\n\tBoats: ");

				// Iterate over the members boats
				for (int i = 0; i < m.getBoats().size(); i++) {
					sb.append((i + 1) + ". " + m.getBoats().get(i).getType() + ",\t" + m.getBoats().get(i).getLength() + "m \t");
				}
			}
		}
		
		return sb.toString();
	}

	// int id, String name, String pNumber, ArrayList<Boat> boats
	public void createMember(String[] values) {
		m_listOfMembers.add(new Member(createId(), values[0], values[1], new ArrayList<Boat>()));
		writeMembersData();
	}
	
	// deleting member from our arraylist, id is controlled by doesMemberExist()
	public void deleteMember(int id) {

		for (int i = 0; i < m_listOfMembers.size(); i ++) {
			
			if (m_listOfMembers.get(i).getMemberID() == id) {
				m_listOfMembers.remove(i);
				i = m_listOfMembers.size() + 1;
			}
		}
		
		writeMembersData();
	}
	
	// REturns a boolean wheter member with corresponding ID exists
	public boolean doesMemberExist(int checkId) {
		Iterator<Member> it = m_listOfMembers.iterator();

		while(it.hasNext()) {
			Member m = (Member) it.next();

			if (m.getMemberID() == checkId) {
				return true;
			}
		}
		
		return false;
	}
	
	// Changes and updated a member with the ID
	public void changeMember(int id, String attribute, String change) {

		for (int i = 0; i < m_listOfMembers.size(); i ++) {

			if (m_listOfMembers.get(i).getMemberID() == id) {
				
				Member changedMember = null;
				
				switch (attribute) {
				case "name":
					changedMember = new Member(m_listOfMembers.get(i).getMemberID(), change, m_listOfMembers.get(i).getPersonalNumber(), m_listOfMembers.get(i).getBoats());
					break;
				case "pnumber":
					changedMember = new Member(m_listOfMembers.get(i).getMemberID(), m_listOfMembers.get(i).getFullName(), change, m_listOfMembers.get(i).getBoats());
					break;
				}
				
				m_listOfMembers.set(i, changedMember);
				i = m_listOfMembers.size() + 1;
			}
		}
		
		writeMembersData();
	}
	
	// Removes/changes/creates a boat
	public void changeBoat(int memId, int boatId, String attribute, String[] change) {

		for (int i = 0; i < m_listOfMembers.size(); i ++) {

			if (m_listOfMembers.get(i).getMemberID() == memId) {
				
				switch (attribute) {
				case "create":
					
					m_listOfMembers.get(i).getBoats().add(new Boat(change[0], Integer.parseInt(change[1])));
					break;
					
				case "remove":
					m_listOfMembers.get(i).getBoats().remove(boatId);
					break;
					
				case "change":
					m_listOfMembers.get(i).getBoats().set(boatId, (new Boat(change[0], Integer.parseInt(change[1]))));
					break;
				}
				
				i = m_listOfMembers.size() + 1;
			}
		}
		
		writeMembersData();
	}
	
	// Function for controlling if a member got a boat or enough boats for change/removal
	public boolean doesMemberGotBoat(int memId, int boatId) {
		Iterator<Member> it = m_listOfMembers.iterator();

		while(it.hasNext()) {
			Member m = (Member) it.next();

			if (m.getMemberID() == memId) {
				return m.getNumberOfBoats() > boatId;
			}
		}
		
		return false;
	}
	
	// Returning an uniqe member ID between 1-999
	private int createId() {
		
		int newId = 0;
		boolean sameId = true;
		
		while (sameId) {
			
			sameId = false;
			newId = (int) Math.floor(Math.random() * 999) + 1;
			Iterator<Member> it = m_listOfMembers.iterator();
			
			while(it.hasNext()) {
				Member m = (Member) it.next();
				
				if (m.getMemberID() == newId) {
					sameId = true;
					break;
				}
			}
		}
		
		return newId;
	}

}