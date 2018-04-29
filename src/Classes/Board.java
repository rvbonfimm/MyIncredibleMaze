package Classes;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author EngComp
 */
public class Board {
    
    private Node[][] _board;
    private Node _begin;
    private Node _end;
    
    private Stack<Node> _path;
    
    private int _size;
    
    public Board(int size) {
        _size = size;
        _board= new Node[_size][_size];
        
        for(int i = 0; i < _size; i++)
            for(int j = 0; j < _size; j++)
                _board[i][j] = new Node(i, j, this);
               
        _begin = _board[0][0];
        _end   = _board[_size - 1][_size - 1];
    }
    
    public Board(int size, int barrier_percentage) {
        this(size);
        
        int quantity_blocked_fields = 
                        (barrier_percentage * (_size * _size)) / 100;
        int aux_random_number_x = 0;
        int aux_random_number_y = 0;
        
        // Generate the random numbers to set the blocked fields
        Random field_position = new Random();
        for (int i = 0; i < quantity_blocked_fields; i++) {
            aux_random_number_x = field_position.nextInt(_size);
            aux_random_number_y = field_position.nextInt(_size);
            
            // Check if the random value was already inserted
            while (!_board[aux_random_number_x][aux_random_number_y].isEmpty()) {
                aux_random_number_x = field_position.nextInt(_size);
                aux_random_number_y = field_position.nextInt(_size);
            
            }
            
            _board[aux_random_number_x][aux_random_number_y].markAsBloked();
        }
        
    
    }
    
    public Node get(int row, int col) {
        return this._board[row][col];
    }

    public int getSize() {
        return _size;
    }

    public Node getBegin() {
        return _begin;
    }

    public Node getEnd() {
        return _end;
    }
    
    public void set(Node path) {
        setPath(path);
        Node c = next();
        do{
            this._board[c.getRow()][c.getCol()].markAsPath();
        }while((c = next()) != null);
        
    }
    
    public void setPath(Node path){
        _path = new Stack<>();
        while(path.getParent() != null){
            _path.push(path);
            path = path.getParent();
        }
    }
    
    public Node next(){
        if(_path.empty())
            return null;
        return _path.pop();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < _size; i++) {
            for(int j = 0; j < _size; j++) {
                sb.append(_board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}