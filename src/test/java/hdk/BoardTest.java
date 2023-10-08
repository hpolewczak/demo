package hdk;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {
    private static final boolean[][] ARRAY_BOARD = {
            {true,  true,  true,  true,  true},
            {false, false, true,  false, true},
            {false, true,  true,  false, false},
            {true,  true,  false, false, false},
            {false, true,  true,  false, false}
    };
    private final Board board = new Board(ARRAY_BOARD, new Point(0, 4));

    @Test
    void findNeighboursForLeftTopCorner() {
        // when
        List<Point> neighbours = board.findNeighbours(new Point(0, 0));
        // then
        assertEquals(1, neighbours.size());
        assertTrue(neighbours.contains(new Point(0, 1)));
    }

    @Test
    void findNeighboursForRightTopCorner() {
        // when
        List<Point> neighbours = board.findNeighbours(new Point(0, 4));
        // then
        assertEquals(2, neighbours.size());
        assertTrue(neighbours.contains(new Point(0, 3)));
        assertTrue(neighbours.contains(new Point(1, 4)));
    }

    @Test
    void findNeighboursForLeftBottomCorner() {
        // when
        List<Point> neighbours = board.findNeighbours(new Point(4, 0));
        // then
        assertEquals(2, neighbours.size());
        assertTrue(neighbours.contains(new Point(3, 0)));
        assertTrue(neighbours.contains(new Point(4, 1)));
    }

    @Test
    void findNeighboursForRightBottomCorner() {
        assertTrue(board.findNeighbours(new Point(4, 4)).isEmpty());
    }

    @Test
    void findNeighboursForCenterPoint() {
        // when
        List<Point> neighbours = board.findNeighbours(new Point(2, 2));
        // then
        assertEquals(2, neighbours.size());
        assertTrue(neighbours.contains(new Point(1, 2)));
        assertTrue(neighbours.contains(new Point(2, 1)));
    }
}