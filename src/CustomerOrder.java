import java.util.Comparator;

public class CustomerOrder {
    int orderTime;
    String customer;
    int numberofBooks;
    int numberofElectronics;
    boolean bundleAble;
    String worker;
    CustomerOrder(int orderTime, String customer, int numberofBooks, int numberofElectronics) {
        this.orderTime = orderTime;
        this.customer = customer;
        this.numberofBooks = numberofBooks;
        this.numberofElectronics = numberofElectronics;
        bundleAble = canBundle();
    }
    public int getOrderTime() {
        return this.orderTime;
    }
    public String getCustomer() {
        return this.customer;
    }
    public int getNumberofBooks() {
        return this.numberofBooks;
    }
    public int getNumberofElectronics() {
        return this.numberofElectronics;
    }
    public boolean canBundle() {
        if ((numberofElectronics == 0 && numberofBooks <= 10) || (numberofBooks == 10 && numberofElectronics <= 10)) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setWorker(String worker) {
        this.worker = worker;
    }
    public int calculateOrderCompletion () {
        if ((this.getNumberofBooks() != 0) && (this.getNumberofElectronics() != 0)) {
            return this.getOrderTime() + this.getNumberofBooks() + this.getNumberofElectronics() + 5;
        }
        return 0;
    }
    public static void printCompletedOrder(CustomerOrder ordertoComplete, int currentTime) {
        System.out.println("OrderCompletion " + currentTime + " " + ordertoComplete.getCustomer());
    }
}
