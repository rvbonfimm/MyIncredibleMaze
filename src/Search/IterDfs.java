package Search;

import Classes.Board;
import Classes.Node;

public class IterDfs extends Dfs {

    private int _limit;

    public IterDfs(Board board) {
        super(board);
        _limit = 1;
    }

    public IterDfs(Board board, int limit) {
        super(board);
        _limit = limit;
    }

    @Override
    public void add(Node current, Node parent) throws NoSuchPathException {
        if (parent != null) {
            current.setLevel(parent.getLevel() + 1);
        }
        if (current.getLevel() > _limit) { // Faz o retrocesso até o nó inicial
            //System.out.println("" + _limit);
            Node temp = remove();
            while (!isEmpty()) { // Necessario desmarcar campos de pai e visitado
                temp.markAsNotVisited();
                temp.setParent(null);
                temp = remove();
            }
            // adiciona o nó inicial e aumenta o limite da profundidade
            add(temp, null);
            _limit++;
            return;
        }

        super.add(current, parent);
    }

    public static void main(String[] args) {
        Board board = new Board(20);
        Search search = new IterDfs(board);
        try {
            Node path = search.run();
            board.set(path);
            System.out.println("" + board);
        } catch (NoSuchPathException e) {
        }
    }
}
