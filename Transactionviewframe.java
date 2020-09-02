import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Transactionviewframe extends JFrame{
Container c;

JTextArea textArea;
JScrollPane scroll;
JButton b1,b2;

Transactionviewframe(){
c=getContentPane();
c.setLayout(null);

textArea = new JTextArea();
scroll = new JScrollPane(textArea);
b1=new JButton("Back");
b2=new JButton("View");

c.add(scroll);
c.add(b1);
c.add(b2);

scroll.setBounds(20,20,350,270);
b1.setBounds(225,310,100,30);
b2.setBounds(75,310,100,30);

ActionListener a1=(ae)->{
Adminframe a=new Adminframe();
this.dispose();
};
b1.addActionListener(a1);

ActionListener a2=(ae)->{
	Connection con=null;
	String z="";
	try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","transactions","dbms2");
	Statement s1=con.createStatement();
	String s2="select * from transaction_history";
	ResultSet rs=s1.executeQuery(s2);
	while(rs.next()){
	int a=rs.getInt(1);
	String b=rs.getString(2);
	String c=rs.getString(3);
	z+="Event No.: "+a+"\nStudent's Reg: "+b+"\nDate: "+c+"\n\n\n";
	}
	textArea.setText(z);
	rs.close();
	s1.close();
	}
	catch(SQLException e){
	System.out.println("Issues: "+e);
	}
	catch(NumberFormatException e){
	System.out.println("Issues: "+e);
	}
	finally{
	try{
	con.close();
	}
	catch(SQLException e){
	System.out.println("Issues: "+e);
	}
	}
};
b2.addActionListener(a2);


this.setSize(400,390);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of EventViewframe