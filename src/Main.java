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
        int requestTime = 0;
        boolean firstLoop = true;
        while (input.hasNextLine())   {
            if (firstLoop) {
                currentLine = breakUpLine(input.nextLine());
                currenttime = Integer.parseInt(currentLine[1]);
                requestTime = Integer.parseInt(currentLine[1]);
            }
            if (currenttime == requestTime) {
                if (currentLine[0].equals("CustomerOrder")) {
                    orderList.addLast(new CustomerOrder(Integer.parseInt(currentLine[1]), currentLine[2], Integer.parseInt(currentLine[3]), Integer.parseInt(currentLine[4])));
                }// If a customer order has been requested create it and add it to the list.
                else if (currentLine[0].equals("PrintAvailableWorkerList")) {

                }
                else if (currentLine[0].equals("PrintWorkerAssignmentList")) {
                }
                else if (currentLine[0].equals("PrintMaxFulfillmentTime")) {

                }
                else {
                    System.out.println("Error");
                    return;
                }
                currentLine = input.nextLine().split("\s");
                requestTime = Integer.parseInt(currentLine[1]);
            } // If the current time matches with the new request,
            // complete the request and ping for a new one
            if ((orderList.last().bundleAble) && (currenttime - orderList.last().getOrderTime() < 5)) {
                // look for a bundle
            }
            currenttime = incrementTime(currenttime);
        }
        // Linked list contains the order of the available workers set not to change
    }
    public static int incrementTime(int currenttime) {
        int hours = currenttime/100;
        int minutes = currenttime%100;
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        return (hours*100)+minutes;
    }
    public static String[] breakUpLine(String inputLine) {
        String[] brokenUp = inputLine.split("\s");
        return brokenUp;
    }
    public String printAvailableWorkerList(SinglyLinkedList<WorkerAssignment> workerList) {
        String output = "AvailableWorkerList " + workerList;
        return output;
    }
}