import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException; 


class Eventdetailsframe extends JFrame{
Container c;

JLabel no,date,time,fees,dur,des,s_name,s_con;
JTextField no1,date1,time1,fees1,dur1,des1,s_name1,s_con1;
JButton b1,b2;


Eventdetailsframe(){
c=getContentPane();
c.setLayout(null);

b1=new JButton("Submit");
b2=new JButton("Back");

no=new JLabel("Event No.");
date=new JLabel("Date");
time=new JLabel("Time");
fees=new JLabel("Fees");
dur=new JLabel("Duration");
des=new JLabel("Description");
s_name=new JLabel("Speaker Name");
s_con=new JLabel("Speaker Number");

no1=new JTextField(4);
date1=new JTextField("yyyy-MM-dd");
time1=new JTextField(8);
fees1=new JTextField(5);
dur1=new JTextField(8);
des1=new JTextField(200);
s_name1=new JTextField(20);
s_con1=new JTextField(10);


c.add(b1);
c.add(b2);
c.add(no);
c.add(date);
c.add(time);
c.add(fees);
c.add(dur);
c.add(des);
c.add(s_name);
c.add(s_con);
c.add(no1);
c.add(date1);
c.add(time1);
c.add(fees1);
c.add(dur1);
c.add(des1);
c.add(s_name1);
c.add(s_con1);

no.setBounds(20,20,120,30);
date.setBounds(20,70,120,30);
time.setBounds(20,120,120,30);
fees.setBounds(20,170,120,30);
dur.setBounds(20,220,120,30);
des.setBounds(20,270,120,30);
s_name.setBounds(20,320,120,30);
s_con.setBounds(20,370,120,30);

no1.setBounds(140,20,240,30);
date1.setBounds(140,70,240,30);
time1.setBounds(140,120,240,30);
fees1.setBounds(140,170,240,30);
dur1.setBounds(140,220,240,30);
des1.setBounds(140,270,240,30);
s_name1.setBounds(140,320,240,30);
s_con1.setBounds(140,370,240,30);

b1.setBounds(75,420,100,30);
b2.setBounds(225,420,100,30);

ActionListener a1=(ae)->{
Eventframe a=new Eventframe();
this.dispose();
};
b2.addActionListener(a1);

date1.addFocusListener(new FocusListener() {
    public void focusGained(FocusEvent e) {
        date1.setText("");
    }

    public void focusLost(FocusEvent e) {
        // nothing
    }
});

ActionListener a2=(ae)->{
Connection con=null;
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","event","dbms1");
	String s1="insert into eventdetails values(?,?,?,?,?,?,?,?,120)";
	PreparedStatement p1=con.prepareStatement(s1);
	int q=Integer.parseInt(no1.getText());
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	java.util.Date date=null;
    	try {  
        	date = formatter.parse(date1.getText());    
   	} catch (ParseException e){
		JOptionPane.showMessageDialog(c,"Issues: "+e);
	}
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	String e=time1.getText();
	int r=Integer.parseInt(fees1.getText());
	String t=dur1.getText();
	String y=des1.getText();
	String i=s_name1.getText();
	double o=Double.parseDouble(s_con1.getText());
	p1.setInt(1,q);
	p1.setDate(2,sqlDate);
	p1.setString(3,e);
	p1.setInt(4,r);	
	p1.setString(5,t);
	p1.setString(6,y);
	p1.setString(7,i);
	p1.setDouble(8,o);
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


this.setSize(400,510);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Eventdetailsframe