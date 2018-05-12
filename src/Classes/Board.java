package Classes;

import java.util.Random;

public class Board {

    private Node[][] _board;
    private Node _begin;
    private Node _end;

    private int _size;

    public Board(int size, int quantity_blocked_itens, int origin_begin, int origin_end, int dest_begin, int dest_end) {
        _size = size;
        _board = new Node[_size][_size];

        for (int i = 0; i < _size; i++) {
            for (int j = 0; j < _size; j++) {
                _board[i][j] = new Node(i, j, this);
            }
        }

        _begin = _board[origin_begin][origin_end];
        _end = _board[dest_begin][dest_end];

        // Start to define the blocked fields with x and y random numbers
        int aux_random_number_x = 0;
        int aux_random_number_y = 0;

        // Generate the random numbers to set the blocked fields
        Random field_position = new Random();

        for (int i = 0; i < quantity_blocked_itens; i++) {
            aux_random_number_x = field_position.nextInt(_size);
            aux_random_number_y = field_position.nextInt(_size);

            // Check if the random value was already inserted
            while (!_board[aux_random_number_x][aux_random_number_y].isEmpty()) {
                aux_random_number_x = field_position.nextInt(_size);
                aux_random_number_y = field_position.nextInt(_size);

            }

            if (_board[aux_random_number_x][aux_random_number_y] != _begin
                    && _board[aux_random_number_x][aux_random_number_y] != _end) {
                _board[aux_random_number_x][aux_random_number_y].markAsBloked();
            }

        }
    }

    public Node get(int row, int col) {
        if (row >= _size || col >= _size) {
            return null;
        }

        return this._board[row][col];
    }

    public int getSize() {
        return _size;
    }

    public Node getBegin() {
        return _begin;
    }

    public Node getEnd() {
        return _end;
    }

    public void set(int row, int col, int type) {
        if (row >= _size || col >= _size) {
            return;
        }

        switch (type) {
            case Node.PATH:
                this._board[row][col].markAsPath();
                break;
            case Node.EMPTY:
                this._board[row][col].markAsEmpty();
                break;
            default:
                this._board[row][col].markAsBloked();
        }
    }

    /**
     * Recebe um Node após a realizacao de uma busca por uma das classes <br>
     * concretas de Search.
     *
     * @param path
     */
    public void set(Node path) {
        if (path == null) {
            return;
        }

        while (path.getParent() != null) {
            this._board[path.getRow()][path.getCol()].markAsPath();
            path = path.getParent();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _size; i++) {
            for (int j = 0; j < _size; j++) {
                sb.append(_board[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
