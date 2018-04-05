/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author EngComp
 */
public class Board {
    
    public static final char EMPTY   =    '0';
    public static final char BEGIN   =    'B';
    public static final char END     =    'E';
    public static final char BLOCKED =    '#';
    public static final char PATH    =    'x';
    private final byte _size;
    private Classes.Position _begin;
    private Classes.Position _end;
    private char _board[][];

    public Board(byte size) {
        this._size = size;
        this._begin = new Classes.Position((byte)0, (byte)0);
        this._end =   new Classes.Position((byte)(_size - 1), (byte)(_size - 1));
    
        _board = new char[_size][_size];
        
         for(int i = 0; i < _size; i++) {
             for(int j = 0; j < _size; j++) {
                 if(i == _begin.getRow() && j == _begin.getColumn())
                     _board[i][j] = Board.BEGIN;
                 else if(i == _end.getRow() && j == _end.getColumn())
                     _board[i][j] = Board.END;
                 else
                    _board[i][j] = Board.EMPTY;
             }
         }
    
    }
    
    public char get(byte r, byte c) {
        return _board[r][c];
    }
    
    public void set(byte r, byte c, char val) {
        _board[r][c] = val;
    }
    
    
    public void set(Path newpath) {
        Path t = newpath;
        while(t.getParent() != null) {
            _board[t.getPos().getRow()][t.getPos().getColumn()] = Board.PATH;
            t = t.getParent();
        }

        //TODO:
        return;
    }

    public byte getSize() {
        return _size;
    }

    public Position getBegin() {
        return _begin;
    }

    public Position getEnd() {
        return _end;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < _size; i++) {
             for(int j = 0; j < _size; j++) {
                 sb.append(_board[i][j]);
             }
             sb.append('\n');
         }
        return sb.toString();
    }
    
    public static void main(String[] args){
        Board board = new Board((byte)10);
        board.set((byte)2,(byte)0, BLOCKED);
        Search s = new Bfs();
        Path p = s.run(board);
        
        board.set(p);
        
        System.out.println(board);
        
    }
    
}
