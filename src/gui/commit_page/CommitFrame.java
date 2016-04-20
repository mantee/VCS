package gui.commit_page;

import javax.swing.*;
import java.awt.*;

public class CommitFrame extends JFrame {
    private JLabel label;
    private JPanel panel;
    private JComboBox comboBox;
    private CommitPanel home;

    public CommitFrame(String selectedUser) {
        super("ActivitiesPanel page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        label = new JLabel(selectedUser + " SAMPLE!");
        label.setPreferredSize(new Dimension(800, 200));
        add(label, BorderLayout.NORTH);

        home = new CommitPanel();
        add(home, BorderLayout.CENTER);

        setVisible(true);
    }
}

