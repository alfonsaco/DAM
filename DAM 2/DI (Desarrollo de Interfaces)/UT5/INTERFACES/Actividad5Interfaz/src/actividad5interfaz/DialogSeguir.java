/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad5interfaz;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

/**
 *
 * @author Alfonso
 */
public class DialogSeguir extends javax.swing.JDialog {

    /**
     * Creates new form DialogBola
     */
    public DialogSeguir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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
        Seguir1 = new javax.swing.JPanel();
        Seguir2 = new javax.swing.JPanel();
        Seguir3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ContenedorGeneral.setBackground(new java.awt.Color(16, 16, 16));
        ContenedorGeneral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ContenedorGeneralMouseMoved(evt);
            }
        });

        Seguir1.setBackground(new java.awt.Color(255, 255, 102));
        Seguir1.setForeground(new java.awt.Color(255, 255, 102));
        Seguir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Seguir1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Seguir1Layout = new javax.swing.GroupLayout(Seguir1);
        Seguir1.setLayout(Seguir1Layout);
        Seguir1Layout.setHorizontalGroup(
            Seguir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        Seguir1Layout.setVerticalGroup(
            Seguir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        Seguir2.setBackground(new java.awt.Color(255, 255, 167));
        Seguir2.setPreferredSize(new java.awt.Dimension(23, 23));

        javax.swing.GroupLayout Seguir2Layout = new javax.swing.GroupLayout(Seguir2);
        Seguir2.setLayout(Seguir2Layout);
        Seguir2Layout.setHorizontalGroup(
            Seguir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        Seguir2Layout.setVerticalGroup(
            Seguir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        Seguir3.setBackground(new java.awt.Color(255, 255, 205));
        Seguir3.setPreferredSize(new java.awt.Dimension(14, 14));

        javax.swing.GroupLayout Seguir3Layout = new javax.swing.GroupLayout(Seguir3);
        Seguir3.setLayout(Seguir3Layout);
        Seguir3Layout.setHorizontalGroup(
            Seguir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        Seguir3Layout.setVerticalGroup(
            Seguir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContenedorGeneralLayout = new javax.swing.GroupLayout(ContenedorGeneral);
        ContenedorGeneral.setLayout(ContenedorGeneralLayout);
        ContenedorGeneralLayout.setHorizontalGroup(
            ContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorGeneralLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(Seguir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Seguir2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Seguir3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        ContenedorGeneralLayout.setVerticalGroup(
            ContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorGeneralLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(ContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Seguir3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seguir2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seguir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContenedorGeneralMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContenedorGeneralMouseMoved
        int x=evt.getX()-Seguir1.getWidth()/2;
        int y=evt.getY()-Seguir1.getHeight()/2;
        
        Seguir1.setLocation(x, y);
        
        // Timer para ponerle un delay al seguimiento
        Timer timer1=new Timer(150, e -> {
            Seguir2.setLocation(x, y);
        });
        
        // Para evitar que se repita, y de malos resultados
        timer1.setRepeats(false);
        timer1.start();
        
        Timer timer2=new Timer(300, e -> {
            Seguir3.setLocation(x, y);
        });
        
        timer2.setRepeats(false);
        timer2.start();
    }//GEN-LAST:event_ContenedorGeneralMouseMoved

    private void Seguir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Seguir1MouseClicked
        ContenedorGeneral.setBackground(new Color(190, 190, 190));
        
        Timer timer=new Timer(20, e-> {
           ContenedorGeneral.setBackground(new Color(16,16,16));
        });
        timer.setRepeats(false);
        timer.start();        
    }//GEN-LAST:event_Seguir1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorGeneral;
    private javax.swing.JPanel Seguir1;
    private javax.swing.JPanel Seguir2;
    private javax.swing.JPanel Seguir3;
    // End of variables declaration//GEN-END:variables
}
