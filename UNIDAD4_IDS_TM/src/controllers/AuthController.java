package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.AuthModel;
import views.AuthView;

public class AuthController {
	private AuthView view;
    private AuthModel model;

    public AuthController(AuthView view, AuthModel model) {
        this.view = view;
        this.model = model;
        Controller();
    }

    private void Controller() {
        view.addAccederListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = view.getUsuario();
                String contraseña = view.getContraseña();

                if (model.autenticar(usuario, contraseña)) {
                    view.setMensaje("Bienvenido.", Color.GREEN);
                } else {
                    view.setMensaje("Usuario o contraseña incorrectos.", Color.RED);
                }
            }
        });
        
        view.addRegistroListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.setVisible(false);
                view.mostrarVentanaRegistro(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object[] data = (Object[]) e.getSource();
                        String usuario = (String) data[0];
                        String contraseña = (String) data[1];
                        String email = (String) data[2];
                        model.registro(usuario, contraseña, email);
                    }
                });
            }
        });
            
    }
}