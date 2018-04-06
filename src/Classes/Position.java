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

    public byte getRow() {
        return _row;
    }

    public byte getColumn() {
        return _column;
    }
    
}
