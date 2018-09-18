import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SearchMap {

    public static void main(String[] args) {
        List<String> test = readFile("input/" + args[0]);  //MAKE THE INPUT FILE A LIST OF LINES

        Hashtable<String, FlightMap> map = new Hashtable<>();  //USE A HASHTABLE FOR QUICK LOOKUP OF AirpORTS

        String originName = test.get(0);  //FIRST LINE OF INPUT FILE IS ONLY THE ORIGIN AIRPORT NAME
        FlightMap origin = new FlightMap(originName);    //MAKE AIRPORT OBJECT OUT OF JUST NAME;
        map.put(originName, origin);      //ADD ORIGIN AIRPORT TO HASHTABLE MAP

        for (int i = 1; i < test.size(); i++) {  //CYCLE THROUGH ALL OTHER LINES IN MAP (LOOK AT EVERY CONNECTION)
            String line = test.get(i);

            String[] arr = line.split(" ");  //SPLIT LINE AT ALL SPACES TO LOOK AT INDIVIDUAL PARTS
            String startName = arr[0];
//            System.out.println(startName);
            String endName = arr[1];
//            System.out.println(endName);
            String price = arr[2];
            Integer priceInt = Integer.parseInt(price);
//            System.out.println(price);

            if (!map.containsKey(startName)) {     //IF WE HAVE NEVER SEEN THIS AIRPORT MAKE OBJECT AND ADD IT TO THE MAP
                FlightMap startAP = new FlightMap(startName);
                map.put(startName, startAP);
            }
            if (!map.containsKey(endName)) {       //IF WE HAVE NEVER SEEN THIS AIRPORT MAKE OBJECT AND ADD IT TO THE MAP
                FlightMap endAP = new FlightMap(endName);
                map.put(endName, endAP);
            }
            FlightMap startAP = map.get(startName);      //NOW THAT AIRPORT IN IN MAP, PULL IT OUT AS AN OBJECT
            FlightMap endAP = map.get(endName);

            startAP.addNewConnection(priceInt, endAP);   //MAKE A CONNECTION BETWEEN START AND END POINT USING PRICE
        }

        //RUN BFS TO FIND ALL CONNECTIONS. IN FN EACH AIRPORT GETS UPDATED WITH PATH TO ORIGIN
        //INIT THE BFS
        BreadthFirstSearch testedBFS = new BreadthFirstSearch(origin, map.values());
        //ACTUALLY CALCULATE THE PATHS
        testedBFS.compute();


        for (FlightMap temp : map.values()) {
            System.out.println(temp.getPath() + " " + temp.getAirportName() + " " + temp.getPriceFromOrigan());
        }
    }


    //FN TO OPEN AND READ FILE ONCE AND PUT IT INTO A LIST OF STRINGS LINE BY LINE
    static List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();  //CREATE LIST OF LINES
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));  //OPEN FILE
            String line;
            while ((line = reader.readLine()) != null) {  //KEEP ADDING LINES TO 'records' UNTIL EOF
                records.add(line);
            }
            reader.close();   //CLOSE BUFFER
            return records;   //RETURN LIST OF STRINGS

        } catch (Exception e) {  //CATCH ANY ERRORS IN FILE IO
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}