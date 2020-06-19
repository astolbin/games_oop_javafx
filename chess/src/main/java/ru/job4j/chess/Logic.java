package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rsl = false;
        int index = this.findBy(source);

        if (index != -1) {
            try {
                Cell[] steps = this.figures[index].way(source, dest);
                if (steps.length > 0
                    && !hasImpedimentInWay(steps)
                    && steps[steps.length - 1].equals(dest)
                ) {
                    this.figures[index] = this.figures[index].copy(dest);
                    rsl = true;
                }
            } catch (IllegalStateException exception) {
            }
        }

        return rsl;
    }

    private boolean hasImpedimentInWay(Cell[] way) {
        for (Cell cell : way) {
            int wayIndex = this.findBy(cell);
            if (wayIndex != -1) {
                return true;
            }
        }
        return false;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
