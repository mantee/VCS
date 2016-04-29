package gui.new_repository_page;

import gui.ClockPanel;
import gui.home_page.ActivitiesPanel;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NewRepositoryFrame extends JFrame {
    private JPanel outerPanel, topPanel, contentPanel;
    private NewRepositoryPanel newRepositoryPanel;
    private ClockPanel clockPanel;

    public NewRepositoryFrame(User user, Clock cl) {
        super("Home page");
        setSize(new Dimension(500, 200));

        // Outer block
        outerPanel = new JPanel();
        // Inner blocks
        topPanel = new JPanel();
        contentPanel = new JPanel();
        // Inner panels
        clockPanel = new ClockPanel(cl);
        newRepositoryPanel = new NewRepositoryPanel(user, cl);

        clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        newRepositoryPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        newRepositoryPanel.setBorder(BorderFactory.createEtchedBorder());

        // Outer block
        outerPanel.setLayout(new BorderLayout());
        // Top block
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        topPanel.add(clockPanel);

        // Content block
        contentPanel.add(newRepositoryPanel);

        outerPanel.add(topPanel, BorderLayout.NORTH);
        outerPanel.add(contentPanel, BorderLayout.CENTER);

        add(new JScrollPane(outerPanel));

        setVisible(true);
    }
}

