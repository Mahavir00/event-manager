import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Mainframe extends JFrame{

Container c;
JButton b1,b2;

Mainframe(){
c=getContentPane();
c.setLayout(null);

b1=new JButton("Admin");
b2=new JButton("Participant");
c.add(b1);
c.add(b2);
b1.setBounds(100,20,200,30);
b2.setBounds(100,70,200,30);

ActionListener a1=(ae)->{
Adminframe a=new Adminframe();
this.dispose();
};
b1.addActionListener(a1);

ActionListener a2=(ae)->{
Participantframe a=new Participantframe();
this.dispose();
};
b2.addActionListener(a2);

this.setSize(400,200);
this.setTitle("Event Registration");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setLocationRelativeTo(null);
}// end of const.

public static void main(String... args){
Mainframe m=new Mainframe();

}// end of main
}// end of class mainframe