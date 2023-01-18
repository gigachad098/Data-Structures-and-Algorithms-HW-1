public class CustomerOrder {
    int orderTime;
    String customer;
    int numberofBooks;
    int numberofElectronics;
    CustomerOrder(int orderTime, String customer, int numberofBooks, int numberofElectronics) {
        this.orderTime = orderTime;
        this.customer = customer;
        this.numberofBooks = numberofBooks;
        this.numberofElectronics = numberofElectronics;
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
}
