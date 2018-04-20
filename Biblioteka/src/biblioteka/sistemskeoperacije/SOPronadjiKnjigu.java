package biblioteka.sistemskeoperacije;

import java.util.LinkedList;

import biblioteka.Autor;
import biblioteka.Knjiga;

public class SOPronadjiKnjigu {
	
	public static LinkedList<Knjiga> izvrsi(Autor autor, 
			String isbn, String naslov, String izdavac,
			LinkedList<Knjiga> knjige) {
		
		if (naslov == null && autor==null && isbn==null && izdavac==null)
			throw new RuntimeException("Morate uneti bar neki parametar");

		LinkedList<Knjiga> novaLista = new LinkedList<Knjiga>();
		
		for (int i=0;i<knjige.size();i++)
			if (knjige.get(i).getNaslov().contains(naslov))
				novaLista.add(knjige.get(i));
		
		return novaLista;
	}
}
