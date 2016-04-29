package gui;

import controllers.RepositoryController;
import gui.home_page.HomeFrame;
import gui.new_repository_page.NewRepositoryFrame;
import gui.repository_page.RepositoryFrame;
import gui.starting_page.StartingFrame;
import models.entities.Repository;
import services.Clock;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new StartingFrame(new Clock());
                    /*RepositoryController rp = new RepositoryController();
                    new RepositoryFrame("Hello world! ", rp.getRepositoryById(1), new Clock());*/
                    //new NewRepositoryFrame("My user", new Clock());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
