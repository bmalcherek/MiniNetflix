package Code;

public class TimeHandler extends Thread {
    private long startTime;
    private long timePassed;
    private long currentTime;
    private int multiplier = 10;
    private boolean started = false;

    public void run() {
        try {
            while (true) {
                if (!started) {
                    this.started = true;
                    this.startTime = System.currentTimeMillis() / 1000L;   //https://stackoverflow.com/questions/732034/getting-unixtime-in-java
                }
                sleep(1000);
                this.timePassed = ((System.currentTimeMillis() / 1000L) - this.startTime) * this.multiplier;
                this.currentTime = System.currentTimeMillis() / 1000L;
                java.util.Date time = new java.util.Date((long) currentTime * 1000);
                System.out.println("Time = " + time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
