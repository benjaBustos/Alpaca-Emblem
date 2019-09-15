package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * @return hit points of the unit
   */
  int getCurrentHitPoints();

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /**
   * @param item
   *     the item to be equipped
   */
  void setEquippedItem(IEquipableItem item);

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);

  void addItem(IEquipableItem item);

  void giveItem(IUnit other, IEquipableItem item);

  void counterAttack(IUnit other);

  void attack(IUnit other);

   void receiveAttackFromBow(Bow bow);

   void receiveAttackFromAxe(Axe axe);

   void receiveAttackFromSpear(Spear spear);

   void receiveAttackFromSword(Sword sword);

   void receiveHealFromStaff(Staff staff);

   void receiveAttackFromDarknessBook(DarknessBook dbook);

   void receiveAttackFromLightBook(LightBook lbook);

   void receiveAttackFromSpiritBook(SpiritBook sbook);

   void receiveWeaknessAttack(IEquipableItem item);

   void receiveResistantAttack(IEquipableItem item);

   void receiveAttack(IEquipableItem item);
}
