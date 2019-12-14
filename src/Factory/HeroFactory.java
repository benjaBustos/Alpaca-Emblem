package Factory;
import model.units.Hero;

public class HeroFactory implements IUnitFactory {
    @Override
    public Hero create(){
        return new Hero(50,2,null);
    }
}
