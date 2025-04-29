
package models;

import java.io.*;

public class AuthModel {
	private final String archivoUsuarios = "usuarios.txt";

    public boolean autenticar(String usuario, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 8) {
                    String usuarioArchivo = partes[5].trim();
                    String contrasenaArchivo = partes[7].trim();

                    if (usuario.equals(usuarioArchivo) && contrasena.equals(contrasenaArchivo)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
        	System.out.println("Archivo de usuarios no encontrado: " + archivoUsuarios);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }
    
    public String registro(String nombres, String apellidos, String empresa, String ambito, String cargo,
            String usuario, String contrasena, String repetirContrasena, String correo) {
    	
    	 String error = validarCampos(nombres, apellidos, empresa, ambito,cargo, usuario, contrasena, repetirContrasena, correo);
         if (error != null) {
             return error;
         }

        
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length >= 8) {
                    if (partes[5].trim().equals(usuario)) {
                        return "El nombre de usuario ya está registrado.";
                    }
                    if (partes[6].trim().equals(correo)) {
                        return "El correo electrónico ya está registrado.";
                    }
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            return "Error al verificar el archivo: " + e.getMessage();
        }
    	
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuarios, true))) {
            bw.write(String.join("|", nombres, apellidos, empresa, ambito, cargo, usuario, correo, contrasena));
            bw.newLine();
            return "Registro completado";
        } catch (IOException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return "Error al registrar usuario";
        }
    }
    private String validarCampos(String nombres, String apellidos, String empresa, String ambito, String cargo,
            String usuario, String contrasena, String repetirContrasena, String correo) {

		if (nombres == null || nombres.trim().isEmpty()) {
		return "Nombres: Campo requerido.";
		}
		for (char c : nombres.toCharArray()) {
			if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
			return "Nombres: Solo se permiten letras y espacios.";
			}
		}
		
		if (apellidos == null || apellidos.trim().isEmpty()) {
		return "Apellidos: Campo requerido.";
		}
		for (char c : apellidos.toCharArray()) {
			if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
			return "Apellidos: Solo se permiten letras y espacios.";
			}
		}
		
		if (empresa == null || empresa.trim().isEmpty()) {
		return "Empresa: Campo requerido.";
		}
		for (char c : empresa.toCharArray()) {
			if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
			return "Empresa: Solo se permiten letras, números y espacios.";
			}
		}
		
		if (ambito == null || !("Tecnología".equals(ambito) || "Salud".equals(ambito) || 
		            "Educación".equals(ambito) || "Comercio".equals(ambito) || "Otro".equals(ambito))) {
		return "Ámbito: Seleccione una opción válida.";
		}
		

		if (cargo == null || cargo.trim().isEmpty()) {
		return "Cargo: Campo requerido.";
		}
		for (char c : cargo.toCharArray()) {
			if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
			return "Cargo: Solo se permiten letras y espacios.";
			}
		}
		
		if (usuario == null || usuario.trim().isEmpty()) {
		return "Nombre de usuario: Campo requerido.";
		}
		for (char c : usuario.toCharArray()) {
			if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
			return "Nombre de usuario: Solo se permiten letras, números y espacios.";
			}
		}
		
		if (contrasena == null || contrasena.trim().isEmpty()) {
		return "Contraseña: Campo requerido.";
		}
		boolean tieneEspecial = false;
		for (char c : contrasena.toCharArray()) {
			if (Character.isWhitespace(c)) {
			return "Contraseña: No se permiten espacios.";
			}
		if ("!@#$%^&*".indexOf(c) >= 0) {
		tieneEspecial = true;
		}
		if (!Character.isLetterOrDigit(c) && "!@#$%^&*".indexOf(c) < 0) {
		return "Contraseña: Solo se permiten letras, números y caracteres especiales (!@#$%^&*).";
		}
			}
			if (!tieneEspecial) {
			return "Contraseña: Debe contener al menos un carácter especial (!@#$%^&*).";
			}
		
		if (!contrasena.equals(repetirContrasena)) {
		return "Las contraseñas no coinciden.";
		}
		
		if (correo == null || correo.trim().isEmpty()) {
		return "Correo: Campo requerido.";
		}
		if (correo.contains(" ") || !correo.contains("@") || !correo.contains(".") || 
		correo.indexOf("@") == 0 || correo.indexOf("@") == correo.length() - 1 || 
		correo.indexOf(".") == correo.length() - 1) {
		return "Correo: Ingrese un correo electrónico válido, sin espacios.";
		}
	
		return null; 
    }
}
