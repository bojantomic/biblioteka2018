package biblioteka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BibliotekaTest {
	
	private Biblioteka b;
	private Knjiga k;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		b = new Biblioteka();
		
		k = new Knjiga();
		k.setIsbn("1234567890123");
		k.setNaslov("Naslov");
		k.setIzdanje(12);
		k.setIzdavac("Izdavac");
		
		Autor a = new Autor();
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		Autor[] niz = new Autor[1];
		niz[0] = a;
		
		k.setAutori(niz);
	}

	@After
	public void tearDown() throws Exception {
		b=null;
		k=null;
	}

	@Test
	public void testDodajKnjigu() {
		b.dodajKnjigu(k);
		
		//Dodata je tacno jedna knjiga
		assertEquals(1, b.vratiSveKnjige().size());
		//Dodata je bas ta knjiga
		assertEquals(k, b.vratiSveKnjige().get(0));
	}
	
	@Test
	public void testDodajKnjigu2() {
		b.dodajKnjigu(k);
		Knjiga k2 = new Knjiga();
		k2.setIsbn("1234567890122");
		
		b.dodajKnjigu(k2);
		
		//Dodata je tacno jedna knjiga u nepraznu listu
		assertEquals(2, b.vratiSveKnjige().size());
		//Dodata je bas ta druga knjiga na kraj
		assertEquals(k2, b.vratiSveKnjige().get(1));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajKnjiguDuplikat() {
		b.dodajKnjigu(k);
		Knjiga k2 = new Knjiga();
		k2.setIsbn("1234567890123");
		
		b.dodajKnjigu(k2);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajKnjiguNull() {
		b.dodajKnjigu(null);
	}

	@Test
	public void testObrisiKnjigu() {
		b.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn("1234567890123");
		
		b.obrisiKnjigu(k2);
		
		assertEquals(0, b.vratiSveKnjige().size());
	}
	
	@Test
	public void testObrisiKnjigu2() {
		b.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn("1234567890122");
		k2.setNaslov("Knjiga 2 naslov");
		b.dodajKnjigu(k2);
		
		b.obrisiKnjigu(k);
		
		assertEquals(1, b.vratiSveKnjige().size());
		assertFalse(b.vratiSveKnjige().contains(k));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testObrisiKnjiguNull() {
		b.obrisiKnjigu(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testObrisiKnjiguNePostoji() {
		b.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn("1234567890122");
		k2.setNaslov("Knjiga 2 naslov");
		
		b.obrisiKnjigu(k2);
	}

	@Test
	public void testVratiSveKnjige() {
		b.dodajKnjigu(k);
		
		assertEquals(1, b.vratiSveKnjige().size());
		assertEquals(k, b.vratiSveKnjige().get(0));
	}
	
	@Test
	public void testVratiSveKnjigePraznaLista() {
		assertEquals(0, b.vratiSveKnjige().size());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testPronadjiKnjiguSviParametriNull() {
		b.pronadjiKnjigu(null, null, null, null);
	}

}
