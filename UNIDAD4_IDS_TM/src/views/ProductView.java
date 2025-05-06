package views;

import models.Product;
import models.ProductModel;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ProductView {

    private DefaultTableModel modelo;
    private JTable tabla;
    private ProductModel modeloProducto;

    public ProductView() {
        this.modeloProducto = new ProductModel(); 
    }

    public void mostrarLista(List<Product> productos) {
        JFrame ventana = new JFrame("Lista de Productos");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Precio", "Stock"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarTabla());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnActualizar);

        ventana.add(scroll, BorderLayout.CENTER);
        ventana.add(panelBoton, BorderLayout.SOUTH);

        llenarTabla(productos);

        ventana.setVisible(true);
    }

    private void llenarTabla(List<Product> productos) {
        modelo.setRowCount(0); 
        for (Product p : productos) {
            Object[] fila = {
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getStock()
            };
            modelo.addRow(fila);
        }
    }

    private void actualizarTabla() {
        List<Product> nuevosProductos = modeloProducto.cargarProductos();
        llenarTabla(nuevosProductos);
    }
}
