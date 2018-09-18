import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFlightMap {
    @Test
    public void addConnectionTest(){
        FlightMap testFlightMap = new FlightMap("test1"); //CREATE NEW AIRPORT

        assertEquals("test1", testFlightMap.getAirportName());  //TEST getName FN OF AIRPORT CLASS
        assertEquals(0, testFlightMap.getConnectedAirports().size()); //TEST TO MAKE SURE CONNCETIONS IS INISALIZED AND EMPTY ON CONTRUCITON OF NEW AIRPORT CLASS

        FlightMap testConnect = new FlightMap("connectTest");  //CREATE A NEW AIRPORT TO TEST ADD CONNECTION
        testFlightMap.addNewConnection(200, testConnect);
        assertEquals(1, testFlightMap.getConnectedAirports().size()); //SEE IF SIZE OF AIRPORT CONCECCTION GREW BY ONE
        Pair<Integer, FlightMap> testPair = new Pair<>(200, testConnect);
        assertEquals(testPair, testFlightMap.getConnectedAirports().get(0));  //SEE IF GET CONNECECTION RETRUNS THE CORRECT PAIR OF AIPORT AND PRICE
    }

    @Test
    public void settersAndGettersAirportClass() {
        FlightMap testWithNoName = new FlightMap();
        testWithNoName.setAirportName("test1");

        assertEquals("test1", testWithNoName.getAirportName());

        FlightMap testConnectionFlightMap1 = new FlightMap("testConnect1");
        FlightMap testConnectionFlightMap2 = new FlightMap("testConnect2");
        List<Pair<Integer, FlightMap>> testConnectionList = new ArrayList<>();
        testConnectionList.add(new Pair<>(100, testConnectionFlightMap1));
        testConnectionList.add(new Pair<>(100, testConnectionFlightMap2));
        testWithNoName.setConnectedAirports(testConnectionList);

        assertEquals(testConnectionList, testWithNoName.getConnectedAirports());
        assertEquals(2, testWithNoName.getConnectedAirports().size());

        testWithNoName.setPriceFromOrigan(300);
        assertEquals(300, testWithNoName.getPriceFromOrigan());

        List<String> fakeTestPath = new ArrayList<>();
        fakeTestPath.add("one");
        fakeTestPath.add("two");
        fakeTestPath.add("three");

        testWithNoName.setPath(fakeTestPath);
        assertEquals(3, testWithNoName.getPath().size());

        List<String> fakeAddToPathTest = new ArrayList<>();
        fakeAddToPathTest.add("four");
        testWithNoName.addToPath(fakeAddToPathTest);
        assertEquals(4, testWithNoName.getPath().size());
    }
}