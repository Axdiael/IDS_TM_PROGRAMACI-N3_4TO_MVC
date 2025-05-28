package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import models.UserModel;
import models.Users;

public class UserView extends JFrame {

    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private JButton btnAgregar;

    public UserView() {
        setTitle("Lista de Usuarios");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono", "Fecha", "Actualizar"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);

        cargarDatos();
        ActualizarBtn();
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> Addview());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);


        add(new JScrollPane(tablaUsuarios), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        UserModel userModel = new UserModel();
        ArrayList<Users> lista = userModel.get();

        for (Users u : lista) {
            Object[] fila = {
                u.getId(),
                u.getName(),
                u.getEmail(),
                u.getRole(),
                u.getPhone(),
                u.getFecha(),
                "Actualizar"
            };
            modeloTabla.addRow(fila);
        }
    }
    
    private void Addview() {
        JDialog dialogo = new JDialog(this, "Nuevo Usuario", true);
        dialogo.setSize(300, 250);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField txtNombre = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtRol = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);

        dialogo.add(new JLabel("Email:"));
        dialogo.add(txtEmail);

        dialogo.add(new JLabel("Rol:"));
        dialogo.add(txtRol);

        dialogo.add(btnGuardar);
        dialogo.add(btnCancelar);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            String rol = txtRol.getText();

            if (!nombre.isEmpty() && !email.isEmpty() && !rol.isEmpty()) {
                UserModel model = new UserModel();
                if (model.add(nombre, email, rol)) {
                    JOptionPane.showMessageDialog(this, "usuario agregado exitosamente");
                    cargarDatos();
                    dialogo.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "error al agregar usuario");
                }
            } else {
                JOptionPane.showMessageDialog(this, "llena los cmpos");
            }
        });

        btnCancelar.addActionListener(e -> dialogo.dispose());

        dialogo.setVisible(true);
    }
    private void ActualizarBtn() {
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int fila = tablaUsuarios.rowAtPoint(e.getPoint());
                int columna = tablaUsuarios.columnAtPoint(e.getPoint());

                if (columna == 6 && fila != -1) {
                    int id = (int) modeloTabla.getValueAt(fila, 0);
                    String nombre = modeloTabla.getValueAt(fila, 1).toString();
                    String email = modeloTabla.getValueAt(fila, 2).toString();
                    String rol = modeloTabla.getValueAt(fila, 3).toString();
                    String telefono = modeloTabla.getValueAt(fila, 4) != null ? modeloTabla.getValueAt(fila, 4).toString() : null;
                    java.util.Date fecha = (java.util.Date) modeloTabla.getValueAt(fila, 5);

                    Users usuario = new Users(id, nombre, email, rol, telefono, fecha);
                    update(usuario);
                }
            }
        });
    }

    
    public void update(Users userToUpdate) {
        JDialog dialogo = new JDialog(this, "Actualizar Usuario", true);
        dialogo.setSize(300, 250);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField txtNombre = new JTextField(userToUpdate.getName());
        JTextField txtEmail = new JTextField(userToUpdate.getEmail());
        JTextField txtRol = new JTextField(userToUpdate.getRole());

        JButton btnActualizar = new JButton("Actualizar");
        JButton btnCancelar = new JButton("Cancelar");

        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);
        dialogo.add(new JLabel("Email:"));
        dialogo.add(txtEmail);
        dialogo.add(new JLabel("Rol:"));
        dialogo.add(txtRol);
        dialogo.add(btnActualizar);
        dialogo.add(btnCancelar);

        btnActualizar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            String rol = txtRol.getText();

            if (!nombre.isEmpty() && !email.isEmpty() && !rol.isEmpty()) {
                UserModel model = new UserModel();
                Users updatedUser = new Users(userToUpdate.getId(), nombre, email, rol, userToUpdate.getPhone(), userToUpdate.getFecha());

                if (model.update(updatedUser)) {
                    JOptionPane.showMessageDialog(this, "usuario actualizado exitosamente");
                    cargarDatos();
                    dialogo.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "error al actualizar usuario");
                }
            } else {
                JOptionPane.showMessageDialog(this, "llena los campos");
            }
        });

        btnCancelar.addActionListener(e -> dialogo.dispose());
        dialogo.setVisible(true);
    }
}

