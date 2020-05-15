package srpfacadelab;

public class Damage {
   private RpgPlayer player;

   public Damage(RpgPlayer player) {
      this.player = player;
   }

   public void takeDamage(int damage) {
      if (damage < player.getArmour()) {
         player.getGameEngine().playSpecialEffect("parry");
      }

      int damageToDeal = damage - player.getArmour();
      player.setHealth(player.getHealth() - damageToDeal);

      player.getGameEngine().playSpecialEffect("lots_of_gore");
   }
}