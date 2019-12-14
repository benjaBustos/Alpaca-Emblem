package Factory;
import model.units.Fighter;
public class FighterFactory implements IUnitFactory {
    @Override
    public Fighter create(){
        return new Fighter(50,2,null);
    }
}
