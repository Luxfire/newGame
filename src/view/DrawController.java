package view;

import Controller.Controller;
import charapters.ControllerCharacter;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class DrawController extends JPanel {

        MainFrame mainFrame;
        ControllerCharacter controller;
        public double zoom;
        public DrawController(ControllerCharacter controller,MainFrame mainFrame)
        {
            this.controller=controller;
            this.mainFrame = mainFrame;

        }

        public void paint(Graphics g)
        {
            zoom=mainFrame.frame.getSize().height/900.0;
            int size=mainFrame.frame.getSize().height;
            mainFrame.frame.setSize(size,size);
            controller.updateCharacters(g,zoom);
            mainFrame.frame.repaint();
        }

    }

