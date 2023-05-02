import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Server {
    public static void main(String[] args) throws RemoteException {
    	Pitanje p1 = new Pitanje("Apstraktna klasa je klasa...",
    							"...koja nema instance",
    							"...koja nema polja",
    							"...cije su sve metoda static",
    							"...cije su sve metode final",
    							1);
    	Pitanje p2 = new Pitanje("Kada potklasa nasledi polja i metode superklase to se naziva:",
								"nasledjivanje implementacije",
								"nasledjivanje tipa",
								"polimorfizam",
								"agregacija",
								1);
    	Pitanje p3 = new Pitanje("Kako se nasledjuje interfejs?",
    							"Interfejs se nasledjuje koriscenjem kljucne reci extends",
    							"Interfejs se nasledjuje koriscenjem kljucne reci implements",
    							"Interfejs se nasledjuje koriscenjem kljucne reci throws",
    							"Interfejs se ne moze naslediti",
    							1);
    	Pitanje[] p = {p1,p2,p3};
        Kviz kviz = new Kviz(p);
        KvizI stub = (KvizI) UnicastRemoteObject.exportObject(kviz,0);
        Registry reg = LocateRegistry.getRegistry();
        reg.rebind("kviz", stub);
    } 
}