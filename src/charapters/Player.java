package charapters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Player {

    public int x;
    public int y;
    public double zoomHeight=0.1;
    public double zoomWidth=0.375*zoomHeight;
    public int width;
    public int height;
    public int xOld;
    public int yOld;
    public int pressButtonCount=0;

    public int animationCurSpeed = 0;
    public int animationSpeed=30;
    public int speed=2500;

    public boolean isActive = false;
    public boolean moved = false;

    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;

    public List<String> spriteDown = new ArrayList();
    public List<String> spriteUp = new ArrayList();
    public List<String> spriteLeft = new ArrayList();
    public List<String> spriteRight = new ArrayList();
    public int spriteCounter = 0;
    public int maxSpriteCount=3;

    public Rectangle playerRect;
    public Rectangle activeZone;

    public Player() {
x=500;
y=500;
        spriteDown.add("res/down1.png");
        spriteDown.add("res/down2.png");
        spriteDown.add("res/down3.png");
        spriteDown.add("res/down4.png");

        spriteUp.add("res/up1.png");
        spriteUp.add("res/up2.png");
        spriteUp.add("res/up3.png");
        spriteUp.add("res/up4.png");

        spriteLeft.add("res/left1.png");
        spriteLeft.add("res/left2.png");
        spriteLeft.add("res/left3.png");
        spriteLeft.add("res/left4.png");

        spriteRight.add("res/right1.png");
        spriteRight.add("res/right2.png");
        spriteRight.add("res/right3.png");
        spriteRight.add("res/right4.png");
    }

    public void update(Graphics g, double size){
        moving();
        drawPlayer(g,size);
    }

    public void moving() {
        xOld = x;
        yOld = y;
        getZones();
        if (moved) {
           // if(curSpeed==speed) {
            try {
                TimeUnit.MICROSECONDS.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                if (down) {
                    y++;
                }
                if (right) {
                    x++;
                }
                if (left) {
                    x--;
                }
                if (up) {
                    y--;
                }
          //      curSpeed=0;
          //  }
            if (animationCurSpeed == animationSpeed) {
                spriteCounter++;
                animationCurSpeed = 0;
            }
            if (spriteCounter > maxSpriteCount) spriteCounter = 0;
            animationCurSpeed++;
         //   curSpeed++
        }
    }


    public void setOldXY()
    {
        x=xOld;
        y=yOld;
    }

    public void getZones()
    {
        playerRect = new Rectangle(x, y+75, width, height-75);
        activeZone = new Rectangle(x-30,y+50,90,60);
    }

        public void drawPlayer(Graphics g, double size) {
        width=(int)Math.round(900*size*zoomWidth);
        height=(int)Math.round(900*size*zoomHeight);
        int newX=(int)(size*x);
        int newY =(int)(size*y);
            g.drawString("speed: "+Integer.toString(speed),20,20);
            if (down && !left && !right)
                g.drawImage(new ImageIcon(spriteDown.get(spriteCounter)).getImage(), newX, newY, width, height, null);
            if (up && !left && !right)
                g.drawImage(new ImageIcon(spriteUp.get(spriteCounter)).getImage(), newX,newY, width, height, null);
            if (right)
                g.drawImage(new ImageIcon(spriteRight.get(spriteCounter)).getImage(), newX, newY, 20, height, null);
            if (left)
                g.drawImage(new ImageIcon(spriteLeft.get(spriteCounter)).getImage(), newX, newY, 20, height, null);
            if (!up && !down && !left && !right)
                g.drawImage(new ImageIcon(spriteDown.get(0)).getImage(), newX, newY, width, height, null);

    }

    public void movingOn(String direction)
    {
        pressButtonCount++;
        moved =true;
        if(direction.equals("left")){
           left=true;}
        if(direction.equals("right"))
            right=true;
        if(direction.equals("up"))
            up=true;
        if(direction.equals("down"))
            down=true;
    }

    public void movingOff(String direction)
    {pressButtonCount--;
    if(pressButtonCount==0)
                     moved=false;
        if(direction.equals("left")){
            left=false;}
        if(direction.equals("right"))
        { right=false;}
        if(direction.equals("up"))
        {up=false;}
        if(direction.equals("down"))
        {down=false;}
    }
}