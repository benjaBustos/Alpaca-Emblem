package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  /**
   * Exchange method
   * @param unit
   */
  public void giveTo(IUnit unit){
    unit.addItem(this);
    this.owner = unit;
  }

  /**
   * Equip item to unit
   * @param unit
   */
  @Override
  public void equipTo(final IUnit unit) {
    unit.setEquippedItem(this);
    owner = unit;
  }

  /**
   * set the Owner for just recieve item
   * @param unit
   */
  public void setOwner(IUnit unit){
    owner = unit;
  }

  /**
   * return item's Owner
   * @return Owner
   */

  @Override
  public IUnit getOwner() {
    return owner;
  }

  /**
   * return item's name
   * @return Name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * return item's power
   * @return Power
   */
  @Override
  public int getPower() {
    return power;
  }

  /**
   * return item's minimum range
   * @return Min range
   */
  @Override
  public int getMinRange() {
    return minRange;
  }

  /**
   * return item's maximum range
   * @return Max range
   */
  @Override
  public int getMaxRange() {
    return maxRange;
  }

  /**
   * override for equals method
   * @param obj
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof IEquipableItem && ((IEquipableItem) obj).getName().equals(name)
            && ((IEquipableItem) obj).getPower() == power;
  }
}
