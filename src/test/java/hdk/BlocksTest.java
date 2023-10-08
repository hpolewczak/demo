package hdk;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlocksTest {
    private final Blocks blocks = new Blocks();

    /*
     * 1 1 1 1 1
     * 0 0 1 0 X
     * 0 1 1 0 0
     * 0 1 0 0 0
     * 0 1 1 0 0
     * */
    @Test
    void noPointsToRemove() {
        // given
        boolean[][] board = {
                {true, true, true, true, true},
                {false, false, true, false, true},
                {false, true, true, false, false},
                {true, true, false, false, false},
                {false, true, true, false, false}
        };
        // when //then
        assertTrue(blocks.getPointsToRemove(board, new Point(1, 4)).isEmpty());
    }

    /*
     * 1 1 1 1 X
     * 0 0 1 0 1
     * 0 1 1 0 0
     * 0 1 0 0 0
     * 0 1 1 0 0
     * */
    @Test
    void onePointToRemove() {
        // given
        boolean[][] board = {
                {true, true, true, true, true},
                {false, false, true, false, true},
                {false, true, true, false, false},
                {true, true, false, false, false},
                {false, true, true, false, false}
        };
        // when
        List<Point> pointsToRemove = blocks.getPointsToRemove(board, new Point(0, 4));
        // then
        assertEquals(1, pointsToRemove.size());
        assertEquals(new Point(1, 4), pointsToRemove.get(0));
    }

    /*
     * 1 1 1 1 1
     * 0 0 1 0 1
     * 0 1 X 0 0
     * 0 1 0 0 0
     * 0 1 1 0 0
     * */
    @Test
    void sevenPointsToRemove() {
        // given
        boolean[][] board = {
                {true,  true,  true,  true,  true},
                {false, false, true,  false, true},
                {false, true,  true,  false, false},
                {true,  true,  false, false, false},
                {false, true,  true,  false, false}
        };
        // when
        List<Point> pointsToRemove = blocks.getPointsToRemove(board, new Point(2, 2));
        // then
        assertEquals(7, pointsToRemove.size());
        assertTrue(pointsToRemove.contains(new Point(0, 0)));
        assertTrue(pointsToRemove.contains(new Point(0, 1)));
        assertTrue(pointsToRemove.contains(new Point(0, 2)));
        assertTrue(pointsToRemove.contains(new Point(0, 3)));
        assertTrue(pointsToRemove.contains(new Point(0, 4)));
        assertTrue(pointsToRemove.contains(new Point(1, 2)));
        assertTrue(pointsToRemove.contains(new Point(1, 4)));
    }
}