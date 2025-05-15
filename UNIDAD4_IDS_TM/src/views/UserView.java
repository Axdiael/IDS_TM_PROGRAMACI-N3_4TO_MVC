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

    public UserView() {
        setTitle("Lista de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono", "Fecha"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);

        cargarDatos();

        add(new JScrollPane(tablaUsuarios), BorderLayout.CENTER);
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

}
