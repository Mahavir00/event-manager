import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException; 


class Payment2 extends JFrame{
Container c;

JLabel cn,ed,cvv,name,rn;
JTextField cn1,ed1,cvv1,name1,rn1;
JButton b1;

Payment2(){
c=getContentPane();
c.setLayout(null);

cn=new JLabel("Card Number");
ed=new JLabel("Expiry-date");
cvv=new JLabel("CVV");
name=new JLabel("Name on card");
rn=new JLabel("Registration No.");

cn1=new JTextField(16);
ed1=new JTextField("yyyy-MM-dd");
cvv1=new JTextField(3);
name1=new JTextField(20);
rn1=new JTextField(9);

b1=new JButton("Pay");

c.add(b1);
c.add(cn);
c.add(ed);
c.add(cvv);
c.add(name);
c.add(rn);
c.add(cn1);
c.add(ed1);
c.add(cvv1);
c.add(name1);
c.add(rn1);

cn.setBounds(20,20,120,30);
ed.setBounds(20,70,120,30);
cvv.setBounds(20,120,120,30);
name.setBounds(20,170,120,30);
rn.setBounds(20,220,120,30);

cn1.setBounds(140,20,240,30);
ed1.setBounds(140,70,240,30);
cvv1.setBounds(140,120,240,30);
name1.setBounds(140,170,240,30);
rn1.setBounds(140,220,240,30);

b1.setBounds(150,270,100,30);

ed1.addFocusListener(new FocusListener() {
    public void focusGained(FocusEvent e) {
        ed1.setText("");
    }

    public void focusLost(FocusEvent e) {
        // nothing
    }
});

ActionListener a1=(ae)->{
Connection con=null;
try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","transactions","dbms2");
	String s1="insert into card values(?,?,?,?,?)";
	PreparedStatement p1=con.prepareStatement(s1);
	double q=Double.parseDouble(cn1.getText());
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	java.util.Date date=null;
    	try {  
        	date = formatter.parse(ed1.getText());    
   	} catch (ParseException e){
		JOptionPane.showMessageDialog(c,"Issues: "+e);
	}
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	int r=Integer.parseInt(cvv1.getText());
	String t=name1.getText();
	String y=rn1.getText();
	p1.setDouble(1,q);
	p1.setDate(2,sqlDate);
	p1.setInt(3,r);
	p1.setString(4,t);	
	p1.setString(5,y);
	int r1=p1.executeUpdate();
	JOptionPane.showMessageDialog(c,r1+" rows inserted.");	
	JOptionPane.showMessageDialog(c,"Payment Successful!");	
	this.dispose();

	s1="update transaction_history set regno=? where regno=?";
	p1=con.prepareStatement(s1);
	p1.setString(1,y);
	p1.setString(2,"18BCE0149");
	p1.executeUpdate();

	p1.close();
	Participantframe a=new Participantframe();
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
b1.addActionListener(a1);

this.setSize(400,370);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Payment2