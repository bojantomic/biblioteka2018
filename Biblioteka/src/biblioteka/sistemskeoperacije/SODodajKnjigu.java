package biblioteka.sistemskeoperacije;

import java.util.LinkedList;

import biblioteka.Knjiga;

public class SODodajKnjigu {

	public static void izvrsi(Knjiga k, LinkedList<Knjiga> knjige) {
		if (k == null || knjige.contains(k))
			throw new RuntimeException("Knjiga je null ili vec postoji");
		
		knjige.add(k);		
	}
	
}
