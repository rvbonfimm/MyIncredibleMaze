package Views;

import Classes.Board;
import Classes.Node;
import Classes.Robo;
import Search.Search;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrame_Maze extends javax.swing.JFrame {

    private final int dimension;
    private int image_pixel;
    private String block_image;
    private String floor_image;
    private int[][] maze_map;

//    private final String img_begin = "assets/Floor_Origin_" + image_pixel + ".png";
//    private final String img_dest = "assets/Floor_Destination_" + image_pixel + ".png";
//    private final String img_floor = "assets/Floor_" + floor_image + "_" + image_pixel + ".png";
//    private final String img_blockFloor = "assets/Barrier_" + block_image + "_" + image_pixel + ".png";
//    private final String img_path = "assets/Found_Field_" + image_pixel + ".png";
//    private final String img_notPath = "assets/Not_Found_Field_" + image_pixel + ".png";
    private final String img_begin = "assets/Floor_Origin_36.png";
    private final String img_dest = "assets/Floor_Destination_36.png";
    private final String img_floor = "assets/Floor_Dark_36.png";
    private final String img_blockFloor = "assets/Barrier_Fire_36.png";
    private final String img_path = "assets/Found_Field_36.png";
    private final String img_notPath = "assets/Not_Found_Field_36.png";

    private Board board;
    private Robo robo;

    public JFrame_Maze(int dimension, int image_pixel, String block_image, String floor_image) {
        this.dimension = dimension;
        this.image_pixel = image_pixel;
        this.block_image = block_image;
        this.floor_image = floor_image;

        initComponents();

        this.jTextField_MethodInput.setEnabled(false);

        // Initialize the Maze (Only basic floor)
        this.jPanel_MazeContainer.add(initializeMaze());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(screenSize.width, screenSize.height);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JComponent initializeMaze() {
        JPanel maze = new JPanel();

        maze_map = new int[dimension][dimension];

        maze.setLayout(new GridLayout(dimension, dimension));
        maze.setSize(dimension, dimension);

        String mounted_image = "assets/Floor" + "_" + floor_image + "_" + image_pixel + ".png";

        // Set the normal and blocked fields
        for (int i = 0; i < maze_map.length; i++) {
            for (int j = 0; j < maze_map[0].length; j++) {
                JLabel label = new JLabel();
                ImageIcon icon = null;
                icon = new ImageIcon(mounted_image);
                label.setIcon(icon);
                maze.add(label);
            }
        }

        jPanel_MazeContainer.setLayout(new GridBagLayout());

        return maze;
    }

    private void createMaze(int barrier_percentage, String method_chosen) {
        int maze_itens_quantity = dimension * dimension;

        // Set the dimension of the Maze
        maze_map = new int[dimension][dimension];

        // Set the blocked fields quantity
        int quantity_blocked_fields = (barrier_percentage * maze_itens_quantity) / 100;

        // Generate a random number between 0 and 1 to know the Origin and Destination flow
        Random mf = new Random();
        Random r = new Random();

        int origin_position_x = 0;
        int origin_position_y = 0;
        int destination_position_x = 0;
        int destination_position_y = 0;

        int maze_flow = mf.nextInt(2);

        int tmp_random_number_begin = r.nextInt(dimension);
        int tmp_random_number_end = r.nextInt(dimension);

        if (maze_flow == 0) {
            origin_position_x = tmp_random_number_begin;
            origin_position_y = 0;
            destination_position_x = tmp_random_number_end;
            destination_position_y = dimension - 1;
        } else {
            origin_position_x = 0;
            origin_position_y = tmp_random_number_begin;
            destination_position_x = dimension - 1;
            destination_position_y = tmp_random_number_end;
        }

        board = new Board(dimension, quantity_blocked_fields, origin_position_x, origin_position_y, destination_position_x, destination_position_y);

        robo = new Robo(board);

        try {
            switch (method_chosen) {
                case "Amplitude":
                    robo.searchByBfs();
                    break;
                case "Profundidade":
                    robo.searchByDfs();
                    break;
                case "Prof. Limitada":
                    System.out.println("Ainda nã está pronto.");
                    break;
                case "Aprof. Iterativo":
                    System.out.println("Ainda nã está pronto.");
                    break;
                case "Bidirecional":
                    robo.searchByBidir();
                    break;
                case "Greedy":
                    robo.searchByGreedy();
                    break;
                case "Custo Uniforme":
                    robo.searchByCustoUniforme();
                    break;
                case "A*":
                    robo.searchByAs();
                    break;
            }
        } catch (Search.NoSuchPathException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum caminho encontrado.", "Busca de caminho", JOptionPane.INFORMATION_MESSAGE);
            clearMaze();
        }

        mountMazePanel();

        // Center the Maze at the Maze Container jPanel
        jPanel_MazeContainer.setLayout(new GridBagLayout());
        
        
    }

    public void clearMaze() {
        this.jPanel_MazeContainer.removeAll();
        this.jPanel_MazeContainer.revalidate();
        this.jPanel_MazeContainer.repaint();
    }

    public void mountMazePanel() {
        JPanel actual_maze = new JPanel();

        clearMaze();

        actual_maze.setLayout(new GridLayout(dimension, dimension));
        actual_maze.setSize(dimension, dimension);

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                JLabel label = new JLabel();
                ImageIcon icon = null;

                switch (board.get(i, j).getType()) {
                    case Node.BEGIN:
                        icon = new ImageIcon(img_begin);
                        break;
                    case Node.BLOCKED:
                        icon = new ImageIcon(img_blockFloor);
                        break;
                    case Node.EMPTY:
                        icon = new ImageIcon(img_floor);
                        break;
                    case Node.PATH:
                        icon = new ImageIcon(img_path);
                        break;
                    case Node.END:
                        icon = new ImageIcon(img_dest);
                        break;
                }

                label.setIcon(icon);
                actual_maze.add(label);
            }
        }

        this.jPanel_MazeContainer.add(actual_maze);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Main = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel_MazeContainer = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox_Methods = new javax.swing.JComboBox<>();
        jTextField_MethodInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton_NextStep = new javax.swing.JButton();
        jButton_Run = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox_Barrier_Percentage = new javax.swing.JCheckBox();
        jTextField_Barrier_Fields_Percentage = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_Close = new javax.swing.JMenuItem();
        jMenuItem_Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_ClearMaze = new javax.swing.JMenuItem();
        jMenuItem_ResetMaze = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Main.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel_MazeContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_MazeContainerLayout = new javax.swing.GroupLayout(jPanel_MazeContainer);
        jPanel_MazeContainer.setLayout(jPanel_MazeContainerLayout);
        jPanel_MazeContainerLayout.setHorizontalGroup(
            jPanel_MazeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel_MazeContainerLayout.setVerticalGroup(
            jPanel_MazeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Métodos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jComboBox_Methods.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Amplitude", "Profundidade", "Prof. Limitada", "Aprof. Iterativo", "Bidirecional", "Greedy", "Custo Uniforme", "A*" }));
        jComboBox_Methods.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_MethodsItemStateChanged(evt);
            }
        });

        jLabel1.setText("Entrada");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox_Methods, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_MethodInput, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jComboBox_Methods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_MethodInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jButton_NextStep.setText("Passo a Passo");
        jButton_NextStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NextStepActionPerformed(evt);
            }
        });

        jButton_Run.setText("Rodar Labirinto");
        jButton_Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_NextStep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton_NextStep, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Run, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuração", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Barreira (%):");

        jCheckBox_Barrier_Percentage.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_Barrier_Percentage.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jCheckBox_Barrier_Percentage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_Barrier_PercentageItemStateChanged(evt);
            }
        });

        jTextField_Barrier_Fields_Percentage.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_Barrier_Percentage)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Barrier_Fields_Percentage, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_Barrier_Fields_Percentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBox_Barrier_Percentage)
                        .addComponent(jLabel5)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_MainLayout = new javax.swing.GroupLayout(jPanel_Main);
        jPanel_Main.setLayout(jPanel_MainLayout);
        jPanel_MainLayout.setHorizontalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_MazeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel_MainLayout.setVerticalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MainLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 129, Short.MAX_VALUE))
                    .addComponent(jPanel_MazeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenuBar1.setBackground(java.awt.Color.white);

        jMenu1.setIcon(new javax.swing.ImageIcon("/home/eliseuvidaloca/Documents/Development/Java/maze/assets/settings.png")); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(70, 50));

        jMenuItem_Close.setText("Fechar Tela");
        jMenuItem_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CloseActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Close);

        jMenuItem_Exit.setText("Fechar Aplicação");
        jMenuItem_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon("/home/eliseuvidaloca/Documents/Development/Java/maze/assets/maze_symbol_mini.png")); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(110, 50));

        jMenuItem_ClearMaze.setText("Limpar Labirinto");
        jMenuItem_ClearMaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ClearMazeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_ClearMaze);

        jMenuItem_ResetMaze.setText("Redefinir Labirinto");
        jMenuItem_ResetMaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ResetMazeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_ResetMaze);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox_Barrier_PercentageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_Barrier_PercentageItemStateChanged
        if (this.jCheckBox_Barrier_Percentage.isSelected()) {
            this.jTextField_Barrier_Fields_Percentage.setEditable(true);
            this.jTextField_Barrier_Fields_Percentage.requestFocus();
        } else {
            this.jTextField_Barrier_Fields_Percentage.setText("");
            this.jTextField_Barrier_Fields_Percentage.setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox_Barrier_PercentageItemStateChanged

    private void jButton_NextStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NextStepActionPerformed
        robo.next();
        mountMazePanel();
    }//GEN-LAST:event_jButton_NextStepActionPerformed

    private void jMenuItem_ClearMazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ClearMazeActionPerformed
        clearMaze();
        jPanel_MazeContainer.add(initializeMaze());
    }//GEN-LAST:event_jMenuItem_ClearMazeActionPerformed

    private void jMenuItem_ResetMazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ResetMazeActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem_ResetMazeActionPerformed

    private void jMenuItem_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem_CloseActionPerformed

    private void jMenuItem_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem_ExitActionPerformed

    private void jComboBox_MethodsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_MethodsItemStateChanged
        if (this.jComboBox_Methods.getSelectedItem().equals("Prof. Limitada")
                || this.jComboBox_Methods.getSelectedItem().equals("Aprof. Iterativo")) {
            this.jTextField_MethodInput.setEnabled(true);
            this.jTextField_MethodInput.requestFocus();
        } else {
            this.jTextField_MethodInput.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox_MethodsItemStateChanged

    private void jButton_RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RunActionPerformed
        // Search the method chosen
        if (this.jComboBox_Methods.getSelectedItem().equals("Selecionar")) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de selecionar algum dos métodos para execução.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
            this.jComboBox_Methods.requestFocus();
            return;
        }

        String method_chosen = String.valueOf(this.jComboBox_Methods.getSelectedItem());

        // Check if the barrier percentage was setted
        int barrier_percentage = 0;

        if (this.jCheckBox_Barrier_Percentage.isSelected()) {
            if (this.jTextField_Barrier_Fields_Percentage.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Você esqueceu de digitar a porcentagem de barreiras do labirinto.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
                this.jTextField_Barrier_Fields_Percentage.requestFocus();
                return;
            } else {
                barrier_percentage = Integer.parseInt(this.jTextField_Barrier_Fields_Percentage.getText());

                if (barrier_percentage < 1 || barrier_percentage > 99) {
                    JOptionPane.showMessageDialog(null, "Porcentagem das barreiras permitido apenas entre 1 e 99.", "Informações não permitidas", JOptionPane.WARNING_MESSAGE);
                    this.jTextField_Barrier_Fields_Percentage.requestFocus();
                    return;
                }
            }
        } else {
            Random barrier = new Random();
            barrier_percentage = barrier.nextInt(25);
        }

        clearMaze();

        // Add the new Maze
        createMaze(barrier_percentage, method_chosen);
    }//GEN-LAST:event_jButton_RunActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_NextStep;
    private javax.swing.JButton jButton_Run;
    private javax.swing.JCheckBox jCheckBox_Barrier_Percentage;
    private javax.swing.JComboBox<String> jComboBox_Methods;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_ClearMaze;
    private javax.swing.JMenuItem jMenuItem_Close;
    private javax.swing.JMenuItem jMenuItem_Exit;
    private javax.swing.JMenuItem jMenuItem_ResetMaze;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel_Main;
    private javax.swing.JPanel jPanel_MazeContainer;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField_Barrier_Fields_Percentage;
    private javax.swing.JTextField jTextField_MethodInput;
    // End of variables declaration//GEN-END:variables
}
