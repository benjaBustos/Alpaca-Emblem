package Factory;
import model.items.Bow;
public class BowFactory implements IitemFactory {
    @Override
    public Bow create(){
        return new Bow("Common bow",8,2,4);
    }
}