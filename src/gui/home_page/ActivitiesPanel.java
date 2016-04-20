package gui.home_page;

import controllers.RepositoryController;
import models.entities.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class ActivitiesPanel extends JPanel implements ActionListener {

    private JLabel label;

    public ActivitiesPanel() throws ParseException, IOException {
        setBorder(BorderFactory.createEtchedBorder());

        RepositoryController repositories = new RepositoryController();

        for(Repository repo : repositories.getAllRepositories())
        {
            //System.out.println(repo);
        }

        JPanel activitiesBlock = new JPanel();

        label = new JLabel("Recent activity");
        activitiesBlock.add(label);

        //scrollPane.add(label);
        add(label);

        //setPreferredSize(new Dimension(700, 600));
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
