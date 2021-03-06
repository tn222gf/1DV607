package ws2.model;

public class Boat {

	private String m_type;
	private int m_length;
	
	public Boat(String bType, int bLength) {
		m_type = bType;
		m_length = bLength;
	}
	
	public String getType() {
		return m_type;
	}
	
	public int getLength() {
		return m_length;
	}
	
	public String toString() {
		return "Type: " + m_type + ", Length: " + m_length;
	}
}
