package gui.new_repository_page;

import controllers.RepositoryController;
import gui.home_page.HomeFrame;
import models.entities.User;
import services.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class NewRepositoryPanel extends JPanel implements ActionListener {

    public NewRepositoryPanel(final User user, final Clock cl, final NewRepositoryFrame outerFrame) {
        JLabel title = new JLabel("Title");
        final JTextField textField = new JTextField(25);
        JButton createButton = new JButton(new AbstractAction("Create") {

            public void actionPerformed(ActionEvent e) {
                try {
                    RepositoryController repositoryController = new RepositoryController();
                    repositoryController.createRepository(user, textField.getText(), cl);
                    new HomeFrame(user, cl);

                    outerFrame.setVisible(false);
                    outerFrame.dispose();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        JButton cancelButton = new JButton("Cancel");

        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        form.add(title);
        form.add(textField);
        buttons.add(createButton);
        buttons.add(cancelButton);

        add(form);
        add(buttons);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
