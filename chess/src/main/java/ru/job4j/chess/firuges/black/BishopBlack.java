package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        Cell[] steps = new Cell[Math.abs(dest.getY() - position.getY())];
        int deltaX = (dest.getX() - position().getX()) / Math.abs(dest.getX() - position().getX());
        int deltaY = (dest.getY() - position().getY()) / Math.abs(dest.getY() - position().getY());
        int x = position().getX();
        int y = position().getY();
        for (int index = 0; index < Math.abs(dest.getY() - position.getY()); index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if(Math.abs(dest.getX() - source.getX()) - Math.abs(dest.getY() - source.getY()) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
