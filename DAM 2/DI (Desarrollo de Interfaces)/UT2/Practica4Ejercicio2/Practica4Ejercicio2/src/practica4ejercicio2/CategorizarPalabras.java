/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ejercicio2;

import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PROGRAMACION
 */
public class CategorizarPalabras extends javax.swing.JFrame {

    private DefaultListModel<String> modelVocales;
    private DefaultListModel<String> modelConsonantes;
    /**
     * Creates new form CategorizarPalabras
     */
    public CategorizarPalabras() {
        // Se inicializan los modelos
        modelVocales=new DefaultListModel<>();
        modelConsonantes=new DefaultListModel<>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPalabra = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListConsonantes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListVocales = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(231, 231, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ingrese palabra:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jTextFieldPalabra.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPalabra.setToolTipText("Insertar una palabra");
        jPanel1.add(jTextFieldPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 184, 32));

        jButtonIngresar.setBackground(new java.awt.Color(51, 102, 255));
        jButtonIngresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonIngresar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonIngresar.setText("INGRESAR");
        jButtonIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButtonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 125, 43));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Comienza por vocal");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Comienza por consonante");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        jListConsonantes.setBackground(new java.awt.Color(255, 255, 255));
        jListConsonantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane1.setViewportView(jListConsonantes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 140, 120));

        jListVocales.setBackground(new java.awt.Color(255, 255, 255));
        jListVocales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane2.setViewportView(jListVocales);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 140, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean esPalabra(String palabra) {
        return palabra.matches("[a-zA-ZáéúíóÁÉÍÓÚ]+");
    }
    private boolean esVocal(String palabra) {
        return palabra.matches("[aeiouAEIOUáéíóúÁÉÍÓÚ]+");
    }
    
    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        if(!jTextFieldPalabra.getText().toString().isEmpty()) {   
            String palabra=jTextFieldPalabra.getText();
            // Vaciamos el input
            jTextFieldPalabra.setText("");
            
            if(esPalabra(palabra)) {
                String letra=palabra.substring(0,1);
                // Condicionales, para ver si empieza por vocal o por consonante
                if(esVocal(letra)) {
                    // Se agrega cada palabra al modelo
                    modelVocales.addElement(palabra);
                    // Se inserta el modelo en la lista
                    jListVocales.setModel(modelVocales);
                } else {
                    modelConsonantes.addElement(palabra);
                    jListConsonantes.setModel(modelConsonantes);
                }
            } else {
                // Dialog para evitar números
                JOptionPane.showMessageDialog(null, "Solo se permiten palabras","Cáracter no permitido",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(CategorizarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategorizarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategorizarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategorizarPalabras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategorizarPalabras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListConsonantes;
    private javax.swing.JList<String> jListVocales;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldPalabra;
    // End of variables declaration//GEN-END:variables
}