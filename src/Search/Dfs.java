/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import java.util.Stack;
import Classes.Board;
import Classes.Node;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EngComp
 */
public class Dfs extends Search{

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
        if(current.isEmpty() && !current.isVisited()) {
            current.markAsVisited();
            current.setParent(parent);
            _stack.push(current);
        }
    }
    
    public static void main(String[] args) {
        Board b = new Board(400, 8);
        Search dfs = new Dfs(b);
        
        try {
            Node path = dfs.run();
            b.set(path);
        } catch (NoSuchPathException ex) {
            Logger.getLogger(Dfs.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("" + b);
        
    }
}
