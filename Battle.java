import java.util.*;

public class Battle {
    private Map<String, List<String>> advantages = new HashMap<>();

    public Battle() {
        advantages.put("Militia", Arrays.asList("Spearmen", "LightCavalry"));
        advantages.put("Spearmen", Arrays.asList("LightCavalry", "HeavyCavalry"));
        advantages.put("LightCavalry", Arrays.asList("FootArcher", "CavalryArcher"));
        advantages.put("HeavyCavalry", Arrays.asList("Militia", "FootArcher", "LightCavalry"));
        advantages.put("CavalryArcher", Arrays.asList("Spearmen", "HeavyCavalry"));
        advantages.put("FootArcher", Arrays.asList("Militia", "CavalryArcher"));
    }

   public boolean isWin(Platoon myArmy, Platoon enemyArmy) {
        String myType = myArmy.getSoldierType();
        String enemyType = enemyArmy.getSoldierType();
        int myCount = myArmy.getSoldierCount();
        int enemyCount = enemyArmy.getSoldierCount();
        
        if (advantages.getOrDefault(myType, new ArrayList<>()).contains(enemyType)) {
            return myCount * 2 > enemyCount;
        }
        else if (advantages.getOrDefault(enemyType, new ArrayList<>()).contains(myType)) {
            return myCount > enemyCount * 2;
        }
        else {
            return myCount > enemyCount;
        }
    }
}
