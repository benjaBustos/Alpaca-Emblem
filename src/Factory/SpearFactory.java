package Factory;
import model.items.Spear;
public class SpearFactory implements IitemFactory {
    @Override
    public Spear create(){
        return new Spear("Common spear",10,1,2);
    }
}