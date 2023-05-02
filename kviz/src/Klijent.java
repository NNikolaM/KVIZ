import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class Klijent  {
    public static void main(String s[]){
			try {
				new Igrac();
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
    }     
}
