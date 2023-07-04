package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell position = bishopBlack.position();
        assertEquals(position, Cell.C8);
    }

    @Test
    public void whenMoveToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] exp = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(rsl, exp);
    }

    @Test
    public void whenMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.C3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C3");
    }

    @Test
    public void whenCopyToB7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell rsl = bishopBlack.copy(Cell.B7).position();
        assertEquals(rsl, Cell.B7);
    }
}