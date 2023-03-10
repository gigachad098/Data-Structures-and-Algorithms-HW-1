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
        SinglyLinkedList<WorkerAssignment> assingmentList = new SinglyLinkedList<WorkerAssignment>();
        SinglyLinkedList<String> availableWorkerList = new SinglyLinkedList<String>();
        availableWorkerList.addLast("Alice");
        availableWorkerList.addLast("Bob");
        availableWorkerList.addLast("Carol");
        availableWorkerList.addLast("David");
        availableWorkerList.addLast("Emily");
        // initialize available worker list with the initial order of workers.
        int MaxFufillMentTime = 0;


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
            else if (assingmentList.first().newestOrder().calculateOrderCompletion() == currenttime)  {
                availableWorkerList.addLast(assingmentList.first().worker);
                while (!assingmentList.first().assignedOrder.isEmpty()) {
                    // order completion
                    CustomerOrder.printCompletedOrder(assingmentList.first().assignedOrder.first(), currenttime);
                    if (currenttime - assingmentList.first().assignedOrder.first().getOrderTime() > MaxFufillMentTime) {
                        MaxFufillMentTime = (currenttime- assingmentList.first().assignedOrder.first().getOrderTime());
                        // If the completed order took longer to fufill then the maximum order time swap them.
                    }
                    assingmentList.first().assignedOrder.removeFirst();
                }
            }
//            Move this stuff down here, up to Here^^^^
            if ((Integer.parseInt(currentLine[1]) == currenttime) || (firstLoop)) {
                switch (currentLine[0]) {
                    case "CustomerOrder":
                        assingmentList = insertList(assingmentList, new WorkerAssignment(availableWorkerList.first(), new CustomerOrder(Integer.parseInt(currentLine[1]), currentLine[2], Integer.parseInt(currentLine[3]), Integer.parseInt(currentLine[4]))));
                        availableWorkerList.removeFirst();
                        break;
                    case "PrintAvailableWorkerList":

                        break;
                    case "PrintWorkerAssignmentList":

                        break;
                    case "PrintMaxFulfillmentTime":
                        printMaxFufillmentTime(MaxFufillMentTime);
                        break;
                    default:
                        System.out.println("Error");
                        return;
                }
                currentLine = input.nextLine().split("\s");
                // You will always handle the first request on the first loop as you need it to start.
                // Therefore, we will ping for a new one.
                firstLoop = false;
                continue;
            } // If the current time matches with the new request,
            // complete the request and ping for a new one
            if (((assingmentList.last().newestOrder().canBundle()) && (assingmentList.last().newestOrder().getOrderTime() - currenttime < 5))) {
                // Will not work without time class
                if (((assingmentList.last().newestOrder().getNumberofBooks() + Integer.parseInt(currentLine[3])) < 10) ||
                        (assingmentList.last().newestOrder().getNumberofElectronics() + Integer.parseInt(currentLine[4]) < 10)) {
                    if (currentLine[0] == "CustomerOrder") {
                        if ((assingmentList.last().newestOrder().getNumberofBooks() == 0) && (Integer.parseInt(currentLine[3]) == 0)) {
                            assingmentList.last().assignedOrder.addLast(new CustomerOrder(Integer.parseInt(currentLine[1]), currentLine[2], Integer.parseInt(currentLine[3]), Integer.parseInt(currentLine[4])));
                            currentLine = input.nextLine().split("\s");
                            continue;
                        }
                        else if ((assingmentList.last().newestOrder().getNumberofElectronics() == 0) && (Integer.parseInt(currentLine[4]) == 0)) {
                            assingmentList.last().assignedOrder.addLast(new CustomerOrder(Integer.parseInt(currentLine[1]), currentLine[2], Integer.parseInt(currentLine[3]), Integer.parseInt(currentLine[4])));
                            currentLine = input.nextLine().split("\s");
                            continue;
                        }
                    }
                }
                // bundle
            }
            currenttime = Time.incrementTime(currenttime);
        }
        // Linked list contains the order of the available workers set not to change
    }
    public static SinglyLinkedList<WorkerAssignment> insertList(SinglyLinkedList<WorkerAssignment> normalList, WorkerAssignment newElement) {
        SinglyLinkedList<WorkerAssignment>  newlist = new SinglyLinkedList<WorkerAssignment>();
        while (normalList.first() != null) {
            if ((normalList.first().newestOrder().calculateOrderCompletion()) < (newElement.newestOrder().calculateOrderCompletion())) {
                newlist.addLast(normalList.first());
            }
            else {
                newlist.addLast(newElement);
                while (normalList.first() != null) {
                    newlist.addLast(normalList.first());
                }
            }
        }
        return newlist;
    }
    public static void printMaxFufillmentTime(int MaxFufillmentTime) {
        System.out.println("PrintMaxFulfillmentTime " + MaxFufillmentTime);
    }
}