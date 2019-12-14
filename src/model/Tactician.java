package model;
import model.units.IUnit;
import controller.GameController;
import java.util.List;
import java.util.ArrayList;

public class Tactician {
    public String name;
    public List<IUnit> myUnits = new ArrayList<>();

    public Tactician(int number){
        this.name = "Player "+number;
    }

    public String getName(){return name; }

    public void addUnit(IUnit unit){
        this.myUnits.add(unit);
    }

    public void removeTactician(GameController controller){


    }
}
