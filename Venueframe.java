import java.util.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


class Venueframe extends JFrame{
Container c;

JLabel rno,bldg,room;
JTextField rno1,bldg1,room1;
JButton b1,b2;

Venueframe(){
c=getContentPane();
c.setLayout(null);

rno=new JLabel("Room Id");
bldg=new JLabel("Building");
room=new JLabel("Room No.");

rno1=new JTextField(4);
bldg1=new JTextField(20);
room1=new JTextField(4);

b1=new JButton("Submit");
b2=new JButton("Back");

c.add(b1);
c.add(b2);
c.add(rno);
c.add(bldg);
c.add(room);
c.add(rno1);
c.add(bldg1);
c.add(room1);


rno.setBounds(20,20,120,30);
bldg.setBounds(20,70,120,30);
room.setBounds(20,120,120,30);

rno1.setBounds(140,20,240,30);
bldg1.setBounds(140,70,240,30);
room1.setBounds(140,120,240,30);

b1.setBounds(75,170,100,30);
b2.setBounds(225,170,100,30);

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
	String s1="insert into venue values(?,?,?)";
	PreparedStatement p1=con.prepareStatement(s1);
	int rn=Integer.parseInt(rno1.getText());
	String bld=bldg1.getText();
	int roo=Integer.parseInt(room1.getText());
	p1.setInt(1,rn);
	p1.setString(2,bld);
	p1.setInt(3,roo);
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

this.setSize(400,250);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Venueframe