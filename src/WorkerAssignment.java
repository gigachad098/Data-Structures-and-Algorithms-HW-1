public class WorkerAssignment {
    String worker;
    CustomerOrder assignedOrder;
    int time;
    public int calculateOrderCompletion (int time, CustomerOrder assignedOrder){
        if ((assignedOrder.getNumberofBooks() != 0) && (assignedOrder.getNumberofElectronics() != 0)) {
            return time + assignedOrder.getNumberofBooks() + assignedOrder.getNumberofElectronics() + 5;
        }
        return 0;
    }
    public static String printAvailableWorkerList(SinglyLinkedList<WorkerAssignment> workerList) {
        return "AvailableWorkerList " + workerList;
    }
}
