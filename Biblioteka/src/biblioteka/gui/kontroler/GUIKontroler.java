package biblioteka.gui.kontroler;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import biblioteka.Autor;
import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.gui.DodajKnjiguProzor;
import biblioteka.gui.GlavniProzor;
import biblioteka.gui.ObrisiKnjiguProzor;
import biblioteka.gui.PronadjiKnjiguProzor;
import biblioteka.interfejs.BibliotekaInterfejs;

public class GUIKontroler {
	
	public static BibliotekaInterfejs biblioteka =
			new Biblioteka();
	
	public static GlavniProzor gp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler.gp = new GlavniProzor();
					GUIKontroler.gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void sacuvaj() {
		JFileChooser fc = new JFileChooser();
		
		int opcija = fc.showSaveDialog(null);
		
		if (opcija == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			
			try {
				biblioteka.sacuvajKnjige(f.getAbsolutePath());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(gp, 
						e.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void ucitaj() {
		JFileChooser fc = new JFileChooser();
		
		int opcija = fc.showOpenDialog(null);
		
		if (opcija == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			
			try {
				biblioteka.ucitajKnjige(f.getAbsolutePath());
				
				gp.prikaziSveKnjige( biblioteka.vratiSveKnjige());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(gp, 
						e.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void prikaziDodajKnjiguProzor() {
		DodajKnjiguProzor dkp = 
				new DodajKnjiguProzor();
		
		dkp.setLocationRelativeTo(gp);
		dkp.setVisible(true);
	}
	
	public static void prikaziObrisiKnjiguProzor(Knjiga k){
		ObrisiKnjiguProzor okp = new ObrisiKnjiguProzor(k);
		
		okp.setLocationRelativeTo(gp);
		okp.setVisible(true);
	}
	
	public static void prikaziPronadjiKnjiguProzor(){
		PronadjiKnjiguProzor pkp = new PronadjiKnjiguProzor();
		
		pkp.setLocationRelativeTo(gp);
		pkp.setVisible(true);
	}
	
	public static void dodaj(String naslov, String isbn, String izdavac,
			int izdanje, String autor1Ime, String autor1Prezime,
			String autor2Ime, String autor2Prezime) {
		try {
			Knjiga k = new Knjiga();

			k.setIsbn(isbn);
			k.setNaslov(naslov);
			k.setIzdavac(izdavac);
			k.setIzdanje(izdanje);

			Autor a1 = new Autor();
			a1.setIme(autor1Ime);
			a1.setPrezime(autor1Prezime);

			Autor[] niz;

			if (!autor2Ime.isEmpty() || !autor2Prezime.isEmpty()) {

				Autor a2 = new Autor();
				a2.setIme(autor2Ime);
				a2.setPrezime(autor2Prezime);

				niz = new Autor[2];
				niz[0] = a1;
				niz[1] = a2;
			} else {
				niz = new Autor[1];
				niz[0] = a1;
			}
			k.setAutori(niz);

			biblioteka.dodajKnjigu(k);

			gp.prikaziSveKnjige( biblioteka.vratiSveKnjige() );

			} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void obrisi(Knjiga k) {
		try {
			biblioteka.obrisiKnjigu(k);

			gp.prikaziSveKnjige(biblioteka.vratiSveKnjige());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static LinkedList<Knjiga> pronadjiKnjige(String naslov) {
		try {
			return biblioteka.pronadjiKnjigu(null, null, naslov, null);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
}
