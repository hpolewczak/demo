package hdk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Blocks {
    public List<Point> getPointsToRemove(boolean[][] board, Point removedBlock) {
        return getPointsToRemove(new Board(board, removedBlock), removedBlock);
    }

    private List<Point> getPointsToRemove(Board board, Point removedBlock) {
        List<Point> result = new ArrayList<>();
        for (Point el : board.findNeighbours(removedBlock)) {
            result.addAll(getBlocksToRemove(board, el, new LinkedList<>(), new ArrayList<>()));
        }
        return result;
    }

    private List<Point> getBlocksToRemove(Board board, Point el, Queue<Point> queue, List<Point> visited) {
        queue.addAll(board.findNeighbours(el).stream()
                .filter(point -> !visited.contains(point))
                .toList());
        visited.add(el);
        if (!queue.isEmpty()) {
            return getBlocksToRemove(board, queue.remove(), queue, visited);
        }
        return board.verifyContainsGround(visited) ? List.of() : visited;
    }
}
