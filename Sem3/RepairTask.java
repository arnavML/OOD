package Sem3;

public class RepairTask {
    private String description;
    private double cost;

    public RepairTask(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "RepairTask{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
