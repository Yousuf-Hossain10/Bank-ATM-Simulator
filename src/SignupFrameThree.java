import javax.swing.*;
import java.awt.*;
import java. awt.event.*;	
import java.util.Random;

public class SignupFrameThree extends JFrame implements ActionListener{

	int cardNumber, pinNumber;
	
	String formNo;
	
	JRadioButton current, savings, fixed, recurring;
	
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	
	JButton submit, cancel;
	
	SignupFrameThree(String formno){
		
		setLayout(null);
		
		this.formNo=formno;
		
		Random rand= new Random();
		
		pinNumber= rand.nextInt(100000);
		cardNumber= rand.nextInt(100000);
		
		JLabel accountDetails= new JLabel("Page 3: Account Details "); 
		accountDetails.setFont(new Font("Garamond", Font.BOLD, 20));
		accountDetails.setBounds(270,55,400,30);
		add(accountDetails);
		
	    JLabel type= new JLabel("Set Account type:");
	    type.setFont(new Font("Garamond", Font.BOLD, 20));
	    type.setBounds(100,140,200,30);
	    add (type);
	    
	    JLabel cnum= new JLabel("Your card number: XXX-26 will look like this");
	    cnum.setFont(new Font("Garamond", Font.BOLD, 20));
	    cnum.setBounds(100,500,600,30);
	    add (cnum);
	    
	    JLabel pnum= new JLabel("Your PIN: XXXX-1456 will look like this");
	    pnum.setFont(new Font("Garamond", Font.BOLD, 20));
	    pnum.setBounds(100,550,600,30);
	    add (pnum);
	    
	    current= new JRadioButton("Current Account");
	    current.setBounds(100,180,150,30);
	    current.setBackground(Color.WHITE);
	    current.setFont(new Font("Garamond", Font.BOLD, 15));
		add(current);
		
		savings= new JRadioButton("Savings Account");
		savings.setBounds(350,180,150,30);
		savings.setBackground(Color.WHITE);
		savings.setFont(new Font("Garamond", Font.BOLD, 15));
		add(savings);
			
		fixed= new JRadioButton("Fixed Deposit");
		fixed.setBounds(100,220,150,30);
		fixed.setBackground(Color.WHITE);
		fixed.setFont(new Font("Garamond", Font.BOLD, 15));
		add(fixed);
				
		recurring= new JRadioButton("Recurring Deposit");
		recurring.setBounds(350,220,150,30);
		recurring.setBackground(Color.WHITE);
		recurring.setFont(new Font("Garamond", Font.BOLD, 15));
		add(recurring);
		
		ButtonGroup accgrp= new ButtonGroup();
		accgrp.add(current);
		accgrp.add(savings);
		accgrp.add(fixed);
		accgrp.add(recurring);
	
		JLabel services= new JLabel("Services required:");
	    services.setFont(new Font("Garamond", Font.BOLD, 20));
	    services.setBounds(100,280,200,30);
	    add (services);
	    
        c1=new JCheckBox("ATM Card");	    
        c1.setBounds(100,325,150,30);
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c1);
	    
		c2=new JCheckBox("Internet Banking");	    
        c2.setBounds(350,325,150,30);
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");	    
        c3.setBounds(100,375,150,30);
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c3);
		
		c4=new JCheckBox("Email and SMS Alerts");	    
        c4.setBounds(350,375,250,30);
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c4);
		
		c5=new JCheckBox("Cheque Book");	    
        c5.setBounds(100,425,150,30);
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c5);
	
		c6=new JCheckBox("E-Statement");	    
        c6.setBounds(350,425,150,30);
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c6);
		
		c7=new JCheckBox("I hereby declare that all of the information provided, are correct to the best of my knowledge");	    
        c7.setBounds(100,680,650,30);
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Garamond", Font.BOLD, 15));
		add(c7);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.GRAY);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Garamond", Font.BOLD, 25 ));
		submit.setBounds(175,730,150,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.GRAY);
		cancel.setForeground(Color.BLACK);
		cancel.setFont(new Font("Garamond", Font.BOLD, 25 ));
		cancel.setBounds(400,730,150,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,850);
		setVisible(true);
		setLocation(350,10);	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String fnum=formNo;
		String acctype = null;
		
		if (ae.getSource()== submit) {
			
			if (current.isSelected()) {
				
				acctype="Current Account";
			
			}else if (savings.isSelected()) {
				
				acctype= "Savings Account";
			
			}else if( fixed.isSelected()) {
			
				acctype="Fixed Deposit";
			
			}else if (recurring.isSelected()) {
				acctype="Reccuring Deposit";		
			}
		}else if(ae.getSource()== cancel) {
			
		}
	
     String cardNo=""+cardNumber;
     String pinNo=""+pinNumber;
	
	 String facilities="";
	 
	 if(c1.isSelected()) {
		 
		 facilities = facilities+ "ATM Card";
		 
	 }if(c2.isSelected()) {
		 
		 facilities = facilities+ " Internet Banking";
	 
	 }if (c3.isSelected()) {
	
		 facilities = facilities+ " Mobile Banking";
		 
	 } if (c4.isSelected()) {
		 
		 facilities = facilities+ " Email and SMS Alerts";
	 
	 } if (c5.isSelected()) {
		 facilities = facilities+ " Cheque Book";
		 
	 } if (c6.isSelected()) {
		 facilities = facilities+ " E-Statement";
		 
	 }
	 
	 try {
		 
		 if(ae.getSource()==submit){

		 
		 if (acctype.equals("")) {
			 JOptionPane.showMessageDialog(null, "The National Identification Number field cannot be left empty!");
			}else {
				
				Connectivity connect= new Connectivity();
				String query1= "insert into signupthree values ('"+fnum+"', '"+cardNo+"', '"+pinNo+"','"+acctype+"', '"+facilities+"')";
				String query2= "insert into login values ('"+fnum+"', '"+cardNo+"', '"+pinNo+"')";
		        connect.s.executeUpdate(query1);
				connect.s.executeUpdate(query2);	
			    
		        JOptionPane.showMessageDialog(null, "Congratulations! the setup is complete. " + "\n Your Card Number is :" +cardNo + "\n Your Pin Number is: "+ pinNo);
			
			    setVisible(false);
			    new Deposit(pinNo).setVisible(true);;
			}
		 
	 }else if (ae.getSource()==cancel) {
		 setVisible(false);
		 new Login().setVisible(true);
		 System.exit(0);
	 }
	 }catch(Exception e ) {
		 e.printStackTrace();
         System.out.println("error: "+e);
	 }
	 
	}
	
}
