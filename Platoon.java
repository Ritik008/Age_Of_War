public class Platoon {
    private String soldierType;
    private int count;

    public Platoon(String soldierType, int count) {
        this.soldierType = soldierType;
        this.count = count;
    }

    public String getSoldierType() {
        return this.soldierType;
    }

    public int getSoldierCount() {
        return this.count;
    }

    @Override
    public String toString() {
        return soldierType + "#" + count;
    }
}