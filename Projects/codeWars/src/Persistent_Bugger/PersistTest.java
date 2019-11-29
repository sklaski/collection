package Persistent_Bugger;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersistTest {
    
	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals(0, Persist.persistence(4));
		assertEquals(3, Persist.persistence(39));
	  assertEquals(4, Persist.persistence(999));
	}
	
}
