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

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem( IEquipableItem item) {

  }
  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

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
  @Override
  public void counterAttack(IUnit other){if(this.equippedItem != null && this.currentHitPoints > 0 && other.getCurrentHitPoints() > 0){this.equippedItem.attack(other); }
  }
  @Override
  public void attack(IUnit other){
    if(this.equippedItem != null && this.currentHitPoints > 0 && other.getCurrentHitPoints() > 0){
      this.equippedItem.attack(other);
      other.counterAttack(this);}
  }
  public void receiveAttack(IEquipableItem item){
    this.currentHitPoints -= item.getPower();
    if(this.currentHitPoints <= 0){
      this.currentHitPoints = 0;
    }
  }
  public void receiveHeal(IEquipableItem item){this.currentHitPoints += item.getPower();}
  @Override
  public void receiveAttackFromBow(Bow bow){receiveAttack(bow);}
  @Override
  public void receiveAttackFromAxe(Axe axe){receiveAttack(axe);}
  @Override
  public void receiveAttackFromSpear(Spear spear){receiveAttack(spear);}
  @Override
  public void receiveAttackFromSword(Sword sword){receiveAttack(sword);}
  @Override
  public void receiveHealFromStaff(Staff staff){receiveHeal(staff);}
  @Override
  public void receiveAttackFromDarknessBook(DarknessBook dbook){receiveAttack(dbook);}
  @Override
  public void receiveAttackFromLightBook(LightBook lbook){receiveAttack(lbook);}
  @Override
  public void receiveAttackFromSpiritBook(SpiritBook sbook){receiveAttack(sbook);}
  @Override
  public void receiveWeaknessAttack(IEquipableItem item){this.currentHitPoints -= item.getPower() * 1.5;
    if(this.currentHitPoints <= 0){
      this.currentHitPoints = 0;
    }}
  @Override
  public void receiveResistantAttack(IEquipableItem item){this.currentHitPoints -= item.getPower() -20;
    if(this.currentHitPoints <= 0){
      this.currentHitPoints = 0;
    }}







}
