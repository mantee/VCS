package gui.starting_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.home_page.HomeFrame;

public class UserSelect extends JPanel implements ActionListener {
    private JButton okButton;
    private JLabel label;
    private JComboBox comboBox;

    private UserSelectListener textListener;

    StartingFrame outerFrame;

    public UserSelect(StartingFrame outerFrame) {
        this.outerFrame = outerFrame;

        setBorder(BorderFactory.createEtchedBorder());
        label = new JLabel();
        label.setText("Select user:");

        comboBox = new JComboBox();
        final DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("Mantė Mikulėnaitė");
        comboBoxModel.addElement("Dominykas Stankevičius");
        comboBoxModel.addElement("Ugnius Sinonis");
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
            clickedOk(selectedUser);
        }
    }

    public void clickedOk(String selectedUser) {
        new HomeFrame(selectedUser);

        outerFrame.setVisible(false);
        outerFrame.dispose();
    }
}
