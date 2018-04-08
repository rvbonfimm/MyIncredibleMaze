/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author EngComp
 */
public class Dfs extends Bfs{
    
    private Stack<Path> _stack;
    
    public Dfs() {
        this._stack = new Stack<>();
    }
    
    @Override
    public boolean isEmpty() {
        return _stack.size() > 0;
    }

    @Override
    public Path remove() {
        return _stack.pop();
    }

    @Override
    public void add(Path path) {
        _stack.push(path);
    }

    @Override
    public Path element() {
        return _stack.peek();
    }
    
    @Override
    public void readNode(
                                Path path,
                                Board board, 
                                HashSet<Position> memo, 
                                Position pos
                            ) 
    {
        if(readLeft(pos, path, board, memo))
            return;
        if(readRight(pos, path, board, memo))
            return;
        if(readDown(pos, path, board, memo))
            return;
        if(readUp(pos, path, board, memo))
            return;
        
    }
  
}
