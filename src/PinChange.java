import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

	JPasswordField pinText , reText;
	JButton change,back;
	String pinNum;
	PinChange(String pinNum) {
		
		setLayout(null);
		
		this.pinNum=pinNum;
		
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Homepage.jpg"));
		Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon image3= new ImageIcon(image2);
		JLabel label = new JLabel(image3);
		add(label);
		label.setBounds(100,25,100,100);
		
		JLabel text1= new JLabel("Want to change the PIN?"); 
		text1.setFont(new Font("Garamond", Font.BOLD, 25));
		text1.setBounds(225,55,400,30);
		add(text1);
		
		JLabel text2= new JLabel("Enter the new PIN:"); 
		text2.setFont(new Font("Garamond", Font.BOLD, 25));
		text2.setBounds(50,200,300,30);
		add(text2);
		
		JLabel text3= new JLabel("Repeat new PIN to confirm:"); 
		text3.setFont(new Font("Garamond", Font.BOLD, 25));
		text3.setBounds(50,250,320,30);
		add(text3);
		
		pinText= new JPasswordField();
		pinText.setFont(new Font("Garamond", Font.PLAIN, 20));
		pinText.setBounds(360,200,200,30);
		add(pinText);
		
		reText= new JPasswordField();
		reText.setFont(new Font("Garamond", Font.PLAIN, 20));
		reText.setBounds(360,250,200,30);
		add(reText);
		
		change=new JButton("Change");
		change.setBackground(Color.GRAY);
		change.setForeground(Color.BLACK);
		change.setFont(new Font("Garamond", Font.BOLD, 20 ));
		change.setBounds(100,400,150,30);
		change.addActionListener(this);
		add(change);
		
		back=new JButton("Back");
		back.setBackground(Color.GRAY);
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Garamond", Font.BOLD, 20 ));
		back.setBounds(300,400,150,30);
		back.addActionListener(this);
		add(back);
	
	getContentPane().setBackground(Color.WHITE);
	setSize(600,600);
	setVisible(true);
	setLocation(350,10);
	
	}
	

    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = String.valueOf(pinText.getPassword());
            String rpin = String.valueOf(reText.getPassword());
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PINs do not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (change.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (change.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Connectivity c1 = new Connectivity();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNum+"' ";
                String q2 = "update login set pinNo = '"+rpin+"' where pinNo = '"+pinNum+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinNum+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pinNum).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


	
	public static void main(String[] args) {
		
		new PinChange("");

	}
}

