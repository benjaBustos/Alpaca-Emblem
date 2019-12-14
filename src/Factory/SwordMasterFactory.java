package Factory;
import model.units.SwordMaster;
public class SwordMasterFactory implements IUnitFactory {
    @Override
    public SwordMaster create(){
        return new SwordMaster(50,2,null);
    }
}
