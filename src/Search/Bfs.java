package Search;

import java.util.LinkedList;
import java.util.Queue;
import Classes.Board;
import Classes.Node;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EngComp
 */
public class Bfs extends Search{

    private Queue<Node> _queue;
    
    public Bfs(Board board) {
        super(board);
        _queue = new LinkedList<>();
    }

    @Override
    public Node remove() {
        return _queue.poll();
    }
    
    @Override
    public void add(Node current, Node parent) {
        if(current.isEmpty() && !current.isVisited()) {
            current.markAsVisited();
            current.setParent(parent);
            _queue.add(current);
        }
    }
    @Override
    public boolean isEmpty() {
        return _queue.size() == 0;
    }
    
    public static void main(String[] args) {
        Board b = new Board(40, 8);
        Search dfs = new Bfs(b);
        
        try {
            Node path = dfs.run();
            b.set(path);
        } catch (NoSuchPathException ex) {
            Logger.getLogger(Dfs.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("" + b);
        
    }
}
