import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;  

public class Deposit extends JFrame implements ActionListener{
	
	JTextField amount;
	
	JButton deposit, back;
    
	String pinNum;
	
    Deposit(String pinNum) {
		
		this.pinNum=pinNum;
		setLayout(null);
	
	ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Homepage.jpg"));
	Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon image3= new ImageIcon(image2);
	JLabel label = new JLabel(image3);
	add(label);
	label.setBounds(75,50,100,100);
	
	JLabel text1= new JLabel("Please enter the Deposit amount"); 
	text1.setFont(new Font("Garamond", Font.BOLD, 25));
	text1.setBounds(200,55,450,30);
	add(text1);
	
	amount= new JTextField();
	amount.setFont(new Font("Garamond", Font.PLAIN, 20));
	amount.setBounds(200,100,300,30);
	add(amount);
	
	deposit=new JButton("Deposit");
	deposit.setBackground(Color.GRAY);
	deposit.setForeground(Color.BLACK);
	deposit.setFont(new Font("Garamond", Font.BOLD, 20 ));
	deposit.setBounds(200,200,150,30);
	deposit.addActionListener(this);
	add(deposit);
	
	back=new JButton("Back");
	back.setBackground(Color.GRAY);
	back.setForeground(Color.BLACK);
	back.setFont(new Font("Garamond", Font.BOLD, 20 ));
	back.setBounds(400,200,150,30);
	back.addActionListener(this);
	add(back);
	
	getContentPane().setBackground(Color.WHITE);
	setSize(650,300);
	setVisible(true);
	setLocation(350,10);

	
	}
    
    public void actionPerformed(ActionEvent ae) {
    	if (ae.getSource()==deposit) {
    		String depAmount= amount.getText();
    		String pin=pinNum;
    		Date date= new Date();
    		if (depAmount.equals(null)) {
    			
    			JOptionPane.showMessageDialog(null, "The deposit amount cannot be left empty plz specify an amount");
    		
    		}else {
    			
    			try {
    			Connectivity connection = new Connectivity();
    			String query= "insert into bank values ('"+pin+"', '"+date+"', 'Deposit' , '"+depAmount+"')";
    			connection.s.executeUpdate(query);
    			JOptionPane.showMessageDialog(null, "Taka "+depAmount+" Deposited successfully!");
    			setVisible(false);
    			new Transactions(pin);
    		
    			}catch(Exception e) {
    				 e.printStackTrace();
    	                System.out.println("error: "+e);
    		}
    		}
    	}else if (ae.getSource()==back) {
    	   
    		setVisible(false);
    		new Transactions(pinNum).setVisible(true);
    	
    	}
    }
	
	public static void main(String[] args) {
		new Deposit("");

	}

}


