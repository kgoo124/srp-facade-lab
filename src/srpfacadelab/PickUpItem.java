package srpfacadelab;

public class PickUpItem {
   private RpgPlayer player;

   public PickUpItem(RpgPlayer player) {
      this.player = player;
   }

   public boolean pickUpItem(Item item) {
      int weight = calculateInventoryWeight();
      if (weight + item.getWeight() > player.getCarryingCapacity())
         return false;

      if (item.isUnique() && checkIfItemExistsInInventory(item))
         return false;

      // Don't pick up items that give health, just consume them.
      if (item.getHeal() > 0) {
         player.setHealth(player.getHealth() + item.getHeal());

         if (player.getHealth() > player.getMaxHealth())
            player.setHealth(player.getMaxHealth());

         if (item.getHeal() > 500) {
            player.getGameEngine().playSpecialEffect("green_swirly");
         }

         return true;
      }

      if (item.isRare())
         player.getGameEngine().playSpecialEffect("cool_swirly_particles");

      player.addItemToInventory(item);

      calculateStats();

      return true;
   }

   private boolean checkIfItemExistsInInventory(Item item) {
      for (Item i : player.getInventory()) {
         if (i.getId() == item.getId())
            return true;
      }
      return false;
   }

   private int calculateInventoryWeight() {
      int sum = 0;
      for (Item i : player.getInventory()) {
         sum += i.getWeight();
      }
      return sum;
   }

   private void calculateStats() {
      int armour = player.getArmour();
      for (Item i : player.getInventory()) {
         armour += i.getArmour();
      }
      player.setArmour(armour);
   }
}