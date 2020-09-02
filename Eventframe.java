import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException; 


class Eventframe extends JFrame{
Container c;

JLabel no,name,cn,cor_name,cor_no,rn;
JTextField no1,name1,cn1,cor_name1,cor_no1,rn1;
JButton b1,b2,b3;

Eventframe(){
c=getContentPane();
c.setLayout(null);

no=new JLabel("Number");
name=new JLabel("Name");
cn=new JLabel("Club Name");
cor_name=new JLabel("Co-ordinator");
cor_no=new JLabel("Co-ordinator Number");
rn=new JLabel("Room No.");

no1=new JTextField(4);
name1=new JTextField(20);
cn1=new JTextField(20);
cor_name1=new JTextField(20);
cor_no1=new JTextField(10);
rn1=new JTextField(4);

b1=new JButton("Event Details");
b2=new JButton("Submit");
b3=new JButton("Back");

c.add(no);
c.add(name);
c.add(cn);
c.add(cor_name);
c.add(cor_no);
c.add(rn);
c.add(no1);
c.add(name1);
c.add(cn1);
c.add(cor_name1);
c.add(cor_no1);
c.add(rn1);

c.add(b1);
c.add(b2);
c.add(b3);

no.setBounds(20,20,120,30);
name.setBounds(20,70,120,30);
cn.setBounds(20,120,120,30);
cor_name.setBounds(20,170,120,30);
cor_no.setBounds(20,220,120,30);
rn.setBounds(20,270,120,30);

no1.setBounds(140,20,240,30);
name1.setBounds(140,70,240,30);
cn1.setBounds(140,120,240,30);
cor_name1.setBounds(140,170,240,30);
cor_no1.setBounds(140,220,240,30);
rn1.setBounds(140,270,240,30);

b1.setBounds(25,320,100,30);
b2.setBounds(150,320,100,30);
b3.setBounds(275,320,100,30);

ActionListener a1=(ae)->{
Edetailsframe a=new Edetailsframe();
this.dispose();
};
b3.addActionListener(a1);

ActionListener a3=(ae)->{
Eventdetailsframe a=new Eventdetailsframe();
this.dispose();
};
b1.addActionListener(a3);

ActionListener a2=(ae)->{
Connection con=null;
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","event","dbms1");
	String s1="insert into event values(?,?,?,?,?,?)";
	PreparedStatement p1=con.prepareStatement(s1);
	int q=Integer.parseInt(no1.getText());
	String w=name1.getText();
	String e=cn1.getText();
	String t=cor_name1.getText();
	double y=Double.parseDouble(cor_no1.getText());
	int u=Integer.parseInt(rn1.getText());

	p1.setInt(1,q);
	p1.setString(2,w);
	p1.setString(3,e);
	p1.setString(4,t);
	p1.setDouble(5,y);
	p1.setInt(6,u);

	int r1=p1.executeUpdate();
	JOptionPane.showMessageDialog(c,r1+" rows inserted.");	
	p1.close();	
}
catch(SQLException e){
	JOptionPane.showMessageDialog(c,"Issues: "+e);
}
catch(NumberFormatException e){
	JOptionPane.showMessageDialog(c,"Issues: "+e);
}
finally{
	try{
	con.close();
	}
	catch(SQLException e){
		JOptionPane.showMessageDialog(c,"Issues: "+e);
	}
}
};
b2.addActionListener(a2);

this.setSize(400,420);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Eventframe



