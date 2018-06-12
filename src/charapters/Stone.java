package charapters;

import java.awt.*;

public class Stone {
    public int width;
    public int height;
    public Point stoneLocation;
    public String imageStone="res/kid.png";
    public boolean onTheFloor=false;
    public boolean inFlight=false;
    public int state=0;
    public Point finishPoint;
    public double zoom;

    public Stone(){
        width=20;
        height=20;
        //stoneLocation=new Point(100,100);
    }
    public void updateStone(Graphics g,double zoom){
        moveStone();
        drawStone(g,zoom);
        this.zoom=zoom;
    }

    public void drawStone(Graphics g,double zoom)
    {
        if(inFlight||onTheFloor)
        g.drawRect(stoneLocation.x,stoneLocation.y,(int)(width*zoom),(int)(height*zoom));
    }

    public void moveStone(){

        if(inFlight){
            if (state==1)
            {
                if(stoneLocation.x<finishPoint.x)
                stoneLocation.x++;
                if (stoneLocation.y>finishPoint.y)
                stoneLocation.y--;
            }
            if (state==2)
            {
                if(stoneLocation.x>finishPoint.x)
                    stoneLocation.x--;
                if (stoneLocation.y>finishPoint.y)
                    stoneLocation.y--;
            }
            if (state==3)
            {
                if(stoneLocation.x>finishPoint.x)
                    stoneLocation.x--;
                if (stoneLocation.y<finishPoint.y)
                    stoneLocation.y++;
            }
            if (state==4)
            {
                if(stoneLocation.x<finishPoint.x)
                    stoneLocation.x++;
                if (stoneLocation.y<finishPoint.y)
                    stoneLocation.y++;
            }
            if(finishPoint.x==stoneLocation.x&&finishPoint.y==stoneLocation.y) {
                inFlight = false;
                onTheFloor=true;
            }

        }

    }

    public void stateDefine(Point player,Point target)
    {
        if(player.x<target.x)
            if(player.y<target.y) state=4;
            else state=1;
            else if(player.y<target.y) state=3;
                else state=2;
                stoneLocation=player;
                finishPoint=target;
                finishPoint.y=(int)(finishPoint.y-30*zoom-height/2);
                finishPoint.x=(int)(finishPoint.x-8*zoom-width/2);
                inFlight=true;
    }

    public Rectangle getStoneZone()
    {
        return new Rectangle(stoneLocation.x,stoneLocation.y,width,height);
    }

}
