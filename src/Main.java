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
        }
        SinglyLinkedList<CustomerOrder> orderList = new SinglyLinkedList<CustomerOrder>();
        while (input.hasNextLine()) {
            String[] currentLine = input.nextLine().split("\s");
            if (currentLine[0] == "CustomerOrder") {
                orderList.addLast(new CustomerOrder(Integer.parseInt(currentLine[1]), currentLine[2], Integer.parseInt(currentLine[3]), Integer.parseInt(currentLine[4])));
            }
        }
        SinglyLinkedList<String> availableWorkerList = new SinglyLinkedList<String>();
        availableWorkerList.addLast("Alice");
        availableWorkerList.addLast("Bob");
        availableWorkerList.addLast("Carol");
        availableWorkerList.addLast("David");
        availableWorkerList.addLast("Emily");
        // Linked list contains the order of the available workers set not to change
    }
    public String assignCustomerOrder() {
    }
}