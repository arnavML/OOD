package Sem3.View;

public class Printer { //The Printer class is responsible for printing the details of the repair order. It has a method printRepairOrderDetails that takes in the details of the repair order and prints them in a formatted way to the console
    public void printRepairOrderDetails(int customerNumber, String description, String date, String status, String diagnosticReport, String repairTasks) { // Prints the details of the repair order in a formatted way to the console
        System.out.println("Customer Number: " + customerNumber);
        System.out.println("Description: " + description);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
        System.out.println("Diagnostic Report: " + diagnosticReport);
        System.out.println();
        System.out.println("Repair Tasks: " + repairTasks);
        System.out.println();
    }
}
