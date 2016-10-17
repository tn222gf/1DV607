package ws2.model;

import java.util.ArrayList;

public class Member {

	private int m_ID;
	private String m_fullName;
	private String m_personalNumber;
	private ArrayList<Boat> m_ownBoats;
	
	public Member(int id, String name, String pNumber, ArrayList<Boat> boats) {
		m_ID = id;
		m_fullName = name;
		m_personalNumber = pNumber;
		m_ownBoats = boats;
	}
	
	public Member(int id, String name, String pNumber) {
		m_ID = id;
		m_fullName = name;
		m_personalNumber = pNumber;
		m_ownBoats = new ArrayList<Boat>();
	}
	
	public int getMemberID() {
		return m_ID;
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
	
	public void createBoat(String bType, int bLength) {
		m_ownBoats.add(new Boat(bType, bLength));
	}
	
	public void removeBoat(int index) {
		m_ownBoats.remove(index);
	}
	
	public void changeBoat(int index, String bType, int bLength) {
		m_ownBoats.set(index, new Boat(bType, bLength));
	}
}
