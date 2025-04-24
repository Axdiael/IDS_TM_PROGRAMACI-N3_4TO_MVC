
package models;

public class AuthModel {
	public boolean autenticar(String usuario, String contraseña) {
        return "admin".equals(usuario) && "1234".equals(contraseña);
    }
}
