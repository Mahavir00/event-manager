import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Adminframe extends JFrame{
Container c;
JButton b1,b2,b3;
Adminframe(){
c=getContentPane();
c.setLayout(null);

b1=new JButton("Event Details");
b2=new JButton("Transaction Details");
b3=new JButton("<");
c.add(b1);
c.add(b2);
c.add(b3);
b1.setBounds(100,20,200,30);
b2.setBounds(100,70,200,30);
b3.setBounds(5,10,45,30);

ActionListener a1=(ae)->{
Mainframe a=new Mainframe();
this.dispose();
};
b3.addActionListener(a1);

ActionListener a2=(ae)->{
Edetailsframe a=new Edetailsframe();
this.dispose();
};
b1.addActionListener(a2);

ActionListener a3=(ae)->{
Transactionviewframe a=new Transactionviewframe();
this.dispose();
};
b2.addActionListener(a3);

this.setSize(400,200);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Adminframe