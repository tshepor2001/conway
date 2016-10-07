package conway;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestCell {

    private Cell cell;

    @Before
    public void setup() {
    }


    @Test
    public void anyLiveCellWithFewerThanTwoLiveNeighboursDies() {
        cell = aliveCell();
        cell.neighbours().add(deadCell());
        cell.neighbours().add(deadCell());
        cell.neighbours().add(aliveCell());

        assertThat(cell.state(), is(Cell.State.DEAD));
    }

    private Cell aliveCell() {
        return new Cell(Cell.State.ALIVE);
    }

    private Cell deadCell() {
        return new Cell(Cell.State.DEAD);
    }
}
