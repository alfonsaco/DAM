/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosdialogs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PROGRAMACION
 */
public class EscogerPersonaje extends javax.swing.JDialog {

    private String nombre;
    /**
     * Creates new form EscogerPersonaje
     */
    // Constructor con el parámetro nombre, para poder utilizarlo
    public EscogerPersonaje(java.awt.Frame parent, boolean modal, String nombre) {
        super(parent, modal);
        this.nombre = nombre;
        initComponents();
        saludar();
    }

    // En caso de error
    private EscogerPersonaje(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelMensaje = new javax.swing.JLabel();
        RadioButtons = new javax.swing.JPanel();
        jRadioButtonAlfil = new javax.swing.JRadioButton();
        jRadioButtonCaballo = new javax.swing.JRadioButton();
        jRadioButtonTorre = new javax.swing.JRadioButton();
        BotonEscoger = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMensajeFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(238, 238, 210));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensaje.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(91, 117, 76));
        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensaje.setText("Texto de Ejemplo");
        jPanel1.add(jLabelMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 14, 361, 95));

        RadioButtons.setBackground(new java.awt.Color(238, 238, 210));
        RadioButtons.setLayout(new java.awt.GridLayout(1, 3));

        buttonGroup1.add(jRadioButtonAlfil);
        jRadioButtonAlfil.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jRadioButtonAlfil.setForeground(new java.awt.Color(91, 117, 76));
        jRadioButtonAlfil.setText("♗");
        RadioButtons.add(jRadioButtonAlfil);

        buttonGroup1.add(jRadioButtonCaballo);
        jRadioButtonCaballo.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jRadioButtonCaballo.setForeground(new java.awt.Color(91, 117, 76));
        jRadioButtonCaballo.setText("♘");
        RadioButtons.add(jRadioButtonCaballo);

        buttonGroup1.add(jRadioButtonTorre);
        jRadioButtonTorre.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jRadioButtonTorre.setForeground(new java.awt.Color(91, 117, 76));
        jRadioButtonTorre.setText("♖");
        RadioButtons.add(jRadioButtonTorre);

        jPanel1.add(RadioButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 320, 60));

        BotonEscoger.setBackground(new java.awt.Color(71, 90, 51));
        BotonEscoger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 68, 38), 2));
        BotonEscoger.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEscoger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEscogerMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 223, 197));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESCOGER");

        javax.swing.GroupLayout BotonEscogerLayout = new javax.swing.GroupLayout(BotonEscoger);
        BotonEscoger.setLayout(BotonEscogerLayout);
        BotonEscogerLayout.setHorizontalGroup(
            BotonEscogerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        BotonEscogerLayout.setVerticalGroup(
            BotonEscogerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(BotonEscoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 170, 140, 50));

        jLabelMensajeFinal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelMensajeFinal.setForeground(new java.awt.Color(91, 117, 76));
        jLabelMensajeFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelMensajeFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 240, 400, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEscogerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEscogerMouseClicked
        String eleccion="";
        if(jRadioButtonAlfil.isSelected()) {
            eleccion="Alfil";
        } else if(jRadioButtonCaballo.isSelected()) {
            eleccion="Caballo";
        } else if(jRadioButtonTorre.isSelected()){
            eleccion="Torre";
        }
        
        if(eleccion != "") {
            int resultado=JOptionPane.showConfirmDialog(this,nombre+" has elegido al "+eleccion+", muy buena elección, pero ¿Estás completamente seguro de tu elección?", "Confirmación2",JOptionPane.YES_NO_OPTION);

            if(resultado == JOptionPane.YES_OPTION) {
                jLabelMensajeFinal.setText("Bienvenido a MathGames");
            } else if(resultado == JOptionPane.NO_OPTION) {
                jLabelMensajeFinal.setText("Vuelve a elegir personaje");
            }
        }
    }//GEN-LAST:event_BotonEscogerMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonEscoger;
    private javax.swing.JPanel RadioButtons;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelMensajeFinal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonAlfil;
    private javax.swing.JRadioButton jRadioButtonCaballo;
    private javax.swing.JRadioButton jRadioButtonTorre;
    // End of variables declaration//GEN-END:variables

    private void saludar() {
        jLabelMensaje.setText("¿Qué personaje quieres ser "+nombre+"?");
    }
}
