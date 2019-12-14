package Factory;
import model.items.Sword;
public class SwordFactory implements IitemFactory {
    @Override
    public Sword create(){
        return new Sword("Common sword",10,1,2);
    }
}