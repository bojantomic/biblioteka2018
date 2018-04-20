package biblioteka.sistemskeoperacije;

import java.util.LinkedList;

import biblioteka.Knjiga;

public class SOObrisiKnjigu {
	
	public static void izvrsi(Knjiga k, LinkedList<Knjiga> knjige) {
		if (k == null || !knjige.contains(k))
			throw new RuntimeException("Knjiga je null ili ne postoji");

		knjige.remove(k);
	}

}
