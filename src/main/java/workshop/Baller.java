package workshop;

public class Baller extends Player {
    String name;
    int numberOfWides;
    int overBalled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWides() {
        return numberOfWides;
    }

    public void setNumberOfWides(int numberOfWides) {
        this.numberOfWides = numberOfWides;
    }

    public int getOverBalled() {
        return overBalled;
    }

    public void setOverBalled(int overBalled) {
        this.overBalled = overBalled;
    }
}
