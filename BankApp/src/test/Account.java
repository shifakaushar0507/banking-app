package test;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Account {
	static int count;
	private Connection con =DBConnection.getCon();
		String acno;
		String name;
	public Account(String acno, String name) {
		super();
		this.acno = acno;
		this.name = name;
	}
	void withBal(Double balance) {
		// TODO Auto-generated method stub
		try{
		Double	newBalance =this.getBalance(acno)-balance;
		PreparedStatement ps = con.prepareStatement("update bankacc set balance = ? where acno = ? ");
		ps.setDouble(1, newBalance);
		ps.setString(2,acno);
		int k =ps.executeUpdate();
		int t = this.addtrans( "debit", balance, "withdrawl of :"+balance, acno);
		if(k > 0 || t >0){
			JOptionPane.showMessageDialog(null,"Withdrawl Succesful !!!!");
			
		}else{
			JOptionPane.showMessageDialog(null,"Error occured !!!!");
		}
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}

	}
	void deposit(Double balance) {
		// TODO Auto-generated method stub
		try{
			Double	newBalance =this.getBalance(acno)+ balance;
			PreparedStatement ps = con.prepareStatement("update bankacc set balance = ? where acno = ? ");
			ps.setDouble(1, newBalance);
			ps.setString(2,acno);
			int k =ps.executeUpdate();
			int t=this.addtrans( "credit", balance, "deposit of :"+balance, acno);
			if(k > 0 || t > 0){
				JOptionPane.showMessageDialog(null,"Deposit Succesful !!!!");
				
			}else{
				JOptionPane.showMessageDialog(null,"Error occured !!!!");
			}
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}

	}
	Double getBalance(String acno) {
		// TODO Auto-generated meth
		Double bal = 0.0;
		try {
		PreparedStatement ps = con.prepareStatement("select * from bankacc where acno = ?");
		ps.setString(1, acno);
		ResultSet rs =ps.executeQuery();
		if(rs.next())bal= rs.getDouble(4);

		}
		catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return bal;
	

	}
	 int addtrans(String type,double bal,String msg,String acno) {
			count++;
			int k = 0;
		try {
			PreparedStatement pst=con.prepareStatement("insert into transactions values(?,?,?,?,?)");
			 int tid = count;
			this.acno = acno;
			pst.setInt(1,tid);
			pst.setString(2,type);
			pst.setDouble(3,bal);
			pst.setString(4, msg);
			pst.setString(5,acno);
			 k = pst.executeUpdate();
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	
	}
	ResultSet getHistory() {
		// TODO Auto-generated method stub
		ResultSet rs =null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from transactions where acno = ?");
			ps.setString(1, acno);
			 rs =ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	 void pinChange(int pin) {
		// TODO Auto-generated method stub
		 try{
				
				PreparedStatement ps = con.prepareStatement("update bankacc set pin = ? where acno = ? ");
				ps.setDouble(1, pin);
				ps.setString(2,acno);
				int k =ps.executeUpdate();
				if(k > 0){
					JOptionPane.showMessageDialog(null,"pin Succesful !!!!");
					
				}else{
					JOptionPane.showMessageDialog(null,"Error occured !!!!");
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}

	}
	 
	 void transfer(double balance,String acn) {
		// TODO Auto-generated method stub
		
		 
		 try{
				Double	newBalance =this.getBalance(acn)+ balance;
				PreparedStatement ps = con.prepareStatement("update bankacc set balance = ? where acno = ? ");
				ps.setDouble(1, newBalance);
				ps.setString(2,acn);
				int k2 =ps.executeUpdate();
				int z =this.addtrans( "credit", balance, "Transfer in rs"+balance, acn);
				if(k2 > 0 || z > 0){
					JOptionPane.showMessageDialog(null,"transfer Succesful !!!!");
					
				}else{
					JOptionPane.showMessageDialog(null,"Error occured !!!!");
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		 try{
				Double	newBalance =this.getBalance(acno)-balance;
				PreparedStatement ps = con.prepareStatement("update bankacc set balance = ? where acno = ? ");
				ps.setDouble(1, newBalance);
				ps.setString(2,acno);
				int k1 =ps.executeUpdate();
				int z = this.addtrans( "debit", balance, "transfered out rs"+balance, acno);
				if(k1 > 0 ||z > 0){
					JOptionPane.showMessageDialog(null,"Withdrawl Succesful !!!!");
					
				}else{
					JOptionPane.showMessageDialog(null,"Error occured !!!!");
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		 }
	}


