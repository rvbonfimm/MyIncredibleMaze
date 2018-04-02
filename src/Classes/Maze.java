package Classes;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Maze extends JFrame {

    JScrollPane jsp = new JScrollPane();

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

        add(addComp());
        setSize(1000, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
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
    private JComponent addComp() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Labirinto"));

        //neste painel é que adicionaremos os chekboxes
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(x, y));

        System.out.println("Grid (X): " + x);
        System.out.println("Grid (Y): " + y);

        int maze_itens_quantity = x * y;

        System.out.println("Maze itens quantity: " + maze_itens_quantity);

        for (int i = 0; i < maze_itens_quantity; i++) {
            JLabel label = new JLabel();
            ImageIcon icon = new ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Maze\\src\\Static\\Floor_Field.png");
            label.setIcon(icon);
            p.add(label);
        }

        int preferred_size_axis_x = x * 40;
        int preferred_size_axis_y = y * 40;

        System.out.println("Preferred size (X): " + preferred_size_axis_x);
        System.out.println("Preferred size (Y): " + preferred_size_axis_y);

        // Define um tamanho do scrollpane
        jsp.setPreferredSize(new Dimension(preferred_size_axis_x, preferred_size_axis_y));

        // Define o painel de checkboxes como viewport do scrollpane
        jsp.setViewportView(p);
        painel.add(jsp);
        return painel;
    }
}
