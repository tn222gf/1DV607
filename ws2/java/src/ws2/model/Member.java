package ws2.model;

import java.util.ArrayList;

public class Member {

	private int m_memberID;
	private String m_fullName;
	private String m_personalNumber;
	private ArrayList<Boat> m_ownBoats;
	
	public Member(int id, String name, String pNumber, ArrayList<Boat> boats) {
	
		m_memberID = id;
		m_fullName = name;
		m_personalNumber = pNumber;
		m_ownBoats = boats;
	}
	
	public int getMemberID() {
		return m_memberID;
	}
	
	public String getFullName() {
		return m_fullName;
	}
	
	public String getPersonalNumber() {
		return m_personalNumber;
	}
	
	public ArrayList<Boat> getBoats() {
		return m_ownBoats;
	}
	
	public int getNumberOfBoats() {
		return m_ownBoats.size();
	}
}
