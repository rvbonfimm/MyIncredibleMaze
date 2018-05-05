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
public class Heuristic {
    private Board _board;
    
    public Heuristic(Board b){
        this._board = b;
    }
    
    public Heuristic row(){
        int cost = _board.getSize() - 1;
        for(int i = 0; i < _board.getSize(); i++) {
            for(int j = 0; j < _board.getSize(); j++) {
                _board.get(i, j).setCost(cost);
                //System.out.println("" + cost);
            }
            cost--;
        }
        return this;
    }
    
    
    public Heuristic col(){
        int cost = _board.getSize() - 1;
        for(int i = 0; i < _board.getSize(); i++) {
            for(int j = 0; j < _board.getSize(); j++) {
                _board.get(j, i).setCost(cost);
                //System.out.println("" + cost);
            }
            cost--;
        }
        return this;
    }
    
    public Heuristic manhattan(){
        return col().row();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < _board.getSize(); i++) {
            for(int j = 0; j < _board.getSize(); j++) {
                sb.append(_board.get(i, j).getCost());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
