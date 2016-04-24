package gui.home_page;

import controllers.RepositoryController;
import gui.repository_page.RepositoryFrame;
import models.entities.Repository;
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
    private RepositoriesPanelListener repositoriesPanelListener;
    HomeFrame outerFrame;

    public RepositoriesPanel(HomeFrame outerFrame, final Clock cl) throws ParseException, IOException {
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
            final Repository repository;
            repository = repositories.get(i);

            JButton openButton = new JButton(new AbstractAction("Open") {
                public void actionPerformed(ActionEvent e) {
                    //do stuff here
                    try {
                        clickedOpen(repository, cl);
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

            JLabel label = new JLabel(repository.getTitle() + " / " + repository.getDateCreated());
            label.setFont(new Font("Sans Serif", Font.PLAIN, 12));
            Dimension d = repositoryInfoBlock.getSize();
            d.height = 20;
            repositoryInfoBlock.setSize(d);
            repositoryInfoBlock.add(label);

            repositoryInfoBlock.add(openButton);
            //openButton.addActionListener(this);
            repositoryInfoBlock.add(deleteButton);
            //deleteButton.addActionListener(this);

            repositoryInfoBlock.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.red));
            add(repositoryInfoBlock);
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void setRepositoriesPanelListener(RepositoriesPanelListener listener) {
        this.repositoriesPanelListener = listener;
    }

    public void clickedOpen(Repository repository, Clock cl) throws IOException, ParseException {
        new RepositoryFrame("Useris", repository, cl);

        outerFrame.setVisible(false);
        outerFrame.dispose();
    }

    public void clickedDelete() throws IOException, ParseException {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure that you want to delete this repository?","Warning",dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
