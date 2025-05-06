package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class ConfiguracionView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConfiguracionView() {
		setTitle("Configuración");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
