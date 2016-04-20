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
    private JLabel label, label2;
    private JPanel outerPanel, topPanel, contentPanel;
    private JComboBox comboBox;
    private ActivitiesPanel activitiesPanel;
    private RepositoriesPanel repositoriesPanel;
    private ClockPanel clockPanel;
    private UserInfoPanel userInfoPanel;
    private Clock cl;
    private JScrollPane scrollPane;

    public HomeFrame(String selectedUser, final Clock cl) throws IOException, ParseException {
        super("ActivitiesPanel page");
        this.cl = cl;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 800));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        scrollPane = new JScrollPane();

        outerPanel = new JPanel();
        topPanel = new JPanel();
        contentPanel = new JPanel();

        activitiesPanel = new ActivitiesPanel();
        repositoriesPanel = new RepositoriesPanel();
        clockPanel = new ClockPanel(cl);
        label = new JLabel(cl.getCurrentDateString());
        label2 = new JLabel("User Info");
        userInfoPanel = new UserInfoPanel(selectedUser);

        clockPanel.setBorder(BorderFactory.createMatteBorder(
            1, 1, 1, 1, Color.darkGray));
        userInfoPanel.setBorder(BorderFactory.createMatteBorder(
            4, 4, 4, 4, Color.orange));
        activitiesPanel.setBorder(BorderFactory.createMatteBorder(
            1, 1, 1, 1, Color.red));
        repositoriesPanel.setBorder(BorderFactory.createMatteBorder(
            1, 1, 1, 1, Color.yellow));

        outerPanel.setLayout(new BorderLayout());

        topPanel.setLayout(new GridLayout(1, 2));

        topPanel.add(userInfoPanel);
        topPanel.add(clockPanel);

        contentPanel.setLayout(new GridLayout(1, 2));

        contentPanel.add(activitiesPanel);
        contentPanel.add(repositoriesPanel);

        outerPanel.add(topPanel, BorderLayout.NORTH);
        outerPanel.add(contentPanel, BorderLayout.CENTER);

        scrollPane = new JScrollPane(outerPanel);

        add(scrollPane);

        cl.addOneDay();
        System.out.println(cl.getCurrentDateString());
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

