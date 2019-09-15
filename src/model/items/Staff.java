package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractItem {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  /**
   * attack method for item to another unit
   * @param other
   */
  @Override
  public void attack(IUnit other) {
    if ((this.getOwner().getLocation()).distanceTo(other.getLocation()) <= this.getMaxRange() && (this.getOwner().getLocation()).distanceTo(other.getLocation()) >= this.getMinRange()) {
      other.receiveHealFromStaff(this);
    }

  }
  /**
   * recieve magic attack SPIRIT
   * @param spiritBook
   */
  @Override
  public void receiveSpiritAttack(SpiritBook spiritBook){}
  /**
   * recieve magic attack DARKNESS
   *
   * @param darknessBook
   */
  @Override
  public void receiveDarkAttack(DarknessBook darknessBook){}
  /**
   * recieve magic attack LIGHT
   * @param lightBook
   */
  @Override
  public void receiveLightAttack(LightBook lightBook){}
  /**
   * override for Staff object
   * @param obj
   * @return boolean if tested item is equal
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof Staff && super.equals(obj);
  }
}
