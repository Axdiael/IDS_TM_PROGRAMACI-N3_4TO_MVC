package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
            registroFrame.setSize(800, 700);
            registroFrame.setLocationRelativeTo(null);
            registroFrame.setResizable(false);
            registroFrame.setLayout(null);

            JPanel panelRegistro = new JPanel();
            panelRegistro.setLayout(null);
            panelRegistro.setBackground(Color.decode("#bfdeed"));
            panelRegistro.setBounds(0, 0, 800, 700);

            JLabel titulo = new JLabel("Registro de Usuario", SwingConstants.CENTER);
            titulo.setBounds(0, 20, 800, 50);
            titulo.setFont(texto);
            panelRegistro.add(titulo);
            
            JLabel nombresLabel = new JLabel("Nombres:");
            nombresLabel.setBounds(100, 80, 100, 30);
            nombresLabel.setFont(texto2);
            panelRegistro.add(nombresLabel);

            JTextField nombresField = new JTextField();
            nombresField.setBounds(200, 80, 200, 30);
            nombresField.setFont(texto2);
            nombresField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        e.consume();
                    }
                }
            });
            panelRegistro.add(nombresField);

            JLabel apellidosLabel = new JLabel("Apellidos:");
            apellidosLabel.setBounds(420, 80, 100, 30);
            apellidosLabel.setFont(texto2);
            panelRegistro.add(apellidosLabel);

            JTextField apellidosField = new JTextField();
            apellidosField.setBounds(520, 80, 200, 30);
            apellidosField.setFont(texto2);
            apellidosField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        e.consume();
                    }
                }
            });
            panelRegistro.add(apellidosField);

            JLabel empresaLabel = new JLabel("Empresa:");
            empresaLabel.setBounds(100, 130, 100, 30);
            empresaLabel.setFont(texto2);
            panelRegistro.add(empresaLabel);

            JTextField empresaField = new JTextField();
            empresaField.setBounds(200, 130, 200, 30);
            empresaField.setFont(texto2);
            empresaField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                        e.consume();
                    }
                }
            });
            panelRegistro.add(empresaField);

           
            JLabel ambitoLabel = new JLabel("Ámbito:");
            ambitoLabel.setBounds(420, 130, 100, 30);
            ambitoLabel.setFont(texto2);
            panelRegistro.add(ambitoLabel);

            JComboBox<String> ambitoCombo = new JComboBox<>(new String[]{"Tecnología", "Salud", "Educación", "Comercio", "Otro"});
            ambitoCombo.setBounds(520, 130, 200, 30);
            ambitoCombo.setFont(texto2);
            panelRegistro.add(ambitoCombo);

            JLabel cargoLabel = new JLabel("Cargo:");
            cargoLabel.setBounds(100, 180, 100, 30);
            cargoLabel.setFont(texto2);
            panelRegistro.add(cargoLabel);

            JTextField cargoField = new JTextField();
            cargoField.setBounds(200, 180, 200, 30);
            cargoField.setFont(texto2);
            cargoField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        e.consume();
                    }
                }
            });
            panelRegistro.add(cargoField);

            JLabel usuarioLabel = new JLabel("Usuario:");
            usuarioLabel.setBounds(420, 180, 100, 30);
            usuarioLabel.setFont(texto2);
            panelRegistro.add(usuarioLabel);

            JTextField regUsuarioField = new JTextField();
            regUsuarioField.setBounds(520, 180, 200, 30);
            regUsuarioField.setFont(texto2);
            regUsuarioField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        e.consume();
                    }
                }
            });
            panelRegistro.add(regUsuarioField);

            JLabel contraseñaLabel = new JLabel("Contraseña:");
            contraseñaLabel.setBounds(100, 230, 100, 30);
            contraseñaLabel.setFont(texto2);
            panelRegistro.add(contraseñaLabel);

            JPasswordField regContraseñaField = new JPasswordField();
            regContraseñaField.setBounds(200, 230, 200, 30);
            regContraseñaField.setFont(texto2);
            regContraseñaField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (Character.isWhitespace(c) || 
                            (!Character.isLetterOrDigit(c) && "!@#$%^&*".indexOf(c) < 0)) {
                            e.consume();
                        }
                }
            });
            panelRegistro.add(regContraseñaField);

            JLabel repetirContraseñaLabel = new JLabel("Repetir Contraseña:");
            repetirContraseñaLabel.setBounds(420, 230, 150, 30);
            repetirContraseñaLabel.setFont(texto2);
            panelRegistro.add(repetirContraseñaLabel);

            JPasswordField repetirContraseñaField = new JPasswordField();
            repetirContraseñaField.setBounds(570, 230, 150, 30);
            repetirContraseñaField.setFont(texto2);
            repetirContraseñaField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (Character.isWhitespace(c) || 
                            (!Character.isLetterOrDigit(c) && "!@#$%^&*".indexOf(c) < 0)) {
                            e.consume();
                        }
                }
            });
            panelRegistro.add(repetirContraseñaField);

            JLabel correoLabel = new JLabel("Correo:");
            correoLabel.setBounds(100, 280, 100, 30);
            correoLabel.setFont(texto2);
            panelRegistro.add(correoLabel);

            JTextField correoField = new JTextField();
            correoField.setBounds(200, 280, 520, 30);
            correoField.setFont(texto2);
            correoField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isLetterOrDigit(c) && "!@#$%^&*.".indexOf(c) < 0) {
                            e.consume();
                        }
                }
            });
            panelRegistro.add(correoField);

            JButton registrarButton = new JButton("Registrar");
            registrarButton.setBounds(250, 350, 130, 40);
            registrarButton.setFont(texto2);
            registrarButton.setBackground(Color.WHITE);
            registrarButton.setForeground(Color.BLACK);
            panelRegistro.add(registrarButton);

            JButton regresarButton = new JButton("Regresar");
            regresarButton.setBounds(420, 350, 130, 40);
            regresarButton.setFont(texto2);
            regresarButton.setBackground(Color.WHITE);
            regresarButton.setForeground(Color.BLACK);
            panelRegistro.add(regresarButton);

            JLabel regMensajeLabel = new JLabel("", SwingConstants.CENTER);
            regMensajeLabel.setBounds(100, 420, 600, 30);
            regMensajeLabel.setFont(texto2);
            panelRegistro.add(regMensajeLabel);

            registrarButton.addActionListener(e -> {
            	String nombres = nombresField.getText();
                String apellidos = apellidosField.getText();
                String empresa = empresaField.getText();
                String ambito = (String) ambitoCombo.getSelectedItem();
                String cargo = cargoField.getText();
                String usuario = regUsuarioField.getText();
                String contraseña = new String(regContraseñaField.getPassword());
                String repetirContraseña = new String(repetirContraseñaField.getPassword());
                String correo = correoField.getText();
                
                if (registrarListener != null) {
                    registrarListener.actionPerformed(new ActionEvent(registrarButton, ActionEvent.ACTION_PERFORMED, null) {
                        @Override
                        public Object getSource() {
                            return new Object[] {nombres, apellidos, empresa, ambito, cargo, usuario, contraseña, repetirContraseña, correo };
                        }
                    });
                }
                
                nombresField.setText("");
                apellidosField.setText("");
                empresaField.setText("");
                cargoField.setText("");
                regUsuarioField.setText("");
                regContraseñaField.setText("");
                repetirContraseñaField.setText("");
                correoField.setText("");
            });

            regresarButton.addActionListener(e -> {
                registroFrame.setVisible(false);
                this.setVisible(true);
            });

            registroFrame.add(panelRegistro);
        }
        registroFrame.setVisible(true);
    }
	
	public void mostrarVentanaHome() {
	    JFrame homeFrame = new JFrame("Bienvenido - Home");
	    homeFrame.setSize(500, 400);
	    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    homeFrame.setLocationRelativeTo(null);
	    homeFrame.setResizable(false);
	    homeFrame.setLayout(null);

	    JPanel homePanel = new JPanel();
	    homePanel.setLayout(null);
	    homePanel.setBackground(Color.decode("#bfdeed"));
	    homePanel.setBounds(0, 0, 500, 400);

	    JLabel welcomeLabel = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
	    welcomeLabel.setBounds(0, 50, 500, 50);
	    welcomeLabel.setFont(texto);
	    homePanel.add(welcomeLabel);

	    JButton logoutButton = new JButton("Cerrar Sesión");
	    logoutButton.setBounds(175, 300, 150, 50);
	    logoutButton.setFont(texto2);
	    logoutButton.setBackground(Color.WHITE);
	    logoutButton.setForeground(Color.BLACK);
	    homePanel.add(logoutButton);

	    logoutButton.addActionListener(e -> {
	        homeFrame.dispose();
	        this.setVisible(true);
	        limpiarCampos();
	    });

	    homeFrame.add(homePanel);
	    homeFrame.setVisible(true);
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
