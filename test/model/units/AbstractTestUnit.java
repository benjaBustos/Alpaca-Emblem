package model.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected DarknessBook darknessBook;
  protected LightBook lightBook;
  protected SpiritBook spiritBook;
  protected List<IEquipableItem> items;
  protected Sorcerer sorcerer;
  protected Sorcerer magito;
  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }


  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
    setInventory();

  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.darknessBook = new DarknessBook("Darkbook",10,1,2);
    this.lightBook = new LightBook("Lightbook",20,1,2);
    this.spiritBook = new SpiritBook("Spiritbook",4,1,2);
    this.sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
    this.magito = new Sorcerer(50,2,field.getCell(1,0));

  }
  public void setInventory(){
    this.items = new ArrayList<>();

  }
  @Test
  public void attackTest(){
    sorcerer.addItem(darknessBook);
    sorcerer.setEquippedItem(darknessBook);
    magito.addItem(lightBook);
    magito.setEquippedItem(lightBook);
    magito.attack(sorcerer);
    assertEquals(20,sorcerer.getCurrentHitPoints());
  }
  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().setEquippedItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  /**
   * Checks if the unit moves correctly
   */
  @Test
  public void addItemTest(){
    assertTrue(getInventory().isEmpty());
    getTestUnit().addItem(getAxe());
    getTestUnit().addItem(getSword());
    getTestUnit().addItem(getBow());
    getTestUnit().addItem(getStaff());
    assertFalse(getTestUnit().getItems().contains(getStaff()));
  }
  public List getInventory() {return items; }
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }



  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Override
  @Test
  public void equipBookTest() { checkEquippedItem(getDarknessBook());}

  @Override
  public DarknessBook getDarknessBook(){return darknessBook;}
  @Override
  public LightBook getLightBook(){return lightBook;}

  @Override
  public SpiritBook getSpiritBook(){return spiritBook;}
}
