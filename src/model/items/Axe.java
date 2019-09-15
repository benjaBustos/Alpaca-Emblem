package model.items;

import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * attack method for item to another unit
   * @param other
   */
  @Override
  public void attack(IUnit other) {
    if ((this.getOwner().getLocation()).distanceTo(other.getLocation()) <= this.getMaxRange() && (this.getOwner().getLocation()).distanceTo(other.getLocation()) >= this.getMinRange()) {
      other.receiveAttackFromAxe(this);
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
   * override for Axe object
   * @param obj
   * @return boolean if tested item is equal
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof Axe && super.equals(obj);
  }
}
