import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java. awt.event.*;	

public class SignupFrameOne extends JFrame implements ActionListener{
	
	int randomNumber1;	
	
	String sRandNum1 = ""+randomNumber1;
	
	JTextField nameText, fNameText, emailText, phoneText, addressText, address2Text;
	
	JButton next;
	
	JDateChooser dobChooser;
	
	JRadioButton male, female, other, married, unmarried, other2;
	
	SignupFrameOne(){
			setLayout(null);
			
			//Generating a 4 Digit Random Application Number
			Random rand= new Random();
			randomNumber1= rand.nextInt(10000);
			
			
			JLabel formNo= new JLabel("YOUR APPLICATION FORM NUMBER IS: "+ randomNumber1); 
			formNo.setFont(new Font("Garamond", Font.BOLD, 25));
			formNo.setBounds(130,20,600,40);
			add(formNo);
			
			JLabel personalDetails= new JLabel("Page 1: Personal Details"); 
			personalDetails.setFont(new Font("Garamond", Font.BOLD, 20));
			personalDetails.setBounds(270,55,400,30);
			add(personalDetails);
			
			JLabel name= new JLabel("Name: "); 
			name.setFont(new Font("Garamond", Font.BOLD, 20));
			name.setBounds(110,140,100,30);
			add(name);
			
			nameText= new JTextField();
			nameText.setFont(new Font("Garamond", Font.PLAIN, 20));
			nameText.setBounds(300,140,300,30);
			add(nameText);
			
			JLabel fName= new JLabel("Father's Name: "); 
			fName.setFont(new Font("Garamond", Font.BOLD, 20));
			fName.setBounds(110,190,200,30);
			add(fName);
			
			fNameText= new JTextField();
			fNameText.setFont(new Font("Garamond", Font.PLAIN, 20));
			fNameText.setBounds(300,190,300,30);
			add(fNameText);
			
			JLabel dob= new JLabel("Date of Birth: "); 
			dob.setFont(new Font("Garamond", Font.BOLD, 20));
			dob.setBounds(110,240,200,30);
			add(dob);
			
			dobChooser= new JDateChooser();
			dobChooser.setBounds(300,240,300,30);
			add(dobChooser);
			
			JLabel gender= new JLabel("Gender: "); 
			gender.setFont(new Font("Garamond", Font.BOLD, 20));
			gender.setBounds(110,290,200,30);
			add(gender);
			
			male= new JRadioButton("Male");
			male.setBounds(300,290,60,30);
		    male.setFont(new Font("Garamond", Font.BOLD, 15));
			male.setBackground(Color.WHITE);
			add(male);
			
			female= new JRadioButton("Female");
			female.setBounds(390,290,100,30);
			female.setFont(new Font("Garamond", Font.BOLD, 15));
			female.setBackground(Color.WHITE);
			add(female);
			
			other= new JRadioButton("Other");
			other.setBounds(500,290,120,30);
			other.setFont(new Font("Garamond", Font.BOLD, 15));
			other.setBackground(Color.WHITE);
			add(other);
			
			ButtonGroup gendergrp= new ButtonGroup();
			gendergrp.add(male);
			gendergrp.add(female);
			gendergrp.add(other);
			
			JLabel email= new JLabel("Email: "); 
			email.setFont(new Font("Garamond", Font.BOLD, 20));
			email.setBounds(110,340,200,30);
			add(email);
			
			emailText= new JTextField();
			emailText.setFont(new Font("Garamond", Font.PLAIN, 20));
			emailText.setBounds(300,340,300,30);
			add(emailText);
			
			JLabel phNum= new JLabel("Phone Number: "); 
			phNum.setFont(new Font("Garamond", Font.BOLD, 20));
			phNum.setBounds(110,390,200,30);
			add(phNum);
			
			phoneText= new JTextField();
			phoneText.setFont(new Font("Garamond", Font.PLAIN, 20));
			phoneText.setBounds(300,390,300,30);
			add(phoneText);
			
			JLabel mstatus= new JLabel("Marital Status: "); 
			mstatus.setFont(new Font("Garamond", Font.BOLD, 20));
			mstatus.setBounds(110,440,200,30);
			add(mstatus);
			
			married= new JRadioButton("Married");
			married.setBounds(300,440,90,30);
			married.setFont(new Font("Garamond", Font.BOLD, 15));
			married.setBackground(Color.WHITE);
			add(married);
			
			unmarried= new JRadioButton("Unmarried");
			unmarried.setBounds(390,440,110,30);
			unmarried.setBackground(Color.WHITE);
			unmarried.setFont(new Font("Garamond", Font.BOLD, 15));
			add(unmarried);
			
			other2= new JRadioButton("Other");
			other2.setBounds(500,440,100,30);
			other2.setBackground(Color.WHITE);
			other2.setFont(new Font("Garamond", Font.BOLD, 15));
			add(other2);
			
			ButtonGroup maritalgrp= new ButtonGroup();
			maritalgrp.add(married);
			maritalgrp.add(unmarried);
			maritalgrp.add(other2);
			
			JLabel address= new JLabel("Present Address: "); 
			address.setFont(new Font("Garamond", Font.BOLD, 20));
			address.setBounds(110,490,200,30);
			add(address);
			
			addressText= new JTextField();
			addressText.setFont(new Font("Garamond", Font.PLAIN, 20));
			addressText.setBounds(300,490,300,30);
			add(addressText);
			
			JLabel address2= new JLabel("Permanent Address: "); 
			address2.setFont(new Font("Garamond", Font.BOLD, 20));
			address2.setBounds(110,540,200,30);
			add(address2);
				
			address2Text= new JTextField();
			address2Text.setFont(new Font("Garamond", Font.PLAIN, 20));
			address2Text.setBounds(300,540,300,30);
			add(address2Text);
			
			next=new JButton("Next");
			next.setBackground(Color.GRAY);
			next.setForeground(Color.BLACK);
			next.setFont(new Font("Garamond", Font.BOLD, 25 ));
			next.setBounds(375,700,150,30);
			next.addActionListener(this);
			add(next);
			
			getContentPane().setBackground(Color.WHITE);
			setSize(800,850);
			setVisible(true);
			setLocation(350,10);

		
		}
	
public void actionPerformed(ActionEvent ae) {
	String formNo= ""+randomNumber1;
	String name= nameText.getText();
	String fName= fNameText.getText();
	String email= emailText.getText();
	String phoneNo= phoneText.getText();
	String pREAddress= addressText.getText();
	String pERAddress= address2Text.getText();
	String dOB= ((JTextField)dobChooser.getDateEditor().getUiComponent()).getText();
	String gender= null;
	
	//Getting output from the radio buttons
	if (male.isSelected()) {
		gender= "Male";
		
	}else if (female.isSelected()) {
		gender= "Female";
	}else if(other.isSelected()) {
		gender= "Other";
		
	}
	
	String marStat= null;
	
	if (married.isSelected()) {
		marStat= "Married";
		
	}else if (unmarried.isSelected()) {
		marStat= "Unmarried";
	}else if(other2.isSelected()) {
		marStat= "Other";
		
	}
	
	try {
		if (name.equals("")){
			JOptionPane.showMessageDialog(null, "The name field cannot be left empty!");
		}else {
			
			Connectivity connect= new Connectivity();
			String query= "insert into signup values ('"+formNo+"', '"+name+"', '"+dOB+"','"+fName+"', '"+gender+"', '"+email+"', '"+phoneNo+"', '"+pREAddress+"', '"+pERAddress+"', '"+marStat+"')";
	        connect.s.executeUpdate(query);	
		    
	        setVisible(false);
	        new SignupFrameTwo(formNo).setVisible(true);
	        
		}
	
	}catch(Exception e){
		 e.printStackTrace();
         System.out.println("error: "+e);
	
	}

}
	
	public static void main(String [] args) {
	
	new SignupFrameOne();
}

	
}
