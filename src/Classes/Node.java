package Classes;

import java.util.ArrayList;

public class Node {

    public static final char EMPTY = '*';
    public static final char BLOCKED = '#';
    public static final char PATH = 'x';
    public static final char BEGIN = 'B';
    public static final char END = 'E';

    private char _type = EMPTY;
    private int _row, _col;
    private Board _board;
    private Node _parent;
    private boolean _visited;

    private int     _cost;
    private int     _fcost;

    private int _level;
    
    public Node(int row, int col, Board b) {
        this._row = row;
        this._col = col;
        this._board = b;
        this._cost  = 0;
        this._fcost = 0;
        this._level = 0;
        this._visited = false;
        this._parent = null;
    }

    public boolean isVisited() {
        return _visited;
    }

    public void markAsVisited() {
        this._visited = true;
    }

    public void markAsNotVisited() {
        this._visited = false;
    }

    
    public int getFcost() {
        return _fcost;
    }

    public void setFcost(int _fcost) {
        this._fcost = _fcost;
    }
    
    public int getCost() {
        return _cost;
    }

    public void setCost(int _cost) {
        this._cost = _cost;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int _level) {
        this._level = _level;
    }
    
    
    
    public Node getSouth() {
        if (_row + 1 >= _board.getSize()) {
            return null;
        }

        return _board.get(_row + 1, _col);
    }

    public Node getNorth() {
        if (_row - 1 < 0) {
            return null;
        }

        return _board.get(_row - 1, _col);
    }

    public Node getEast() {
        if (_col + 1 >= _board.getSize()) {
            return null;
        }

        return _board.get(_row, _col + 1);
    }

    public Node getWest() {
        if (_col - 1 < 0) {
            return null;
        }

        return _board.get(_row, _col - 1);
    }
    
    public Node getSe(){
        if(_col + 1 >= _board.getSize() || _row + 1 >= _board.getSize())
            return null;
        
        return _board.get(_row + 1, _col + 1);
    }
    
    
    public Node getSo(){
        if(_col - 1 < 0 || _row + 1 >= _board.getSize())
            return null;
        
        return _board.get(_row + 1, _col - 1);
    }
    
    
    public Node getNe(){
        if(_col + 1 >= _board.getSize() || _row - 1 < 0)
            return null;
        
        return _board.get(_row - 1, _col + 1);
    }

    public Node getNo(){
        if(_col - 1 < 0 || _row - 1 < 0)
            return null;
        
        return _board.get(_row - 1, _col - 1);
    }
    
    public Node getParent() {
        return _parent;
    }

    public void setParent(Node parent) {
        this._parent = parent;
    }

    public void markAsBloked() {
        this._type = Node.BLOCKED;
    }

    public void markAsPath() {
        this._type = Node.PATH;
    }

    public void markAsEmpty() {
        this._type = Node.EMPTY;
    }

    public boolean isEmpty() {
        return this._type == Node.EMPTY || this._type == Node.BEGIN || this._type == Node.END;
    }
    
    public boolean isBlocked() {
        return this._type == Node.BLOCKED;
    }

    public char getType() {
        return _type;
    }
    /**
     * 
     * @return ArrayList com todos os vizinhos 
     */
    public ArrayList<Node> getAdjList() {
        /** 
         * 
         */
        Node u, d, r, l, no, ne, so, se;
        ArrayList<Node> ls;

        ls = new ArrayList<>();

        u = getNorth();
        d = getSouth();
        r = getEast();
        l = getWest();

        no = getNo();
        ne = getNe();
        so = getSo();
        se = getSe();
        
        if (u != null) {
            ls.add(u);
        }
        if (d != null) {
            ls.add(d);
        }
        if (r != null) {
            ls.add(r);
        }
        if (l != null) {
            ls.add(l);
        }
        
        if(no != null)
            ls.add(no);
        if(ne != null)
            ls.add(ne);
        if(so != null)
            ls.add(so);
        if(se != null)
            ls.add(se);

        return ls;
    }

    public void setType(char type) {
        this._type = type;
    }

    public int getRow() {
        return _row;
    }

    public int getCol() {
        return _col;
    }

    @Override
    public String toString() {
        return "" + this._type;// + " " + row + " " + col;
    }

    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        return other._row == this._row && other._col == this._col;
    }
    
    public static void main(String[] args) {
        
    }
}
