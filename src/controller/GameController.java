package controller;

import java.util.*;

import model.Tactician;
import model.items.IEquipableItem;
import model.items.MagicItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;
import Factory.*;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {
  public List<Tactician> players = new ArrayList<>();
  public Field mapa = new Field();
  public long randomseed = new Random().nextLong();
  private Tactician turnOwner;
  private IUnit selectedUnit;
  private int currentTurn = 0;
  public int maxRounds = -1;
  private int roundNumber = 0;
  private IEquipableItem selectedItem;
  public Random random = new Random(this.randomseed);
  private IitemFactory axeF = new AxeFactory();
  private IitemFactory bowF = new BowFactory();
  private IitemFactory darkF = new DarknessBookFactory();
  private IitemFactory lightF = new LightBookFactory();
  private IitemFactory spearF = new SpearFactory();
  private IitemFactory spiritF = new SpiritBookFactory();
  private IitemFactory staffF = new StaffFactory();
  private IitemFactory swordF = new SwordFactory();

  private IUnitFactory alpacaF = new AlpacaFactory();
  private IUnitFactory archerF = new ArcherFactory();
  private IUnitFactory clericF = new ClericFactory();
  private IUnitFactory fighterF = new FighterFactory();
  private IUnitFactory heroF = new HeroFactory();
  private IUnitFactory sorcererF = new SorcererFactory();
  private IUnitFactory swordMasterF = new SwordMasterFactory();


  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
    for(int i=0;i<numberOfPlayers;i++){
      Tactician player = new Tactician(i);
      this.players.add(player);
      this.playerSetup(player);
    }
    this.setTurnOwner(getTacticians().get(getCurrentTurn()));
    this.mapa.implantSeed(randomseed);
    this.mapa.createMap(mapSize);




  }

  /**
   * Setup for a Tactician with one instance of each unit with their respective weapon
   *
   * @param tactician
   *     tactician to set units with
   */

  public void playerSetup(Tactician tactician){
    IUnit myHero = heroF.create();
    IEquipableItem lanza = spearF.create();
    myHero.addItem(lanza);
    myHero.setEquippedItem(lanza);
    addUnitToTactician(tactician,myHero);


    IUnit myAlpaca = alpacaF.create();
    addUnitToTactician(tactician,myAlpaca);

    IUnit myArcher = archerF.create();
    IEquipableItem arco  = bowF.create();
    myArcher.addItem(arco);
    myArcher.setEquippedItem(arco);
    addUnitToTactician(tactician,myArcher);

    IUnit mySorcererD = sorcererF.create();
    IEquipableItem libroD = darkF.create();
    mySorcererD.addItem(libroD);
    mySorcererD.setEquippedItem(libroD);
    addUnitToTactician(tactician,mySorcererD);

    IUnit mySorcererL = sorcererF.create();
    IEquipableItem libroL = lightF.create();
    mySorcererL.addItem(libroL);
    mySorcererL.setEquippedItem(libroL);
    addUnitToTactician(tactician,mySorcererL);

    IUnit mySorcererS = sorcererF.create();
    IEquipableItem libroS = spiritF.create();
    mySorcererS.addItem(libroS);
    mySorcererS.setEquippedItem(libroS);
    addUnitToTactician(tactician,mySorcererS);

    IUnit myCleric = clericF.create();
    IEquipableItem vara  = staffF.create();
    myCleric.addItem(vara);
    myCleric.setEquippedItem(vara);
    addUnitToTactician(tactician,myCleric);

    IUnit myFighter = fighterF.create();
    IEquipableItem hacha  = axeF.create();
    myFighter.addItem(hacha);
    myFighter.setEquippedItem(hacha);
    addUnitToTactician(tactician,myFighter);

    IUnit mySwordMaster = swordMasterF.create();
    IEquipableItem espada  = swordF.create();
    mySwordMaster.addItem(espada);
    mySwordMaster.setEquippedItem(espada);
    addUnitToTactician(tactician,mySwordMaster);

  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticians() {
    return List.copyOf(this.players);
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return this.mapa;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return this.turnOwner;
  }

  /**
   * Setter for Turn Owner
   *
   * @return tactician to be turn Owner
   */

  public void setTurnOwner(Tactician tactician){
    this.turnOwner = tactician;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return roundNumber;
  }
  /**
   * Setter for RoundNumber
   *
   * @return int round
   */
  public void setRoundNumber(int round){
    this.roundNumber = round;
  }


  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return maxRounds;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {
    this.setCurrentTurn(getCurrentTurn()+1);
    if(this.getCurrentTurn() == getTacticians().size()) {
      this.setRoundNumber(getRoundNumber()+1);
      if(this.getRoundNumber() < this.getMaxRounds()){
        this.setCurrentTurn(0);
        Collections.shuffle(getTacticians());
        while(getTurnOwner().getName().equals(getTacticians().get(getCurrentTurn()))){
          Collections.shuffle(getTacticians());
        }
        this.setTurnOwner(getTacticians().get(getCurrentTurn()));


      }
      else{

      }

    }
    else{
      this.setTurnOwner(getTacticians().get(getCurrentTurn()));
    }

  }
  /**
   * Getter for Turn Owner
   *
   * @return int with the current turn
   */

  public int getCurrentTurn()  {return currentTurn; }

  /**
   * Setter for Turn Owner
   *
   */

  public void setCurrentTurn(int turno){
    this.currentTurn = turno;
  }
  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {
      for(int i = 0; i <this.players.size();i++) {
        if(this.players.get(i).getName().equals(tactician)){
          for(int j = 0; j < players.get(i).myUnits.size();j++){
            players.get(i).myUnits.get(j).setLocation(null);
          }
          players.remove(players.get(i));

        }
      }

  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {
    setRoundNumber(maxTurns);
    Collections.shuffle(getTacticians(),random);
    this.setRoundNumber(0);
    this.setCurrentTurn(0);



  }
  /**
   * Adds unit to a tactician
   *
   * @param tactician
   *   tactician to be added with a unit
   * @param unit
   *   unit to be added to tactician
   */

  public void addUnitToTactician(Tactician tactician,IUnit unit){
    tactician.addUnit(unit);
  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {
    Collections.shuffle(getTacticians(),random);
    this.setCurrentTurn(0);
  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    List<String> winners = new ArrayList<>();
    for(int k=0;k<this.getTacticians().size();k++){
      winners.add(getTacticians().get(k).getName());
    }
    return winners;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return this.selectedUnit;
  }
  /**
   * Select unit to the controller
   *
   * @param unit
   *  unit to be selected
   */
  public void setSelectedUnit(IUnit unit){
    this.selectedUnit = unit;
  }
  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {
    setSelectedUnit(this.getGameMap().getCell(x,y).getUnit());

  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return selectedUnit.getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
    this.selectedUnit.setEquippedItem(selectedUnit.getItems().get(index));

  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {

  }
  /**
   * Getter for selected item
   *
   * @return selecte item
   */
  public IEquipableItem getSelectedItem(){return this.selectedItem;}

  /**
   * Setter for Selected item
   *
   * @param item
   *  item to be selected
   */
  public void setSelectedItem(IEquipableItem item){this.selectedItem = item;}


  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {
    setSelectedItem(getSelectedUnit().getItems().get(index));

  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {
    this.getGameMap().getCell(x,y).getUnit().addItem(getSelectedItem());


  }
}
