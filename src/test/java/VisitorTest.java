import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class VisitorTest {
    Visitor test = new Visitor();
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
    Exception exception = assertThrows(NullPointerException.class, () -> {
        test.load(null);
    });
    String expectedMessage = "For input string";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
    }

}