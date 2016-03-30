import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Person{
    private String firstName;
    private String lastName;
    Person(String f, String l){
        firstName = f;
        lastName = l;
    }
    public String toString(){
        return firstName+ " "+ lastName;
    }
}
class DynamicMethods{
    LinkedList<Person> l;
    JFrame wnd;
    JTextArea ta;
    void readData(){
        l = new LinkedList<Person>();
        try{
            BufferedReader b = new BufferedReader(new FileReader("people.dat"));
            String line = null;
            while ((line = b.readLine()) != null){
                String[] s = line.split(" ");
                l.add(new Person(s[0], s[1]));
            }
        }catch(Exception e) {System.err.println();}
    }
    void initiateWindow(){
        wnd = new JFrame();
        wnd.setSize(400, 200);
        wnd.setLayout(new FlowLayout());
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta = new JTextArea(10,20);
        wnd.add(ta);
        JButton b = new JButton("Remove First");
        wnd.add(b);
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (l.size()>0) l.removeFirst();
                    ta.setText("");
                    showData();
                }
            }
        );
        wnd.setVisible(true);
    }
    void showData(){
        if (l.size()==0) ta.setText("No persons are in the list");
        else
            for (int i = 0; i<l.size(); i++){
                ta.append(l.get(i).toString()+"\n");
            }
    }
    void mainFunctionality(){
        readData();
        initiateWindow();
        showData();
    }
    public static void main(String[] args){
        DynamicMethods dm = new DynamicMethods();
        dm.mainFunctionality();
    }
}
