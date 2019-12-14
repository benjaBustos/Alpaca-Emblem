package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import model.Tactician;
import model.items.IEquipableItem;
import model.items.Spear;
import model.items.Sword;
import model.map.Field;
import model.units.Hero;
import model.units.IUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */


class GameControllerTest {

  private GameController controller;
  private long randomSeed;
  private List<String> testTacticians;


  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests
    randomSeed = new Random().nextLong();
    controller = new GameController(4, 128);
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(128, gameMap.getSize()); // getSize deben definirlo
    assertTrue(controller.getGameMap().isConnected());
    Random testRandom = new Random(controller.randomseed);
    Field testField = new Field();
    testField.setRandom(testRandom);
    testField.createMap(gameMap.getSize());

    for(int i=0;i<gameMap.getSize();i++){
      for(int j=0;j<gameMap.getSize();j++) {
        assertEquals(gameMap.getCell(i, j), testField.getCell(i, j));
        assertEquals(gameMap.getCell(i, j).getNeighbours().size(), testField.getCell(i, j).getNeighbours().size());
      //assertEquals(gameMap.getCell(i,j).getNeighbours(),testField.getCell(i,j).getNeighbours());
        //for(int k=0;k<gameMap.getCell(i,j).getNeighbours().size();k++){
        //  assertTrue(gameMap.getCell(i,j).getNeighbours());
        //}
      }
    }

    // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
    //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
    //    las dimensiones definidas y que sea conexo.
    //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
    //    secuencia de números generada sea siempre la misma, así pueden predecir los
    //    resultados que van a obtener.
    //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
    //    usar el método setSeed de Random.
    //  ESTO ÚLTIMO NO ESTÁ IMPLEMENTADO EN EL MAPA, ASÍ QUE DEBEN AGREGARLO (!)
  }

  @Test
  void getTurnOwner() {
    controller.setTurnOwner(controller.getTacticians().get(0));
    IUnit test_hero = new Hero(50,2,null);
    assertEquals("Player 0",controller.getTurnOwner().getName());

    //  En este caso deben hacer lo mismo que para el mapa
  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {
      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    Random randomTurnSequence = new Random();
    IntStream.range(0, 50).forEach(i -> {
      controller.initGame(randomTurnSequence.nextInt());
      assertEquals(randomTurnSequence.nextInt(), controller.getMaxRounds());
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    Tactician firstPlayer = controller.getTurnOwner();
    // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
    Tactician secondPlayer = controller.players.get(controller.getCurrentTurn()+1); // <- Deben cambiar esto (!)
    assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

    controller.endTurn();
    assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
    assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians().forEach(tactician -> assertNotEquals("Player 1", tactician));
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 5");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    IntStream.range(0, 8).forEach(i -> controller.endTurn());
    assertEquals(4, controller.getWinners().size());
    controller.getWinners().forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

    controller.initGame(2);
    IntStream.range(0, 4).forEach(i -> controller.endTurn());
    assertNull(controller.getWinners());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 2");
    IntStream.range(0, 2).forEach(i -> controller.endTurn());
    List<String> winners = controller.getWinners();
    assertEquals(2, winners.size());
    assertTrue(List.of("Player 1", "Player 2").containsAll(winners));

    controller.initEndlessGame();
    for (int i = 0; i < 3; i++) {
      assertNull(controller.getWinners());
      controller.removeTactician("Player " + i);
    }
    assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {
    controller.setTurnOwner(controller.getTacticians().get(0));
    controller.setSelectedUnit(controller.getTurnOwner().myUnits.get(0));
    assertEquals(Hero.class,controller.getSelectedUnit().getClass());

  }

  @Test
  void selectUnitIn() {
    controller.setTurnOwner(controller.getTacticians().get(0));
    controller.setSelectedUnit(controller.getTurnOwner().myUnits.get(0));

    controller.getGameMap().getCell(0,0).setUnit(controller.getSelectedUnit());
    controller.getSelectedUnit().setLocation(controller.getGameMap().getCell(0,0));
    controller.selectUnitIn(0,0);
    assertEquals(Hero.class, controller.getSelectedUnit().getClass());
  }

  @Test
  void getItems() {
    controller.setTurnOwner(controller.getTacticians().get(0));
    controller.setSelectedUnit(controller.getTurnOwner().myUnits.get(0));
    List<IEquipableItem> testlist = new ArrayList<>();
    IEquipableItem lanza_pruebaTest = new Spear("lanza prueba",5,2,3);
    testlist.add(lanza_pruebaTest);
    assertEquals(testlist.get(0).getClass(),controller.getItems().get(0).getClass());
  }

  @Test
  void equipItem() {
    controller.setTurnOwner(controller.getTacticians().get(0));
    controller.setSelectedUnit(controller.getTurnOwner().myUnits.get(0));
    IEquipableItem lanza_pruebaTest = new Spear("Hiper lanza",5,2,3);
    controller.getSelectedUnit().addItem(lanza_pruebaTest);
    controller.equipItem(1);
    //assertTrue(controller.getSelectedUnit().getEquippedItem().getName().equals("Hiper lanza"));
    assertEquals(lanza_pruebaTest.getName(),controller.getSelectedUnit().getEquippedItem().getName());

  }

  @Test
  void useItemOn() {
  }

  @Test
  void selectItem() {
    controller.setTurnOwner(controller.getTacticians().get(0));
    controller.setSelectedUnit(controller.getTurnOwner().myUnits.get(0));
    controller.selectItem(0);
    assertEquals(Spear.class,controller.getSelectedItem().getClass());


  }

  @Test
  void giveItemTo() {
  }

}

