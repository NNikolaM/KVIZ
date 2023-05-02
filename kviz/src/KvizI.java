import java.rmi.Remote;
import java.rmi.RemoteException;
public interface KvizI extends Remote {
	public String[] postaviPitanje(int i) throws RemoteException;
	public boolean proveriOdgovor(int i, int odg) throws RemoteException;
}
