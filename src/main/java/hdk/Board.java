package hdk;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final boolean[][] board;

    public Board(boolean[][] board, Point removedBlock) {
        this.board = board;
        if (removedBlock != null) {
            board[removedBlock.x()][removedBlock.y()] = false;
        }
    }

    public List<Point> findNeighbours(Point block) {
        ArrayList<Point> neighbours = new ArrayList<>();
        if (block.x() > 0 && board[block.x() - 1][block.y()]) {
            neighbours.add(new Point(block.x() - 1, block.y()));
        }
        if (block.x() < board.length - 1 && board[block.x() + 1][block.y()]) {
            neighbours.add(new Point(block.x() + 1, block.y()));
        }
        if (block.y() > 0 && board[block.x()][block.y() - 1]) {
            neighbours.add(new Point(block.x(), block.y() - 1));
        }
        if (block.y() < board[block.x()].length - 1 && board[block.x()][block.y() + 1]) {
            neighbours.add(new Point(block.x(), block.y() + 1));
        }

        return neighbours;
    }

    public boolean verifyContainsGround(List<Point> visited) {
        return visited.stream()
                .anyMatch(point -> point.x() == board.length-1);
    }
}
