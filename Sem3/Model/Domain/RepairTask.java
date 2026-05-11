package Sem3.Model.Domain;

public class RepairTask { //Represents a repair task that is performed as part of a repair order. It has properties for the description of the task and the cost of the task, along with getters and setters for these properties.
    private String description;
    private double cost;

    public RepairTask(String description, double cost) { //Constructor for the RepairTask class. It takes in a description of the task and its cost, and initializes the corresponding fields of the RepairTask object.
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() { //Returns the description of the repair task
        return description; 
    }

    public void setDescription(String description) {    //Sets the description of the repair task to the given value
        this.description = description;
    }

    public double getCost() { //Returns the cost of the repair task
        return cost;
    }

    public void setCost(double cost) { //Sets the cost of the repair task to the given value
        this.cost = cost;
    }

    @Override //Didnt bother using
    public String toString() {
        return "RepairTask{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
