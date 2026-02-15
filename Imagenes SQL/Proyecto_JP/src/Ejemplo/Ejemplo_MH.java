package Ejemplo;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ejemplo_MH extends javax.swing.JFrame {

    public Ejemplo_MH() {
        initComponents();
        Registro();
        setLocation(350, 250);        
    }

    DefaultTableModel Tabla;

    void Registro() {
        Tabla = new DefaultTableModel();
        Tabla.addColumn("Codigo");
        Tabla.addColumn("Nombre");
        Tabla.addColumn("Apellido");
        Tabla.addColumn("Sexo");
        String Select = "SELECT * FROM IMAGEN_PERSONA";
        String Arra[] = new String[4];
        try {
            st = cn.createStatement();
            rs = st.executeQuery(Select);
            while (rs.next()) {
                Arra[0] = rs.getString(1);
                Arra[1] = rs.getString(2);
                Arra[2] = rs.getString(3);
                Arra[3] = rs.getString(4);
                Tabla.addRow(Arra);
            }
            Tabla_Datos.setModel(Tabla);
        } catch (Exception e) {
            System.out.println("Erro En Mostrar : " + e.getMessage());
        }
    }

    void Limpiar() {
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        cboSexo.setSelectedIndex(0);
        lblFoto.setIcon(null);
        lblLocalizador.setText(null);
    }

    Conexion con = new Conexion();
    Connection cn = con.Mundo_Programación();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    FileInputStream Cargar_Archivo;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoto = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        lblLocalizador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        brnRegistrar = new javax.swing.JButton();
        btnMofificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cboSexo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSeleccionar.setText("Imagen");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Sexo");

        brnRegistrar.setText("Registrar");
        brnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnRegistrarActionPerformed(evt);
            }
        });

        btnMofificar.setText("Modificar");
        btnMofificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMofificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "M", "F" }));

        Tabla_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_DatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Datos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(brnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnMofificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(99, 99, 99))
                            .addComponent(txtNombre)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                            .addComponent(lblLocalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLocalizador, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionar)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brnRegistrar)
                    .addComponent(btnMofificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar Imagen de Entrada");
        int Open = chooser.showOpenDialog(null);
        if (Open == JFileChooser.APPROVE_OPTION) {
            File Archivo = chooser.getSelectedFile();
            lblLocalizador.setText(String.valueOf(Archivo));
            Image Imagen = getToolkit().getImage(lblLocalizador.getText());
            Imagen = Imagen.getScaledInstance(150, 160, Image.SCALE_SMOOTH);
            lblFoto.setIcon(new ImageIcon(Imagen));
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void brnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnRegistrarActionPerformed
        String Insert = "INSERT INTO IMAGEN_PERSONA VALUES (?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(Insert);
            ps.setString(1, txtCodigo.getText());
            ps.setString(2, txtNombre.getText());
            ps.setString(3, txtApellido.getText());
            ps.setString(4, cboSexo.getSelectedItem().toString());
            Cargar_Archivo = new FileInputStream(lblLocalizador.getText());
            ps.setBinaryStream(5, Cargar_Archivo);
            int Respuesta = ps.executeUpdate();
            if (Respuesta > 0) {
                JOptionPane.showMessageDialog(null, "Registrado Con Exito");
                Limpiar();
                Registro();
            } else {
                JOptionPane.showMessageDialog(null, "No Se Pudo Registrar");
            }
        } catch (FileNotFoundException | SQLException ex) {
            System.out.println("Error En Insertar : " + ex.getMessage());
        }
    }//GEN-LAST:event_brnRegistrarActionPerformed

    private void btnMofificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMofificarActionPerformed
        try {
            String Update = "UPDATE IMAGEN_PERSONA SET Nombre = ?, Apellido = ?, Sexo = ?, Foto = ? WHERE ID_Codigo = ?";
            ps = cn.prepareStatement(Update);
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtApellido.getText());
            ps.setString(3, cboSexo.getSelectedItem().toString());
            Cargar_Archivo = new FileInputStream(lblLocalizador.getText());
            ps.setBinaryStream(4, Cargar_Archivo);
            ps.setString(5, txtCodigo.getText());
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Con Exito");
                Registro();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No Se Pudo Modificar");
            }
        } catch (SQLException | FileNotFoundException ex) {
            System.out.println("Error En Modificar : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnMofificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String Delete = "DELETE FROM IMAGEN_PERSONA WHERE ID_Codigo = ?";
        try {
            ps = cn.prepareStatement(Delete);
            ps.setString(1, txtCodigo.getText());
            int n = ps.executeUpdate();
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Eliminado Con  Exito");
                Registro();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No Se Pudo Eliminar");
            }
        } catch (SQLException ex) {
            System.out.println("Error En Eliminar : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void Tabla_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DatosMouseClicked
        int Celda = Tabla_Datos.rowAtPoint(evt.getPoint());
        txtCodigo.setText(Tabla_Datos.getValueAt(Celda, 0).toString());
        txtNombre.setText(Tabla_Datos.getValueAt(Celda, 1).toString());
        txtApellido.setText(Tabla_Datos.getValueAt(Celda, 2).toString());
        cboSexo.setSelectedItem(Tabla_Datos.getValueAt(Celda, 3).toString());
    }//GEN-LAST:event_Tabla_DatosMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejemplo_MH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ejemplo_MH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Datos;
    private javax.swing.JButton brnRegistrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMofificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblLocalizador;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
