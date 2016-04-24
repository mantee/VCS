package gui.repository_page;

import models.entities.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CodePanel extends JPanel implements ActionListener {

    public CodePanel(Repository repository) {
        setBorder(BorderFactory.createEtchedBorder());

        FileSystemModel systemTree = new FileSystemModel(new File("user_files/repository" + repository.getId()));

        Dimension d = systemTree.getPreferredSize();
        d.width = 800;
        systemTree.setPreferredSize(d);
        add(systemTree);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
