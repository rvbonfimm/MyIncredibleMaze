package Views;

import Classes.Board;
import Classes.Node;
import Classes.Robo;
import Search.*;
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
    private final int image_pixel;
    private final String block_image;
    private final String floor_image;
    private int[][] begin;
    private int[][] end;
    private int[][] maze_map;

    private Board board;
    private Robo robo;
    private JPanel maze;
    private Search search;

    private int barrierPercentage;
    
    public JFrame_Maze(int dimension, int image_pixel, String block_image, String floor_image) {
        this.dimension = dimension;
        this.image_pixel = image_pixel;
        this.block_image = block_image;
        this.floor_image = floor_image;

        initComponents();

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

    private JComponent createMaze(int barrier_percentage) {
        maze = new JPanel();
        
        int maze_itens_quantity = dimension * dimension;

        // Set the dimension of the Maze
        maze_map = new int[dimension][dimension];
        
        // Set the blocked fields quantity
        int quantity_blocked_fields = (barrier_percentage * maze_itens_quantity) / 100;

        this.barrierPercentage = barrier_percentage;

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

        /*
        robo = new Robo(board);

        try {
            robo.searchByDFS();
            //search = new Greedy(board);
        } catch (Search.NoSuchPathException ex) {
            System.out.println("System Exception: " + ex);
        }
*/
        mountMazePanel();
        
        
        return maze;
    }

    public void mountMazePanel() {

        JPanel actual_maze = new JPanel();
                // Setting images that'll be used
        String img_begin = "assets/Floor_Origin_" + image_pixel + ".png";
        String img_dest = "assets/Floor_Destination_" + image_pixel + ".png";
        String img_floor = "assets/Floor_" + floor_image + "_" + image_pixel + ".png";
        String img_blockFloor = "assets/Barrier_" + block_image + "_" + image_pixel + ".png";
        String img_path = "assets/Found_Field_" + image_pixel + ".png";
        String img_notPath = "assets/Not_Found_Field_" + image_pixel + ".png";

        
        // Clear the actual maze
        this.jPanel_MazeContainer.removeAll();
        this.jPanel_MazeContainer.revalidate();
        this.jPanel_MazeContainer.repaint();

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
                    case Node.END:
                        icon = new ImageIcon(img_dest);
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
        jCheckBox_Amplitude = new javax.swing.JCheckBox();
        jCheckBox_Depth = new javax.swing.JCheckBox();
        jCheckBox_Limited_Depth = new javax.swing.JCheckBox();
        jCheckBox_Iterative_Deepening = new javax.swing.JCheckBox();
        jCheckBox_Bidirectional = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jButton_Run = new javax.swing.JButton();
        jButton_Next = new javax.swing.JButton();
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
            .addGap(0, 385, Short.MAX_VALUE)
        );
        jPanel_MazeContainerLayout.setVerticalGroup(
            jPanel_MazeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Métodos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jCheckBox_Amplitude.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox_Amplitude.setText("Amplitude");
        jCheckBox_Amplitude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_AmplitudeActionPerformed(evt);
            }
        });

        jCheckBox_Depth.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox_Depth.setText("Profundidade");
        jCheckBox_Depth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DepthActionPerformed(evt);
            }
        });

        jCheckBox_Limited_Depth.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox_Limited_Depth.setText("Prof. Limitada");
        jCheckBox_Limited_Depth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Limited_DepthActionPerformed(evt);
            }
        });

        jCheckBox_Iterative_Deepening.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox_Iterative_Deepening.setText("Aprof. Iterativo");
        jCheckBox_Iterative_Deepening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Iterative_DeepeningActionPerformed(evt);
            }
        });

        jCheckBox_Bidirectional.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox_Bidirectional.setText("Bidirecional");
        jCheckBox_Bidirectional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_BidirectionalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_Bidirectional)
                    .addComponent(jCheckBox_Iterative_Deepening)
                    .addComponent(jCheckBox_Limited_Depth)
                    .addComponent(jCheckBox_Depth)
                    .addComponent(jCheckBox_Amplitude))
                .addGap(47, 47, 47))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox_Amplitude)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox_Depth)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox_Limited_Depth)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox_Iterative_Deepening)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox_Bidirectional)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jButton_Run.setText("Rodar Labirinto");
        jButton_Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RunActionPerformed(evt);
            }
        });

        jButton_Next.setText("Proximo Passo");
        jButton_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Run)
                    .addComponent(jButton_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Run, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Next)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jTextField_Barrier_Fields_Percentage, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
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
                .addGap(48, 48, 48)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_MazeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addComponent(jPanel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox_AmplitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_AmplitudeActionPerformed
        if (this.jCheckBox_Amplitude.isSelected()) {
            
            this.jCheckBox_Depth.setSelected(false);
            this.jCheckBox_Limited_Depth.setSelected(false);
            this.jCheckBox_Iterative_Deepening.setSelected(false);
            this.jCheckBox_Bidirectional.setSelected(false);

            createMaze(this.barrierPercentage);
            
            robo = new Robo(board);

            try {
                robo.searchByBfs();
            } catch (Search.NoSuchPathException ex) {
                JOptionPane.showMessageDialog(null, "Caminho nao encontrado", "OPS", JOptionPane.WARNING_MESSAGE);
            }
            mountMazePanel();
            
        }
    }//GEN-LAST:event_jCheckBox_AmplitudeActionPerformed

    private void jCheckBox_DepthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DepthActionPerformed
        if (this.jCheckBox_Depth.isSelected()) {
            this.jCheckBox_Amplitude.setSelected(false);
            this.jCheckBox_Limited_Depth.setSelected(false);
            this.jCheckBox_Iterative_Deepening.setSelected(false);
            this.jCheckBox_Bidirectional.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_DepthActionPerformed

    private void jCheckBox_Limited_DepthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Limited_DepthActionPerformed
        if (this.jCheckBox_Limited_Depth.isSelected()) {
            this.jCheckBox_Amplitude.setSelected(false);
            this.jCheckBox_Depth.setSelected(false);
            this.jCheckBox_Iterative_Deepening.setSelected(false);
            this.jCheckBox_Bidirectional.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_Limited_DepthActionPerformed

    private void jCheckBox_Iterative_DeepeningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Iterative_DeepeningActionPerformed
        if (this.jCheckBox_Iterative_Deepening.isSelected()) {
            this.jCheckBox_Amplitude.setSelected(false);
            this.jCheckBox_Limited_Depth.setSelected(false);
            this.jCheckBox_Depth.setSelected(false);
            this.jCheckBox_Bidirectional.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_Iterative_DeepeningActionPerformed

    private void jCheckBox_BidirectionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_BidirectionalActionPerformed
        if (this.jCheckBox_Bidirectional.isSelected()) {
            this.jCheckBox_Amplitude.setSelected(false);
            this.jCheckBox_Limited_Depth.setSelected(false);
            this.jCheckBox_Iterative_Deepening.setSelected(false);
            this.jCheckBox_Depth.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_BidirectionalActionPerformed

    private void jCheckBox_Barrier_PercentageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_Barrier_PercentageItemStateChanged
        if (this.jCheckBox_Barrier_Percentage.isSelected()) {
            this.jTextField_Barrier_Fields_Percentage.setEditable(true);
            this.jTextField_Barrier_Fields_Percentage.requestFocus();
        } else {
            this.jTextField_Barrier_Fields_Percentage.setText("");
            this.jTextField_Barrier_Fields_Percentage.setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox_Barrier_PercentageItemStateChanged

    private void jButton_RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RunActionPerformed
        // Search the method chosen
        if (!this.jCheckBox_Amplitude.isSelected()
                && !this.jCheckBox_Depth.isSelected()
                && !this.jCheckBox_Limited_Depth.isSelected()
                && !this.jCheckBox_Iterative_Deepening.isSelected()
                && !this.jCheckBox_Bidirectional.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de selecionar algum dos métodos para execução.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
            this.jCheckBox_Amplitude.requestFocus();
            return;
        } else {
            String method_chosen = "";
            if (this.jCheckBox_Amplitude.isSelected()) {
                method_chosen = this.jCheckBox_Amplitude.getText();
            } else if (this.jCheckBox_Depth.isSelected()) {
                method_chosen = this.jCheckBox_Depth.getText();
            } else if (this.jCheckBox_Limited_Depth.isSelected()) {
                method_chosen = this.jCheckBox_Limited_Depth.getText();
            } else if (this.jCheckBox_Iterative_Deepening.isSelected()) {
                method_chosen = this.jCheckBox_Iterative_Deepening.getText();
            } else if (this.jCheckBox_Bidirectional.isSelected()) {
                method_chosen = this.jCheckBox_Bidirectional.getText();
            }
        }

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

        // Clear the Maze Container
        this.jPanel_MazeContainer.removeAll();

        // Update the component view
        jPanel_MazeContainer.revalidate();
        jPanel_MazeContainer.repaint();

        // Add the new Maze
        this.jPanel_MazeContainer.add(createMaze(barrier_percentage));
    }//GEN-LAST:event_jButton_RunActionPerformed

    private void jMenuItem_ClearMazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ClearMazeActionPerformed
        jPanel_MazeContainer.removeAll();
        jPanel_MazeContainer.revalidate();
        jPanel_MazeContainer.repaint();
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

    private void jButton_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NextActionPerformed
        robo.next();
        mountMazePanel();
    }//GEN-LAST:event_jButton_NextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Next;
    private javax.swing.JButton jButton_Run;
    private javax.swing.JCheckBox jCheckBox_Amplitude;
    private javax.swing.JCheckBox jCheckBox_Barrier_Percentage;
    private javax.swing.JCheckBox jCheckBox_Bidirectional;
    private javax.swing.JCheckBox jCheckBox_Depth;
    private javax.swing.JCheckBox jCheckBox_Iterative_Deepening;
    private javax.swing.JCheckBox jCheckBox_Limited_Depth;
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
    // End of variables declaration//GEN-END:variables
}
