import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main (final String args[]) {
        File file = new File(args[0]);
        final Scanner input;
        try {
            input = new Scanner(file, "US-ASCII");
        }
        catch (FileNotFoundException e) {
            return;
        } // If the file is not found a return is issued


        // Create all needed lists
        SinglyLinkedList<CustomerOrder> orderList = new SinglyLinkedList<CustomerOrder>();
        SinglyLinkedList<WorkerAssignment> assingmentList = new SinglyLinkedList<WorkerAssignment>();
        SinglyLinkedList<String> availableWorkerList = new SinglyLinkedList<String>();
        availableWorkerList.addLast("Alice");
        availableWorkerList.addLast("Bob");
        availableWorkerList.addLast("Carol");
        availableWorkerList.addLast("David");
        availableWorkerList.addLast("Emily");
        // initialize available worker list with the initial order of workers.


        if (!input.hasNextLine()) {
            System.out.println("Error: No Input in file");
            return;
        } // Stop the program if there is no input in the file.
        int currenttime = -1;
        String[] currentLine = new String[0];
        boolean firstLoop = true;
        while (input.hasNextLine())   {
            if (firstLoop) {
                currentLine = input.nextLine().split("\s");
                currenttime = Integer.parseInt(currentLine[1]);
            }
            if ((orderList.last().getOrderTime() == currenttime) || (firstLoop)) {
                switch (currentLine[0]) {
                    case "CustomerOrder":
                        orderList.addLast(new CustomerOrder(Integer.parseInt(currentLine[1]), currentLine[2], Integer.parseInt(currentLine[3]), Integer.parseInt(currentLine[4])));
                        orderList.sort();
                        break;
                    case "PrintAvailableWorkerList":

                        break;
                    case "PrintWorkerAssignmentList":
                        break;
                    case "PrintMaxFulfillmentTime":

                        break;
                    default:
                        System.out.println("Error");
                        return;
                }
                currentLine = input.nextLine().split("\s");
                // You will always handle the first request on the first loop as you need it to start.
                // Therefore, we will ping for a new one.
                firstLoop = false;
            } // If the current time matches with the new request,
            // complete the request and ping for a new one
            if (((orderList.last().bundleAble) && (currenttime - orderList.last().getOrderTime() < 5)) && ((orderList.last().getNumberofElectronics() == 0) && (((orderList.last().getNumberofBooks() + Integer.parseInt(currentLine[3])) < 10) ||
                    (orderList.last().getNumberofBooks() == 0) && (orderList.last().getNumberofElectronics() + Integer.parseInt(currentLine[4]) < 10)))) {
                // bundle
                currentLine = input.nextLine().split("\s");
            }
            currenttime = Time.incrementTime(currenttime);
        }
        // Linked list contains the order of the available workers set not to change
    }
}