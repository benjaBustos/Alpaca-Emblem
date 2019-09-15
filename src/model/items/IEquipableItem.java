package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be equipped with the item
   */
  void equipTo(IUnit unit);

  /**
   * Give this item to a  unit
   * @param unit
   * the unit that will be equipper with the item
   */
  void giveTo(IUnit unit);
  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  /**
   * item attack another unit
   *
   * @param other
   */
  void attack(IUnit other);

  /**
   * general method item receieve spirit attack
   * @param spiritBook
   */
  void receiveSpiritAttack(SpiritBook spiritBook);

  /**
   * general method item receieve darkness attack
   * @param darknessBook
   */
  void receiveDarkAttack(DarknessBook darknessBook);

  /**
   * general method item receieve light attack
   * @param lightBook
   */
  void receiveLightAttack(LightBook lightBook);

  /**
   * set the owner to this item
   * @param unit
   */
  void setOwner(IUnit unit);
}

