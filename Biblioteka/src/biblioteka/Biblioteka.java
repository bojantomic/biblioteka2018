package biblioteka;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

/**
 * Klasa koja predstavlja Biblioteku sa nekim osnovnim funkcionalnostima.
 * @author Bojan Tomic
 * @version 1.0
 *
 */
public class Biblioteka implements BibliotekaInterfejs{

	/**
	 * Lista knjiga dostupnih u biblioteci
	 */
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	/**
	 * Dodaje novu knjigu u ponudu biblioteke
	 * @param k nova knjiga koja se dodaje u biblioteku
	 * @throws java.lang.RuntimeException ako je uneta knjiga null ili se vec
	 * nalazi u biblioteci ista takva
	 */
	@Override
	public void dodajKnjigu(Knjiga k) {
		if (k == null || knjige.contains(k))
			throw new RuntimeException("Knjiga je null ili vec postoji");
		
		knjige.add(k);		
	}

	/**
	 * Brise knjigu iz ponude biblioteke
	 * @param k knjiga koju je potrebno obrisati
	 * @throws java.lang.RuntimeException ako je uneta knjiga null ili se ne
	 * moze naci u biblioteci
	 */
	@Override
	public void obrisiKnjigu(Knjiga k) {
		if (k == null || !knjige.contains(k))
			throw new RuntimeException("Knjiga je null ili ne postoji");

		knjige.remove(k);
	}

	/**
	 * Vraca celokupnu ponudu knjiga iz biblioteke
	 * @return lista svih knjiga iz biblioteke
	 */
	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

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
	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (naslov == null && autor==null && isbn==null && izdavac==null)
			throw new RuntimeException("Morate uneti bar neki parametar");

		LinkedList<Knjiga> novaLista = new LinkedList<Knjiga>();
		
		for (int i=0;i<knjige.size();i++)
			if (knjige.get(i).getNaslov().contains(naslov))
				novaLista.add(knjige.get(i));
		
		return novaLista;
	}

	/**
	 * Deserijalizuje (ucitava) sve knjige iz fajla i unosi ih u biblioteku.
	 * 
	 * Pre ucitavanja se brise postojeci sadrzaj biblioteke.
	 * 
	 * @param fajl putanja do fajla sa serijalizovanim knjigama.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void ucitajKnjige(String fajl) {
		try(ObjectInputStream in = 
			 new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(fajl)))){
		
			knjige = (LinkedList<Knjiga>)(in.readObject());
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Serijalizuje (cuva) sve knjige iz biblioteke u fajl.
	 * 
	 * @param fajl putanja do fajla u koji treba sacuvati (serijalizovati) knjige.
	 */
	@Override
	public void sacuvajKnjige(String fajl){
		try(ObjectOutputStream out = 
				 new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fajl)))){
			
				out.writeObject(knjige);
			}
			catch(Exception e) {
				throw new RuntimeException(e);
			}
	}
	
	

}
