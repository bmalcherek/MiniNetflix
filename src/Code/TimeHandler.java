package Code;

import java.util.Calendar;
import java.util.Date;

public class TimeHandler extends Thread {
    private Date startDate;
    private Date currentDate;
    private long timePassed;
    private int multiplier = 3600 * 24;
    private boolean started = false;
    private Date nextPaymentDate;

    public void run() {
        try {
            while (ProgramKiller.getInstance().getRunning()) {
                while (true) {
                    if (!started) {
                        this.started = true;
                        this.startDate = new Date(System.currentTimeMillis());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(this.startDate);
                        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                        this.nextPaymentDate = calendar.getTime();
                    }
                    sleep(1000);
                    this.timePassed = (System.currentTimeMillis() - this.startDate.getTime()) * this.multiplier;
                    this.currentDate = new Date(this.startDate.getTime() + this.timePassed);
                    System.out.println("Date: " + this.currentDate);
                }
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean checkIfEndOfMonth() {
        try {
            if (this.currentDate.after(this.nextPaymentDate)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(this.currentDate);
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                this.nextPaymentDate = calendar.getTime();

                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            System.out.println("Not ready");
        }
        return false;
    }

}
