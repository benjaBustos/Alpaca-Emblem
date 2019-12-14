package Factory;
import model.items.Axe;
public class AxeFactory implements IitemFactory {
    @Override
    public Axe create(){
        return new Axe("Common axe",10,1,2);
    }
}
