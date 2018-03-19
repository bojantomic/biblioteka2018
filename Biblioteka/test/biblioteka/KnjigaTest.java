package biblioteka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnjigaTest {
	
	private Knjiga k;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		k = new Knjiga();
	}

	@After
	public void tearDown() throws Exception {
		k = null;
	}

	@Test
	public void testSetAutori() {
		Autor[] niz = new Autor[2];
		
		niz[0] = new Autor();
		niz[1] = new Autor();
		
		k.setAutori(niz);
		
		assertArrayEquals(niz,k.getAutori());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAutoriNull() {
		k.setAutori(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAutoriPrazanNiz() {
		k.setAutori(new Autor[0]);
	}

	@Test
	public void testSetNaslov() {
		k.setNaslov("Tihi okean");
		
		assertEquals("Tihi okean", k.getNaslov());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNaslovNull() {
		k.setNaslov(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNaslovPrazanString() {
		k.setNaslov("");
	}

	@Test
	public void testSetIsbn() {
		k.setIsbn("9876543211234");
		
		assertEquals("9876543211234", k.getIsbn());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIsbnNull() {
		k.setIsbn(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIsbnManjeOd13() {
		k.setIsbn("123456789012");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIsbnViseOd13() {
		k.setIsbn("12345678901243");
	}

	@Test
	public void testSetIzdavac() {
		k.setIzdavac("Laguna");
		
		assertEquals("Laguna", k.getIzdavac());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIzdavacNull() {
		k.setIzdavac(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIzdavacPrazanString() {
		k.setIzdavac("");
	}

	@Test
	public void testSetIzdanje() {
		k.setIzdanje(12);
		
		assertEquals(12, k.getIzdanje());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIzdanjeNula() {
		k.setIzdanje(0);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIzdanjeManjeOdNule() {
		k.setIzdanje(-1);
	}

	@Test
	public void testEqualsObject() {
		k.setIsbn("1234567890123");
		k.setNaslov("Naslov");
		k.setIzdanje(1);
		k.setIzdavac("izdavac");
		k.setAutori(new Autor[1]);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("1234567890123");
		k2.setNaslov("Naslov 2");
		k2.setIzdanje(2);
		k2.setIzdavac("izdavac 2");
		k2.setAutori(new Autor[3]);

		assertTrue(k.equals(k2));
	}
	
	@Test
	public void testEqualsObjectFalse() {
		k.setIsbn("1234567890121");
		k.setNaslov("Naslov 2");
		k.setIzdanje(2);
		k.setIzdavac("izdavac 2");
		k.setAutori(new Autor[3]);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("1234567890123");
		k2.setNaslov("Naslov 2");
		k2.setIzdanje(2);
		k2.setIzdavac("izdavac 2");
		k2.setAutori(new Autor[3]);

		assertFalse(k.equals(k2));
	}

}
