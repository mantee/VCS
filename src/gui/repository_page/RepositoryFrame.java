package gui.repository_page;

import gui.ClockPanel;
import gui.home_page.ActivitiesPanel;
import gui.home_page.HomeFrame;
import gui.home_page.RepositoriesPanel;
import gui.home_page.UserInfoPanel;
import gui.new_commit_page.NewCommitFrame;
import models.entities.Repository;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class RepositoryFrame extends JFrame {
    private JPanel outerPanel, topPanel, contentPanel;
    private ClockPanel clockPanel;
    private UserInfoPanel infoPanel;
    private CodePanel codePanel;
    private CommitsPanel commitsPanel;


    public RepositoryFrame(final User user, final Repository repository, final Clock cl) throws FileNotFoundException {
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
        infoPanel = new UserInfoPanel(user);
        clockPanel = new ClockPanel(cl);
        JButton newRepositoryButton = new JButton(new AbstractAction("New commit") {
            public void actionPerformed(ActionEvent e) {
                newComimitOpen(user, repository, cl);
            }
        });
        JButton homeButton = new JButton(new AbstractAction("Home") {
            public void actionPerformed(ActionEvent e) {
                goHome(user, cl);
            }
        });
        clockPanel.add(homeButton, FlowLayout.LEFT);
        clockPanel.add(newRepositoryButton, FlowLayout.LEFT);
        codePanel = new CodePanel(repository);
        commitsPanel = new CommitsPanel(repository);

        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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

    void newComimitOpen(final User user, Repository repository, final Clock cl){
        new NewCommitFrame(user, repository, cl);

        this.setVisible(false);
        this.dispose();
    }
    void goHome(User user, Clock cl) {
        try {
            new HomeFrame(user, cl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.setVisible(false);
        this.dispose();
    }
}

