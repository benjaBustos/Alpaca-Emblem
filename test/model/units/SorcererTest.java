package model.units;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.DarknessBook;
import model.items.LightBook;
import org.junit.jupiter.api.Test;

public class SorcererTest extends AbstractTestUnit {
    private Sorcerer sorcerer,magito;
    private DarknessBook libroOscuro;
    private LightBook libroLuz;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
        magito = new Sorcerer(50,2,field.getCell(1,0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    /**
     * Checks if the bow is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(darknessBook);
        sorcerer.setEquippedItem(darknessBook);
        assertEquals(darknessBook, sorcerer.getEquippedItem());

    }


}
