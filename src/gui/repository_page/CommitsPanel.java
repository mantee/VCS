package gui.repository_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommitsPanel extends JPanel implements ActionListener {

    public CommitsPanel() {
        //setBorder(BorderFactory.createEtchedBorder());

        add(new JLabel("Commits"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
