package controllers;

import models.Product;
import models.ProductModel;
import views.ProductView;
import java.util.List;

public class ProductController {
	private ProductModel modelo;
    private ProductView vista;

    public ProductController(ProductModel modelo, ProductView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        List<Product> productos = modelo.cargarProductos();
        vista.mostrarLista(productos);
    }

    public static void main(String[] args) {
        ProductModel modelo = new ProductModel();
        ProductView vista = new ProductView();
        ProductController controlador = new ProductController(modelo, vista);
        controlador.iniciar();
    }
}
