package model.items;

import model.units.Sorcerer;

public interface MagicItem extends IEquipableItem {
    void receiveSpiritAttack(SpiritBook spiritBook);

    void receiveDarkAttack(DarknessBook darknessBook);

    void receiveLightAttack(LightBook lightBook);


}
