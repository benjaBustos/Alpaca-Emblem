package model.items;

import model.units.IUnit;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Sword extends AbstractItem {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public Sword(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  /**
   * attack method for item to another unit
   * @param other
   */
  @Override
  public void attack(IUnit other) {
    if ((this.getOwner().getLocation()).distanceTo(other.getLocation()) <= this.getMaxRange() && (this.getOwner().getLocation()).distanceTo(other.getLocation()) >= this.getMinRange()) {
      other.receiveAttackFromSword(this);
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
   * override for sword object
   * @param obj
   * @return boolean if tested item is equal
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof Sword && super.equals(obj);
  }
}
