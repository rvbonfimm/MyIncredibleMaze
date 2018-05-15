package Search;

import Classes.Board;
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
}
