public class Time {
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
    public static int calculateOrderCompletion(int currenttime, CustomerOrder order) {
        // base case
        int hours = currenttime/100;
        int minutes = currenttime%100;
        if ((order.getNumberofElectronics() != 0) && (order.getNumberofBooks() != 0)) {
            minutes = 15 + order.getNumberofElectronics() + order.getNumberofBooks();
        }
        if (minutes > 60) {
            hours = hours + minutes/60;
            minutes = minutes%60;
        }
        int time = (hours*100) + minutes;
        return time;
    }
}
