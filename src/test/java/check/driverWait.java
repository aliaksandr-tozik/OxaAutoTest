package check;

public class driverWait {
    public void wait(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {}
    }
}
