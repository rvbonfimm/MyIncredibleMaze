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
        return _queue.size() == 0;
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
