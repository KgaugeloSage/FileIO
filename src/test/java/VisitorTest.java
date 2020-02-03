import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class VisitorTest {
    Visitor test = new Visitor();

    @Test
    void save() throws IOException {
        test.setFullName("  cvbndguj   ");
        test.setAge(26);
        test.setNameOfPersonVisited("Kgaugelo Ramaramela");
        test.setComments("Wuuuuuuuuh Wabala3423ba Dub DUb");

        assertTrue(test.save(), "File already exists, user visiting again so it only appended different information");
    }

    @Test
    void load() throws IOException {
        assertTrue(test.load("Belrtflo Sage"), "File does not exist");
    }

    @Test
    void loadError() {
        assertThrows(FileNotFoundException.class, () -> test.load("Bello Sage"));
    }


}