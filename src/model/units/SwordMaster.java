package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents a <i>SwordMaster</i> type unit.
 * <p>
 * A <i>SwordMaster</i> is a unit that <b>can only use sword type weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordMaster extends AbstractUnit {

  public SwordMaster(final int hitPoints, final int movement, final Location location,
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
  @Override
  public void receiveAttackFromSpear(Spear spear){receiveWeaknessAttack(spear);}
  @Override
  public void receiveAttackFromAxe(Axe axe){receiveResistantAttack(axe);}
  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  public void setEquippedItem(Sword item) {
    if(items.contains(item)) {
      equippedItem = item;
      item.setOwner(this);
    }
    else{
      equippedItem = null;
    }
  }
}
