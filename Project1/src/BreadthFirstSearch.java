import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private Airport origan;
    private Airport goal;

    public BreadthFirstSearch(Airport start, Airport goalNode){
        this.origan = start;
        this.goal = goalNode;
    }

    public boolean compute(){
        if(this.origan.equals(goal)){
            System.out.println("Goal Node Found!");
            System.out.println(origan.getAirportName());
        }

        Queue<Pair<Integer, Airport>> queue = new LinkedList<>();
        ArrayList<Airport> explored = new ArrayList<>();
        queue.add(this.origan);
        explored.add(origan);

        while(!queue.isEmpty()){
            Pair<Integer, Airport> current = queue.remove();
            if(current.getValue().equals(this.goal)) {
                System.out.println(explored);
                return true;
            }
            else{
                if(current.getConnectedAirports()..isEmpty())
                    return false;
                else
                    queue.addAll(current.getConnectedAirports());
            }
            explored.add(current);
        }

        return false;

    }
}
