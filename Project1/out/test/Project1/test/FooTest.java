import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class FooTest {
    @Test
    public void readFileTest(){
        List<String> outPut = Main.readFile("test/testInput.txt");
        assertEquals(11, outPut.size());
        assertNull(Main.readFile("DNE"));
    }

    @Test
    public void addConnectionTest(){
        Airport testAirport = new Airport("test1"); //CREATE NEW AIRPORT

        assertEquals("test1", testAirport.getAirportName());  //TEST getName FN OF AIRPORT CLASS
        assertEquals(0, testAirport.getConnectedAirports().size()); //TEST TO MAKE SURE CONNCETIONS IS INISALIZED AND EMPTY ON CONTRUCITON OF NEW AIRPORT CLASS

        Airport testConnect = new Airport("connectTest");  //CREATE A NEW AIRPORT TO TEST ADD CONNECTION
        testAirport.addNewConnection(200, testConnect);
        assertEquals(1, testAirport.getConnectedAirports().size()); //SEE IF SIZE OF AIRPORT CONCECCTION GREW BY ONE
        Pair<Integer, Airport> testPair = new Pair<>(200, testConnect);
        assertEquals(testPair, testAirport.getConnectedAirports().get(0));  //SEE IF GET CONNECECTION RETRUNS THE CORRECT PAIR OF AIPORT AND PRICE
    }

    @Test
    public void settersAndGettersAirportClass() {
        Airport testWithNoName = new Airport();
        testWithNoName.setAirportName("test1");

        assertEquals("test1", testWithNoName.getAirportName());

        Airport testConnectionAirport1 = new Airport("testConnect1");
        Airport testConnectionAirport2 = new Airport("testConnect2");
        List<Pair<Integer, Airport>> testConnectionList = new ArrayList<>();
        testConnectionList.add(new Pair<>(100, testConnectionAirport1));
        testConnectionList.add(new Pair<>(100, testConnectionAirport2));
        testWithNoName.setConnectedAirports(testConnectionList);

        assertEquals(2, testWithNoName.getConnectedAirports().size());



    }
}
