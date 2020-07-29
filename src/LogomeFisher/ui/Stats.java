package LogomeFisher.ui;

public class Stats {
    private static Stats instance = null;

    private long startTime = 0;
    private int bankTrips = 0;
    private int shrimps = 0;
    private int anchovies = 0;
    private int fishLevel = 0;
    private String status = "waiting";

    public final static int SHRIMP_XP = 10;
    public final static int ANCHOVIES_XP = 40;

    protected Stats() {
        startTime = System.currentTimeMillis();
    }

    public static Stats getInstance() {
        if (instance == null) {
            instance = new Stats();
        }
        return instance;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getBankTrips() {
        return bankTrips;
    }

    public void incBankTrips() {
        this.bankTrips++;
    }

    public int getShrimps() {
        return shrimps;
    }

    public void incShrimps() {
        this.shrimps++;
    }

    public int getAnchovies() {
        return anchovies;
    }

    public void incAnchovies() {
        this.anchovies++;
    }

    public void setFishLevel(int fishLevel) {
        this.fishLevel = fishLevel;
    }

    public int getFishLevel() {
        return fishLevel;
    }

    public void incFishLevel() {
        this.fishLevel++;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalXP() {
        // Another way is to store starting experience and then subtract it from current
        return SHRIMP_XP * this.shrimps + ANCHOVIES_XP * this.anchovies;
    }
}
