package view;
import Controller.Controller;
import charapters.ControllerCharacter;
import charapters.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by user on 06.09.2017.
 */
public class KeyListener extends KeyAdapter {

    public ControllerCharacter controller;

   public KeyListener(ControllerCharacter controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {

          controller.getPlayer().movingOn("left");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {

            controller.getPlayer().movingOn("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {

            controller.getPlayer().movingOn("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            controller.getPlayer().movingOn("down");
        }
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD1){
            controller.getPlayer().speed-=500;
        };
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD2){
            controller.getPlayer().speed+=500;
        };


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            controller.getPlayer().movingOff("left");
        }else
        if (e.getKeyCode() == KeyEvent.VK_D) {
            controller.getPlayer().movingOff("right");
        }else
        if (e.getKeyCode() == KeyEvent.VK_W) {
            controller.getPlayer().movingOff("up");
        }else
        if (e.getKeyCode() == KeyEvent.VK_S) {
            controller.getPlayer().movingOff("down");
        }

    }
}