/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import java.util.LinkedList;
import java.util.Queue;
import Classes.Board;
import Classes.Node;

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
    
    
}
