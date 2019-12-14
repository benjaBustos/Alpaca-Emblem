package Factory;
import model.items.Staff;
public class StaffFactory implements IitemFactory {
    @Override
    public Staff create(){
        return new Staff("Common staff",10,1,2);
    }
}