package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        
        
        return lista;
    }
    public boolean addProducto(int identi, String nombre, double precio, int disp) {
        JSONParser jsonParser = new JSONParser();
        JSONArray listaProductos;

        try {
            String rutaJson = getClass().getResource("/files/products.json").toURI().getPath();
            
           
            try (FileReader lector = new FileReader(rutaJson)) {
                Object obj = jsonParser.parse(lector);
                listaProductos = (JSONArray) obj; 
            }

            
            JSONObject nuevoProducto = new JSONObject();
            nuevoProducto.put("id", identi);
            nuevoProducto.put("title", nombre);
            nuevoProducto.put("price", precio);
            nuevoProducto.put("stock", disp);

           
            listaProductos.add(nuevoProducto);

            try (FileWriter archivo = new FileWriter(rutaJson)) {
                archivo.write(listaProductos.toJSONString());
                archivo.flush();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}