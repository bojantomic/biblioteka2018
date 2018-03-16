package biblioteka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AutorTest {
	
	private Autor a;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		a = new Autor();
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testSetIme() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImeNull() {
		a.setIme(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImePrazanString() {
		a.setIme("");
	}

	@Test
	public void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrezimeNull() {
		a.setPrezime(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrezimePrazanString() {
		a.setPrezime("");
	}

	@Test
	public void testToString() {
		a.setIme("Pera");
		a.setPrezime("Mikic");
		
		assertEquals("Autor [ime=Pera, prezime=Mikic]", a.toString());
	}

	@Test
	public void testEqualsObject() {
		a.setIme("Pera");
		a.setPrezime("Mikic");
		
		Autor a2 = new Autor();
		a2.setIme("Pera");
		a2.setPrezime("Mikic");
		
		assertTrue( a.equals(a2) );
		
	}
	
	@Test
	public void testEqualsObjectFalse() {
		a.setIme("Pera");
		a.setPrezime("Mikic");
		
		Autor a2 = new Autor();
		a2.setIme("Pera");
		a2.setPrezime("Zikic");
		
		assertFalse( a.equals(a2) );
		
	}

}
