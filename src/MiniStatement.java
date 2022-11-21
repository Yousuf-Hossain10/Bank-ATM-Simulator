import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1;
    JLabel l1;
    String pin;
    MiniStatement(String pin){
        
    	this.pin=pin;
        
    	getContentPane().setBackground(Color.WHITE);
        setSize(600,600);
        setLocation(20,20);
        
        l1 = new JLabel();
        
        add(l1);
        
        JLabel l2 = new JLabel("Your history with KoldKash");
    	l2.setFont(new Font("Garamond", Font.BOLD, 20 ));
        l2.setBounds(100, 20, 300, 20);
        add(l2);
        
        JLabel l3 = new JLabel();
    	l3.setFont(new Font("Garamond", Font.BOLD, 20 ));
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
    	l4.setFont(new Font("Garamond", Font.BOLD, 20 ));
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try{
            Connectivity connect = new Connectivity();
            ResultSet rs = connect.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Connectivity connect1 = new Connectivity();
            ResultSet rs = connect1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Taka:" +balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        b1.setBackground(Color.GRAY);
    	b1.setForeground(Color.BLACK);
    	b1.setFont(new Font("Garamond", Font.BOLD, 20 ));
        add(b1);
        
        b1.addActionListener(this);
        
        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new Transactions(pin);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}
