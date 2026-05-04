package Sem3;
import java.util.ArrayList;
import java.util.List;

public class RepairOrder {
    private int orderPhoneNumber;
    private String description;
    private String status;
    private String date;
    private String diagnosticReport;

    private List<RepairTask> repairTasks = new ArrayList<>();

    public List<RepairTask> getRepairTasks() {
        return repairTasks;
    }

    public void addRepairTask(String taskDescription, Double cost) {
        repairTasks.add(new RepairTask(taskDescription, cost));
    }


    public RepairOrder(int orderPhoneNumber, String description, String date, String status) {
        this.orderPhoneNumber = orderPhoneNumber;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public int getOrderPhoneNumber() {
        return orderPhoneNumber;
    }

    public void setOrderPhoneNumber(int orderPhoneNumber) {
        this.orderPhoneNumber = orderPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDiagnosticReport(String diagnosticReport) {
        this.diagnosticReport = diagnosticReport;
    }
    public String getDiagnosticReport() {
        return diagnosticReport;
    }

    @Override
    public String toString() {
        return "RepairOrder{" +
                "orderPhoneNumber=" + orderPhoneNumber +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
