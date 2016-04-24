package gui.home_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import gui.ClockPanel;
import services.Clock;
public class HomeFrame extends JFrame implements ActionListener {
    private JPanel outerPanel, topPanel, contentPanel;
    private ActivitiesPanel activitiesPanel;
    private RepositoriesPanel repositoriesPanel;
    private ClockPanel clockPanel;
    private UserInfoPanel infoPanel;

    public HomeFrame(String selectedUser, final Clock cl) throws IOException, ParseException {
        super("Home page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Outer block
        outerPanel = new JPanel();
        // Inner blocks
        topPanel = new JPanel();
        contentPanel = new JPanel();
        // Inner panels
        infoPanel = new UserInfoPanel(selectedUser);
        clockPanel = new ClockPanel(cl);
        activitiesPanel = new ActivitiesPanel();
        repositoriesPanel = new RepositoriesPanel(this, cl);

        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        activitiesPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        repositoriesPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Outer block
        outerPanel.setLayout(new BorderLayout());
        // Top block
        topPanel.setLayout(new GridLayout(1, 2));

        topPanel.add(infoPanel);
        topPanel.add(clockPanel);

        // Content block
        contentPanel.setLayout(new GridLayout(1, 2));

        contentPanel.add(activitiesPanel);
        contentPanel.add(repositoriesPanel);

        outerPanel.add(topPanel, BorderLayout.NORTH);
        outerPanel.add(contentPanel, BorderLayout.CENTER);

        add(new JScrollPane(outerPanel));
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

