package Search;

import java.util.ArrayList;
import Classes.Board;
import Classes.Node;

public abstract class Search {

    public class NoSuchPathException extends Exception {
    }

    private Node _begin;
    private Node _target;
    private Node _current;

    private Board _board;

    public Search(Board board) {
        this._board = board;
        this._begin = board.getBegin();
        this._target = board.getEnd();
    }

    public Node getBegin() {
        return _begin;
    }

    public Node getTarget() {
        return _target;
    }

    public void setBegin(Node _begin) {
        this._begin = _begin;
    }

    public void setTarget(Node _target) {
        this._target = _target;
    }

    public Node getCurrent() {
        return _current;
    }

    public abstract boolean isEmpty();

    public abstract Node remove();

    public abstract void add(Node current, Node parent);

    /**
     * Realiza uma busca completa
     *
     * @return Nó objetivo com seus respectivos pais.
     * @throws Search.Search.NoSuchPathException
     */
    @SuppressWarnings("empty-statement")
    public Node run() throws NoSuchPathException {
        /**
         * A busca em sua forma mais geral.
         *
         */
        add(_begin, null);
        while (!isEmpty() && next());

        if (_current == null || !_current.equals(_target)) {
            throw new NoSuchPathException();
        }
        return _current;
    }

    /**
     * Representa cada iteracao em uma busca.<br>
     * Pode-se fazer sucessivas chamadas a este metodo até que se encontre o nó
     * objetivo.<br>
     * Este metodo nao funciona sem que se passe um nó inicial atraves <br>
     * do metodo add()
     *
     * @return Verdadeiro se o nó objetivo for encontrado, e falso caso
     * contrario
     */
    public boolean next() {

        _current = remove();
        if (_current.equals(_target)) {
            return false;
        }

        ArrayList<Node> nodes = _current.getAdjList();
        for (Node node : nodes) {
            add(node, _current);
        }

        return true;
    }
}
