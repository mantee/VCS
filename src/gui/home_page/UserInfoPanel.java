package gui.home_page;

import gui.starting_page.UserSelect;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPanel extends JPanel implements ActionListener {

    public UserInfoPanel(User user) {
        add(new JLabel(user.getFirstname()));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        Dimension d = getPreferredSize();
        d.height = 200;
        setPreferredSize(d);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
