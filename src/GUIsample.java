import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class DynamicMethods{
    JFrame wnd;
    JTextArea ta;

    void initiateWindow(){
        wnd = new JFrame();
        wnd.setSize(100, 200);
        wnd.setLayout(new FlowLayout());
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta = new JTextArea(10,10);
        wnd.add(ta);
        JButton b = new JButton("Remove First");
        wnd.add(b);
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ta.setText("ok");

                }
            }
        );
        wnd.setVisible(true);
    }
    void mainFunctionality(){

        initiateWindow();
    }
    public static void main(String[] args){
        DynamicMethods dm = new DynamicMethods();
        dm.mainFunctionality();
    }
}
