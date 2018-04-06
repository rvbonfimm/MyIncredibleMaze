/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author EngComp
 */
public abstract class Search {
    public abstract boolean isEmpty();
    public abstract Path remove();
    public abstract void add(Path path);
    public abstract boolean readNode(   Path path,
                                        Board board, 
                                        Map<Position, 
                                        Boolean> memo, Position pos
                                    );
    public Path run(Board board) {
     
        Map<Position, Boolean> memo = new HashMap<Position, Boolean>();
        
        
        
        add(new Path(board.getBegin(), null));
        memo.put(board.getBegin(), true);
        
        while(isEmpty()) {
            Path p = remove();
            
            if(readNode(p, board, memo, p.getPos()) == false)
                break;
            
        }
        
        return remove();
    }
}
