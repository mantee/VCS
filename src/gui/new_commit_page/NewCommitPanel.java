package gui.new_commit_page;

import controllers.CommitController;
import gui.repository_page.RepositoryFrame;
import models.entities.Repository;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewCommitPanel extends JPanel implements ActionListener {

    private File file;

    public NewCommitPanel(final User user, final Repository repository, final Clock cl, final NewCommitFrame outerFrame) {
        JLabel title = new JLabel("Title");
        final JTextField textField = new JTextField(25);
        final JLabel filename = new JLabel("...");

        JButton chooseFile = new JButton(new AbstractAction("Choose file...") {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int rVal = chooser.showOpenDialog(NewCommitPanel.this);

                file = chooser.getSelectedFile();

                if (rVal == JFileChooser.APPROVE_OPTION) {
                    filename.setText(chooser.getCurrentDirectory().toString()
                        + "/"
                        + chooser.getSelectedFile().getName());
                }
                if (rVal == JFileChooser.CANCEL_OPTION) {
                    filename.setText("Canceled");
                }
            }
        });

        JButton createButton = new JButton(new AbstractAction("Create") {
            public void actionPerformed(ActionEvent e) {
                try {
                    CommitController repositoryController = new CommitController();
                    repositoryController.createCommit(user, repository, textField.getText(), cl, file);
                    new RepositoryFrame(user, repository, cl);

                    outerFrame.setVisible(false);
                    outerFrame.dispose();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton cancelButton = new JButton(new AbstractAction("Cancel") {
            public void actionPerformed(ActionEvent e) {
                try {
                    new RepositoryFrame(user, repository, cl);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

                outerFrame.setVisible(false);
                outerFrame.dispose();

                outerFrame.setVisible(false);
                outerFrame.dispose();
            }
        });

        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        form.add(title);
        form.add(textField);
        filePanel.add(new JLabel("Directory: "));
        filePanel.add(filename);
        buttons.add(chooseFile);
        buttons.add(createButton);
        buttons.add(cancelButton);

        add(form);
        add(filePanel);
        add(buttons);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
