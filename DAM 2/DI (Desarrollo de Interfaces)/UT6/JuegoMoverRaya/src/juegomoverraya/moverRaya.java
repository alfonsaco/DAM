/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomoverraya;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alfonso
 */
public class moverRaya extends javax.swing.JFrame {

    private int x;
    /**
     * Creates new form moverRaya
     */
    public moverRaya() {
        initComponents();
        
        // Estilos del JFrame
        this.setSize(660, 390);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/juegomoverraya/images/icono.png")).getImage());
        
        x=ContenedorRaya.getWidth()/2-20;
        
        // Crear panel para dibujar
        PanelRaya panelRaya=new PanelRaya();
        panelRaya.setBounds(ContenedorRaya.getBounds()); 
        panelRaya.setBackground(ContenedorRaya.getBackground());
  
        ContenedorRaya.add(panelRaya);            
        ContenedorRaya.revalidate();
        ContenedorRaya.repaint();     
    }
    
    // Clase para dibujar la raya en el panel
    private class PanelRaya extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(93, 194, 148));
            g.fillRect(x, ContenedorRaya.getHeight()/4-10, 2, 100);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenedorGeneral = new javax.swing.JPanel();
        ContenedorRaya = new javax.swing.JPanel();
        BotonIzquierda = new javax.swing.JPanel();
        jLabelIzquierda = new javax.swing.JLabel();
        BotonDerecha = new javax.swing.JPanel();
        jLabelDerecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ContenedorGeneral.setBackground(new java.awt.Color(204, 204, 204));
        ContenedorGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContenedorRaya.setBackground(new java.awt.Color(7, 7, 7));

        javax.swing.GroupLayout ContenedorRayaLayout = new javax.swing.GroupLayout(ContenedorRaya);
        ContenedorRaya.setLayout(ContenedorRayaLayout);
        ContenedorRayaLayout.setHorizontalGroup(
            ContenedorRayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        ContenedorRayaLayout.setVerticalGroup(
            ContenedorRayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        ContenedorGeneral.add(ContenedorRaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 610, 240));

        BotonIzquierda.setBackground(new java.awt.Color(102, 102, 255));
        BotonIzquierda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabelIzquierda.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabelIzquierda.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIzquierda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIzquierda.setText("MOVER IZQUIERDA");
        jLabelIzquierda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIzquierdaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIzquierdaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIzquierdaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BotonIzquierdaLayout = new javax.swing.GroupLayout(BotonIzquierda);
        BotonIzquierda.setLayout(BotonIzquierdaLayout);
        BotonIzquierdaLayout.setHorizontalGroup(
            BotonIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIzquierda, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        BotonIzquierdaLayout.setVerticalGroup(
            BotonIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIzquierda, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        ContenedorGeneral.add(BotonIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 160, 50));

        BotonDerecha.setBackground(new java.awt.Color(102, 102, 255));
        BotonDerecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabelDerecha.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabelDerecha.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDerecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDerecha.setText("MOVER DERECHA");
        jLabelDerecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDerechaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDerechaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDerechaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BotonDerechaLayout = new javax.swing.GroupLayout(BotonDerecha);
        BotonDerecha.setLayout(BotonDerechaLayout);
        BotonDerechaLayout.setHorizontalGroup(
            BotonDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        BotonDerechaLayout.setVerticalGroup(
            BotonDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        ContenedorGeneral.add(BotonDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // HOVER DE LOS BOTONES
    private void jLabelDerechaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDerechaMouseEntered
        BotonDerecha.setBackground(new Color(141, 141, 204));
    }//GEN-LAST:event_jLabelDerechaMouseEntered

    private void jLabelDerechaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDerechaMouseExited
        BotonDerecha.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_jLabelDerechaMouseExited

    private void jLabelIzquierdaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIzquierdaMouseEntered
        BotonIzquierda.setBackground(new Color(141, 141, 204));
    }//GEN-LAST:event_jLabelIzquierdaMouseEntered

    private void jLabelIzquierdaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIzquierdaMouseExited
        BotonIzquierda.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_jLabelIzquierdaMouseExited

    // MOVER LA RAYA
    private void jLabelIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIzquierdaMouseClicked
        x-=5;
        ContenedorRaya.repaint();
    }//GEN-LAST:event_jLabelIzquierdaMouseClicked

    private void jLabelDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDerechaMouseClicked
        x+=5;
        ContenedorRaya.repaint();
    }//GEN-LAST:event_jLabelDerechaMouseClicked

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
            java.util.logging.Logger.getLogger(moverRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(moverRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(moverRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(moverRaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new moverRaya().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonDerecha;
    private javax.swing.JPanel BotonIzquierda;
    private javax.swing.JPanel ContenedorGeneral;
    private javax.swing.JPanel ContenedorRaya;
    private javax.swing.JLabel jLabelDerecha;
    private javax.swing.JLabel jLabelIzquierda;
    // End of variables declaration//GEN-END:variables
}