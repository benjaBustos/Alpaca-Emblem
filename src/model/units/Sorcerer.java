package model.units;

import model.items.*;
import model.map.Location;

public class Sorcerer extends AbstractUnit {
    /**
     * Creates a new Unit.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param items
     */
    public Sorcerer(int hitPoints, int movement, Location location, IEquipableItem... items) {
        super(hitPoints, movement, location,3, items);
    }

    @Override
    public void receiveAttackFromBow(Bow bow){receiveWeaknessAttack(bow);}
    @Override
    public void receiveAttackFromAxe(Axe axe){receiveWeaknessAttack(axe);}
    @Override
    public void receiveAttackFromSpear(Spear spear){receiveWeaknessAttack(spear);}
    @Override
    public void receiveAttackFromSword(Sword sword){receiveWeaknessAttack(sword);}
    @Override
    public void receiveAttackFromDarknessBook(DarknessBook dbook){this.getEquippedItem().receiveDarkAttack(dbook);}
    @Override
    public void receiveAttackFromLightBook(LightBook lbook){this.getEquippedItem().receiveLightAttack(lbook);}
    @Override
    public void receiveAttackFromSpiritBook(SpiritBook sbook){this.getEquippedItem().receiveSpiritAttack(sbook);}

    public void setEquippedItem(MagicItem item) {
        if(items.contains(item)) {
            equippedItem = item;

        }
    }
}
