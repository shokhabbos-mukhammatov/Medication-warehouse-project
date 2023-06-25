package edu.itpu.fopjava_course_work.main;

import edu.itpu.fopjava_course_work.controller.DispatcherController;
import edu.itpu.fopjava_course_work.controller.RawConverters;
import edu.itpu.fopjava_course_work.service.MedicationService;
import edu.itpu.fopjava_course_work.service.ServiceFactory;
import edu.itpu.fopjava_course_work.view.MedicationView;
import edu.itpu.fopjava_course_work.view.Observer;

import java.util.Collection;
import java.util.Scanner;

public class Main implements Observer {

    public static void main(String[] args) {
        MedicationService medicationService = new ServiceFactory().getAMedicationeService();
        MedicationView view = new MedicationView(medicationService);
        DispatcherController controller = new DispatcherController(medicationService, RawConverters.getConvertersMap());

        Scanner scanner = new Scanner(System.in);
        System.out.println("= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n\n");
        System.out.println("Welcome to Medication Warehouse Search application!\n"+
        "Version: 1.0.0\n"+
        "Created date: 21 May 2023\n"+
        "Powered by Shokhabbos Mukhammatov\n\n");
        System.out.println("= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n\n");
        System.out.println("List of avaliable commands:\n"+
        "exit   - type 'exit' for stopping application\n"+
        "all    - type 'all' to print entire list of medications from a source file\n"+
        "ignore expirydate - type 'ignore expirydate' to call settings of checking expiration date\n"+
        "(after calling this function, type 'yes' or 'no'. This setting is yes by default)\n"+
        "search - type 'search' to call search function, than follow steps than will be given further\n\n"
        );
        System.out.println("= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n\n");
        boolean work = true;
        while (work){
            System.out.println("Enter command or 'exit' to quit:");
            String command = scanner.nextLine();

            switch (command){
                case("exit"):
                    System.out.println("Exiting...");
                    work=false;
                    break;
                case("all"):
                    controller.retrieveAllMedications();
                    System.out.println("\n= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n");
                    break;
                case("ignore expirydate"):
                    System.out.println("Do you want to ignore checking for expiration of medication?\n"+
                    "yes or no -> ");
                    String ignoreCheckCommand = scanner.nextLine();
                    if(ignoreCheckCommand.equalsIgnoreCase("yes"))
                        controller.setIgnoredExpirationDate(true);
                    else if(ignoreCheckCommand.equalsIgnoreCase("no"))
                        controller.setIgnoredExpirationDate(true);
                    else System.out.println("incorrect input, please try again!");
                    System.out.println("\n= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n");
                    break;
                case("search"):
                    System.out.println("Enter search criteria (key=value pairs separated by &):");
                    String requestData = scanner.nextLine();
                    controller.listen(requestData);
                    System.out.println("\n= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n");
                    break;
                default:System.out.println("wrong command, please try again!");
                    System.out.println("\n= * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * = * =\n");
            }
        }
    }
    public void update(Collection updatedCollection){
        updatedCollection.forEach(System.out::println);
    }
}

