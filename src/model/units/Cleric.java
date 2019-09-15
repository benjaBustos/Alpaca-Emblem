package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents a cleric type unit. A cleric can only use staff type weapons, which means
 * that it can receive attacks but can't counter attack any of those.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Cleric(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }
  /**
   * general damage from diferent class (Darkmagic)
   * @param dbook
   */
  @Override
  public void receiveAttackFromDarknessBook(DarknessBook dbook){receiveWeaknessAttack(dbook);}
  /**
   * general damage from diferent class (Lightmagic)
   * @param lbook
   */
  @Override
  public void receiveAttackFromLightBook(LightBook lbook){receiveWeaknessAttack(lbook);}
  /**
   * general damage from diferent class (Spiritmagic)
   * @param sbook
   */
  @Override
  public void receiveAttackFromSpiritBook(SpiritBook sbook){receiveWeaknessAttack(sbook);}

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  public void setEquippedItem(Staff item) {
    if(items.contains(item)) {
      equippedItem = item;
      item.setOwner(this);

    }
    else{
      equippedItem = null;
    }
  }
}
