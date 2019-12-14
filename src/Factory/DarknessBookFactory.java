package Factory;
import model.items.DarknessBook;
public class DarknessBookFactory implements IitemFactory {
    @Override
    public DarknessBook create(){
        return new DarknessBook("Common darkbook",10,1,2);
    }
}