import java.util.*;

public class WarMain {
    private static final Set<String> VALID_TYPES = new HashSet<>(Arrays.asList(
        "Militia", "Spearmen", "LightCavalry", "HeavyCavalry", "FootArcher", "CavalryArcher"
    ));

    public static List<Platoon> readAndValidateInput(String line) {
        if (line == null || line.trim().isEmpty()) {
            System.out.println("Error: Empty input.");
            return null;
        }

        String[] parts = line.split(";");
        if (parts.length != 5) {
            System.out.println("Error: Need 5 platoons.");
            return null;
        }

        List<Platoon> platoons = new ArrayList<>();
        Set<String> types = new HashSet<>();
        for (String p : parts) {
            if (!p.contains("#")) {
                System.out.println("Error: Bad format: " + p);
                return null;
            }
            String[] data = p.split("#");
            String type = data[0];
            if (!VALID_TYPES.contains(type)) {
                System.out.println("Error: Invalid type: " + type);
                return null;
            }
            if (types.contains(type)) {
                System.out.println("Error: Duplicate type: " + type);
                return null;
            }
            types.add(type);

            int soldiers;
            try {
                soldiers = Integer.parseInt(data[1]);
                if (soldiers <= 0) {
                    System.out.println("Error: Need positive soldiers.");
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number: " + data[1]);
                return null;
            }

            platoons.add(new Platoon(type, soldiers));
        }
        return platoons;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter 5 platoons");
        System.out.println("Types: Militia, Spearmen, LightCavalry, HeavyCavalry, FootArcher, CavalryArcher");
        System.out.println("Example: Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120");

        List<Platoon> myArmy = null;
        while (myArmy == null) {
            System.out.print("\nYour army: ");
            myArmy = readAndValidateInput(scanner.nextLine());
            if (myArmy == null) {
                System.out.println("Try again: ");
            }
        }

        System.out.print("Opponent's army: ");
        List<Platoon> enemyArmy = null;
        while (enemyArmy == null) {
            enemyArmy = readAndValidateInput(scanner.nextLine());
            if (enemyArmy == null) {
                System.out.println("Try again: ");
            }
        }

        scanner.close();

        War war = new War(myArmy, enemyArmy);
        war.displayResult();
    }
}