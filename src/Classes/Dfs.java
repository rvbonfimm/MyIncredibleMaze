package Classes;

import java.util.HashSet;
import java.util.Stack;

public class Dfs extends Search{
    
    private Stack<Path> _stack;
    
    public Dfs() {
        this._stack = new Stack<>();
    }
    
    @Override
    public boolean isEmpty() {
        return _stack.isEmpty();
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
        
        int i = 0;
        if(readRight(pos, path, board, memo))
            return;
        if(readDown(pos, path, board, memo))
            return;
        if(readUp(pos, path, board, memo))
            return;
        
        if(readLeft(pos, path, board, memo))
            return;
    }
  
}