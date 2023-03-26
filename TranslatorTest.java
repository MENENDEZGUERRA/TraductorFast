import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TranslatorTest {
    @Test
    public void testTranslate() {
        Translator translator = new Translator();

        // Test case 1: Valid word and language
        String input1 = "casa\nen\n";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);
        translator.translate();
        assertEquals("Translation of casa: house", outContent.toString().trim());

        // Test case 2: Valid word but invalid language
        String input2 = "casa\nes\n";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        translator.translate();
        assertEquals("The word casa does not have a translation in this dictionary.", outContent.toString().trim());

        // Test case 3: Invalid word
        String input3 = "xyz\nen\n";
        InputStream in3 = new ByteArrayInputStream(input3.getBytes());
        System.setIn(in3);
        translator.translate();
        assertEquals("The word xyz does not have a translation in this dictionary.", outContent.toString().trim());
    }
}
