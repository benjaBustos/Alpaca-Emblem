package Factory;

import model.units.Alpaca;

public class AlpacaFactory implements IUnitFactory {
    @Override
    public Alpaca create(){
        return new Alpaca(50,2,null);
    }
}
