public class WorkerAssignment {
    String worker;
    SinglyLinkedList<CustomerOrder> assignedOrder;
    WorkerAssignment(String worker, CustomerOrder firstOrder) {
        worker = this.worker;
        assignedOrder = new SinglyLinkedList<CustomerOrder>();
        assignedOrder.addLast(firstOrder);
    }
    public CustomerOrder newestOrder() {
        return this.assignedOrder.last();
    }
}
