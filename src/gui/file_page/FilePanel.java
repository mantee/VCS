package gui.file_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilePanel extends JPanel implements ActionListener {

    public FilePanel() {
        setBorder(BorderFactory.createEtchedBorder());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(700, 600));

        JPanel panel = new JPanel();
        scrollPane.add(panel);
        setLayout(new GridLayout(1, 1));

        add(scrollPane);

        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
