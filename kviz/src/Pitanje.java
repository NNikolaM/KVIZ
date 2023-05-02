public class Pitanje {
	String pitanje;
	String[] odgovori = new String[4];
	int t; // tacan odgovor
	Pitanje(String pitanje, String odg1, String odg2, String odg3, String odg4, int t){
		this.pitanje=pitanje;
		this.odgovori[0]=odg1;
		this.odgovori[1]=odg2;
		this.odgovori[2]=odg3;
		this.odgovori[3]=odg4;
		this.t=t;
	}
	public String[] pitanje() {
		String[] s = new String[5];
		s[0] = pitanje;
		s[1] = odgovori[0];
		s[2] = odgovori[1];
		s[3] = odgovori[2];
		s[4] = odgovori[3];
		return s;
	}
	public int odgovor() {
		return t;
	}
}
