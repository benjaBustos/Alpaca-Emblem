package Factory;
import model.items.SpiritBook;
public class SpiritBookFactory implements IitemFactory {
    @Override
    public SpiritBook create(){
        return new SpiritBook("Common spiritbook",10,1,2);
    }
}