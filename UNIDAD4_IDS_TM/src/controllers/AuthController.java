package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
                    view.setVisible(false);
                    view.mostrarVentanaHome(); 
                } else {
                    JOptionPane.showMessageDialog(view, 
                        "Usuario o contraseña incorrectos", 
                        "Error de autenticacion", 
                        JOptionPane.ERROR_MESSAGE);
                    view.limpiarCampos();
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
                        String nombres = (String) data[0];
                        String apellidos = (String) data[1];
                        String empresa = (String) data[2];
                        String ambito = (String) data[3];
                        String cargo = (String) data[4];
                        String usuario = (String) data[5];
                        String contraseña = (String) data[6];
                        String repetirContrasena = (String) data[7];
                        String correo = (String) data[8];

                        String resultado = model.registro(nombres, apellidos, empresa, ambito, cargo, 
                                                         usuario, contraseña, repetirContrasena, correo);
                        if (resultado.equals("Registro completado")) {
                            JOptionPane.showMessageDialog(view, 
                                "Registro completado", 
                                "Éxito", 
                                JOptionPane.INFORMATION_MESSAGE);
               
                            view.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(view, 
                                resultado, 
                                "Error de registro", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });
            
    }
}