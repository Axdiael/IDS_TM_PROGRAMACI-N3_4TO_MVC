package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class HomeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 233, 233));
		panel.setBounds(0, 0, 786, 674);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 0, 786, 54);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Home View");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 521, 786, 123);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Usuarios");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Registros");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Configuración");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 171, 786, 106);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 128, 255));
		panel_8.setBounds(0, 0, 786, 10);
		panel_4.add(panel_8);
		
		JLabel lblNewLabel_1_1 = new JLabel("10");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(200, 41, 59, 46);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Notificaciones");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(312, 41, 186, 36);
		panel_4.add(lblNewLabel_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(0, 287, 786, 107);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(128, 255, 255));
		panel_9.setBounds(0, 0, 786, 10);
		panel_5.add(panel_9);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("12:30");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(200, 39, 88, 46);
		panel_5.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Hora actual");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(316, 47, 186, 36);
		panel_5.add(lblNewLabel_2_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(0, 404, 786, 117);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 128));
		panel_10.setBounds(0, 0, 786, 10);
		panel_6.add(panel_10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("500");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1_1_2.setBounds(200, 40, 59, 46);
		panel_6.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Vistas");
		lblNewLabel_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(320, 48, 186, 36);
		panel_6.add(lblNewLabel_2_1_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 54, 786, 107);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(128, 255, 128));
		panel_11.setBounds(0, 0, 786, 10);
		panel_3.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("100");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBounds(195, 40, 59, 46);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuarios registrados");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(312, 48, 186, 36);
		panel_3.add(lblNewLabel_2);
	
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UsuariosView().setVisible(true);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistrosView().setVisible(true);
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConfiguracionView().setVisible(true);
			}
		});

	
	}
	
	
	
}
