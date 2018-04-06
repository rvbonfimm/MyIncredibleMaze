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
public class Path {
    Position _pos;
    Path _parent;

    public Path(Position pos, Path parent) {
        this._pos = pos;
        this._parent = parent;
    }

    public Position getPos() {
        return _pos;
    }

    public Path getParent() {
        return _parent;
    }
    
    
}
