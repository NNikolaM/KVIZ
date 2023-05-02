import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IgracGUI {
	String ime = "IGRAC";
	String[] niz;
	
	public void setNiz(String[] niz) {
		this.niz=niz;
	}
	
	public JButton getButton2() {
		return this.button2;
	}
	
	public JList<String> getList() {
		return this.list;
	}
	public JLabel getLabel() {
		return label;
	}
	public void registracija() {
		frame.setTitle("KVIZ");

		panel.add(label);
		panel.add(text);
		panel.add(button1);
		
		label.setText("Unesite ime:");
		label.setBounds(30, 70, 350, 30);
		text.setText(ime);
		text.setBounds(30, 110, 350, 20);
		text.setColumns(10);
		button1.setText("POKRENI IGRU");
		button1.setBounds(30, 155, 150, 25);
	}
	
	public void potvrdiRegistraciju() {
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ime = text.getText();
				kviz();
			}
		});
	}

	public void kviz() {
		frame.setTitle(ime);
		
		text.setVisible(false);
		button1.setVisible(false);
		panel.remove(text);
		panel.remove(button1);
		frame.add(list);
		panel.add(button2);
		
		label.setText(niz[0]);
		label.setBounds(40, 40, 350, 25);
		
		String[] s = {niz[1],niz[2],niz[3],niz[4]};
		list.setBounds(40, 90, 350, 80);
		list.setListData(s);
		
		button2.setBounds(40, 200, 100, 20);
		button2.setText("POTVRDI");
	}
	
	private JFrame frame;
	private JPanel panel;
	private JLabel label = new JLabel();
	private JTextField text = new JTextField();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JList<String> list = new JList<String>();
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		frame.setContentPane(panel);
		panel.setLayout(null);
	}
}