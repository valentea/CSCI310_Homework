import javafx.util.Pair;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FooTest {
    @Test
    public void test1(){
        List<String> outPut = Main.readFile("test/testInput.txt");
        assertEquals(11, outPut.size());
        assertNull(Main.readFile("DNE"));
    }

    @Test
    public void test2(){
        airport testAirport = new airport("test1");
        assertEquals("test1", testAirport.getName());
        assertEquals(0, testAirport.getConnect().size());

        airport testConnect = new airport("connectTest");
        testAirport.addConnection(200, testConnect);
        assertEquals(1, testAirport.getConnect().size());
        Pair<airport, Integer> testPair = new Pair<>(testConnect, 200);
        assertEquals(testPair, testAirport.getConnect().get(0));


    }
}
