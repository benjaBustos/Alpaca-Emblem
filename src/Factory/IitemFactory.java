package Factory;

import model.items.IEquipableItem;
import model.items.MagicItem;

public interface IitemFactory {
    IEquipableItem create();
}
