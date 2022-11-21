import javax.swing.*;
import java.awt.*;
import java. awt.event.*;	

public class SignupFrameTwo extends JFrame implements ActionListener{
	
    String formNo;	
	
	JTextField  nidText;
	
	JButton next;
	
	JComboBox relComb, incComb, eduComb, occupationComb;
	
	JRadioButton employee_yes, employee_no, existAcc_yes,existAcc_no;
	
	SignupFrameTwo(String formNo){
	
		    this.formNo= formNo;
		
		    setLayout(null);
			
			setTitle("New account application form page: 02");
			
			JLabel additionalDetails= new JLabel("Page 2: Additional Details"); 
			additionalDetails.setFont(new Font("Garamond", Font.BOLD, 20));
			additionalDetails.setBounds(270,55,400,30);
			add(additionalDetails);
			
			JLabel rel= new JLabel("Religion: "); 
			rel.setFont(new Font("Garamond", Font.BOLD, 20));
			rel.setBounds(110,140,100,30);
			add(rel);
			
			String relVal []= {"Muslim","Hindu","Christian","Other" };
			relComb = new JComboBox(relVal);
			relComb.setFont(new Font("Garamond", Font.BOLD, 20));
			relComb.setBounds(300,140,300,30);
			add(relComb);
			
			JLabel income= new JLabel("Income in BDT: "); 
			income.setFont(new Font("Garamond", Font.BOLD, 20));
			income.setBounds(110,220,200,30);
			add(income);
			
			String incVal []= {"<25000","<50000","<100000","<150000","<200000","300000+" };
			incComb = new JComboBox(incVal);
			incComb.setFont(new Font("Garamond", Font.BOLD, 20));
			incComb.setBounds(300,220,300,30);
			add(incComb);
			
			JLabel education= new JLabel("Education: "); 
			education.setFont(new Font("Garamond", Font.BOLD, 20));
			education.setBounds(110,300,200,30);
			add(education);
			
			String eduVal []= {"Primary","SSC","HSC","Graduate","Other" };
			eduComb = new JComboBox(eduVal);
			eduComb.setFont(new Font("Garamond", Font.BOLD, 20));
			eduComb.setBounds(300,300,300,30);
			add(eduComb);
			
			JLabel occupation= new JLabel("Occupation: "); 
			occupation.setFont(new Font("Garamond", Font.BOLD, 20));
			occupation.setBounds(110,380,200,30);
			add(occupation);
			
			String occupationVal []= {"Salaried Employee","Business Person","Medical Personel","Self Employed","Student","Other" };
			occupationComb = new JComboBox(occupationVal);
			occupationComb.setFont(new Font("Garamond", Font.BOLD, 20));
			occupationComb.setBounds(300,380,300,30);
			add(occupationComb);
						
			JLabel nID= new JLabel("NID number: "); 
			nID.setFont(new Font("Garamond", Font.BOLD, 20));
			nID.setBounds(110,460,200,30);
			add(nID);
			
			nidText= new JTextField();
			nidText.setFont(new Font("Garamond", Font.PLAIN, 20));
			nidText.setBounds(300,460,300,30);
			add(nidText);
			
			JLabel employee= new JLabel("Employee of the establishment? "); 
			employee.setFont(new Font("Garamond", Font.BOLD, 20));
			employee.setBounds(110,540,300,30);
			add(employee);
			
			employee_yes= new JRadioButton("Yes");
			employee_yes.setBounds(400,540,90,30);
			employee_yes.setBackground(Color.WHITE);
			employee_yes.setFont(new Font("Garamond", Font.BOLD, 15));
			add(employee_yes);
			
			employee_no= new JRadioButton("No");
			employee_no.setBounds(500,540,90,30);
			employee_no.setBackground(Color.WHITE);
			employee_no.setFont(new Font("Garamond", Font.BOLD, 15));
			add(employee_no);
			
			ButtonGroup employeegrp= new ButtonGroup();
			employeegrp.add(employee_yes);
			employeegrp.add(employee_no);
			
			JLabel existingAcc= new JLabel("Already have an account? "); 
			existingAcc.setFont(new Font("Garamond", Font.BOLD, 20));
			existingAcc.setBounds(110,620,300,30);
			add(existingAcc);
			
			existAcc_yes= new JRadioButton("Yes");
			existAcc_yes.setBounds(400,620,90,30);
			existAcc_yes.setBackground(Color.WHITE);
			existAcc_yes.setFont(new Font("Garamond", Font.BOLD, 15));
			add(existAcc_yes);
			
			existAcc_no= new JRadioButton("No");
			existAcc_no.setBounds(500,620,90,30);
			existAcc_no.setBackground(Color.WHITE);
			existAcc_no.setFont(new Font("Garamond", Font.BOLD, 15));
			add(existAcc_no);
			
			ButtonGroup existAccgrp= new ButtonGroup();
			existAccgrp.add(existAcc_yes);
			existAccgrp.add(existAcc_no);
			
			next=new JButton("Next");
			next.setBackground(Color.GRAY);
			next.setForeground(Color.BLACK);
			next.setFont(new Font("Garamond", Font.BOLD, 25 ));
			next.setBounds(325,700,150,30);
			next.addActionListener(this);
			add(next);
			
			getContentPane().setBackground(Color.WHITE);
			setSize(800,850);
			setVisible(true);
			setLocation(350,10);

		
		}
	
public void actionPerformed(ActionEvent ae) {
	String fnum=formNo;
	String nationalID= nidText.getText();
	String religion= (String)relComb.getSelectedItem();
	String income= (String)incComb.getSelectedItem();
	String education= (String)eduComb.getSelectedItem();
	String occupation= (String)occupationComb.getSelectedItem();
	
	
	String employedStat= null;
	
	//Getting output from the radio buttons
	if (employee_yes.isSelected()) {
		employedStat= "Yes";
		
	}else if (employee_no.isSelected()) {
		employedStat= "No";
	}
	
	String existAcc= null;
	
	if (existAcc_yes.isSelected()) {
		existAcc= "Yes";
		
	}else if (existAcc_no.isSelected()) {
		existAcc= "No";
	}
	
	try {
		if (nationalID.equals("")){
			JOptionPane.showMessageDialog(null, "The National Identification Number field cannot be left empty!");
		}else {
			
			Connectivity connect= new Connectivity();
			String query= "insert into signuptwo values ('"+fnum+"', '"+nationalID+"', '"+religion+"','"+income+"', '"+education+"', '"+occupation+"', '"+employedStat+"', '"+existAcc+"')";
	        connect.s.executeUpdate(query);	
		    
	        setVisible(false);
	        new SignupFrameThree(fnum).setVisible(true);
		}
	
	}catch(Exception e){
		 e.printStackTrace();
         System.out.println("error: "+e);
	
	}

}	
}
