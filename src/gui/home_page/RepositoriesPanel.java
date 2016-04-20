package gui.home_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepositoriesPanel extends JPanel implements ActionListener {

    private JLabel label = new JLabel("Label");

    public RepositoriesPanel() {
        //setPreferredSize(new Dimension(700, 600));
        add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
