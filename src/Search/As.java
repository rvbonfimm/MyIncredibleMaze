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
    /**
     * h = f + g
     * @param current
     * @param parent 
     */
    private void updateCost(Node current, Node parent) {
        //  f é o custo do pai + custo de um passo
        //      tal que o custo de um passo é 1
        //  g é o custo da heuristica aplicada a este nó pelos metodos
        // da classe Heuristic
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
        int size = 10;
        int cost = 0;
        Board b = new Board(size);
        b.setBegin(b.get(2, 0));
        b.setEnd(b.get(size / 2, size-1));
        
        Heuristic.manhattan(b);
        System.out.println("" + Heuristic.out(b));
        
        Search dfs = new As(b);
        for(int i = 0; i < size - 5; i++)
            b.set(i, 5, Node.BLOCKED);
        
        try {
            Node path = dfs.run();
            cost = path.getParent().getCost();
            System.out.println("Custo" + path.getCost());
            b.set(path);
        } catch (NoSuchPathException ex) {
            Logger.getLogger(Dfs.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("" + b);
        System.out.println("" + Heuristic.out(b));
        System.out.println("Quantidade de nós " + (size * size));
        System.out.println("Custo " + (cost));
    }   
}
