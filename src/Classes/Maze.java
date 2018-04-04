package Classes;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
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
    private int[][] begin;
    private int[][] end;
    private int[][] maze_map;

    public Maze() {
    }

    public Maze(int x, int y, String method_chosen, int barrier_percentage) {
        this.x = x;
        this.y = y;
        this.barrier_percentage = barrier_percentage;

        add(createMaze());
        setSize(x * 75, y * 65);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private JComponent createMaze() {

        // Create the backend needs
        int maze_itens_quantity = x * y;

        Random r = new Random();

        int random_begin = r.nextInt(x) + 1;
        int random_end = r.nextInt(y) + 1;

        // specify the Begin and the End of the Maze
        int maze_begin[][] = new int[random_begin][0];
        int maze_end[][] = new int[0][random_end];

        // Set the dimension of the Maze
        maze_map = new int[x][y];

        // Set the blocked fields quantity
        int quantity_blocked_fields = (barrier_percentage * maze_itens_quantity) / 100;

        ArrayList<Integer> blocked_fields_manager = new ArrayList<>();

        Random field_position = new Random();

        int aux_random_number = 0;

        // Generate the random numbers to set the blocked fields
        for (int i = 0; i < quantity_blocked_fields; i++) {
            aux_random_number = field_position.nextInt(maze_itens_quantity);

            // Check if the random value was already inserted
            while (blocked_fields_manager.contains(aux_random_number)) {
                aux_random_number = field_position.nextInt(maze_itens_quantity);
            }

            blocked_fields_manager.add(aux_random_number);
        }

        // Create the front end needs
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Labirinto"));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(x, y));

        int counter = 0;

        // Initialize the Maze with a sequential value and set the normal and blocked fields
        for (int i = 0; i < maze_map.length; i++) {

            for (int j = 0; j < maze_map[0].length; j++) {

                maze_map[i][j] = counter;

                JLabel label = new JLabel();
                ImageIcon icon = null;

                if (blocked_fields_manager.contains(maze_map[i][j])) {
                    System.out.println("Found blocked field: " + maze_map[i][j]);
                    icon = new ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Maze\\src\\Static\\Fire_Field.png");
                } else {
                    icon = new ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Maze\\src\\Static\\Floor_Field.png");
                }

                label.setIcon(icon);
                p.add(label);

                counter++;
            }
        }

        int preferred_size_axis_x = x * 40;
        int preferred_size_axis_y = y * 40;

        // Define um tamanho do scrollpane
        jsp.setPreferredSize(new Dimension(preferred_size_axis_x, preferred_size_axis_y));

        // Define o painel de checkboxes como viewport do scrollpane
        jsp.setViewportView(p);
        painel.add(jsp);

        System.out.println("Maze length (X): " + maze_map.length);
        System.out.println("Maze length (Y): " + maze_map[0].length);
        System.out.println("Begin random (X): " + random_begin);
        System.out.println("End random (Y): " + random_end);
        System.out.println("Grid (X): " + x);
        System.out.println("Grid (Y): " + y);
        System.out.println("Maze itens quantity: " + maze_itens_quantity);
        System.out.println("Fire fieds quantity: " + quantity_blocked_fields);
        System.out.println("Blocked fields quantity: " + blocked_fields_manager.size());
        System.out.println("Preferred size (X): " + preferred_size_axis_x);
        System.out.println("Preferred size (Y): " + preferred_size_axis_y);
        return painel;
    }
}
