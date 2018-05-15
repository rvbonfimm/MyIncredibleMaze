package Views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JOptionPane;

public class JFrame_Specifications extends javax.swing.JFrame {

    public JFrame_Specifications() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Main = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Maze_Dimension = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel_ImageMazeSize = new javax.swing.JPanel();
        jCheckBox_Min_Pixel = new javax.swing.JCheckBox();
        jCheckBox_Max_Pixel = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_Run = new javax.swing.JButton();
        jPanel_BlockMazeItem = new javax.swing.JPanel();
        jCheckBox_Lava = new javax.swing.JCheckBox();
        jCheckBox_Fire = new javax.swing.JCheckBox();
        jCheckBox_Mini_Tree = new javax.swing.JCheckBox();
        jCheckBox_Tree = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel_FloorMazeItem = new javax.swing.JPanel();
        jCheckBox_Dark = new javax.swing.JCheckBox();
        jCheckBox_Nature = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton_Test = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel_Main.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dimensão do Labirinto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Dimensão:");

        jTextField_Maze_Dimension.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Maze_Dimension, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTextField_Maze_Dimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Configure seu Labirinto:");

        jPanel_ImageMazeSize.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_ImageMazeSize.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tamanho dos Itens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jCheckBox_Min_Pixel.setText("18 Pixels");
        jCheckBox_Min_Pixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Min_PixelActionPerformed(evt);
            }
        });

        jCheckBox_Max_Pixel.setText("36 Pixels");
        jCheckBox_Max_Pixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Max_PixelActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Barrier_Fire_18.png")); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Barrier_Fire_36.png")); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel_ImageMazeSizeLayout = new javax.swing.GroupLayout(jPanel_ImageMazeSize);
        jPanel_ImageMazeSize.setLayout(jPanel_ImageMazeSizeLayout);
        jPanel_ImageMazeSizeLayout.setHorizontalGroup(
            jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Min_Pixel)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Max_Pixel)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(42, 42, 42))))
        );
        jPanel_ImageMazeSizeLayout.setVerticalGroup(
            jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_Min_Pixel)
                    .addComponent(jCheckBox_Max_Pixel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(48, 48, 48))
        );

        jButton_Run.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Run.setText("Avançar");
        jButton_Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RunActionPerformed(evt);
            }
        });

        jPanel_BlockMazeItem.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_BlockMazeItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Barreira", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jCheckBox_Lava.setText("Lava");
        jCheckBox_Lava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_LavaActionPerformed(evt);
            }
        });

        jCheckBox_Fire.setText("Fogo");
        jCheckBox_Fire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_FireActionPerformed(evt);
            }
        });

        jCheckBox_Mini_Tree.setText("Mini-árvore");
        jCheckBox_Mini_Tree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Mini_TreeActionPerformed(evt);
            }
        });

        jCheckBox_Tree.setText("Árvore");
        jCheckBox_Tree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_TreeActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Barrier_Lava_36.png")); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Barrier_Mini-Tree_36.png")); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Barrier_Fire_36.png")); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Barrier_Tree_36.png")); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel_BlockMazeItemLayout = new javax.swing.GroupLayout(jPanel_BlockMazeItem);
        jPanel_BlockMazeItem.setLayout(jPanel_BlockMazeItemLayout);
        jPanel_BlockMazeItemLayout.setHorizontalGroup(
            jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BlockMazeItemLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBox_Lava))
                .addGap(26, 26, 26)
                .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBox_Fire))
                .addGap(18, 18, 18)
                .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BlockMazeItemLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Mini_Tree)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_BlockMazeItemLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_BlockMazeItemLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Tree)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_BlockMazeItemLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27))))
        );
        jPanel_BlockMazeItemLayout.setVerticalGroup(
            jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BlockMazeItemLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_BlockMazeItemLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Lava)
                        .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_BlockMazeItemLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel_BlockMazeItemLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_BlockMazeItemLayout.createSequentialGroup()
                        .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox_Mini_Tree)
                            .addComponent(jCheckBox_Tree)
                            .addComponent(jCheckBox_Fire))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_BlockMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_FloorMazeItem.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_FloorMazeItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo do Piso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jCheckBox_Dark.setText("Dark");
        jCheckBox_Dark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DarkActionPerformed(evt);
            }
        });

        jCheckBox_Nature.setText("Natural");
        jCheckBox_Nature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_NatureActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Floor_Nature_36.png")); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\roger\\Documents\\NetBeansProjects\\Merge_Maze\\maze\\assets\\Floor_Dark_36.png")); // NOI18N
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel_FloorMazeItemLayout = new javax.swing.GroupLayout(jPanel_FloorMazeItem);
        jPanel_FloorMazeItem.setLayout(jPanel_FloorMazeItemLayout);
        jPanel_FloorMazeItemLayout.setHorizontalGroup(
            jPanel_FloorMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FloorMazeItemLayout.createSequentialGroup()
                .addGroup(jPanel_FloorMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_FloorMazeItemLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jCheckBox_Nature)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_FloorMazeItemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel_FloorMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox_Dark, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel_FloorMazeItemLayout.setVerticalGroup(
            jPanel_FloorMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FloorMazeItemLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel_FloorMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_Dark)
                    .addComponent(jCheckBox_Nature))
                .addGap(18, 18, 18)
                .addGroup(jPanel_FloorMazeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_Test.setText("Default Test");
        jButton_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_MainLayout = new javax.swing.GroupLayout(jPanel_Main);
        jPanel_Main.setLayout(jPanel_MainLayout);
        jPanel_MainLayout.setHorizontalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_BlockMazeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_ImageMazeSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_FloorMazeItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MainLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel2))
                    .addGroup(jPanel_MainLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton_Test)
                        .addGap(114, 114, 114)
                        .addComponent(jButton_Run, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_MainLayout.setVerticalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_ImageMazeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_BlockMazeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_FloorMazeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Run, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Test))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void jCheckBox_Max_PixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Max_PixelActionPerformed
        if (this.jCheckBox_Max_Pixel.isSelected()) {
            this.jCheckBox_Min_Pixel.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_Max_PixelActionPerformed

    private void jCheckBox_Min_PixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Min_PixelActionPerformed
        if (this.jCheckBox_Min_Pixel.isSelected()) {
            this.jCheckBox_Max_Pixel.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_Min_PixelActionPerformed

    private void jButton_RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RunActionPerformed
        if (this.jTextField_Maze_Dimension.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de digitar o tamanho labirinto.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
            this.jTextField_Maze_Dimension.requestFocus();
            return;
        }

        // Cleck if the dimension passed will not burst the view
        if (!this.jCheckBox_Min_Pixel.isSelected() && !this.jCheckBox_Max_Pixel.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de escolher o tamanho da imagem do labirinto.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
            this.jCheckBox_Min_Pixel.requestFocus();
            return;
        }

        String block_image_chosen = "";

        if (!this.jCheckBox_Lava.isSelected()
                && !this.jCheckBox_Fire.isSelected()
                && !this.jCheckBox_Mini_Tree.isSelected()
                && !this.jCheckBox_Tree.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de selecionar ao menos um tipo de bloqueio para o labirinto.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
            this.jCheckBox_Lava.requestFocus();
            return;
        } else {
            if (this.jCheckBox_Lava.isSelected()) {
                block_image_chosen = "Lava";
            } else if (this.jCheckBox_Fire.isSelected()) {
                block_image_chosen = "Fire";
            } else if (this.jCheckBox_Mini_Tree.isSelected()) {
                block_image_chosen = "Mini-Tree";
            } else if (this.jCheckBox_Tree.isSelected()) {
                block_image_chosen = "Tree";
            }
        }

        String floor_image_chosen = "";

        if (!this.jCheckBox_Nature.isSelected() && !this.jCheckBox_Dark.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de selecionar ao menos um tipo de piso para o labirinto.", "Informações necessárias faltantes", JOptionPane.WARNING_MESSAGE);
            this.jCheckBox_Nature.requestFocus();
            return;
        } else {
            if (this.jCheckBox_Nature.isSelected()) {
                floor_image_chosen = "Nature";
            } else if (this.jCheckBox_Dark.isSelected()) {
                floor_image_chosen = "Dark";
            }
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width_resolution = screenSize.width;
        int dimension = Integer.parseInt(this.jTextField_Maze_Dimension.getText());
        int image_pixels;
        float quantity_permitted_itens;

        // The values 36 and 71 is a found number to check the max itens quantity permitted by actual resolution
        if (this.jCheckBox_Min_Pixel.isSelected()) {
            image_pixels = 18;
            quantity_permitted_itens = width_resolution / 36;
        } else {
            image_pixels = 36;
            quantity_permitted_itens = width_resolution / 72;
        }

        if (dimension > quantity_permitted_itens) {
            JOptionPane.showMessageDialog(null, "A dimensão digitada supera a capacidade permitida de sua resolução. Favor escolher um valor menor!", "Dimensão não permitida", JOptionPane.WARNING_MESSAGE);
            this.jTextField_Maze_Dimension.requestFocus();
            return;
        }

        JFrame_Maze m = new JFrame_Maze(dimension, image_pixels, block_image_chosen, floor_image_chosen);
    }//GEN-LAST:event_jButton_RunActionPerformed

    private void jCheckBox_LavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_LavaActionPerformed
        if (jCheckBox_Lava.isSelected()) {
            this.jCheckBox_Fire.setSelected(false);
            this.jCheckBox_Mini_Tree.setSelected(false);
            this.jCheckBox_Tree.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_LavaActionPerformed

    private void jCheckBox_FireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_FireActionPerformed
        if (jCheckBox_Fire.isSelected()) {
            this.jCheckBox_Lava.setSelected(false);
            this.jCheckBox_Mini_Tree.setSelected(false);
            this.jCheckBox_Tree.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_FireActionPerformed

    private void jCheckBox_Mini_TreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Mini_TreeActionPerformed
        if (jCheckBox_Mini_Tree.isSelected()) {
            this.jCheckBox_Fire.setSelected(false);
            this.jCheckBox_Lava.setSelected(false);
            this.jCheckBox_Tree.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_Mini_TreeActionPerformed

    private void jCheckBox_TreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_TreeActionPerformed
        if (jCheckBox_Tree.isSelected()) {
            this.jCheckBox_Fire.setSelected(false);
            this.jCheckBox_Mini_Tree.setSelected(false);
            this.jCheckBox_Lava.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_TreeActionPerformed

    private void jCheckBox_NatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_NatureActionPerformed
        if (this.jCheckBox_Nature.isSelected()) {
            this.jCheckBox_Dark.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_NatureActionPerformed

    private void jCheckBox_DarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DarkActionPerformed
        if (this.jCheckBox_Dark.isSelected()) {
            this.jCheckBox_Nature.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_DarkActionPerformed

    private void jButton_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TestActionPerformed
        JFrame_Maze m = new JFrame_Maze(15, 36, "Fire", "Dark");
    }//GEN-LAST:event_jButton_TestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Run;
    private javax.swing.JButton jButton_Test;
    private javax.swing.JCheckBox jCheckBox_Dark;
    private javax.swing.JCheckBox jCheckBox_Fire;
    private javax.swing.JCheckBox jCheckBox_Lava;
    private javax.swing.JCheckBox jCheckBox_Max_Pixel;
    private javax.swing.JCheckBox jCheckBox_Min_Pixel;
    private javax.swing.JCheckBox jCheckBox_Mini_Tree;
    private javax.swing.JCheckBox jCheckBox_Nature;
    private javax.swing.JCheckBox jCheckBox_Tree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_BlockMazeItem;
    private javax.swing.JPanel jPanel_FloorMazeItem;
    private javax.swing.JPanel jPanel_ImageMazeSize;
    private javax.swing.JPanel jPanel_Main;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_Maze_Dimension;
    // End of variables declaration//GEN-END:variables
}
