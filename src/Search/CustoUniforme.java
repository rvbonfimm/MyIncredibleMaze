
package Search;

import Classes.Board;
import Classes.Node;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class CustoUniforme extends Search{
    
    private Queue<Node> _queue;

    public CustoUniforme(Board board) {
        super(board);
        //Comparator for the PriorityQueue, sort by cost.
        Comparator<Node> costComparator = Comparator.comparing(Node::getCost);
        _queue = new PriorityQueue<>(costComparator);
        
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                board.get(i, j).setCost(i+j);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return _queue.size() == 0;
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
            if(parent!=null){
                current.setCost(current.getCost()+parent.getCost());
            }    
            _queue.add(current);
        }
    }  
}