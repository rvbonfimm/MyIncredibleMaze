package Search;

import java.util.Stack;
import Classes.Board;
import Classes.Node;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dfs extends Search {

    private Stack<Node> _stack;

    public Dfs(Board board) {
        super(board);
        _stack = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return _stack.isEmpty();
    }

    @Override
    public Node remove() {
        return _stack.pop();
    }

    @Override
    public void add(Node current, Node parent) throws NoSuchPathException {
        if (current.isEmpty() && !current.isVisited()) {
            current.markAsVisited();
            current.setParent(parent);
            _stack.push(current);
        }
    }

    public static void main(String[] args) {
        int size = 200;
        Board b = new Board(size);
        Search dfs = new Dfs(b);

        try {
            Node path = dfs.run();
            b.set(path);
        } catch (NoSuchPathException ex) {
            Logger.getLogger(Dfs.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("" + b);
        System.out.println("Quantidade de nós " + (size * size));
    }
}
