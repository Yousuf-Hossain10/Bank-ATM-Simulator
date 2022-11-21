import javax.swing.*;
import java.awt.*;
import java. awt.event.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdraw, transfer, minist, pinChange, exit;
	
	String pinNumber;
	
	Transactions(String pinNum) {
		
		setLayout(null);
		
		this.pinNumber= pinNum;
		
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Homepage.jpg"));
		Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon image3= new ImageIcon(image2);
		JLabel label = new JLabel(image3);
		add(label);
		label.setBounds(100,50,100,100);
		
		JLabel text1= new JLabel("Please select your transacions"); 
		text1.setFont(new Font("Garamond", Font.BOLD, 25));
		text1.setBounds(250,55,400,30);
		add(text1);
		
		deposit=new JButton("Deposit");
		deposit.setBackground(Color.GRAY);
		deposit.setForeground(Color.BLACK);
		deposit.setFont(new Font("Garamond", Font.BOLD, 20 ));
		deposit.setBounds(100,200,150,30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdraw=new JButton("Cash Withdrawal");
		withdraw.setBackground(Color.GRAY);
		withdraw.setForeground(Color.BLACK);
		withdraw.setFont(new Font("Garamond", Font.BOLD, 20 ));
		withdraw.setBounds(325,150,250,30);
		withdraw.addActionListener(this);
		add(withdraw);
		
		transfer=new JButton("Fast Cash");
		transfer.setBackground(Color.GRAY);
		transfer.setForeground(Color.BLACK);
		transfer.setFont(new Font("Garamond", Font.BOLD, 20 ));
		transfer.setBounds(325,300,250,30);
		transfer.addActionListener(this);
		add(transfer);
		
		minist=new JButton("Mini Statement");
		minist.setBackground(Color.GRAY);
		minist.setForeground(Color.BLACK);
		minist.setFont(new Font("Garamond", Font.BOLD, 20 ));
		minist.setBounds(325,200,250,30);
		minist.addActionListener(this);
		add(minist);
		
		pinChange=new JButton("PIN Change");
		pinChange.setBackground(Color.GRAY);
		pinChange.setForeground(Color.BLACK);
		pinChange.setFont(new Font("Garamond", Font.BOLD, 20 ));
		pinChange.setBounds(325,250,250,30);
		pinChange.addActionListener(this);
		add(pinChange);
			
		exit=new JButton("Exit");
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Garamond", Font.BOLD, 20 ));
		exit.setBounds(100,250,150,30);
		exit.addActionListener(this);
		add(exit);
	
	getContentPane().setBackground(Color.WHITE);
	setSize(650,500);
	setVisible(true);
	setLocation(350,10);
	
	}
	
	
	public void actionPerformed (ActionEvent ae) {
		
		if (ae.getSource()==exit) {
			
			System.exit(0);		
			
		}else if (ae.getSource()==deposit) {
				
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
				
			}else if (ae.getSource()==withdraw) {
				
				setVisible(false);
				new Withdrawal(pinNumber).setVisible(true);
			
			}else if (ae.getSource()==transfer) {
				
				setVisible(false);
				new FastCash(pinNumber).setVisible(true);
			
			}else if (ae.getSource()==pinChange) {
				
				setVisible(false);
				new PinChange(pinNumber).setVisible(true);
			
			} else if (ae.getSource()==minist) {
				
				setVisible(false);
				new MiniStatement(pinNumber).setVisible(true);
			}							
		
	}
		
	public static void main(String [] args) {
		
		new Transactions("");
	}

}
