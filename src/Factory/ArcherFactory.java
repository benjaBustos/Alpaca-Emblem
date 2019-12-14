package Factory;

import model.units.Archer;
public class ArcherFactory implements IUnitFactory {
    @Override
    public Archer create(){
        return new Archer(50,2,null);
    }

}
