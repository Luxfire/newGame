package Controller;

import charapters.ControllerCharacter;
import view.DrawController;
import view.KeyListener;
import view.MainFrame;
import view.MouseListener;

public class Controller {
    public MainFrame mainFrame;
    public ControllerCharacter controllerCharacter;
    public DrawController drawController;
    public KeyListener keyListener;
    public MouseListener mouseListener;

    public Controller(){
        mainFrame = new MainFrame();
        controllerCharacter= new ControllerCharacter();
        drawController = new DrawController(controllerCharacter,mainFrame);
        keyListener = new KeyListener(controllerCharacter);
        mouseListener = new MouseListener(controllerCharacter);
        mainFrame.frame.add(drawController);
        mainFrame.frame.addKeyListener(keyListener);
        mainFrame.frame.addMouseListener(mouseListener);

    }
}
