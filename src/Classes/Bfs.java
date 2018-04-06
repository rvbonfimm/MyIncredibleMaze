/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author EngComp
 */
public class Bfs extends Search{

    private Queue<Path> _queue;
    
    public Bfs() {
        _queue = new LinkedList<Path>();
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

    private void put(Path path, Map<Position, Boolean> memo, Position pos) {
            memo.put(pos, Boolean.TRUE);
            add(new Path(pos, path));
    }
    
    private boolean isBlocked(Board board, byte r, byte c) {
        return board.get(r, c) == Board.BLOCKED;
    }
    
    
    
    @Override
    public boolean readNode(
                                Path path,
                                Board board, 
                                Map<Position, Boolean> memo, 
                                Position pos
                            ) 
    {
        byte row, col;
        row = pos.getRow();
        col = pos.getColumn();
        
        if( (byte)(row + 1) < board.getSize() 
                    && memo.get(new Position((byte)(row + 1), col)) == null
                    && !isBlocked(board, (byte)(row + 1), col))
            put(path, memo, new Position((byte)(row + 1), col));
        
        if( (byte)(row - 1) > -1 
                    && memo.get(new Position((byte)(row - 1), col)) == null 
                    && !isBlocked(board, (byte)(row - 1), col))
            put(path, memo, new Position((byte)(row -1), col));
    
        if( (byte)(col + 1) < board.getSize() 
                    && memo.get(new Position(row, (byte)(col + 1))) == null 
                    && !isBlocked(board, row, (byte)(col + 1)))
            put(path, memo, new Position(row, (byte)(col + 1)));
        
        if( (byte)(col - 1) > -1 
                    && memo.get(new Position(row, (byte)(col - 1))) == null 
                    && !isBlocked(board, row, (byte)(col - 1)))
            put(path, memo, new Position(row, (byte)(col - 1)));
           
        Path ver = _queue.element();
        if(ver.getPos().getRow() == board.getEnd().getRow() 
                && ver.getPos().getColumn() == board.getEnd().getColumn())
            return false;
        if(memo.size() == board.getSize() * board.getSize())
            return true;
        //System.out.println("" + ver.getPos().getRow() + " " + ver.getPos().getColumn());
        return true;
    }
    
    
}
