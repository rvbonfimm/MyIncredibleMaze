package Classes;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
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

        // Set the blocked fields quantity
        int quantity_blocked_fields = (barrier_percentage * maze_itens_quantity) / 100;

        Board board = new Board((byte)x, (byte)quantity_blocked_fields);
        Search search = new Bfs();
        board.set(search.run(board));
        
        // Create the front end needs
        JPanel outer_painel = new JPanel();

        JPanel maze_panel = new JPanel();
        maze_panel.setLayout(new GridLayout(x, y));
        //maze_panel.setBorder(BorderFactory.createTitledBorder("Labirinto"));

        // Initialize the Maze with a sequential value and set the normal and blocked fields
        for (int i = 0; i < board.getSize(); i++) {

            for (int j = 0; j < board.getSize(); j++) {

       
                JLabel label = new JLabel();
                ImageIcon icon = null;

                switch(board.get((byte)i, (byte)j)) {
                    case Board.BLOCKED: 
                         icon = new ImageIcon("Assets/Fire_Field.png"); break;
                    case Board.EMPTY:
                        icon = new ImageIcon("Assets/Floor_Field.png"); break;
                    default:
                        icon = new ImageIcon("Assets/Path_Field.png");
                }

                label.setIcon(icon);
                maze_panel.add(label);

            }
        }

        int preferred_size_axis_x = x * 37;
        int preferred_size_axis_y = y * 37;

        // Define o tamanho do scrollpane
        jsp.setPreferredSize(new Dimension(preferred_size_axis_x, preferred_size_axis_y));

        setLayout(new GridBagLayout());

        jsp.setViewportView(maze_panel);
        outer_painel.add(jsp);

        
        Classes.Debugger.debug(0, "Grid (X): " + x);
        Classes.Debugger.debug(0, "Grid (Y): " + y);
        Classes.Debugger.debug(0, "Maze itens quantity: " + maze_itens_quantity);
        Classes.Debugger.debug(0, "Fire fieds quantity: " + quantity_blocked_fields);
        //Classes.Debugger.debug(0, "Blocked fields quantity: " + blocked_fields_manager.size());
        
        Classes.Debugger.debug(0, "Preferred size (Y): " + preferred_size_axis_y);
        Classes.Debugger.debug(0, "----------------------------------- END -------------------------");

        return outer_painel;
    }
}
