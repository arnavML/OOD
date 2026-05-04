package Sem3;

public class Printer {
    public void printRepairOrderDetails(RepairOrder repairOrder) {
        System.out.println("Printing Repair Order Details...");
        System.out.println("Customer Number: " + repairOrder.getOrderPhoneNumber());
        System.out.println("Description: " + repairOrder.getDescription());
        System.out.println("Date: " + repairOrder.getDate());
        System.out.println("Status: " + repairOrder.getStatus());
        System.out.println("Diagnostic Report: " + repairOrder.getDiagnosticReport());
        for (RepairTask task : repairOrder.getRepairTasks()) {
            System.out.println("Task: " + task.getDescription());
            System.out.println("Cost: " + task.getCost());
        }
        System.out.println();
    }
}
