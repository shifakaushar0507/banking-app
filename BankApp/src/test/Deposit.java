package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {
	Account acc;
	private JPanel contentPane;
	private JTextField amtField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit(Account acc) {
		this.acc = acc;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 682, 514);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeposit = new JLabel("Deposit Form");
		lblDeposit.setForeground(Color.BLACK);
		lblDeposit.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblDeposit.setBounds(227, 13, 203, 70);
		contentPane.add(lblDeposit);
		
		JLabel lblTypeTheAmount = new JLabel("Type the amount you want to Deposit.");
		lblTypeTheAmount.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTypeTheAmount.setBounds(77, 135, 397, 70);
		contentPane.add(lblTypeTheAmount);
		
		amtField = new JTextField();
		amtField.setBounds(239, 243, 203, 50);
		contentPane.add(amtField);
		amtField.setColumns(10);
		
		JButton DepositButton = new JButton("DEPOSIT");
		DepositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acc.deposit(Double.parseDouble(amtField.getText()));
			}
		});
		DepositButton.setBounds(274, 328, 131, 39);
		contentPane.add(DepositButton);
	}
}
