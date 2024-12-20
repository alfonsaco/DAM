/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomoverbola;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alfonso
 */
public class JuegoBola extends javax.swing.JFrame {

    private int y;
    private int x;
    /**
     * Creates new form JuegoBola
     */
    public JuegoBola() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/juegomoverbola/images/icono.png")).getImage());
        
        // Se sustituye el panel por uno igual, para poder dibujar en él
        PanelBola panelBola = new PanelBola();
        panelBola.setBounds(ContenedorBola.getBounds()); 
        panelBola.setBackground(ContenedorBola.getBackground());
        ContenedorGeneral.remove(ContenedorBola);      
        ContenedorBola = panelBola;                    
        ContenedorGeneral.add(ContenedorBola);         
        ContenedorGeneral.revalidate();
        ContenedorGeneral.repaint();
       
        x=ContenedorBola.getWidth()/2;
        y=ContenedorBola.getHeight()/2;
        ContenedorBola.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ContenedorGeneral = new javax.swing.JPanel();
        ContenedorBola = new javax.swing.JPanel();
        GridBotones = new javax.swing.JPanel();
        BotonUP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonLeft = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BotonDown = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BotonRight = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ContenedorGeneral.setBackground(new java.awt.Color(204, 204, 204));
        ContenedorGeneral.setLayout(null);

        ContenedorBola.setBackground(new java.awt.Color(8, 8, 8));
        ContenedorBola.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        javax.swing.GroupLayout ContenedorBolaLayout = new javax.swing.GroupLayout(ContenedorBola);
        ContenedorBola.setLayout(ContenedorBolaLayout);
        ContenedorBolaLayout.setHorizontalGroup(
            ContenedorBolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        ContenedorBolaLayout.setVerticalGroup(
            ContenedorBolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        ContenedorGeneral.add(ContenedorBola);
        ContenedorBola.setBounds(20, 20, 337, 279);

        GridBotones.setOpaque(false);
        GridBotones.setLayout(new java.awt.GridBagLayout());

        BotonUP.setBackground(new java.awt.Color(153, 0, 0));
        BotonUP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juegomoverbola/images/up.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonUPLayout = new javax.swing.GroupLayout(BotonUP);
        BotonUP.setLayout(BotonUPLayout);
        BotonUPLayout.setHorizontalGroup(
            BotonUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );
        BotonUPLayout.setVerticalGroup(
            BotonUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        GridBotones.add(BotonUP, gridBagConstraints);

        BotonLeft.setBackground(new java.awt.Color(153, 0, 0));
        BotonLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juegomoverbola/images/left.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonLeftLayout = new javax.swing.GroupLayout(BotonLeft);
        BotonLeft.setLayout(BotonLeftLayout);
        BotonLeftLayout.setHorizontalGroup(
            BotonLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );
        BotonLeftLayout.setVerticalGroup(
            BotonLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        GridBotones.add(BotonLeft, gridBagConstraints);

        BotonDown.setBackground(new java.awt.Color(153, 0, 0));
        BotonDown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juegomoverbola/images/down.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonDownLayout = new javax.swing.GroupLayout(BotonDown);
        BotonDown.setLayout(BotonDownLayout);
        BotonDownLayout.setHorizontalGroup(
            BotonDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );
        BotonDownLayout.setVerticalGroup(
            BotonDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        GridBotones.add(BotonDown, gridBagConstraints);

        BotonRight.setBackground(new java.awt.Color(153, 0, 0));
        BotonRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juegomoverbola/images/right.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonRightLayout = new javax.swing.GroupLayout(BotonRight);
        BotonRight.setLayout(BotonRightLayout);
        BotonRightLayout.setHorizontalGroup(
            BotonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );
        BotonRightLayout.setVerticalGroup(
            BotonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        GridBotones.add(BotonRight, gridBagConstraints);

        ContenedorGeneral.add(GridBotones);
        GridBotones.setBounds(378, 47, 210, 207);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BOTÓN ARRIBA
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int minArr=ContenedorBola.getInsets().top;
        
        if(y > minArr) {
            y-=5;
        } else {
            y=minArr;
        }        
        ContenedorBola.repaint();
    }//GEN-LAST:event_jLabel1MouseClicked

    // BOTÓN ABAJO
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int minAbj=ContenedorBola.getHeight()-50;
        
        if(y < minAbj) {
            y+=5;   
        } else {
            y=minAbj;
        }        
        ContenedorBola.repaint();
    }//GEN-LAST:event_jLabel2MouseClicked

    // BOTÓN IZQUIERDA
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int minIzq=ContenedorBola.getInsets().left;
        
        if(x > minIzq) {
            x-=5;            
        } else {
            x=minIzq;
        }
        ContenedorBola.repaint();
    }//GEN-LAST:event_jLabel4MouseClicked

    // BOTÓN DERECHA
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int minDer=ContenedorBola.getWidth()-50;
        
        if(x < minDer) {
            x+=5;    
        } else {
            x=minDer;
        }
        ContenedorBola.repaint();        
    }//GEN-LAST:event_jLabel3MouseClicked

   // Clase interna para dibujar la bola
    private class PanelBola extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED); 
            g.fillOval(x, y, 50, 50);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoBola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoBola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoBola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoBola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoBola().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonDown;
    private javax.swing.JPanel BotonLeft;
    private javax.swing.JPanel BotonRight;
    private javax.swing.JPanel BotonUP;
    private javax.swing.JPanel ContenedorBola;
    private javax.swing.JPanel ContenedorGeneral;
    private javax.swing.JPanel GridBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
