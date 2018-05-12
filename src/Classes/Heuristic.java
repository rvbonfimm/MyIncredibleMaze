package Classes;

public class Heuristic {

    public static void row(Board board) {
        int cost = board.getSize() - 1;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Node node = board.get(i, j);
                node.setCost(node.getCost() + cost);
                //System.out.println("" + cost);
            }
            cost--;
        }
    }

    public static void col(Board board) {
        int cost = board.getSize() - 1;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Node node = board.get(j, i);
                node.setCost(node.getCost() + cost);
                //System.out.println("" + cost);
            }
            cost--;
        }
    }

    public static void manhattan(Board board) {
        Heuristic.col(board);
        Heuristic.row(board);
    }

    public static String out(Board board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                sb.append(board.get(i, j).getCost());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
