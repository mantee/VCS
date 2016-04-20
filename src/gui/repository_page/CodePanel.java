package gui.repository_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class CodePanel extends JPanel implements ActionListener {

    public CodePanel() {
        setBorder(BorderFactory.createEtchedBorder());

        FileSystemModel systemTree = new FileSystemModel(new File("user_files/Repository1"));
        JScrollPane scrollPane = new JScrollPane(systemTree);
        scrollPane.setPreferredSize(new Dimension(700, 600));

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tabPanel1 = new JPanel();
        tabbedPane.setPreferredSize(new Dimension(700, 600));
        tabPanel1.add(scrollPane);

        JPanel tabPanel2 = new JPanel();
        JLabel tabPanel2Label = new JLabel("Text2");
        tabPanel2Label.setHorizontalAlignment(JLabel.CENTER);
        tabPanel2.add(tabPanel2Label);

        tabbedPane.addTab("Code", null, tabPanel1);
        tabbedPane.addTab("Two", null, tabPanel2);

        setLayout(new GridLayout(1, 1));


        add(tabbedPane);

        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
