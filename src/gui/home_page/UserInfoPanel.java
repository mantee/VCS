package gui.home_page;

import gui.starting_page.UserSelect;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPanel extends JPanel implements ActionListener {

    public UserInfoPanel(String selectedUser) {
        add(new JLabel(selectedUser));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        Dimension d = getPreferredSize();
        d.height = 200;
        setPreferredSize(d);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
