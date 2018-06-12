package view;

import charapters.ControllerCharacter;
import charapters.Stone;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    ControllerCharacter controllerCharacter;

    public MouseListener(ControllerCharacter controllerCharacter) {
        this.controllerCharacter = controllerCharacter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!controllerCharacter.stone.inFlight&&!controllerCharacter.stone.onTheFloor){
        Point point = new Point(controllerCharacter.getPlayer().x, controllerCharacter.getPlayer().y);
        controllerCharacter.stone.stateDefine(point, e.getPoint());
        }
    }
}

