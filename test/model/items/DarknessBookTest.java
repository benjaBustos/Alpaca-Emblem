package model.items;

import model.map.Location;
import model.units.AbstractTestUnit;
import model.units.Sorcerer;
import model.units.IUnit;
public class DarknessBookTest extends AbstractTestItem {
    private DarknessBook darknessBook;
    private DarknessBook wrongDarknessBook;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem() {
        expectedName = "Common darkbook";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        darknessBook = new DarknessBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongDarknessBook = new DarknessBook("Wrong Darkbook", 0, -1, -2);
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
        return wrongDarknessBook;
    }

    @Override
    public IEquipableItem getTestItem() {
        return darknessBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
