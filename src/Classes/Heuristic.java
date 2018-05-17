package Classes;

public class Heuristic {
    public static void row(Board board){
        int cost = 0;
        for(int i = board.getEnd().getRow(); i >= 0; i--) {
            for(int j = 0; j < board.getSize(); j++) {
                Node node = board.get(i, j);
                node.setCost(node.getCost() + cost);
            }
            cost++;
        }
        cost = 1;
        for(int i = board.getEnd().getRow() + 1; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                Node node = board.get(i, j);
                node.setCost(node.getCost() + cost);
            }
            cost++;
        }
    }
    public static void col(Board board){
        int cost = 0;
        for(int i = board.getEnd().getCol(); i >= 0; i--) {
            for(int j = 0; j < board.getSize(); j++) {
                Node node = board.get(j, i);
                node.setCost(node.getCost() + cost);
            }
            cost++;
        }
        cost = 1;
        for(int i = board.getEnd().getCol() + 1; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                Node node = board.get(j, i);
                node.setCost(node.getCost() + cost);
            }
            cost++;
        }
        
    }
    /**
     * Diatancia da linha e coluna de board.getEnd() para qualquer nó
     * de Board
     * <br>
     *   6 | 5 | 4 | 3 | 2 |  <br>
     *   5 | 4 | 3 | 2 | 1 |  <br>
     *   4 | 3 | 2 | 1 | 0 |----- Board.getEnd() <br>
     *   5 | 4 | 3 | 2 | 1 | <br>
     *   6 | 5 | 4 | 3 | 2 | <br>
     * <br>
     * 
     * @param board 
     */
    public static void manhattan(Board board) {
        Heuristic.col(board);
        Heuristic.row(board);
    }

    public static String out(Board board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                sb.append(board.get(i, j).getCost());
                sb.append(" | ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        Board b = new Board(5);
        b.setEnd(b.get(2, 4));
        Heuristic.manhattan(b);
        
        System.out.println("" + out(b));
        System.out.println("" + b);
    }
}   
