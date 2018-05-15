package Search;

import Classes.Board;
import Classes.Heuristic;
import Classes.Node;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy extends Search {

    private PriorityQueue<Node> _pq;

    public Greedy(Board board) {
        super(board);

        _pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getCost() - o2.getCost();
            }
        });
    }

    @Override
    public boolean isEmpty() {
        return _pq.isEmpty();
    }

    @Override
    public Node remove() {
        return _pq.poll();
    }

    @Override
    public void add(Node current, Node parent) {
        if (current.isEmpty() && !current.isVisited()) {
            current.markAsVisited();
            current.setParent(parent);
            _pq.add(current);
        }
    }

    public static void main(String[] args) {
        Board board = new Board(4);
        Search search = new Greedy(board);

        try {
            Heuristic.manhattan(board);
            System.out.println("" + Heuristic.out(board));
            Node path = search.run();
            board.set(path);

            System.out.println("" + Heuristic.out(board));
            System.out.println("" + board);
        } catch (Exception e) {
            System.out.println("" + board);
        }
    }
}
