package Classes;

import java.util.Random;

public class Maze {

    private int x;
    private int y;
    private int barrier_percentage;
    private String method_chosen;
    private int[][] begin;
    private int[][] end;
    private int[][] maze_map;

    public Maze() {
    }

    public Maze(int x, int y, String method_chosen, int barrier_percentage) {
        this.x = x;
        this.y = y;
        this.method_chosen = method_chosen;
        this.barrier_percentage = barrier_percentage;
    }

    public boolean createMaze() {
        Random r = new Random();

        int random_begin = r.nextInt(x) + 1;
        int random_end = r.nextInt(y) + 1;
        System.out.println("Begin random (X): " + random_begin);
        System.out.println("End random (Y): " + random_end);

        // specify the Begin and End of the Maze
        int b[][] = new int[random_begin][0];
        int e[][] = new int[0][random_end];

        // Set the dimension of the Maze
        maze_map = new int[x][y];

        System.out.println("Maze length (X): " + maze_map.length);
        System.out.println("Maze length (Y): " + maze_map[0].length);

        int counter = 0;

        // Fill the Maze with a sequential value
        for (int i = 0; i < maze_map.length; i++) {
            for (int j = 0; j < maze_map[0].length; j++) {
                maze_map[i][j] = counter;
                counter++;
            }
        }

        return true;
    }

    // Show the maze values to each position
    public void showMaze() {
        for (int line = 0; line < maze_map.length; line++) {
            System.out.println("Line: " + line);
            for (int column = 0; column < maze_map[0].length; column++) {
                System.out.println("Maze values [" + line + "][" + column + "]: " + maze_map[line][column]);
            }
        }
    }
}
