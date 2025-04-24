import javax.swing.SwingUtilities;

import controllers.AuthController;
import models.AuthModel;
import views.AuthView;

public class Main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AuthView view = new AuthView();
            AuthModel model = new AuthModel();
            new AuthController(view, model);
        });
    }
}
