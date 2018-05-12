package Search;

import Classes.Board;
import Classes.Node;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BidirecionalBfs extends Search {

    private Queue<Node> queue_a;
    private Queue<Node> queue_b;

    private HashSet<Node> dc_a;
    private HashSet<Node> dc_b;

    private Node current_a;
    private Node current_b;

    private Node target_a;
    private Node target_b;

    private Node begin_a;
    private Node begin_b;

    private boolean collision;

    public BidirecionalBfs(Board board) {
        super(board);

        collision = false;

        queue_a = new LinkedList<>();
        queue_b = new LinkedList<>();

        dc_a = new HashSet<>();
        dc_b = new HashSet<>();

        begin_a = board.getBegin();
        begin_b = board.getEnd();

        target_a = board.getEnd();
        target_b = board.getBegin();

        current_a = null;
        current_b = null;

    }

    @Override
    public boolean next() {
        current_a = queue_a.remove();
        current_b = queue_b.remove();

        if (current_a.equals(target_a)) {
            return false;
        }
        if (current_b.equals(target_b)) {
            return false;
        }
        for (Node a : current_a.getAdjList()) {
            if (a.isEmpty() && !dc_a.contains(a)) {
                if (a.getParent() == null) {
                    a.setParent(current_a);
                } else {
                    if (dc_b.contains(a)) {
                        for (Node k : dc_b) {
                            if (k.equals(current_b)) {
                                collision = true;
                                current_b = a;
                            }
                        }
                    }
                }
                dc_a.add(a);
                queue_a.add(a);
            }
            if (collision) {
                return false;
            }
        }
        for (Node b : current_b.getAdjList()) {
            if (b.isEmpty() && !dc_b.contains(b)) {
                if (b.getParent() == null) {
                    b.setParent(current_b);
                } else {
                    if (dc_a.contains(b)) {
                        for (Node k : dc_a) {
                            if (k.equals(current_a)) {
                                collision = true;
                                current_a = b;
                            }
                        }
                    }
                }
                dc_b.add(b);
                queue_b.add(b);
            }
            if (collision) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isEmpty() {
        return queue_a.isEmpty() || queue_b.isEmpty();
    }

    @Override
    public Node remove() {
        return null;
    }

    @Override
    public void add(Node current, Node parent) {

    }

    @SuppressWarnings("empty-statement")
    public Node run() throws NoSuchPathException {
        /**
         * A busca em sua forma mais geral.
         *
         */

        queue_a.add(begin_a);
        queue_b.add(begin_b);
        dc_a.add(begin_a);
        dc_b.add(begin_b);

        while (!isEmpty() && next());

        if (!collision) {
            throw new NoSuchPathException();
        }

        Queue<Node> q = new LinkedList<>();
        while (current_b.getParent() != null) {
            q.add(current_b);
            current_b = current_b.getParent();
        }

        Node ret = q.remove();
        ret.setParent(current_a);
        while (!q.isEmpty()) {
            q.peek().setParent(ret);
            ret = q.remove();
        }

        return ret;
    }

//    public static void main(String[] args) {
//        Board board = new Board(100, 10);
//        BidirecionalBfs bd = new BidirecionalBfs(board);
//        Node path;
//        try {
//            path = bd.run();
//            board.set(path);
//            System.out.println("" + board);
//        } catch (NoSuchPathException ex) {
//
//        }
//        System.out.println("" + board);
//    }
}
