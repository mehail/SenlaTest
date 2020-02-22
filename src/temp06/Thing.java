package temp06;

public class Thing {

    private double weight;
    private int cost;

    public Thing(double weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static Thing generate() {
        final double weight = Math.random() * 999 + 1;
        final int cost = (int) Math.random() * 999 + 1;
        return new Thing(weight, cost);
    }

}
