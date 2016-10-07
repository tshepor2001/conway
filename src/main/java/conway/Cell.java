package conway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cell {
    private List<Cell> neighbours;
    public State state;

    public Cell(State state) {
        this.state = state;
        neighbours = new ArrayList<Cell>();
    }

    public State state() {
        if (neighbours().stream()
                .filter(cell -> cell.state().equals(State.ALIVE))
                .collect(Collectors.toList()).size() < 2){
            return State.DEAD;
        }
        return state;
    }



    public List<Cell> neighbours() {
        return neighbours;
    }

    public enum State {
        DEAD, ALIVE;
    }
}
