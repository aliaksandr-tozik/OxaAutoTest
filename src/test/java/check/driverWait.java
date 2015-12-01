package check;

public class DriverWait {
    public void wait(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {}
    }
}
