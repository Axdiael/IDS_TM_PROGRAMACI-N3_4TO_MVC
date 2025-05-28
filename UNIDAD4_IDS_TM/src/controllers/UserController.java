package controllers;

import models.UserModel;
import models.Users;
import views.UserView;

public class UserController {

    private UserModel modelo;
    private UserView vista;

    public UserController(UserModel modelo, UserView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
    }
    
    public void update(Users userToUpdate) {
        vista.update(userToUpdate); 
    }
}
