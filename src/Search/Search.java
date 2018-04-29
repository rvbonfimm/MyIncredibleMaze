/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import java.util.ArrayList;
import Classes.Board;
import Classes.Node;

/**
 *
 * @author EngComp
 */
public abstract class Search {
    
    private Node  _begin;
    private Node  _target;
    private Node  _current;
    
    private Board _board;
    
    public Search(Board board) {
        this._board     = board;
        this._begin     = board.getBegin();
        this._target    = board.getEnd();
        
    }
    
    public abstract boolean isEmpty();
    public abstract Node remove();
    public abstract void add(Node current, Node parent);
    
    public Node run() { 
        add(_begin, null);
        
        while(!isEmpty()) {
            _current = remove();
           
            ArrayList<Node> nodes = _current.getAdjList();
            for(Node node : nodes) {
                add(node, _current);
                if(node.equals(_target))
                    return node;
            }
        }
        
        return null;
    }
}