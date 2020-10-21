package test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;
public class MainWindow {
Account acc ;
	 JFrame frame;

private static Connection con=DBConnection.getCon();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow(this.acno,this.name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainWindow(String acno,String name) {
		acc = new Account(acno,name);
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 833, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton wdButton = new JButton("WITHDRAWL");
		wdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Withdrawl(acc).setVisible(true);
		
			}
		});
		
		//wdButton.setBackground(new Color(240, 240, 240));
		wdButton.setBounds(50, 187, 208, 44);
		frame.getContentPane().add(wdButton);
		
		JButton pinButton = new JButton("PIN CHANGE");
		pinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PinChange(acc).setVisible(true);
			}
		});
		pinButton.setBounds(50, 290, 208, 44);
		frame.getContentPane().add(pinButton);
		
		JButton transferButton = new JButton("TRANSFER");
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Transfer(acc).setVisible(true);
			}
		});
		//transferButton.setBackground(new Color(240, 240, 240));
		transferButton.setBounds(50, 416, 208, 44);
		frame.getContentPane().add(transferButton);
		
		JButton depButton = new JButton("DEPOSIT");
		//depButton.setBackground(new Color(240, 240, 240));
		depButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Deposit(acc).setVisible(true);
			}
		});
		depButton.setBounds(543, 187, 208, 44);
		frame.getContentPane().add(depButton);
		
		JButton balButton = new JButton("BALANCE");
		//balButton.setBackground(new Color(240, 240, 240));
		balButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Balance is"+acc.getBalance(acc.acno));
				
		}}
			);
		balButton.setBounds(543, 290, 208, 44);
		frame.getContentPane().add(balButton);
		
		JButton transHisButton = new JButton("TRANSACTION HISTROY");
		transHisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TransactionHist(acc).setVisible(true);
			}
		});
		//transHisButton.setBackground(new Color(240, 240, 240));
		transHisButton.setBounds(543, 416, 208, 44);
		frame.getContentPane().add(transHisButton);
		
		JLabel welcomeLabel = new JLabel(" WELCOME "+acc.name);
		welcomeLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		welcomeLabel.setBounds(262, 31, 272, 72);
		frame.getContentPane().add(welcomeLabel);
	}
}
