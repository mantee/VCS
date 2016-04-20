package gui;

import gui.starting_page.StartingFrame;
import services.Clock;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new StartingFrame(new Clock());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
