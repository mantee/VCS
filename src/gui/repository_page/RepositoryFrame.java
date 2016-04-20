package gui.repository_page;

import javax.swing.*;
import java.awt.*;

public class RepositoryFrame extends JFrame {
    private JLabel label;
    private JPanel panel;
    private JComboBox comboBox;
    private CodePanel home;

    public RepositoryFrame(String selectedUser) {
        super("ActivitiesPanel page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        label = new JLabel(selectedUser + ", welcome to the home page!");
        label.setPreferredSize(new Dimension(800, 200));
        add(label, BorderLayout.NORTH);

        home = new CodePanel();
        add(home, BorderLayout.CENTER);

        setVisible(true);
    }
}

