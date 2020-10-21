package test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class LoginForm {

	private static JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblLoginForm.setBackground(Color.WHITE);
		lblLoginForm.setBounds(220, 33, 134, 38);
		frame.getContentPane().add(lblLoginForm);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 129, 122, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 207, 130, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(270, 139, 116, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(270, 214, 116, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try{
				Connection con =DBConnection.getCon();
				String uname = username.getText();
				int pin =Integer.parseInt(passwordField.getText());
				PreparedStatement ps = con.prepareStatement("select * from bankacc where acno = ? and pin = ? ");
				ps.setString(1, uname);
				ps.setInt(2, pin );
				ResultSet rs = ps.executeQuery();
				if (rs.next()){
					JOptionPane.showMessageDialog(null, "Login succesfull!!! ");
					frame.setVisible(false);
					new MainWindow(rs.getString(1),rs.getString(3)).frame.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"login details mismatch","login error",JOptionPane.ERROR_MESSAGE);
				}
			}catch(Exception ex){ex.printStackTrace();}
			}
			
		});
		btnLogin.setBounds(139, 314, 159, 38);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 299, 537, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(218, 84, 134, 2);
		frame.getContentPane().add(separator_1);
	}
}
