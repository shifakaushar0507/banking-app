package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transfer extends JFrame {
Account acc;
	private JPanel contentPane;
	private JTextField amtField;
	private JTextField accnoField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer frame = new Transfer();
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
	public Transfer(Account acc) {
		this.acc=acc;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 729, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTransferForm = new JLabel("Transfer Form");
		lblTransferForm.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTransferForm.setBounds(270, 41, 177, 41);
		contentPane.add(lblTransferForm);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acc.transfer(Double.parseDouble(amtField.getText()), accnoField.getText());
				
			}
		});
		btnTransfer.setBounds(273, 310, 133, 46);
		contentPane.add(btnTransfer);
		
		JLabel lblNewLabel = new JLabel("Transfer Amount");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(64, 116, 155, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Transferee accno");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(59, 213, 171, 57);
		contentPane.add(lblNewLabel_1);
		
		amtField = new JTextField();
		amtField.setBounds(414, 134, 116, 22);
		contentPane.add(amtField);
		amtField.setColumns(10);
		
		accnoField = new JTextField();
		accnoField.setBounds(414, 231, 116, 22);
		contentPane.add(accnoField);
		accnoField.setColumns(10);
	}

}
