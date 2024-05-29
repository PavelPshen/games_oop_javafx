package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void thenPositionIsA1() {
        BishopBlack bish = new BishopBlack(Cell.A1);
        Cell expected = Cell.A1;
        Cell output = bish.position();
        assertThat(output).isEqualTo(expected);

    }

    @Test
    void thenCopyFromA7toA1() {
        BishopBlack bish = new BishopBlack(Cell.A7);
        Cell expected = Cell.G1;
        Cell output = bish.copy(expected).position();
        assertThat(output).isEqualTo(expected);
    }

    @Test
    void thenWayFromC1toG5() {
        BishopBlack bish = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] output = bish.way(Cell.G5);
        assertThat(output).isEqualTo(expected);
    }

    @Test
    void whenWayThenImpossibleMoveException()
            throws ImpossibleMoveException {
        BishopBlack bish = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bish.way(Cell.G6);
        });
        String expected = "Could not move by diagonal from C1 to G6";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}