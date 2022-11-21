import javax.swing.*;
import java.awt.*;
import java. awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, withdraw, transfer, minist, pinChange, balanceEnq, exit;
	
	String pinNumber;
	
	FastCash(String pinNum) {
		
		setLayout(null);
		
		this.pinNumber= pinNum;
		
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Homepage.jpg"));
		Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon image3= new ImageIcon(image2);
		JLabel label = new JLabel(image3);
		add(label);
		label.setBounds(100,25,100,100);
		
		JLabel text1= new JLabel("Please select an Amount"); 
		text1.setFont(new Font("Garamond", Font.BOLD, 25));
		text1.setBounds(225,55,400,30);
		add(text1);
		
		deposit=new JButton("Taka 10000");
		deposit.setBackground(Color.GRAY);
		deposit.setForeground(Color.BLACK);
		deposit.setFont(new Font("Garamond", Font.BOLD, 20 ));
		deposit.setBounds(225,400,250,30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdraw=new JButton("Taka 200");
		withdraw.setBackground(Color.GRAY);
		withdraw.setForeground(Color.BLACK);
		withdraw.setFont(new Font("Garamond", Font.BOLD, 20 ));
		withdraw.setBounds(225,150,250,30);
		withdraw.addActionListener(this);
		add(withdraw);
		
		transfer=new JButton("Taka 5000");
		transfer.setBackground(Color.GRAY);
		transfer.setForeground(Color.BLACK);
		transfer.setFont(new Font("Garamond", Font.BOLD, 20 ));
		transfer.setBounds(225,350,250,30);
		transfer.addActionListener(this);
		add(transfer);
		
		minist=new JButton("Taka 500");
		minist.setBackground(Color.GRAY);
		minist.setForeground(Color.BLACK);
		minist.setFont(new Font("Garamond", Font.BOLD, 20 ));
		minist.setBounds(225,200,250,30);
		minist.addActionListener(this);
		add(minist);
		
		pinChange=new JButton("Taka 2000");
		pinChange.setBackground(Color.GRAY);
		pinChange.setForeground(Color.BLACK);
		pinChange.setFont(new Font("Garamond", Font.BOLD, 20 ));
		pinChange.setBounds(225,300,250,30);
		pinChange.addActionListener(this);
		add(pinChange);
		
		balanceEnq=new JButton("Taka 1000");
		balanceEnq.setBackground(Color.GRAY);
		balanceEnq.setForeground(Color.BLACK);
		balanceEnq.setFont(new Font("Garamond", Font.BOLD, 20 ));
		balanceEnq.setBounds(225,250,250,30);
		balanceEnq.addActionListener(this);
		add(balanceEnq);
		
		exit=new JButton("Back");
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Garamond", Font.BOLD, 20 ));
		exit.setBounds(225,450,250,30);
		exit.addActionListener(this);
		add(exit);
	
	getContentPane().setBackground(Color.WHITE);
	setSize(550,550);
	setVisible(true);
	setLocation(350,10);
	
	}
	
	
	public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(5); //k
            Connectivity connection = new Connectivity();
            ResultSet rs = connection.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            
            }else{
                Date date = new Date();
                connection.s.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Taka. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
		
	public static void main(String [] args) {
		
		new FastCash("");
	}

}
