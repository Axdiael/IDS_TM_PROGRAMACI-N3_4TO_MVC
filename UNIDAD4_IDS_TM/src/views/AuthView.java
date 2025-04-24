package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AuthView extends JFrame{
	private Font texto = new Font("Andale Mono", Font.BOLD, 22);
    private Font texto2 = new Font("Andale Mono", Font.BOLD, 18);
    
    private JTextField usuarioField;
    private JPasswordField contraseñaField;
    private JLabel mensajeLabel;
    private JButton accederButton;
    private JButton registroButton;
    private ActionListener registrarListener;
    private JFrame registroFrame;

    public AuthView() {
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        iniciarLoginPanel();
        this.setVisible(true);
    }

    private void iniciarLoginPanel() {
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBackground(Color.decode("#bfdeed"));
        panelLogin.setOpaque(true);
        panelLogin.setBounds(0, 0, 420, 600);

        JLabel etiqueta1 = new JLabel("Inicio de sesión", SwingConstants.CENTER);
        etiqueta1.setBounds(0, 50, 420, 50);
        etiqueta1.setFont(texto);
        panelLogin.add(etiqueta1);

        ImageIcon iconoUsuario = new ImageIcon(getClass().getResource("/Images/user.png"));
        JLabel usuarioIcon = new JLabel(new ImageIcon(iconoUsuario.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        usuarioIcon.setBounds(50, 140, 30, 30);
        panelLogin.add(usuarioIcon);

        JLabel usuarioLabel = new JLabel("USUARIO:");
        usuarioLabel.setBounds(50, 110, 150, 30);
        usuarioLabel.setFont(texto2);
        usuarioLabel.setForeground(Color.BLACK);
        panelLogin.add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setBounds(100, 140, 250, 30);
        usuarioField.setFont(texto2);
        panelLogin.add(usuarioField);

        ImageIcon iconoPassword = new ImageIcon(getClass().getResource("/Images/password.png"));
        JLabel passwordIcon = new JLabel(new ImageIcon(iconoPassword.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        passwordIcon.setBounds(50, 210, 30, 30);
        panelLogin.add(passwordIcon);

        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaLabel.setBounds(50, 180, 150, 30);
        contraseñaLabel.setForeground(Color.BLACK);
        contraseñaLabel.setFont(texto2);
        panelLogin.add(contraseñaLabel);

        contraseñaField = new JPasswordField();
        contraseñaField.setBounds(100, 210, 250, 30);
        contraseñaField.setFont(texto2);
        panelLogin.add(contraseñaField);

        accederButton = new JButton("Acceder");
        accederButton.setBounds(135, 300, 150, 50);
        accederButton.setFont(texto2);
        accederButton.setBackground(Color.WHITE);
        accederButton.setForeground(Color.BLACK);
        panelLogin.add(accederButton);
        
        registroButton = new JButton("Registrarse");
        registroButton.setBounds(135, 360, 150, 50);
        registroButton.setFont(texto2);
        registroButton.setBackground(Color.WHITE);
        registroButton.setForeground(Color.BLACK);
        panelLogin.add(registroButton);

        mensajeLabel = new JLabel("", SwingConstants.CENTER);
        mensajeLabel.setBounds(50, 420, 320, 30);
        mensajeLabel.setFont(texto2);
        panelLogin.add(mensajeLabel);

        this.add(panelLogin);
    }
    
	public void mostrarVentanaRegistro(ActionListener registrarListener) {
        if (registroFrame == null) {
            registroFrame = new JFrame("Registro");
            registroFrame.setSize(420, 600);
            registroFrame.setLocationRelativeTo(null);
            registroFrame.setResizable(false);
            registroFrame.setLayout(null);

            JPanel panelRegistro = new JPanel();
            panelRegistro.setLayout(null);
            panelRegistro.setBackground(Color.decode("#bfdeed"));
            panelRegistro.setBounds(0, 0, 420, 600);

            JLabel titulo = new JLabel("Registro de Usuario", SwingConstants.CENTER);
            titulo.setBounds(0, 50, 420, 50);
            titulo.setFont(texto);
            panelRegistro.add(titulo);

            JLabel usuarioLabel = new JLabel("Usuario:");
            usuarioLabel.setBounds(50, 110, 150, 30);
            usuarioLabel.setFont(texto2);
            panelRegistro.add(usuarioLabel);

            JTextField regUsuarioField = new JTextField();
            regUsuarioField.setBounds(100, 140, 250, 30);
            regUsuarioField.setFont(texto2);
        panelRegistro.add(regUsuarioField);

            JLabel contraseñaLabel = new JLabel("Contraseña:");
            contraseñaLabel.setBounds(50, 180, 150, 30);
            contraseñaLabel.setFont(texto2);
            panelRegistro.add(contraseñaLabel);

            JPasswordField regContraseñaField = new JPasswordField();
            regContraseñaField.setBounds(100, 210, 250, 30);
            regContraseñaField.setFont(texto2);
            panelRegistro.add(regContraseñaField);

            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setBounds(50, 250, 150, 30);
            emailLabel.setFont(texto2);
            panelRegistro.add(emailLabel);

            JTextField emailField = new JTextField();
            emailField.setBounds(100, 280, 250, 30);
            emailField.setFont(texto2);
            panelRegistro.add(emailField);

            JButton registrarButton = new JButton("Registrar");
            registrarButton.setBounds(135, 360, 150, 50);
            registrarButton.setFont(texto2);
            registrarButton.setBackground(Color.WHITE);
            registrarButton.setForeground(Color.BLACK);
            panelRegistro.add(registrarButton);

            JButton regresarButton = new JButton("Regresar");
            regresarButton.setBounds(135, 420, 150, 50);
            regresarButton.setFont(texto2);
            regresarButton.setBackground(Color.WHITE);
            regresarButton.setForeground(Color.BLACK);
            panelRegistro.add(regresarButton);

            JLabel regMensajeLabel = new JLabel("", SwingConstants.CENTER);
            regMensajeLabel.setBounds(50, 480, 320, 30);
            regMensajeLabel.setFont(texto2);
            panelRegistro.add(regMensajeLabel);

            registrarButton.addActionListener(e -> {
                String usuario = regUsuarioField.getText();
                String contraseña = new String(regContraseñaField.getPassword());
                String email = emailField.getText();
                
                if (registrarListener != null) {
                    registrarListener.actionPerformed(new ActionEvent(registrarButton, ActionEvent.ACTION_PERFORMED, null) {
                        @Override
                        public Object getSource() {
                            return new Object[] { usuario, contraseña, email };
                        }
                    });
                }
                
                regMensajeLabel.setText("Registro exitoso");
                regMensajeLabel.setForeground(Color.GREEN);
                
                regUsuarioField.setText("");
                regContraseñaField.setText("");
                emailField.setText("");
            });

            regresarButton.addActionListener(e -> {
                registroFrame.setVisible(false);
                this.setVisible(true);
            });

            registroFrame.add(panelRegistro);
        }
        registroFrame.setVisible(true);
    }

    public String getUsuario() {
        return usuarioField.getText();
    }

    public String getContraseña() {
        return new String(contraseñaField.getPassword());
    }

    public void setMensaje(String mensaje, Color color) {
        mensajeLabel.setText(mensaje);
        mensajeLabel.setForeground(color);
    }

    public void addAccederListener(ActionListener listener) {
        accederButton.addActionListener(listener);
    }
    
    public void addRegistroListener(ActionListener listener) {
    	if (registroButton != null) {
            registroButton.addActionListener(listener);
        }
    }
    public void addRegistrarListener(ActionListener listener) {
    	 this.registrarListener = listener;
    }
    

    public void limpiarCampos() {
        usuarioField.setText("");
        contraseñaField.setText("");
        mensajeLabel.setText("");
    }
}