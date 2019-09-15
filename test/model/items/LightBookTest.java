package model.items;

import model.map.Location;
import model.units.Sorcerer;
import model.units.IUnit;
public class LightBookTest extends AbstractTestItem{
        private LightBook lightbook;
        private LightBook wronglightbook;
        private Sorcerer sorcerer;

        @Override
        public void setTestItem() {
            expectedName = "Common lightbook";
            expectedPower = 10;
            expectedMinRange = 1;
            expectedMaxRange = 2;
            lightbook = new LightBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
        }

        /**
         * Sets up an item with wrong ranges setted.
         */
        @Override
        public void setWrongRangeItem() {
            wronglightbook = new LightBook("Wrong Lightbook", 0, -1, -2);
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
            return wronglightbook;
        }

        @Override
        public IEquipableItem getTestItem() {
            return lightbook;
        }

        /**
         * @return a unit that can equip the item being tested
         */
        @Override
        public IUnit getTestUnit() {
            return sorcerer;
        }

}
