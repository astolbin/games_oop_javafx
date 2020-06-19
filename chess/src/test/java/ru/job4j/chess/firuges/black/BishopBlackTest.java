package ru.job4j.chess.firuges.black;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenBishopCreate() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        assertThat(bishop.position(), is(Cell.C8));
    }

    @Test
    public void whenBishopCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Figure copy = bishop.copy(Cell.E6);
        assertThat(copy.position(), is(Cell.E6));
    }

    @Test
    public void whenBishopWayCorrectC1G5() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expect));
    }

    @Test
    public void whenBishopWayCorrectB6E3() {
        BishopBlack bishop = new BishopBlack(Cell.B6);
        Cell[] way = bishop.way(Cell.B6, Cell.E3);
        Cell[] expect = {Cell.C5, Cell.D4, Cell.E3};
        assertThat(way, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void whenBishopWayIncorrectB6E2() {
        BishopBlack bishop = new BishopBlack(Cell.B6);
        Cell[] way = bishop.way(Cell.B6, Cell.E2);
    }
}