package Search;

import java.util.Stack;
import Classes.Board;
import Classes.Node;

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
    public void add(Node current, Node parent) {
        if (current.isEmpty() && !current.isVisited()) {
            current.markAsVisited();
            current.setParent(parent);
            _stack.push(current);
        }
    }
}
