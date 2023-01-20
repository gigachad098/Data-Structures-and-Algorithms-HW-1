public class WorkerAssignment {
    String worker;
    SinglyLinkedList<CustomerOrder> assignedOrder;
    WorkerAssignment(String worker, CustomerOrder firstOrder) {
        worker = this.worker;
        assignedOrder.addLast(firstOrder);
    }

    public int calculateOrderCompletion (CustomerOrder assignedOrder) {
        if ((assignedOrder.getNumberofBooks() != 0) && (assignedOrder.getNumberofElectronics() != 0)) {
            return assignedOrder.getOrderTime() + assignedOrder.getNumberofBooks() + assignedOrder.getNumberofElectronics() + 5;
        }
        return 0;
    }
    public CustomerOrder lastOrder() {
        return this.assignedOrder.last();
    }
    public static String printAvailableWorkerList(SinglyLinkedList<WorkerAssignment> workerList) {
        return "AvailableWorkerList " + workerList;
    }
}
