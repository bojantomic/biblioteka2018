package biblioteka;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Klasa koja predstavlja knjigu
 * @author Bojan Tomic
 * @version 1.0
 *
 */
public class Knjiga implements Serializable {
	
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 7226253925652679998L;

	/**
	 * 	Naslov knjige
	 */
	private String naslov;
	
	/**
	 * ISBN broj knjige odnosno identifikator
	 */
	private String isbn;
	
	/**
	 * Naziv izdavaca knjige
	 */
	private String izdavac;
	
	/**
	 * Redni broj izdanja knjige
	 */
	private int izdanje;
	
	/**
	 * Autori knjige
	 */
	private Autor[] autori;
	
	/**
	 * Vraca autore knjige
	 * @return niz sa objektima klase Autor
	 */
	public Autor[] getAutori() {
		return autori;
	}
	
	/**
	 * Postavlja autore knjige
	 * @param autori niz autora knjige
	 * @throws java.lang.RuntimeException ako je uneti
	 * niz autora null ili nema nijedan element;
	 */
	public void setAutori(Autor[] autori) {
		if (autori==null || autori.length==0)
			throw new RuntimeException("Morate uneti bar jednog autora");
		
		this.autori = autori;
	}
	
	/**
	 * Vraca naslov knjige
	 * @return naslov knjige
	 */
	public String getNaslov() {
		return naslov;
	}

	/**
	 * Postavlja naslov knjige
	 * @param naslov naslov knjige
	 * @throws java.lang.RuntimeException ako je uneti
	 * naslov null ili prazan String
	 */
	public void setNaslov(String naslov) {
		if (naslov==null || naslov.isEmpty())
			throw new RuntimeException("Morate uneti naslov");
		
		this.naslov = naslov;
	}
	
	/**
	 * Vraca ISBN knjige
	 * @return ISBN knjige kao String
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * Postavlja ISBN knjige
	 * @param isbn ISBN knjige od trinaest znakova
	 * @throws java.lang.RuntimeException ako je uneti
	 * ISBN null ili nema tacno 13 znakova
	 */
	
	public void setIsbn(String isbn) {
		if (isbn==null || isbn.length()!=13)
			throw new RuntimeException("ISBN mora imati tacno 13 znakova");
			
		this.isbn = isbn;
	}
	
	/**
	 * Vraca naziv izdavaca knjige
	 * @return naziv izdavaca knjige
	 */
	public String getIzdavac() {
		return izdavac;
	}
	/**
	 * Postavlja naziv izdavaca knjige
	 * @param izdavac naziv izdavaca knjige
	 * @throws java.lang.RuntimeException ako je uneti
	 * naziv null ili prazan String
	 */
	public void setIzdavac(String izdavac) {
		if (izdavac == null || izdavac.isEmpty())
			throw new RuntimeException("Morate uneti izdavaca");
		
		this.izdavac = izdavac;
	}
	
	
	/**
	 * Vraca redni broj izdanja knjige
	 * @return redni broj izdanja knjige
	 */
	public int getIzdanje() {
		return izdanje;
	}
	
	/**
	 * Postavlja izdanje knjige
	 * @param izdanje redni broj izdanja knjige
	 * @throws java.lang.RuntimeException ako je uneti
	 * broj izdanja nula ili manji
	 */
	public void setIzdanje(int izdanje) {
		if (izdanje <= 0)
			throw new RuntimeException("Izdanje mora biti vec od nule");
		
		this.izdanje = izdanje;
	}
	
	/**
	 * Vraca String sa svim podacima o knjizi
	 * @return String sa svim podacim o knjizi
	 */
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", izdavac=" + izdavac + ", izdanje=" + izdanje
				+ ", autori=" + Arrays.toString(autori) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	/**
	 * Proverava da li su dve knjige iste, poredi prema ISBN-u
	 * @return true ako su ISBN oznake obe knjige iste, 
	 * a false u svim ostalim situacijama
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	
}
