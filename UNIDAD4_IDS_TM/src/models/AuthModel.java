
package models;

import java.io.*;

public class AuthModel {
	private final String archivoUsuarios = "usuarios.txt";

    public boolean autenticar(String usuario, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String usuarioArchivo = partes[0].trim();
                    String contrasenaArchivo = partes[1].trim();

                    if (usuario.equals(usuarioArchivo) && contrasena.equals(contrasenaArchivo)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }
    
    public void registro(String usuario, String contrasena, String email) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuarios, true))) {
            bw.write(usuario + "," + contrasena + "," + email);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }
}
