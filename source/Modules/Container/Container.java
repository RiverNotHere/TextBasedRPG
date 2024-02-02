package source.Modules.Container;

import source.Interfaces.Interactable;
import source.Modules.Item.Item;

public class Container implements Interactable {
    public static final int DEFAULT_CAPACITY = 5;

    private Item[] inventory;
}
