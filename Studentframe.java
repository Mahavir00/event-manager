import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Studentframe extends JFrame{
Container c;

JLabel reg,f_name,m_name,l_name,con_no;
JTextField reg1,f_name1,m_name1,l_name1,con_no1;
JButton b1,b2;

Studentframe(){
c=getContentPane();
c.setLayout(null);

reg=new JLabel("Registration No.");
f_name=new JLabel("First Name");
m_name=new JLabel("Middle Name");
l_name=new JLabel("Last Name");
con_no=new JLabel("Contact Number");


reg1=new JTextField(9);
f_name1=new JTextField(10);
m_name1=new JTextField(10);
l_name1=new JTextField(10);
con_no1=new JTextField(10);

b1=new JButton("Submit");
b2=new JButton("Back");

c.add(b1);
c.add(b2);
c.add(reg);
c.add(f_name);
c.add(m_name);
c.add(l_name);
c.add(con_no);

c.add(reg1);
c.add(f_name1);
c.add(m_name1);
c.add(l_name1);
c.add(con_no1);

reg.setBounds(20,20,120,30);
f_name.setBounds(20,70,120,30);
m_name.setBounds(20,120,120,30);
l_name.setBounds(20,170,120,30);
con_no.setBounds(20,220,120,30);

reg1.setBounds(140,20,240,30);
f_name1.setBounds(140,70,240,30);
m_name1.setBounds(140,120,240,30);
l_name1.setBounds(140,170,240,30);
con_no1.setBounds(140,220,240,30);

b1.setBounds(75,270,100,30);
b2.setBounds(225,270,100,30);

ActionListener a1=(ae)->{
Participantframe a=new Participantframe();
this.dispose();
};
b2.addActionListener(a1);

ActionListener a2=(ae)->{
Connection con=null;
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","transactions","dbms2");
	String s1="insert into student values(?,?,?,?,?)";
	PreparedStatement p1=con.prepareStatement(s1);
	String q=reg1.getText();
	String w=f_name1.getText();
	String e=m_name1.getText();
	String t=l_name1.getText();
	double y=Double.parseDouble(con_no1.getText());

	p1.setString(1,q);
	p1.setString(2,w);
	p1.setString(3,e);
	p1.setString(4,t);
	p1.setDouble(5,y);
	

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
b1.addActionListener(a2);

this.setSize(400,370);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Clubframe