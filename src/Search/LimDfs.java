package Search;

import Classes.Board;
import Classes.Node;

public class LimDfs extends Dfs {

    private int _limit;

    public LimDfs(Board board, int limit) {
        super(board);
        _limit = limit;
    }

    @Override
    public void add(Node current, Node parent) throws NoSuchPathException {
        if (parent != null) {
            current.setLevel(parent.getLevel() + 1);
        }

        System.out.println(current.getLevel());

        if (current.getLevel() > _limit) {
            throw new NoSuchPathException();
        }
        super.add(current, parent);
    }

    public static void main(String[] args) {
        Board board = new Board(10);
        Search search = new LimDfs(board, 10);
        try {
            Node path = search.run();
            board.set(path);
            System.out.println("" + board);
        } catch (NoSuchPathException e) {
        }
    }

}
