package model.items;

import model.units.IUnit;
import model.units.Sorcerer;

public class DarknessBook extends AbstractItem implements MagicItem {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange
     */
    public DarknessBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }
    /**
     * attack method for item to another unit
     * @param other
     */
    @Override
    public void attack(IUnit other) {
        if ((this.getOwner().getLocation()).distanceTo(other.getLocation()) <= this.getMaxRange() && (this.getOwner().getLocation()).distanceTo(other.getLocation()) >= this.getMinRange()) {
            other.receiveAttackFromDarknessBook(this);
        }
    }
    /**
     * recieve magic attack SPIRIT
     * @param spiritBook
     */
    @Override
    public void receiveSpiritAttack(SpiritBook spiritBook){this.getOwner().receiveResistantAttack(spiritBook);}
    /**
     * recieve magic attack DARKNESS
     *
     * @param darknessBook
     */
    @Override
    public void receiveDarkAttack(DarknessBook darknessBook){this.getOwner().receiveAttack(darknessBook);}
    /**
     * recieve magic attack LIGHT
     * @param lightBook
     */
    @Override
    public void receiveLightAttack(LightBook lightBook){this.getOwner().receiveWeaknessAttack(lightBook);}
    /**
     * override for darkbook object
     * @param obj
     * @return boolean if tested item is equal
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof DarknessBook && super.equals(obj);
    }

}
