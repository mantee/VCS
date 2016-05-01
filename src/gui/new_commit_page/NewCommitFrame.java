package gui.new_commit_page;

import gui.ClockPanel;
import models.entities.Repository;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;

public class NewCommitFrame extends JFrame {
    private JPanel outerPanel, topPanel, contentPanel;
    private NewCommitPanel newCommitPanel;
    private ClockPanel clockPanel;


    public NewCommitFrame(User user, Repository repository, Clock cl) {
        super("Home page");
        setSize(new Dimension(500, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Outer block
        outerPanel = new JPanel();
        // Inner blocks
        topPanel = new JPanel();
        contentPanel = new JPanel();
        // Inner panels
        clockPanel = new ClockPanel(cl);
        newCommitPanel = new NewCommitPanel(user, repository, cl, this);

        clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        newCommitPanel.setBorder(BorderFactory.createEtchedBorder());

        // Outer block
        outerPanel.setLayout(new BorderLayout());
        // Top block
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        topPanel.add(clockPanel);

        // Content block
        contentPanel.add(newCommitPanel);

        outerPanel.add(topPanel, BorderLayout.NORTH);
        outerPanel.add(contentPanel, BorderLayout.CENTER);

        add(new JScrollPane(outerPanel));

        setVisible(true);
    }
}

