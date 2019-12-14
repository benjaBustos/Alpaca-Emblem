package Factory;
import model.items.LightBook;
public class LightBookFactory implements IitemFactory {
    @Override
    public LightBook create(){
        return new LightBook("Common lightbook",10,1,2);
    }
}