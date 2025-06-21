import java.util.*;

public class War {
    List<Platoon> myArmy;
    List<Platoon> enemyArmy;
    Battle battle;

    public War(List<Platoon> myArmy, List<Platoon> enemyArmy) {
        this.myArmy = myArmy;
        this.enemyArmy = enemyArmy;
        this.battle = new Battle();
    }

     public List<Platoon> getBestArrangement() {
        List<List<Platoon>> permutations = generatePermutations(myArmy);
        
        for (List<Platoon> perm : permutations) {
            int wins = 0;
            for (int i = 0; i < 5; i++) {
                if (battle.isWin(perm.get(i), enemyArmy.get(i))) {
                    wins++;
                }
            }

            if (wins >= 3) {
                return new ArrayList<>(perm);
            }
        }

        return null;
    }


    private List<List<Platoon>> generatePermutations(List<Platoon> platoons) {
        List<List<Platoon>> result = new ArrayList<>();
        List<Platoon> copy = new ArrayList<>(platoons);
        backtrack(copy, 0, result);
        return result;
    }


    private void backtrack(List<Platoon> list, int index, List<List<Platoon>> result) {
        if (index == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, i, index);
            backtrack(list, index + 1, result);
            Collections.swap(list, i, index); // backtrack
        }
    }

    public void displayResult() {
        System.out.println("\nOutput:");
        List<Platoon> best = getBestArrangement();
        if (best == null) {
            System.out.println("There is no chance of winning");
        } else {
            for (int i = 0; i < best.size(); i++) {
                System.out.print(best.get(i));
                if (i < best.size() - 1) System.out.print(";");
            }
            System.out.println();
        }
    }
}
