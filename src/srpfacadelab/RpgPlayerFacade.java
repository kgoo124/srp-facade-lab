package srpfacadelab;

public class RpgPlayerFacade {
   RpgPlayer player;
   Damage damage;
   UseItem useItem;
   PickUpItem pickUpItem;

   public RpgPlayerFacade(IGameEngine gameEngine) {
      this.player = new RpgPlayer(gameEngine);
      damage = new Damage(player);
      useItem = new UseItem(player);
      pickUpItem = new PickUpItem(player);
   }

   public void takeDamage(int damage) {
      this.damage.takeDamage(damage);
   }

   public void useItem(Item item) {
      useItem.useItem(item);
   }

   public boolean pickUpItem(Item item) {
      return pickUpItem.pickUpItem(item);
   }

}