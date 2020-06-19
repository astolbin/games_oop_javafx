package ru.job4j.chess;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.RookBlack;

import static org.junit.Assert.*;

public class LogicTest {
    @Test
    public void whenFigureNotFound() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.D2, Cell.E3);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenMoveFigureWithImpediment() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new RookBlack(Cell.D2));
        boolean rsl = logic.move(Cell.C1, Cell.E3);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenMoveFigureWithoutImpediment() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new RookBlack(Cell.D3));
        boolean rsl = logic.move(Cell.C1, Cell.E3);
        assertThat(rsl, is(true));
    }
}