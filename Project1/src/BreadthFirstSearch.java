import javafx.util.Pair;

import java.util.*;

public class BreadthFirstSearch {
    private FlightMap origan;
    private Collection<FlightMap> map;

    public BreadthFirstSearch(FlightMap start, Collection<FlightMap> map){
        this.origan = start;
        this.map = map;
    }

    public FlightMap getOrigan() {
        return origan;
    }
    public void setOrigan(FlightMap origan) {
        this.origan = origan;
    }
    public Collection<FlightMap> getMap() {
        return map;
    }
    public void setMap(Collection<FlightMap> map) {
        this.map = map;
    }

    public void compute() {

        Queue<FlightMap> queue = new LinkedList<>();
        ArrayList<FlightMap> explored = new ArrayList<>();
        queue.add(this.origan);

        while (!queue.isEmpty()) {
            FlightMap current = queue.remove();
            for (Pair<Integer, FlightMap> goal : current.getConnectedAirports()) {
                if(!explored.contains(goal.getValue())) {
                    if(!current.equals(origan)) {
                        List<String> compPath = new ArrayList<>(current.getPath());
                        String tempCurrentName = current.getAirportName();
                        compPath.add(tempCurrentName);
                        goal.getValue().addToPath(compPath);
                        int price = current.getPriceFromOrigan();
                        price += goal.getKey();
                        goal.getValue().setPriceFromOrigan(price);

                    }else{
                        List<String> justOriganName = new ArrayList<>();
                        justOriganName.add(current.getAirportName());
                        goal.getValue().addToPath(justOriganName);
                        goal.getValue().setPriceFromOrigan(goal.getKey());
                    }
                    queue.add(goal.getValue());
                    explored.add(goal.getValue());
                }
            }

        }
    }
}
