/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashSet;

/**
 *
 * @author EngComp
 */
public abstract class Search {

    public abstract boolean isEmpty();
    public abstract Path remove();
    public abstract void add(Path path);
    public abstract Path element();
    
    
    public boolean isTarget(Board board){
        Path ver = element();
        if(ver.getPos().getRow() == board.getEnd().getRow() 
                && ver.getPos().getColumn() == board.getEnd().getColumn())
            return true;
        return false;
    }
    
    public abstract void readNode   
                                    (  
                                        Path path,
                                        Board board, 
                                        HashSet<Position> memo, 
                                        Position pos
                                    );
                                    
    public Path run(Board board) {
        HashSet<Position> memo = new HashSet<>();
        
        add(new Path(board.getBegin(), null));
        memo.add(board.getBegin());
        
        while(isEmpty() && !isTarget(board)) {
            Path p = remove();
            readNode(p, board, memo, p.getPos());
        }
        
        return remove();
    }
}
