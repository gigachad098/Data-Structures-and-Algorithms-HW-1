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
        int currenttime;
        boolean firstLoop = true;
        while (input.hasNextLine()   {
            if (firstLoop) {

            }

        }
        // Linked list contains the order of the available workers set not to change
    }
    public int incrementTime(int currenttime) {
        int hours = currenttime/100;
        int minutes = currenttime%100;
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        return (hours*100)+minutes;
    }
}