package model.items;

import model.map.Location;
import model.units.Sorcerer;
import model.units.IUnit;
public class SpiritBookTest extends AbstractTestItem {
    private SpiritBook spiritBook;
    private SpiritBook wrongspiritbook;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Common spiritbook";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        spiritBook = new SpiritBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongspiritbook = new SpiritBook("Wrong spiritbook", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongspiritbook;
    }

    @Override
    public IEquipableItem getTestItem() {
        return spiritBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
