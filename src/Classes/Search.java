package Classes;


import java.util.ArrayList;
import java.util.HashSet;


public abstract class Search {

    private Board _board;
    private Path _current;
    private Position _target;
    private Position _begin;
    
    private HashSet<Position> _memo;
    
    public Search(Board board, Position begin, Position target) {
        this._board = board;
        this._begin = begin;
        this._target = target;
        this._memo = new HashSet<>();
        this._current = new Path(_begin, null);
     
    }
    
    public Search(Board board) {
        this._board = board;
        this._begin = board.getBegin();
        this._target = board.getEnd();
        this._memo = new HashSet<>();
        this._current = new Path(_begin, null);
    }
    
    public boolean isTarget(Position current) {
        return current.equals(this._target);
    }
    
    public abstract Path remove();
    
    private Position createPosition(int row, int col){
        return new Position((byte)row, (byte)col);
    }
    
    public ArrayList<Path> getNodes(Path path) {
        byte r, c;
        
        ArrayList<Path> ls = new ArrayList<Path>();
        r = path.getPos().getRow();
        c = path.getPos().getColumn();
        
        if(path.getPos().getRow() - 1 >= 0)
            ls.add(new Path(createPosition(r - 1, c), path));
        if(path.getPos().getColumn() - 1 >= 0)
            ls.add(new Path(createPosition(r, c - 1), path));
        if(path.getPos().getRow() + 1 <= _board.getSize() - 1 )
            ls.add(new Path(createPosition(r + 1, c), path));
        if(path.getPos().getColumn() + 1 <= _board.getSize() - 1 )
            ls.add(new Path(createPosition(r, c + 1), path));
        
        return ls;
    }
    
    public abstract void add(Path path);
    public abstract boolean isEmpty();
    private boolean isBlocked(Position pos){
        return _board.get(pos.getColumn(), pos.getRow()) == Board.BLOCKED;
    }
    
    public Path run() {
        
        do
            next();
        while(!isTarget(this._current.getPos()));
        
        return this._current;
    }
    
    public Position next() {
        if(!_memo.contains(this._current.getPos())){
            this._memo.add(_current.getPos());
            this.add(_current);
        }
        
        this._current = remove();
        ArrayList<Path> nodes = getNodes(this._current);
        for(Path path : nodes) {
            if(!_memo.contains(path.getPos()) && !isBlocked(path.getPos())) 
            {
                _memo.add(path.getPos());
                add(path);
            }
        }
        
        
        return this._current.getPos();
    }

    public Path getCurrent() {
        return _current;
    }
    
    
}
