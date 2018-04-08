/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashSet;
import java.util.LinkedList;

import java.util.Queue;

/**
 *
 * @author EngComp
 */
public class Bfs extends Search{

    private final Queue<Path> _queue;
    
    public Bfs() {
        _queue = new LinkedList<>();
    }
    
    @Override
    public boolean isEmpty() {
        return _queue.size() > 0;
    }

    @Override
    public Path remove() {
        return _queue.poll();
    }

    @Override
    public void add(Path path) {
        _queue.add(path);
    }

    @Override
    public Path element() {
        return _queue.element();
    }

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
        return true;
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
    
    @Override
    public void readNode(
                                Path path,
                                Board board, 
                                HashSet<Position> memo, 
                                Position pos
                        ) 
    {
        readLeft(pos, path, board, memo);
        readRight(pos, path, board, memo);
        readDown(pos, path, board, memo);
        readUp(pos, path, board, memo);
    }
    
}
