package Classes;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
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

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        setSize(width, height);

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
        Board board = new Board((byte)x, (byte)quantity_blocked_fields);
        Search search = new Bfs();
        board.set(search.run(board));
        
        /*
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
        */
        // Create the front end needs
        JPanel outer_painel = new JPanel();

        JPanel maze_panel = new JPanel();
        maze_panel.setLayout(new GridLayout(x, y));
        //maze_panel.setBorder(BorderFactory.createTitledBorder("Labirinto"));

        int counter = 0;

        // Initialize the Maze with a sequential value and set the normal and blocked fields
        for (int i = 0; i < maze_map.length; i++) {

            for (int j = 0; j < maze_map[0].length; j++) {

                maze_map[i][j] = counter;

                JLabel label = new JLabel();
                ImageIcon icon = null;

                switch(board.get((byte)i, (byte)j)) {
                    case Board.BLOCKED: 
                        Classes.Debugger.debug(0, "Found blocked field: " + maze_map[i][j]);
                         icon = new ImageIcon("Assets/Fire_Field.png"); break;
                    case Board.EMPTY:
                        icon = new ImageIcon("Assets/Floor_Field.png"); break;
                    default:
                        icon = new ImageIcon("");
                }

                label.setIcon(icon);
                maze_panel.add(label);

                counter++;
            }
        }

        int preferred_size_axis_x = x * 37;
        int preferred_size_axis_y = y * 37;

        // Define o tamanho do scrollpane
        jsp.setPreferredSize(new Dimension(preferred_size_axis_x, preferred_size_axis_y));

        setLayout(new GridBagLayout());

        jsp.setViewportView(maze_panel);
        outer_painel.add(jsp);

        Classes.Debugger.debug(0, "Maze length (X): " + maze_map.length);
        Classes.Debugger.debug(0, "Maze length (Y): " + maze_map[0].length);
        Classes.Debugger.debug(0, "Begin random (X): " + random_begin);
        Classes.Debugger.debug(0, "End random (Y): " + random_end);
        Classes.Debugger.debug(0, "Grid (X): " + x);
        Classes.Debugger.debug(0, "Grid (Y): " + y);
        Classes.Debugger.debug(0, "Maze itens quantity: " + maze_itens_quantity);
        Classes.Debugger.debug(0, "Fire fieds quantity: " + quantity_blocked_fields);
        //Classes.Debugger.debug(0, "Blocked fields quantity: " + blocked_fields_manager.size());
        Classes.Debugger.debug(0, "Maze length (Y): " + maze_map[0].length);
        Classes.Debugger.debug(0, "Preferred size (Y): " + preferred_size_axis_y);
        Classes.Debugger.debug(0, "----------------------------------- END -------------------------");

        return outer_painel;
    }
}
