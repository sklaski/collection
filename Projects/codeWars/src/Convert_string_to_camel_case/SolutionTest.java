package Convert_string_to_camel_case;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
	@Test
	public void testEmpty() {
		String input = "";
		System.out.println("input: " + input);
		assertEquals("", Solution.toCamelCase(input));
	}
	
	@Test
	public void testAll() {
		String[] toTest = new String[] {
				"the_Stealth_Warrior", //testSomeUnderscoreLowerStart
				"The-Stealth-Warrior", //testSomeDashUpperStart				
				"The_Stealth_Warrior", //testSomeUnderscoreUpperStart 
				"the-Stealth-Warrior", //testSomeDashLowerStart 
		};
		for(String testString : toTest) {
			System.out.println("input: " + testString);
			assertEquals(testString, Solution.toCamelCase(testString));
		}
	}	
	
	@Test
	public void testSomeUnderscoreLowerStart() {
		String input = "the_Stealth_Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", Solution.toCamelCase(input));
	}

	@Test
	public void testSomeDashLowerStart() {
		String input = "the-Stealth-Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", Solution.toCamelCase(input));
	}
}