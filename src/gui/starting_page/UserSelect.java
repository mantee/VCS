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

public class UserSelect extends JPanel implements ActionListener {
    private Clock cl;
    private JButton okButton;
    private JLabel label;
    private JComboBox comboBox;

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

        for(User user : users.getAllUsers())
        {
            comboBoxModel.addElement(user.getFirstname() + " " + user.getLastname());
        }
        comboBox.setModel(comboBoxModel);

        okButton = new JButton("Ok");

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
        String selectedUser = comboBox.getSelectedItem().toString();

        JButton clicked = (JButton)e.getSource();

        if(clicked == okButton) {
            if(textListener != null) {
                textListener.okEventOccured();
            }
            try {
                clickedOk(selectedUser);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void clickedOk(String selectedUser) throws IOException, ParseException {
        new HomeFrame(selectedUser, cl);

        outerFrame.setVisible(false);
        outerFrame.dispose();
    }
}
