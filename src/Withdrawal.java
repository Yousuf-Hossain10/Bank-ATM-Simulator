import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Withdrawal extends JFrame implements ActionListener{
	
	JTextField amount;
	
	JButton withdraw, back;
    
	String pinNum;
	
    Withdrawal(String pinNum) {
		
		this.pinNum=pinNum;
		setLayout(null);
	
	ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Homepage.jpg"));
	Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon image3= new ImageIcon(image2);
	JLabel label = new JLabel(image3);
	add(label);
	label.setBounds(75,50,100,100);
	
	JLabel text1= new JLabel("Please enter the Withdrawal amount"); 
	text1.setFont(new Font("Garamond", Font.BOLD, 25));
	text1.setBounds(200,55,450,30);
	add(text1);
	
	amount= new JTextField();
	amount.setFont(new Font("Garamond", Font.PLAIN, 20));
	amount.setBounds(200,100,300,30);
	add(amount);
	
	withdraw=new JButton("Withdraw");
	withdraw.setBackground(Color.GRAY);
	withdraw.setForeground(Color.BLACK);
	withdraw.setFont(new Font("Garamond", Font.BOLD, 20 ));
	withdraw.setBounds(200,200,150,30);
	withdraw.addActionListener(this);
	add(withdraw);
	
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
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String Wamount = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(withdraw.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Connectivity connection = new Connectivity();
                    
                    ResultSet rs = connection.s.executeQuery("select * from bank where pin = '"+pinNum+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(Wamount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance to perform action");
                        return;
                    }
                    
                    connection.s.executeUpdate("insert into bank values('"+pinNum+"', '"+date+"', 'Withdrawl', '"+Wamount+"')");
                    JOptionPane.showMessageDialog(null, "Taka "+Wamount+" withdrawn Successfully");
                    
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinNum).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

	
	public static void main(String[] args) {
		new Withdrawal("");

	}

}
