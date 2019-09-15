package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import model.items.*;

import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  public int currentHitPoints;
  public int movement;
  protected IEquipableItem equippedItem;
  private Location location;
  private int maxItems;
  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit( int hitPoints, int movement,
      Location location, int maxItems, IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.maxItems = maxItems;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));

  }

  /**
   * get actual hit points for unit
   * @return actual hitpoints
   */
  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  /**
   * get Bag of items for unit
   * @return Bag
   */
  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  /**get unit's equipped item
   *
   * @return equipped item
   */
  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  /**
   * general method to set item to unit
   * @param item
   */
  @Override
  public void setEquippedItem( IEquipableItem item) {

  }

  /**
   * general location method, gets unit current location
   * @return
   */
  @Override
  public Location getLocation() {
    return location;
  }

  /**
   * sets location for unit
   * @param location
   */
  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  /**
   * get how much movement a unit can move
   * @return movement
   */
  @Override
  public int getMovement() {
    return movement;
  }

  /**
   * general move method for unit
   * @param targetLocation
   */
  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  /**
   * adds item to list of items
   * @param item
   */
  @Override
  public void addItem(IEquipableItem item){
    if(items.size()<maxItems){
      items.add(item);
    }
  }

  /**
   * Exchange method between units
   * @param other
   * @param item
   */
  @Override
  public void giveItem(IUnit other, IEquipableItem item){
    if(this.getLocation().distanceTo(other.getLocation())==1){
      if(this.items.contains(item)){
        item.giveTo(other);
        this.items.remove(item);
        this.setEquippedItem(item);
      }
    }
  }

  /**
   * unit counter attacks after taking damage
   * @param other
   */
  @Override
  public void counterAttack(IUnit other){if(this.equippedItem != null && this.currentHitPoints > 0 && other.getCurrentHitPoints() > 0){this.equippedItem.attack(other); }
  }

  /**
   * principal attack methot between units
   * @param other
   */
  @Override
  public void attack(IUnit other){
    if(this.equippedItem != null && this.currentHitPoints > 0 && other.getCurrentHitPoints() > 0){
      this.equippedItem.attack(other);
      other.counterAttack(this);}
  }

  /**
   * generic unit receiving attack from item
   * @param item
   */
  public void receiveAttack(IEquipableItem item){
    this.currentHitPoints -= item.getPower();
    if(this.currentHitPoints <= 0){
      this.currentHitPoints = 0;
    }
  }

  /**
   * unit receiving heal
   * @param item
   */
  public void receiveHeal(IEquipableItem item){this.currentHitPoints += item.getPower();}

  /**
   * unit receiving attack from bow
   * @param bow
   */
  @Override
  public void receiveAttackFromBow(Bow bow){receiveAttack(bow);}

  /**
   * unit receiving attack from axe
   * @param axe
   */
  @Override
  public void receiveAttackFromAxe(Axe axe){receiveAttack(axe);}

  /**
   * unit receiving attack from spear
   * @param spear
   */
  @Override
  public void receiveAttackFromSpear(Spear spear){receiveAttack(spear);}

  /**
   * unit receiving attack from sword
   * @param sword
   */
  @Override
  public void receiveAttackFromSword(Sword sword){receiveAttack(sword);}

  /**
   * unit receiving receiving heal by staff
   * @param staff
   */
  @Override
  public void receiveHealFromStaff(Staff staff){receiveHeal(staff);}

  /**
   * unit receiving attack from dark magic
   * @param dbook
   */
  @Override
  public void receiveAttackFromDarknessBook(DarknessBook dbook){receiveAttack(dbook);}

  /**
   * unit receiving attack from light magic
   * @param lbook
   */
  @Override
  public void receiveAttackFromLightBook(LightBook lbook){receiveAttack(lbook);}

  /**
   * unit receiving attack from spirit magic
   * @param sbook
   */
  @Override
  public void receiveAttackFromSpiritBook(SpiritBook sbook){receiveAttack(sbook);}

  /**
   * unit receiving damage from weakness attack
   * @param item
   */
  @Override
  public void receiveWeaknessAttack(IEquipableItem item){this.currentHitPoints -= item.getPower() * 1.5;
    if(this.currentHitPoints <= 0){
      this.currentHitPoints = 0;
    }}

  /**
   * unit receiving damage from resistant attack
   * @param item
   */
  @Override
  public void receiveResistantAttack(IEquipableItem item){this.currentHitPoints -= item.getPower() -20;
    if(this.currentHitPoints <= 0){
      this.currentHitPoints = 0;
    }}







}
