package model.units;

import model.items.*;
import model.map.Location;

/**
 * A <i>Hero</i> is a special kind of unit, the player that defeats this unit wins the game.
 * <p>
 * This unit <b>can only use spear weapons</b>.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Hero extends AbstractUnit {

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Hero(final int hitPoints, final int movement, final Location location,
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
  public void receiveAttackFromAxe(Axe axe){receiveWeaknessAttack(axe);}
  @Override
  public void receiveAttackFromSword(Sword sword){receiveResistantAttack(sword);}

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  public void setEquippedItem(Spear item) {
    if(items.contains(item)) {
      equippedItem = item;

    }
  }
}
