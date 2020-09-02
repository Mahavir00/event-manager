import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Edetailsframe extends JFrame{

Container c;
JButton b1,b2,b3,b4,b5,b6,b7,b8;

Edetailsframe(){
c=getContentPane();
c.setLayout(null);

b1=new JButton("Create Event");
b2=new JButton("View Events");
//b3=new JButton("Update Event");
b4=new JButton("<");
b5=new JButton("Create Club");
b6=new JButton("View Clubs");
b7=new JButton("Create Venue");
b8=new JButton("View Venue");

c.add(b1);
c.add(b2);
//c.add(b3);
c.add(b4);
c.add(b5);
c.add(b6);
c.add(b7);
c.add(b8);

b1.setBounds(100,20,200,30);
b2.setBounds(100,70,200,30);
//b3.setBounds(100,120,200,30);
b5.setBounds(100,120,200,30);
b6.setBounds(100,170,200,30);
b7.setBounds(100,220,200,30);
b8.setBounds(100,270,200,30);
b4.setBounds(5,10,45,30);

ActionListener a1=(ae)->{
Adminframe a=new Adminframe();
this.dispose();
};
b4.addActionListener(a1);

ActionListener a2=(ae)->{
Clubframe a=new Clubframe();
this.dispose();
};
b5.addActionListener(a2);

ActionListener a3=(ae)->{
Eventframe a=new Eventframe();
this.dispose();
};
b1.addActionListener(a3);

ActionListener a4=(ae)->{
Venueframe a=new Venueframe();
this.dispose();
};
b7.addActionListener(a4);

ActionListener a5=(ae)->{
Eventviewframe a=new Eventviewframe();
this.dispose();
};
b2.addActionListener(a5);

ActionListener a6=(ae)->{
Clubviewframe a=new Clubviewframe();
this.dispose();
};
b6.addActionListener(a6);

ActionListener a7=(ae)->{
Venueviewframe a=new Venueviewframe();
this.dispose();
};
b8.addActionListener(a7);



this.setSize(400,370);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Edetailsframe