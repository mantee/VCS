package gui.repository_page;

import models.entities.Commit;
import models.entities.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CommitsPanel extends JPanel implements ActionListener {

    public CommitsPanel(Repository repository) throws FileNotFoundException {
        ArrayList<Commit> commits = repository.getCommits();
        for (int i = 0; i < commits.size(); i++) {
            JPanel commitInfoBlock = new JPanel();
            commitInfoBlock.setLayout(new BorderLayout());
            final Commit commit = commits.get(i);

            JLabel label = new JLabel(commit.getMessage());
            label.setFont(new Font("Sans Serif", Font.PLAIN, 12));

            JPanel leftPanel = new JPanel();
            leftPanel.add(label);

            JPanel rightPanel = new JPanel();
            rightPanel.add(new JLabel(commit.getDate()));

            if (commits.get(commits.size()-1).getId() == commit.getId()) {
                JButton openButton = new JButton(new AbstractAction("Open") {
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                rightPanel.add(openButton);
            }

            if (commits.get(commits.size()-1).getId() - 1 == commit.getId())
            {
                JButton resetButton = new JButton(new AbstractAction("Reset") {
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                rightPanel.add(resetButton);
            }

            commitInfoBlock.add(leftPanel, BorderLayout.CENTER);
            commitInfoBlock.add(rightPanel, BorderLayout.EAST);

            commitInfoBlock.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.red));
            commitInfoBlock.setBorder(BorderFactory.createEtchedBorder());
            add(commitInfoBlock);
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
