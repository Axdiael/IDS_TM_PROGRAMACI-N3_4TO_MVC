package views;

import models.Product;
import models.ProductModel;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProductController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductView {

    private DefaultTableModel modelo;
    private JTable tabla;
    private ProductModel modeloProducto;

    public ProductView() {
        this.modeloProducto = new ProductModel(); 
    }

    public void mostrarLista() {
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
        
        JButton btnAdd = new JButton("Añadir producto");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductController pc = new ProductController();
                pc.add(); 
            }
        });

        JPanel panelBotton = new JPanel();
        panelBoton.add(btnActualizar);
        panelBoton.add(btnAdd);

        ventana.add(scroll, BorderLayout.CENTER);
        ventana.add(panelBoton, BorderLayout.SOUTH);

        actualizarTabla();
        
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

    public void add()
	{
		
    	JFrame ventana = new JFrame("Añadir Producto");
        ventana.setBounds(100, 100, 400, 400);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        ventana.getContentPane().add(panel);

        JLabel idTag = new JLabel("ID del producto");
        idTag.setBounds(50, 30, 150, 25);
        panel.add(idTag);

        JTextField idInput = new JTextField();
        idInput.setBounds(200, 30, 120, 25);
        panel.add(idInput);

        JLabel nameTag = new JLabel("Nombre del producto");
        nameTag.setBounds(50, 70, 150, 25);
        panel.add(nameTag);

        JTextField nameInput = new JTextField();
        nameInput.setBounds(200, 70, 120, 25);
        panel.add(nameInput);

        JLabel priceTag = new JLabel("Precio");
        priceTag.setBounds(50, 110, 150, 25);
        panel.add(priceTag);

        JTextField priceInput = new JTextField();
        priceInput.setBounds(200, 110, 120, 25);
        panel.add(priceInput);

        JLabel stockTag = new JLabel("Stock");
        stockTag.setBounds(50, 150, 150, 25);
        panel.add(stockTag);

        JTextField stockInput = new JTextField();
        stockInput.setBounds(200, 150, 120, 25);
        panel.add(stockInput);

        
		JButton add = new JButton("añadir producto");
		add.setBounds(100, 250, 200, 40);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int id = Integer.parseInt(idInput.getText());
                String nombre = nameInput.getText();
                double precio = Double.parseDouble(priceInput.getText());
                int stock = Integer.parseInt(stockInput.getText());
				
				ProductModel pm = new ProductModel();
				pm.addProducto(id, nombre, precio, stock);
				
				ventana.dispose();
				
				ProductController pc = new ProductController(); 
				pc.products();
				
			}});
		panel.add(add); 
		
		
	}
	
}
