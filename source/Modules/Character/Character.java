package source.Modules.Character;

import java.util.*;

import source.Modules.Item.*;

public class Character {
    private int health;
    private Map<String, Integer> stats = new HashMap<>();
    private Item[] equipments;

    public void initStats() {
        stats.put("atk", 10);
    }
}
