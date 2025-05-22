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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono", "Fecha"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);

        cargarDatos();
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> Addview());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);


        add(new JScrollPane(tablaUsuarios), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        UserModel userModel = new UserModel();
        ArrayList<Users> lista = userModel.get();

        for (Users u : lista) {
            Object[] fila = {
                u.getId(),
                u.getName(),
                u.getEmail(),
                u.getRole(),
                u.getPhone(),
                u.getFecha()
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

}
