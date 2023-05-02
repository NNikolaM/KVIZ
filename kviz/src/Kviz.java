import java.rmi.RemoteException;	
public class Kviz implements KvizI{
	Pitanje[] pitanja;
	Kviz(Pitanje[] pitanja){this.pitanja=pitanja;}
	public String[] postaviPitanje(int i) throws RemoteException {
		String[] s = pitanja[i].pitanje();
		return s;
	}
	public boolean proveriOdgovor(int i, int odg) throws RemoteException {
		if(odg == pitanja[i].odgovor()) return true;
		else return false;
	}
}