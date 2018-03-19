package biblioteka.interfejs;

import java.util.LinkedList;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterfejs {
	
	/**
	 * Dodaje novu knjigu u ponudu biblioteke
	 * @param k nova knjiga koja se dodaje u biblioteku
	 * @throws java.lang.RuntimeException ako je uneta knjiga null ili se vec
	 * nalazi u biblioteci ista takva
	 */
	public void dodajKnjigu(Knjiga k);
	
	/**
	 * Brise knjigu iz ponude biblioteke
	 * @param k knjiga koju je potrebno obrisati
	 * @throws java.lang.RuntimeException ako je uneta knjiga null ili se ne
	 * moze naci u biblioteci
	 */
	public void obrisiKnjigu (Knjiga k);
	
	/**
	 * Vraca celokupnu ponudu knjiga iz biblioteke
	 * @return lista svih knjiga iz biblioteke
	 */
	public LinkedList<Knjiga> vratiSveKnjige();
	
	/**
	 * Pronalazi i vraca listu sa svim knjigama iz biblioteke koji odgovaraju upitu.
	 * 
	 * Nem oraju se uneti svi parametri, oni koji budu null se ne uzimaju u razmatranje prilikom pretrage
	 * 
	 * @param autor autor knjige
	 * @param isbn isbn knjige
	 * @param naslov DEO naslova knjige ili ceo naslov knjige
	 * @param izdavac DEO naziva izdavaca ili ceo naziv
	 * 
	 * @return lista sa knjigam koje odgovaraju upitu
	 * 
	 * @throws java.lang.RuntimeException ako su svi parametri null
	 */
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov,
			String izdavac);
	

}
