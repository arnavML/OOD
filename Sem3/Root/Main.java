package Sem3.Root;

import Sem3.Controller.Controller;
import Sem3.View.Printer;
import Sem3.View.Viewer;
import Sem3.integration.CustomerRegistry;
import Sem3.integration.RepairOrderRegistry;

public class Main { //The Main class is the entry point of the application. It initializes the necessary components (view, controller, customer registry, repair order registry, and printer) and starts the view to accept user input and perform search for customers and repair orders.
    private static Viewer view;
    private static Controller controller;
    private static CustomerRegistry customerRegistry = new CustomerRegistry();
    private static RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
    private static Printer printer = new Printer();

    public static void main(String[] args) { //Boots up the system by initializing the controller and view, and then starts the view to perform search
        controller = new Controller(customerRegistry, repairOrderRegistry, printer);
        view = new Viewer(controller);
        view.Start(); // Start the view to accept user input and perform search // Can also start itself in initialization, but this way there have more control over when it starts for future use
    }

}