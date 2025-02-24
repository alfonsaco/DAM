package actividad4interfaz.pantallas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import actividad4interfaz.pantallas.Fuente;
import actividad4interfaz.pantallas.JuegoAhorcado;
import actividad4interfaz.pantallas.JuegoPPT;
import actividad4interfaz.pantallas.JuegoPinturillo;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Alfonso
 */
public class SeleccionJuego extends javax.swing.JFrame {

    CompoundBorder bordeCompuesto;
    CompoundBorder bordeCompuestoFinal;
    MatteBorder bordeExteriorFinal;
    MatteBorder bordeExterior;
    MatteBorder bordeInterno;
    AudioClip change;
    
    private String nombre;
    private String email;
    /**
     * Creates new form SeleccionJuego
     */
    public SeleccionJuego(String nombre, String email) {
        initComponents();
        
        // Datos heredados
        this.nombre=nombre;
        this.email=email;
        
        // Estilos de la pantalla 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(550, 410);
        this.setIconImage(new ImageIcon(getClass().getResource("/actividad4interfaz/images/icono.png")).getImage());
        
        // Borde de los botones
        bordeInterno=BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(255, 25, 0));
        bordeExterior=BorderFactory.createMatteBorder(2, 0, 2, 0, new Color(255, 25, 0, 70));
        bordeExteriorFinal=BorderFactory.createMatteBorder(4, 0, 4, 0, new Color(255, 25, 0, 15));
        bordeCompuesto=new CompoundBorder(bordeExterior, bordeInterno);
        bordeCompuestoFinal=new CompoundBorder(bordeExteriorFinal, bordeCompuesto);
        
        // Fuente
        Fuente cambiarFuente=new Fuente();
        Font fuente=cambiarFuente.cargarFuente("/actividad4interfaz/fonts/Roboto-Thin.ttf", 30f);
        if(fuente != null){
            LabelBotonJugar.setFont(fuente);
        }
        
        // Palabras heredadas de la otra clase
        jLabelUsuario.setText(nombre);
        jLabelEmail.setText(email);
        
        change=java.applet.Applet.newAudioClip(getClass().getResource("/actividad4interfaz/audio/change.wav"));
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        ContenedorSeleccion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaJuegos = new javax.swing.JList<>();
        BotonJugar = new javax.swing.JPanel();
        LabelBotonJugar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ContenedorCuenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));

        ContenedorSeleccion.setBackground(new java.awt.Color(51, 51, 51));
        ContenedorSeleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListaJuegos.setBackground(new java.awt.Color(19, 19, 19));
        ListaJuegos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ListaJuegos.setForeground(new java.awt.Color(255, 255, 255));
        ListaJuegos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "              PINTURILLO", "  PIEDRA, PAPEL Y TIJERAS", "              AHORCADO" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaJuegos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ListaJuegos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaJuegosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaJuegos);

        ContenedorSeleccion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 350, 120));

        BotonJugar.setBackground(new java.awt.Color(13, 13, 13));
        BotonJugar.setOpaque(false);

        LabelBotonJugar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        LabelBotonJugar.setForeground(new java.awt.Color(255, 25, 0));
        LabelBotonJugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelBotonJugar.setText("JUGAR");
        LabelBotonJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelBotonJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelBotonJugarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelBotonJugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabelBotonJugarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BotonJugarLayout = new javax.swing.GroupLayout(BotonJugar);
        BotonJugar.setLayout(BotonJugarLayout);
        BotonJugarLayout.setHorizontalGroup(
            BotonJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelBotonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        BotonJugarLayout.setVerticalGroup(
            BotonJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelBotonJugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        ContenedorSeleccion.add(BotonJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 230, 60));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4interfaz/images/selecciona_1.png"))); // NOI18N
        ContenedorSeleccion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 530, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4interfaz/images/fondo1.png"))); // NOI18N
        ContenedorSeleccion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 380));

        jTabbedPane1.addTab("Juegos", ContenedorSeleccion);

        ContenedorCuenta.setBackground(new java.awt.Color(51, 51, 51));
        ContenedorCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30), 2));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("USUARIO:");
        jPanel1.add(jLabel3, new java.awt.GridBagConstraints());

        jLabelUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        jPanel1.add(jLabelUsuario, gridBagConstraints);

        jLabelEmail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        jPanel1.add(jLabelEmail, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("EMAIL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        ContenedorCuenta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 300, 260));

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4interfaz/images/fondo1.png"))); // NOI18N
        ContenedorCuenta.add(ImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 380));

        jTabbedPane1.addTab("Mi Cuenta", ContenedorCuenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelBotonJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelBotonJugarMouseClicked
        String seleccion=ListaJuegos.getSelectedValue();
        
        if(seleccion == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un juego");
        } else {
            abrirJuego(seleccion);
        }
    }//GEN-LAST:event_LabelBotonJugarMouseClicked

    // Método para abrir la ventana de juego
    private void abrirJuego(String juego) {     
        switch(juego) {
            case "              PINTURILLO":
                new JuegoPinturillo(this, true).setVisible(true);                
                break;
            case "              AHORCADO":
                new JuegoAhorcado(this, true).setVisible(true);
                break;
            case "  PIEDRA, PAPEL Y TIJERAS":
                new JuegoPPT(this, true).setVisible(true);
                break;
        }
    }
    
    // HOVER DEL BOTÓN
    private void LabelBotonJugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelBotonJugarMouseEntered
        ContenedorSeleccion.repaint();
        ContenedorSeleccion.revalidate();
        BotonJugar.setBorder(bordeCompuestoFinal);
    }//GEN-LAST:event_LabelBotonJugarMouseEntered

    private void LabelBotonJugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelBotonJugarMouseExited
        ContenedorSeleccion.repaint();
        ContenedorSeleccion.revalidate();
        BotonJugar.setBorder(null);
    }//GEN-LAST:event_LabelBotonJugarMouseExited

    // SE REPRODUCE UN SONIDO AL CAMBIAR DE SELECCIÓN DE LA JLIST
    private void ListaJuegosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaJuegosValueChanged
        change.play();
    }//GEN-LAST:event_ListaJuegosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonJugar;
    private javax.swing.JPanel ContenedorCuenta;
    private javax.swing.JPanel ContenedorSeleccion;
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JLabel LabelBotonJugar;
    private javax.swing.JList<String> ListaJuegos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
