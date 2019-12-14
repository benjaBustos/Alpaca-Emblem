package model.items;

import model.units.IUnit;

public interface AggroItem extends IEquipableItem {
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
     * @return the minimum range of the item
     */
    int getMinRange();

    /**
     * @return the maximum range of the item
     */
    int getMaxRange();


}
