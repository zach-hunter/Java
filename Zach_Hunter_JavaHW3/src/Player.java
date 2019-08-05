public class Player {
    private String playerName;
    private String playerPos;
    private int playerBats;
    private int playerHits;
    private double playerAverage;


    public Player() {

    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getPlayerPos() {
        return this.playerPos;
    }

    public int getPlayerBats() {
        return this.playerBats;
    }

    public int getPlayerHits() {
        return this.playerHits;
    }

    public double getPlayerAverage() {
        return this.playerAverage;
    }

    public void setPlayerName(String name) {
        this.playerName = name != "" ? name : " ";
    }

    public void setPlayerPos(String pos) {
        this.playerPos = pos != "" ? pos : " ";
    }

    public void setPlayerBats(int bats) {
        this.playerBats = bats > 0 ? bats : 0;
    }

    public void setPlayerHits(int hits) {
        this.playerHits = hits > 0 ? hits : 0;
    }

    public void setPlayerAverage() {
        this.playerAverage = (this.getPlayerHits()/this.getPlayerBats());
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %d, %.3f", this.getPlayerName(), this.getPlayerPos(), this.getPlayerBats(), this.getPlayerHits(), this.getPlayerAverage());
    }


}
