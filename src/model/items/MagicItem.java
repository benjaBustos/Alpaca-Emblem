package model.items;

import model.units.Sorcerer;

public interface MagicItem extends IEquipableItem {
    /**
     * general method to receive spirit attack
     * @param spiritBook
     */
    void receiveSpiritAttack(SpiritBook spiritBook);

    /**
     * general method to receive darkness attack
     * @param darknessBook
     */
    void receiveDarkAttack(DarknessBook darknessBook);

    /**
     * general method to receive light attack
     * @param lightBook
     */
    void receiveLightAttack(LightBook lightBook);


}
