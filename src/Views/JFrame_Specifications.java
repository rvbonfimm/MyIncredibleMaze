package Views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JFrame_Specifications extends javax.swing.JFrame {

    public JFrame_Specifications() {
        initComponents();

        ImageIcon icon_18_pixels = new ImageIcon("assets/Barrier_Fire_18.png");
        ImageIcon icon_36_pixels = new ImageIcon("assets/Barrier_Fire_36.png");

        this.jLabel_18Pixels.setIcon(icon_18_pixels);
        this.jLabel_36Pixels.setIcon(icon_36_pixels);
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
        jLabel_18Pixels = new javax.swing.JLabel();
        jLabel_36Pixels = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_Run = new javax.swing.JButton();
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

        jLabel_18Pixels.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_36Pixels.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel_ImageMazeSizeLayout = new javax.swing.GroupLayout(jPanel_ImageMazeSize);
        jPanel_ImageMazeSize.setLayout(jPanel_ImageMazeSizeLayout);
        jPanel_ImageMazeSizeLayout.setHorizontalGroup(
            jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Min_Pixel)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jLabel_18Pixels)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel_ImageMazeSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jCheckBox_Max_Pixel)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ImageMazeSizeLayout.createSequentialGroup()
                        .addComponent(jLabel_36Pixels)
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
                    .addComponent(jLabel_18Pixels)
                    .addComponent(jLabel_36Pixels))
                .addGap(48, 48, 48))
        );

        jButton_Run.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Run.setText("Avançar");
        jButton_Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RunActionPerformed(evt);
            }
        });

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
                .addGap(81, 81, 81)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jPanel_ImageMazeSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
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
                .addGap(71, 71, 71)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_ImageMazeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129)
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

        String floor_image_chosen = "";

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

        JFrame_Maze m = new JFrame_Maze(dimension, image_pixels);
    }//GEN-LAST:event_jButton_RunActionPerformed

    private void jButton_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TestActionPerformed
        JFrame_Maze m = new JFrame_Maze(15, 36);
    }//GEN-LAST:event_jButton_TestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Run;
    private javax.swing.JButton jButton_Test;
    private javax.swing.JCheckBox jCheckBox_Max_Pixel;
    private javax.swing.JCheckBox jCheckBox_Min_Pixel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_18Pixels;
    private javax.swing.JLabel jLabel_36Pixels;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_ImageMazeSize;
    private javax.swing.JPanel jPanel_Main;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_Maze_Dimension;
    // End of variables declaration//GEN-END:variables
}
