/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Search.Dfs;
import Search.Search;
import java.util.Stack;

/**
 *
 * @author EngComp
 */
public class Robo {
    /**
     *  Recebe um Board
     *  Faz uma busca em board
     *  recebe um caminho
     *  armazena o caminho
     *  
     * OBJETIVO: percorrer um caminho - nó por nó ate o final
     */
    private Board _board;
    private boolean _walk; 
    private Node _current;
    private Stack<Node> _path; 
    
    public Robo(Board board){
        _board = board;
        _walk  = false;
        _current = null;
    }
    
    public void searchByDFS() throws Search.NoSuchPathException{
        if(_walk == true)
            return;// se esta andando entao nao é possivel buscar caminhos
        Search s = new Dfs(_board);
        Node p = s.run();
        
        _path = new Stack<>();
        while(p.getParent() != null){
            _path.push(p);
            p = p.getParent();
        }
        
        next();
    }

    public boolean isWalk() {
        return _walk;
    }
    
    public void next(){
        if(_path == null)
            return;
        if(_walk == false)
            _walk = true;
        if(_path.isEmpty()) {
            _walk = false;
            _path = null;
            return;
        }
        if(_current != null)
            _board.set(_current.getRow(), _current.getCol(), Node.EMPTY);
        _current = _path.pop();
        _board.set(_current.getRow(), _current.getCol(), Node.PATH);
    }
    
    public static void main(String[] args){
        Board b = new Board(10, 5);
        Robo robo = new Robo(b);
        try {
            robo.searchByDFS();
            while(robo.isWalk())
                robo.next();
        }catch(Exception e) {}
        
        System.out.println("" + b);
    }
}
