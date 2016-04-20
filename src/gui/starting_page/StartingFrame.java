package gui.starting_page;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Objects;

import gui.repository_page.CodePanel;
import services.Clock;

public class StartingFrame extends JFrame {
    private JLabel label;
    private JPanel panel;
    private JComboBox comboBox;
    private UserSelect uSelect;
    private CodePanel home;

    public StartingFrame(Clock cl) throws Exception {

        super("User select");
        System.out.println(cl.getCurrentDateString());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 300));
        setLayout(new BorderLayout());
        uSelect = new UserSelect(this, cl);
        label = new JLabel("Welcome to our VCS");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(500, 100));
        add(label, BorderLayout.NORTH);
        add(uSelect, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }


}

