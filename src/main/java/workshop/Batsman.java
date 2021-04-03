package workshop;

public class Batsman extends Player{
    AttackingType attackingType;
    String name;
    int score;
    int ballsPlayed;
    boolean isOut;

    public AttackingType getAttackingType() {
        return attackingType;
    }

    public void setAttackingType(AttackingType attackingType) {
        this.attackingType = attackingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }
}
