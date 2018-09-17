import javafx.util.Pair;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Airport {
    private String airportName;
    private List<Pair<Integer, Airport>> connectedAirports = new ArrayList<>(); //ALWAYS INITIALIZE CONNECTION LIST AS EMPTY.

    //CONSTRUCTORS
    public Airport(String name){ //CONSTRUCT NEW AIRPORT WITH ONLY NAME
        this.airportName = name;
    }
    //DEFAULT CONSTRUCTOR
    public Airport() {}

    //SETTERS AND GETTERS
    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    public List<Pair<Integer, Airport>> getConnectedAirports() {
        return connectedAirports;
    }
    public void setConnectedAirports(List<Pair<Integer, Airport>> connectedAirports) {
        this.connectedAirports = connectedAirports;
    }

    //ADD NEW CONNECTION
    public void addNewConnection(Integer price, Airport connectingAirport){
        this.connectedAirports.add(new Pair<>(price, connectingAirport));
    }
}
