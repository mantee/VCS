package gui.starting_page;

import javax.swing.*;
import java.awt.*;

import gui.home_page.Home;

public class StartingFrame extends JFrame {
    private JLabel label;
    private JPanel panel;
    private JComboBox comboBox;
    private UserSelect uSelect;
    private Home home;


    public StartingFrame() {
        super("User select");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 300));
        setLayout(new BorderLayout());
        uSelect = new UserSelect(this);
        label = new JLabel("Welcome to our VCS");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(500, 100));
        add(label, BorderLayout.NORTH);
        add(uSelect, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}

