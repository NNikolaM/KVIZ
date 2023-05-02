import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Igrac extends Thread {
	IgracGUI igrac;
	Registry registar;
	KvizI skelton;
	
	String[] pitanje = new String[5];
	int bodovi=0;
	int akcija=0;
	boolean odgovor;
	
	Igrac() throws RemoteException, NotBoundException{
		igrac = new IgracGUI();
		registar = LocateRegistry.getRegistry("localhost");
        skelton = (KvizI) registar.lookup("kviz");
        this.start();
	}
	public void igra() throws RemoteException {
		pitanje = skelton.postaviPitanje(0);
		igrac.setNiz(pitanje);
		igrac.registracija();
		igrac.potvrdiRegistraciju();
		potvrdiOdgovor();
	}
	public void potvrdiOdgovor() {
		igrac.getButton2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				akcija++;
				try {
					odgovor = skelton.proveriOdgovor(akcija-1, igrac.getList().getSelectedIndex()+1);
					proveriOdgovor(odgovor);
					pitanje = skelton.postaviPitanje(akcija);
					igrac.getLabel().setText(pitanje[0]);
					String[] odgovori = {pitanje[1],pitanje[2],pitanje[3],pitanje[4]};
					igrac.getList().setListData(odgovori);
				} catch (RemoteException | ArrayIndexOutOfBoundsException e1) {
					igrac.getList().setVisible(false);
					igrac.getButton2().setVisible(false);
					igrac.getLabel().setText("BROJ BODOVA: "+bodovi);
				}
				
			}
		});
	}
	
	public void proveriOdgovor(boolean odgovor) {
		if(odgovor == true) bodovi=bodovi+10;
	}
	
	public void run() {
			try {
				igra();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	}
}
