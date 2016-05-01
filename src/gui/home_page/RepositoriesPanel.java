package gui.home_page;

import controllers.RepositoryController;
import gui.repository_page.RepositoryFrame;
import models.entities.Repository;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class RepositoriesPanel extends JPanel {

    private JLabel titleLabel = new JLabel("My repositories");
    private RepositoryController repositoryController = new RepositoryController();
    HomeFrame outerFrame;

    public RepositoriesPanel(final User user, HomeFrame outerFrame, final Clock cl) throws ParseException, IOException {
        this.outerFrame = outerFrame;
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createMatteBorder(
            1, 1, 1, 1, Color.green));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(titleLabel);
        add(new JLabel(" "));
        ArrayList<Repository> repositories = repositoryController.getAllRepositories();

        for (int i = 0; i < repositories.size(); i++) {
            JPanel repositoryInfoBlock = new JPanel();
            repositoryInfoBlock.setLayout(new BorderLayout());
            final Repository repository = repositories.get(i);

            JButton openButton = new JButton(new AbstractAction("Open") {
                public void actionPerformed(ActionEvent e) {
                    //do stuff here
                    try {
                        clickedOpen(user, repository, cl);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            JButton deleteButton = new JButton(new AbstractAction("Delete") {
                public void actionPerformed(ActionEvent e) {
                    //do stuff here
                    try {
                        clickedDelete();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            JLabel label = new JLabel(repository.getTitle());
            label.setFont(new Font("Sans Serif", Font.PLAIN, 18));

            JPanel leftPanel = new JPanel();
            leftPanel.add(label);

            JPanel rightPanel = new JPanel();
            rightPanel.add(new JLabel(repository.getDateCreated()));
            rightPanel.add(openButton);
            rightPanel.add(deleteButton);

            repositoryInfoBlock.add(leftPanel, BorderLayout.CENTER);
            repositoryInfoBlock.add(rightPanel, BorderLayout.EAST);

            repositoryInfoBlock.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.red));
            repositoryInfoBlock.setBorder(BorderFactory.createEtchedBorder());
            add(repositoryInfoBlock);
            repositoryInfoBlock.setBorder(BorderFactory.createEtchedBorder());
            add(repositoryInfoBlock);
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void clickedOpen(final User user, Repository repository, Clock cl) throws IOException, ParseException {
        new RepositoryFrame(user, repository, cl);

        outerFrame.setVisible(false);
        outerFrame.dispose();
    }

    public void clickedDelete() throws IOException, ParseException {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this repository?","Warning",dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Do something if "Yes"
        } else {
            // Do something if "No"
        }
    }
}
