
package models;

public class AuthModel {
	public boolean autenticar(String usuario, String contraseña) {
        return "admin".equals(usuario) && "1234".equals(contraseña);
    }
	
	public void registro(String usuario, String contraseña, String email) {
        System.out.println("Registro de usuario:");
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + contraseña);
        System.out.println("Email: " + email);
    }
}
