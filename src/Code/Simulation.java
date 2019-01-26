package Code;

import java.util.*;

import static java.lang.Thread.sleep;

public class Simulation{

    private long account;

    public void startSimulation() {
        TimeHandler timeHandler = new TimeHandler();
        timeHandler.setDaemon(true);
        timeHandler.start();
        Runnable task = () -> {
            while (true) {
                if (timeHandler.checkIfEndOfMonth()) {
                    System.out.println("Payment time");
                }
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        new Thread(task).start();
    }
}
