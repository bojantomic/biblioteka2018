package biblioteka;

import java.io.Serializable;

/**
 * Klasa koja predstavlja autora knjige.
 * 
 * @author Bojan Tomic
 * @version 1.0
 *
 */
public class Autor implements Serializable {
		
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -947036814239167726L;

	/**
	 * Ime autora
	 */
	private String ime;
	
	/**
	 * Prezime autora
	 */
	private String prezime;

	
	/**
	 * Vraca vrednost atributa ime.
	 * @return ime autora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja novu vrednost za ime autora.
	 * 
	 * @param ime nova vrednost za ime autora
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet null ili prazana String za ime
	 */
	public void setIme(String ime) {
		if (ime==null || ime.isEmpty())
			throw new RuntimeException("Unesite ime");
		
		this.ime = ime;
	}

	/**
	 * Vraca vrednost atributa prezime.
	 * @return prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja novu vrednost za prezime autora.
	 * 
	 * @param prezime nova vrednost za prezime autora
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 * <ul> 
	 * 
	 * <li>null String</li>
	 * 
	 * <li>prazan String za prezime</li>
	 * 
	 * </ul>
	 */
	public void setPrezime(String prezime) {
		if (prezime==null || prezime.isEmpty())
			throw new RuntimeException("Unesite prezime");

		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	

}
