package gui.starting_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import services.Clock;

import controllers.UserController;
import gui.home_page.HomeFrame;
import models.entities.User;
import models.entities.ComboItem;

public class UserSelect extends JPanel implements ActionListener {
    private Clock cl;
    private JLabel label;
    private JComboBox comboBox;
    private User selectedUser = null;

    private UserSelectListener textListener;

    StartingFrame outerFrame;

    public UserSelect(StartingFrame outerFrame, Clock cl) throws Exception {
        this.cl = cl;
        this.outerFrame = outerFrame;
        UserController users = new UserController();

        cl.addOneDay();
        System.out.println(cl.getCurrentDateString());

        setBorder(BorderFactory.createEtchedBorder());
        label = new JLabel();
        label.setText("Select user:");

        comboBox = new JComboBox();
        final DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        for(final User user : users.getAllUsers())
        {
            if (selectedUser == null) {
                selectedUser = user;
            }

            comboBox.addItem(new ComboItem(user.getFirstname() + " " + user.getLastname(), user));
        }

        comboBox.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                Object userObj = comboBox.getSelectedItem();
                User user = ((ComboItem)userObj).getComboUser();
                selectedUser = user;
            }
        });

        JButton okButton = new JButton(new AbstractAction("Ok") {
            public void actionPerformed(ActionEvent e) {
                try {
                    clickedOk(selectedUser);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

        add(label);
        add(comboBox);
        add(okButton);

        okButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void setUserSelectListener(UserSelectListener listener) {
        this.textListener = listener;
    }

    private JButton dialogButton;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void clickedOk(User selectedUser) throws IOException, ParseException {
        new HomeFrame(selectedUser, cl);

        outerFrame.setVisible(false);
        outerFrame.dispose();
    }
}
