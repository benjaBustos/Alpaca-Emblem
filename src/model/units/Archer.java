package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents an <i>Archer</i> type unit.
 * <p>
 * This kind of unit <b>can only use bows</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Archer extends AbstractUnit {

  /**
   * Creates a new archer
   *
   * @param hitPoints
   *     maximum hit points of the unit
   * @param movement
   *     the amount of cells this unit can move
   * @param position
   *     the initial position of this unit
   * @param items
   *     the items carried by this unit
   */
  public Archer( int hitPoints, int movement, Location position,
       IEquipableItem... items) {
    super(hitPoints, movement, position, 3, items);
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
   * <p>
   * The <i>Archer</i> can <b>only equip Bows</b>.
   *
   * @param item
   *     the item to equip
   */
  public void setEquippedItem(Bow item) {
    if(items.contains(item)) {
      equippedItem = item;
      item.setOwner(this);

    }
    else{
      equippedItem = null;
    }
  }

}
