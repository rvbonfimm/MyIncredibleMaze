package Classes;

import java.util.HashSet;
import java.util.Stack;

public class Dfs extends Search{

    private Stack<Path> _stack;
    
    public Dfs(Board board) {
        super(board);
        _stack = new Stack<>();
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
    public boolean isEmpty() {
        return _stack.size() == 0;
    }

    
  
    
}