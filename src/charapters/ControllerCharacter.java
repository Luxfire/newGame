package charapters;

import java.awt.*;

public class ControllerCharacter {
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    private Player player;
    public Stone stone;
    public ControllerCharacter() {
        player = new Player();
        stone=new Stone();
    }

    public void updateCharacters(Graphics g, double size){
        player.update(g,size);
        stone.updateStone(g,size);
        interaction();
    }

   public void interaction()
   {

       if(stone.onTheFloor)
           if(player.activeZone.intersects(stone.getStoneZone()))
               stone.onTheFloor=false;
   }
}
