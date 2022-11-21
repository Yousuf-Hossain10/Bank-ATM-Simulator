import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
	JButton signIn, signUp, clear;
	JTextField cardText;
    JPasswordField pinText;
	Login(){
		setTitle ("Simple ATM Simulator");
		setLayout(null);
		
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Homepage.jpg"));
		Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon image3= new ImageIcon(image2);
		JLabel label = new JLabel(image3);
		add(label);
		label.setBounds(120,20,100,100);
		
		JLabel welcomeText= new JLabel("Welcome to KoldKash");
		welcomeText.setFont(new Font("Garamond", Font.BOLD, 32 ));
		welcomeText.setBounds(260,40,400,40);
		add(welcomeText);
		
		JLabel cardNum= new JLabel("Card No :");
		cardNum.setFont(new Font("Garamond", Font.BOLD, 25 ));
		cardNum.setBounds(120,150,150,40);
		add(cardNum);
		
		cardText= new JTextField();
		cardText.setBounds(300, 150, 250, 30);
		cardText.setFont(new Font("Garamond", Font.BOLD, 25));
		add(cardText);
		
		JLabel pinNum= new JLabel("PIN No :");
		pinNum.setFont(new Font("Garamond", Font.BOLD, 25 ));
		pinNum.setBounds(120,220,400,40);
		add(pinNum);
		
		pinText= new JPasswordField();
		pinText.setBounds(300, 220, 250, 30 );
		cardText.setFont(new Font("Garamond", Font.BOLD, 25));
		add(pinText);
		
		signIn= new JButton("Sign In");
		signIn.setBounds(300,300,120,30);
		signIn.setBackground(Color.GRAY);
		signIn.setForeground(Color.BLACK);
		signIn.addActionListener(this);
		signIn.setFont(new Font("Garamond", Font.BOLD, 20));
		add(signIn);
		
		clear= new JButton("Clear");
		clear.setBounds(430,300,120,30);
		clear.setBackground(Color.GRAY);
		clear.setForeground(Color.BLACK);
		clear.addActionListener(this);
		clear.setFont(new Font("Garamond", Font.BOLD, 20));
		add(clear);
		
		signUp= new JButton("Sign Up");
		signUp.setBounds(300,350,250,30);
		signUp.setBackground(Color.GRAY);
		signUp.setForeground(Color.BLACK);
		signUp.setFont(new Font("Garamond", Font.BOLD, 20));
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(700,500);
		setVisible(true);
		setLocation(350,200);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== clear) {
			
			cardText.setText("");
			pinText.setText("");
			
		} else if(ae.getSource()== signIn) {
			
			Connectivity connection = new Connectivity();
			String cardNum= cardText.getText();
			String pinNum = String.valueOf(pinText.getPassword());
			String query = "select * from login where cardNo= '"+cardNum+"' and pinNo = '"+pinNum+"'";
		
		    try {
		    	ResultSet rs= connection.s.executeQuery(query);
		        
		       if (rs.next()) {
		    	   
		    	   setVisible(false);
		           new Transactions(pinNum).setVisible(true);
		       
		       }else {
		    	   
		    	   JOptionPane.showMessageDialog(null,"The credentials do not match, please try again");
		       }
		    
		    }catch(Exception e) {
		    	
		    	 e.printStackTrace();
	                System.out.println("error: "+e);
		    	
		    }
		
		
		
		
		
		} else if(ae.getSource()== signUp) {
			setVisible(false);
			new SignupFrameOne().setVisible(true);
			
		}
	}
	
	
	public static void main (String[]args) {
		
		new Login();
		
		}
 
}
