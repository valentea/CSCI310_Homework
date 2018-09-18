import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class FlightMap {
    private String airportName;
    private List<Pair<Integer, FlightMap>> connectedAirports = new ArrayList<>(); //ALWAYS INITIALIZE CONNECTION LIST AS EMPTY.
    private int priceFromOrigan;
    private List<String> path = new ArrayList<>();

    //CONSTRUCTORS
    public FlightMap(String name){ //CONSTRUCT NEW AIRPORT WITH ONLY NAME
        this.airportName = name;
    }
    //DEFAULT CONSTRUCTOR
    public FlightMap() {}

    //SETTERS AND GETTERS
    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    public List<Pair<Integer, FlightMap>> getConnectedAirports() {
        return connectedAirports;
    }
    public void setConnectedAirports(List<Pair<Integer, FlightMap>> connectedAirports) {
        this.connectedAirports = connectedAirports;
    }
    public int getPriceFromOrigan() {
        return priceFromOrigan;
    }
    public void setPriceFromOrigan(int priceFromOrigan) {
        this.priceFromOrigan = priceFromOrigan;
    }
    public List<String> getPath() {
        return path;
    }
    public void setPath(List<String> path) {
        this.path = path;
    }

    //ADD NEW CONNECTION
    public void addNewConnection(Integer price, FlightMap connectingFlightMap){
        this.connectedAirports.add(new Pair<>(price, connectingFlightMap));
    }

    //ADD A LIST OF STRINGS (THE NAMES OF ALL THE PRECEEDING AIRPORTS)
        //ONLY USED IN THE BFS CLASS AND THEREFOR WE ALWAYS PUT IN THE ENTIRE LIST (PATH) OF THE AIRPORT BEFORE IT
    public void addToPath(List<String> temp){
        for(String portPath : temp){
            this.path.add(portPath);
        }
    }
}
