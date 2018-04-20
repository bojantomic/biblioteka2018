package biblioteka.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import biblioteka.Knjiga;

public class SOSacuvajKnjige {

	public static void izvrsi(String fajl, 
			LinkedList<Knjiga> knjige){
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
