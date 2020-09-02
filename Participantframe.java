import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Participantframe extends JFrame{
Container c;
JButton b1,b2,b3,b4;
Participantframe(){
c=getContentPane();
c.setLayout(null);

b1=new JButton("View Events");
b2=new JButton("Payment");
b4=new JButton("Student");
b3=new JButton("<");
c.add(b1);
c.add(b2);
c.add(b3);
c.add(b4);
b1.setBounds(100,20,200,30);
b2.setBounds(100,70,200,30);
b4.setBounds(100,120,200,30);
b3.setBounds(5,10,45,30);

ActionListener a1=(ae)->{
Mainframe a=new Mainframe();
this.dispose();
};
b3.addActionListener(a1);

ActionListener a2=(ae)->{
Studentframe a=new Studentframe();
this.dispose();
};
b4.addActionListener(a2);

ActionListener a3=(ae)->{
Payment1 a=new Payment1();
this.dispose();
};
b2.addActionListener(a3);


ActionListener a4=(ae)->{
Peventviewframe a=new Peventviewframe();
this.dispose();
};
b1.addActionListener(a4);

this.setSize(400,210);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.
}// end of Participantframe