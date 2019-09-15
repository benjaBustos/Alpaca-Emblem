package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Fighter extends AbstractUnit {

  public Fighter(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  @Override
  public void receiveAttackFromDarknessBook(DarknessBook dbook){receiveWeaknessAttack(dbook);}
  @Override
  public void receiveAttackFromLightBook(LightBook lbook){receiveWeaknessAttack(lbook);}
  @Override
  public void receiveAttackFromSpiritBook(SpiritBook sbook){receiveWeaknessAttack(sbook);}
  @Override
  public void receiveAttackFromSword(Sword sword){receiveWeaknessAttack(sword);}
  @Override
  public void receiveAttackFromSpear(Spear spear){receiveResistantAttack(spear);}
  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  public void setEquippedItem(Axe item) {
    if(items.contains(item)) {
      equippedItem = item;
      item.setOwner(this);

    }
    else{
      equippedItem = null;
    }
  }
}
