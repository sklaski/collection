package convertBooleanValuesToStringsYesNo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class boolToWordTest {
    @Test
    public void testBoolToWord() {
        assertEquals(YesOrNo.boolToWord(true),"Yes");
        assertEquals(YesOrNo.boolToWord(false),"No");
    }
}