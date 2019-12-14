package Factory;
import model.units.Sorcerer;
public class SorcererFactory implements IUnitFactory {
    @Override
    public Sorcerer create(){
        return new Sorcerer(50,2,null);
    }
}
