package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

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

        mensajeLabel = new JLabel("", SwingConstants.CENTER);
        mensajeLabel.setBounds(50, 360, 320, 30);
        mensajeLabel.setFont(texto2);
        panelLogin.add(mensajeLabel);

        this.add(panelLogin);
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

    public void limpiarCampos() {
        usuarioField.setText("");
        contraseñaField.setText("");
        mensajeLabel.setText("");
    }
}