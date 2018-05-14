/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import Classes.Board;
import Classes.Heuristic;
import Classes.Node;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EngComp
 */
public class As extends Search{

    private PriorityQueue<Node> _pq;
    
    public As(Board board) {
        super(board);
       
        _pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getCost() - o2.getCost();
            }
        });
       
        board.getBegin().setFcost(0);
    }

    @Override
    public boolean isEmpty() {
        return _pq.isEmpty();
    }

    @Override
    public Node remove() {
        return _pq.poll();
    }

    private void updateCost(Node current, Node parent) {
        if(parent != null)
            current.setFcost(parent.getFcost() + 1);
        current.setCost( current.getCost() + current.getFcost() );
    
    }
    
    @Override
    public void add(Node current, Node parent) {
        if(current.isEmpty() && !current.isVisited()) {
            current.markAsVisited();
            current.setParent(parent);
            updateCost(current, parent);
            _pq.add(current);
        }
    }
 
    public static void main(String[] args) {
        Board b = new Board(5);
        b.setBegin(b.get(2, 0));
        b.setEnd(b.get(2, 4));
        Heuristic.manhattan(b);
        System.out.println("" + Heuristic.out(b));
        
        Search dfs = new As(b);
        b.set(1, 2, Node.BLOCKED);
        b.set(2, 2, Node.BLOCKED);
        b.set(3, 2, Node.BLOCKED);
        try {
            Node path = dfs.run();
            System.out.println("Custo" + path.getCost());
            b.set(path);
        } catch (NoSuchPathException ex) {
            Logger.getLogger(Dfs.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("" + b);
        System.out.println("" + Heuristic.out(b));
    }   
}
