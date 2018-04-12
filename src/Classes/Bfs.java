/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;

import java.util.Queue;

/**
 *
 * @author EngComp
 */
public class Bfs extends Search{

    private Queue<Path> _queue;
    
    public Bfs(Board board) {
        super(board);
        _queue = new LinkedList<Path>();
    }

    public Bfs(Board board, Position begin, Position target) {
        super(board, begin, target);
        _queue = new LinkedList<Path>();
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
    public boolean isEmpty() {
        return _queue.size() == 0;
    }
    
    
}
