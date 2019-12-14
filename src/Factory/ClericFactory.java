package Factory;

import model.units.Cleric;
public class ClericFactory implements IUnitFactory {
    @Override
    public Cleric create(){
        return new Cleric(50,2,null);
    }
}
