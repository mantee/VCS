package gui;

import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockPanel extends JPanel implements ActionListener {

    private JLabel label = new JLabel();
    private Clock cl;

    public ClockPanel(Clock cl) {
        add(label);
        cl.displayDateTime(cl, label);

        setLayout(new FlowLayout(FlowLayout.RIGHT));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
