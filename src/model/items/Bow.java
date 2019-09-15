package model.items;

import model.units.IUnit;

/**
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Bow extends AbstractItem {

  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }
  /**
   * attack method for item to another unit
   * @param other
   */
  @Override
  public void attack(IUnit other) {
    if ((this.getOwner().getLocation()).distanceTo(other.getLocation()) <= this.getMaxRange() && (this.getOwner().getLocation()).distanceTo(other.getLocation()) >= this.getMinRange()) {
      other.receiveAttackFromBow(this);
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
   * override for bow object
   * @param obj
   * @return boolean if tested item is equal
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof Bow && super.equals(obj);
  }
}
