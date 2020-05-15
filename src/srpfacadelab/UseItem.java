package srpfacadelab;

import java.util.List;

public class UseItem {
   private RpgPlayer player;

   public UseItem(RpgPlayer player) {
      this.player = player;
   }

   public void useItem(Item item) {
      if (item.getName().equals("Stink Bomb")) {
         List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

         for (IEnemy enemy : enemies) {
            enemy.takeDamage(100);
         }
      }
   }
}