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
    
    public ProductController() {
        this.modelo = new ProductModel();
        this.vista = new ProductView();
    }

    public void iniciar() {
    	vista.mostrarLista();
    }
    
    public void add() {
		
		vista.add();
	}
    
    public void products() {
        vista.mostrarLista();  
    }
}
