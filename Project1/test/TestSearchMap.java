import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class TestSearchMap {
    @Test
    public void readFileTest(){
        List<String> outPut = SearchMap.readFile("test/testInput.txt");
        assertEquals(11, outPut.size());
        assertNull(SearchMap.readFile("DNE"));
    }
}
