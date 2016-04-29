package gui.repository_page;

import gui.ClockPanel;
import gui.home_page.ActivitiesPanel;
import gui.home_page.RepositoriesPanel;
import gui.home_page.UserInfoPanel;
import models.entities.Repository;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class RepositoryFrame extends JFrame {
    private JPanel outerPanel, topPanel, contentPanel;
    private ClockPanel clockPanel;
    private UserInfoPanel infoPanel;
    private CodePanel codePanel;
    private CommitsPanel commitsPanel;


    public RepositoryFrame(String selectedUser, Repository repository, Clock cl) throws FileNotFoundException {
        super("ActivitiesPanel page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Outer block
        outerPanel = new JPanel();
        // Inner blocks
        topPanel = new JPanel();
        contentPanel = new JPanel();
        // Inner panels
        infoPanel = new UserInfoPanel(selectedUser);
        clockPanel = new ClockPanel(cl);
        codePanel = new CodePanel(repository);
        commitsPanel = new CommitsPanel(repository);

        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //codePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        commitsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Outer blocks
        outerPanel.setLayout(new BorderLayout());
        // Top block
        topPanel.setLayout(new GridLayout(1, 2));

        topPanel.add(infoPanel);
        topPanel.add(clockPanel);

        // Content block
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Code", null, codePanel);
        tabbedPane.addTab("Commits", null, commitsPanel);

        contentPanel.add(tabbedPane);

        outerPanel.add(topPanel, BorderLayout.NORTH);
        outerPanel.add(contentPanel, BorderLayout.CENTER);

        add(new JScrollPane(outerPanel));

        setVisible(true);
    }
}

