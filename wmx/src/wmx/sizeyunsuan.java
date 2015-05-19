package wmx;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
 
import java.util.Random;
import java.util.Scanner;
 
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class sizeyunsuan implements ActionListener, ItemListener {
    JFrame f;
    JTextField first, second, third, last;
    JButton sub, cancel, button1, button2, button3, fourth, denyu;
    Box box1, box2, box3, box4;
    String s = null, w = null, m = null;
    Container con;
    String fuhao = "";
    Choice c2;
    int count = 0 ,count1=0;
    double temp;
    JTextArea textShow;
 
    public sizeyunsuan() {
        f = new JFrame();
        f.setTitle("欢迎进入王铭霞制作的四则运算测试");
        f.setSize(370, 320);
        f.setLocation(200, 200);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = f.getContentPane();
 
        box1 = Box.createHorizontalBox();
 
        first = new JTextField(5);
        c2 = new Choice();
        c2.addItemListener(this);
        c2.add("");
        c2.add("+");
        c2.add("-");
        c2.add("*");
        c2.add("/");
        third = new JTextField(5);
        fourth = new JButton("=");
        button3=new JButton("清空面板");
         
        last = new JTextField(7);
        box1.add(first);
        box1.add(c2);
        box1.add(third);
        box1.add(fourth);
        box1.add(last);
      
         
        box2 = Box.createHorizontalBox();
        sub = new JButton("confirm");
        cancel = new JButton("cancel");
        button1 = new JButton("random1"); 
        box2.add(button1);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(sub);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(button3);
        
        
        box2.add(Box.createHorizontalStrut(10));   
        box2.add(cancel);
        sub.addActionListener(this);
        box3=Box.createHorizontalBox();
        textShow=new JTextArea (150,100);
        box3.add(textShow);
         
         
        box4 = Box.createVerticalBox();
        box4.add(Box.createVerticalStrut(20));
        box4.add(box1);
        box4.add(Box.createVerticalStrut(20));
        box4.add(box3);
        box4.add(Box.createVerticalStrut(20));
        box4.add(box2);
        box4.add(Box.createVerticalStrut(10));
        con.add(box4);
 
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s = String.valueOf(Math.round((Math.random() * 100)));
                w = String.valueOf(Math.round((Math.random() * 100) + 1));
                first.setText(s);
                third.setText(w);
                
            }
        });
 
        cancel.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() ==cancel )
                    last.setText(null);
                   
                 
            }
           
             
        });
        button3.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() ==button3 )
                    textShow.setText(null);
            }
            });
        
 
        f.setVisible(true);
    }
 
    public static void main(String arg[]) {
        sizeyunsuan w = new sizeyunsuan();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        double s1 = Integer.parseInt(first.getText());
        double s2 = Integer.parseInt(third.getText());
        double result = 0;
        if (fuhao.equals("+")) {
            result = s1 + s2;
            temp = Integer.parseInt(last.getText());
            if (temp == result) {
                JOptionPane.showMessageDialog(null, "congradulation");
                count=count+1;
 
            }
            if (temp != result) {
                JOptionPane.showMessageDialog(null, "sorry");
                count1=count1+1;
 
            }
 
 
        }
        else if (fuhao.equals("-")) {
            result = s1 - s2;
 
            temp = Integer.parseInt(last.getText());
            if (temp != result) {
                JOptionPane.showMessageDialog(null, "sorry");
                count1=count1+1;
            }
 
            if (temp == result) {
                JOptionPane.showMessageDialog(null, "congradulation");
                count=count+1;
         
            }  
        }
        else if (fuhao.equals("*")) {
            result = s1 * s2;
          
            temp = Integer.parseInt(last.getText());
            if (temp == result) {
                JOptionPane.showMessageDialog(null, "congradulation");
                count=count+1;
                 
            }
            if (temp != result) {
                JOptionPane.showMessageDialog(null, "sorry");
                count1=count1+1;
                 
 
            }
        }
        else if (fuhao.equals("/")) {
            result = s1 / s2;
 
            temp = Integer.parseInt(last.getText());
            if (temp != result) {
                JOptionPane.showMessageDialog(null, "sorry");
                count1=count1+1;
             
            }
            if (temp == result) {
                JOptionPane.showMessageDialog(null, "congradulation");
                count=count+1;
                 
 
            }
 
        }
        textShow.append(s1+""+fuhao+""+s2+"="+result+"\n");
        textShow.append("right"+count+"\n");
        textShow.append("wrong"+count1+"\n");
    }
 
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == c2) {
            String str1 = c2.getSelectedItem();
            fanhui(str1);
        }
    }
 
    public String fanhui(String str2) {
        return fuhao = str2;
    }
}
