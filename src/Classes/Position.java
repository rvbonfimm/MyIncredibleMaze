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
public class Position {
    private byte _row;
    private byte _column;
    
    public Position(byte row, byte col) {
        this._row = row;
        this._column = col;
    }

    public Position up(){
        return new Position((byte)(_row + 1), _column);
    }
    
    public Position down(){
        
        return new Position((byte)(_row - 1), _column);
    }
    
    public Position left(){
        return new Position(_row, (byte)(_column - 1));
    }
    
    public Position right(){
        return new Position(_row, (byte)(_column + 1));
    }
    
    
    public byte getRow() {
        return _row;
    }

    public byte getColumn() {
        return _column;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this._row != other._row) {
            return false;
        }
        if (this._column != other._column) {
            return false;
        }
        return true;
    }

    

}
