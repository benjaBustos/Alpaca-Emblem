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
    @Override
    public void attack(IUnit other) {
        if ((this.getOwner().getLocation()).distanceTo(other.getLocation()) <= this.getMaxRange() && (this.getOwner().getLocation()).distanceTo(other.getLocation()) >= this.getMinRange()) {
            other.receiveAttackFromDarknessBook(this);
        }
    }

    @Override
    public void receiveSpiritAttack(SpiritBook spiritBook){this.getOwner().receiveResistantAttack(spiritBook);}
    @Override
    public void receiveDarkAttack(DarknessBook darknessBook){this.getOwner().receiveAttack(darknessBook);}
    @Override
    public void receiveLightAttack(LightBook lightBook){this.getOwner().receiveWeaknessAttack(lightBook);}

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DarknessBook && super.equals(obj);
    }
    /**
    public void setEquippedItem(Sorcerer sorcerer){
        sorcerer.setEquippedDBook(this);
    }
     */
}
