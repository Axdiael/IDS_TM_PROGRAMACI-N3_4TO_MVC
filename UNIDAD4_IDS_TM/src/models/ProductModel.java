package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    public List<Product> cargarProductos() {
        List<Product> lista = new ArrayList<>();
        JSONParser analizador = new JSONParser();

        try {
            String rutaJson = getClass().getResource("/files/products.json").toURI().getPath();
            try (FileReader lector = new FileReader(rutaJson)) {
                JSONArray productosJson = (JSONArray) analizador.parse(lector);

                for (Object elemento : productosJson) {
                    JSONObject prod = (JSONObject) elemento;
                    
                    Long idLong = (Long) prod.get("id");
                    String nombre = (String) prod.get("title"); 
                    Object precioObj = prod.get("price"); 
                    Long stockLong = (Long) prod.get("stock");

                    if (idLong == null || nombre == null || precioObj == null || stockLong == null) {
                        System.err.println("Producto inválido encontrado: " + prod);
                        continue; 
                    }

                    double precio;
                    try {
                        precio = Double.parseDouble(precioObj.toString());
                    } catch (NumberFormatException e) {
                        System.err.println("Precio inválido en producto: " + prod);
                        continue; 
                    }
                    Product producto = new Product(idLong.intValue(), nombre, precio, stockLong.intValue());
                    lista.add(producto);
                }
            }
        } catch (Exception ex) {
            System.err.println("Error al leer el archivo JSON: " + ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println("=== Lista de Productos ===");
        for (Product p : lista) {
            System.out.println(p);
        }

        
        return lista;
    }
}