import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Clubframe extends JFrame{
Container c;

JLabel name,fc,cd,con_name,con_no;
JTextField name1,fc1,cd1,con_name1,con_no1;
JButton b1,b2;

Clubframe(){
c=getContentPane();
c.setLayout(null);

name=new JLabel("Name");
fc=new JLabel("Faculty Coord.");
cd=new JLabel("Description");
con_name=new JLabel("Contact Person");
con_no=new JLabel("Contact Number");

name1=new JTextField(20);
fc1=new JTextField(20);
cd1=new JTextField(200);
con_name1=new JTextField(20);
con_no1=new JTextField(10);

b1=new JButton("Submit");
b2=new JButton("Back");

c.add(b1);
c.add(b2);
c.add(name);
c.add(fc);
c.add(cd);
c.add(con_name);
c.add(con_no);
c.add(name1);
c.add(fc1);
c.add(cd1);
c.add(con_name1);
c.add(con_no1);


name.setBounds(20,20,120,30);
fc.setBounds(20,70,120,30);
cd.setBounds(20,120,120,30);
con_name.setBounds(20,170,120,30);
con_no.setBounds(20,220,120,30);

name1.setBounds(140,20,240,30);
fc1.setBounds(140,70,240,30);
cd1.setBounds(140,120,240,30);
con_name1.setBounds(140,170,240,30);
con_no1.setBounds(140,220,240,30);

b1.setBounds(75,270,100,30);
b2.setBounds(225,270,100,30);

ActionListener a1=(ae)->{
Edetailsframe a=new Edetailsframe();
this.dispose();
};
b2.addActionListener(a1);

ActionListener a2=(ae)->{
Connection con=null;
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","event","dbms1");
	String s1="insert into club values(?,?,?,?,?)";
	PreparedStatement p1=con.prepareStatement(s1);
	String cnam=name1.getText();
	String f=fc1.getText();
	String c1=cd1.getText();
	String con_nam=con_name1.getText();
	double con_n=Double.parseDouble(con_no1.getText());
	p1.setString(1,cnam);
	p1.setString(2,f);
	p1.setString(3,c1);
	p1.setString(4,con_nam);
	p1.setDouble(5,con_n);
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