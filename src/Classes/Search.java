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
    
    private void put(Path path, HashSet<Position> memo, Position pos) {
        memo.add(pos);
        add(new Path(pos, path));
    }
    
    private boolean isBlocked(Board board, Position pos) {
        return board.get(pos.getRow(), pos.getColumn()) == Board.BLOCKED;
    }

    public boolean readUp(Position pos, Path path, Board board, HashSet<Position> memo){
        if( pos.up().getRow() < board.getSize() 
                    && !memo.contains(pos.up())
                    && !isBlocked(board, pos.up())) {
        
            put(path, memo, pos.up());
            return true;
        }
        return false;
    }
    public boolean readDown(Position pos, Path path, Board board, HashSet<Position> memo) {
        if( pos.down().getRow() > -1 
                    && !memo.contains(pos.down())
                    && !isBlocked(board, pos.down())) {
         
            put(path, memo, pos.down());
            return true;

        }
        return false;
    }
    public boolean readRight(Position pos, Path path, Board board, HashSet<Position> memo) {
        if( pos.right().getColumn() < board.getSize() 
                    && !memo.contains(pos.right())
                    && !isBlocked(board, pos.right())) {
            put(path, memo, pos.right());
            return true;
        }
        return false;
    }
    public boolean readLeft(Position pos, Path path, Board board, HashSet<Position> memo) {
        if( pos.left().getColumn() > -1 
                    && !memo.contains(pos.left() )
                    && !isBlocked(board, pos.left())) {
            
            put(path, memo, pos.left());
            return true;
        }   
        return false;
    }

    
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
        
        while(!isEmpty()){// && !isTarget(board)) {
            Path p = remove();
            readNode(p, board, memo, p.getPos());
            if(isTarget(board))
                break;
        }
        
        return remove();
    }
}
