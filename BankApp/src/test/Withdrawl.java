package test;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Withdrawl extends JFrame {
	Account acc ;
	private JPanel contentPane;
	private static JTextField amtField;
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawl frame = new Withdrawl();
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
	public Withdrawl(Account acc) {
		this.acc = acc;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 682, 514);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		amtField = new JTextField();
		amtField.setBounds(238, 238, 203, 50);
		contentPane.add(amtField);
		amtField.setColumns(10);
		
		JButton wDbutton = new JButton("WITHDRAW");
		wDbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				acc.withBal(Double.parseDouble(amtField.getText()));
				
				
			}
		});
		wDbutton.setBounds(274, 328, 131, 39);
		contentPane.add(wDbutton);
		
		JLabel lblTypeTheAmount = new JLabel("Type the amount you want to withdraw.");
		lblTypeTheAmount.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTypeTheAmount.setBounds(77, 135, 397, 70);
		contentPane.add(lblTypeTheAmount);
		
		JLabel lblWithdrawlForm = new JLabel("WithDrawl Form");
		lblWithdrawlForm.setForeground(Color.BLACK);
		lblWithdrawlForm.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblWithdrawlForm.setBounds(227, 13, 203, 70);
		contentPane.add(lblWithdrawlForm);
	}

}
