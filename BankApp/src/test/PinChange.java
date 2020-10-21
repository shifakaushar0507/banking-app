package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PinChange extends JFrame {
	Account acc;
	private JPanel contentPane;
	private JTextField pinField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PinChange(Account acc) {
		this.acc=acc;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 647, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPinChange = new JLabel("Pin Change");
		lblPinChange.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblPinChange.setBounds(229, 26, 155, 46);
		contentPane.add(lblPinChange);
		
		pinField = new JTextField();
		pinField.setBounds(212, 223, 146, 22);
		contentPane.add(pinField);
		pinField.setColumns(10);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acc.pinChange(Integer.parseInt(pinField.getText()));
			}
		});
		btnSubmit.setBounds(246, 309, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblNewPin = new JLabel("new pin");
		lblNewPin.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewPin.setBounds(228, 162, 130, 37);
		contentPane.add(lblNewPin);
	}

}
