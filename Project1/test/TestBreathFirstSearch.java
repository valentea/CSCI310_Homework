import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBreathFirstSearch {
    @Test
    public void initBFSTest(){
        FlightMap testOrigin = new FlightMap("testOrigin");
        FlightMap testGoal = new FlightMap("testGoal");

        HashMap<String, FlightMap> map = new HashMap<>();
        map.put(testOrigin.getAirportName(), testOrigin);
        map.put(testGoal.getAirportName(), testGoal);

        BreadthFirstSearch testBFS = new BreadthFirstSearch(testOrigin, map.values());

        assertEquals("testOrigin", testBFS.getOrigan().getAirportName());
        assertEquals(2, testBFS.getMap().size());

        testBFS.setOrigan(testGoal);
        assertEquals("testGoal", testBFS.getOrigan().getAirportName());

        FlightMap testNewSizeOfMapAfterBFSMapSet = new FlightMap("sizeChangeTest");
        map.put(testNewSizeOfMapAfterBFSMapSet.getAirportName(), testNewSizeOfMapAfterBFSMapSet);

        testBFS.setMap(map.values());
        assertEquals(3, testBFS.getMap().size());
    }

    @Test
    public void computeBFSTest(){
        FlightMap testOrigin = new FlightMap("testOrigin");
        FlightMap testGoal = new FlightMap("testGoal");
        testOrigin.addNewConnection(300, testGoal);

        HashMap<String, FlightMap> map = new HashMap<>();
        map.put(testOrigin.getAirportName(), testOrigin);
        map.put(testGoal.getAirportName(), testGoal);

        BreadthFirstSearch testBFS = new BreadthFirstSearch(testOrigin, map.values());
        testBFS.compute();

        List<String> testPath = new ArrayList<>();
        testPath.add(testOrigin.getAirportName());

        assertEquals(testPath, testGoal.getPath());
        assertEquals(300, testGoal.getPriceFromOrigan());
    }
}
