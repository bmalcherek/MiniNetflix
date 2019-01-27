package Code;

import java.nio.charset.Charset;
import java.util.*;

public class Distributor extends Thread{
    private String distributorName;
    private List<WatchableElement> productList = new ArrayList<>();
    private double deal;
    private double newWatchableElementChance = 0.4;
    private double newMovieChance = 0.7;
    private double newTVSeriesChance = 0.5;

    public Distributor() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 15;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        this.distributorName = buffer.toString();   //https://www.baeldung.com/java-random-string
        this.deal = random.nextInt(10) + 1;
    }

    public void addMovie() {
        WatchableElement movie = new Movie();
        this.productList.add(movie);
    }

    public void addTVSeries() {
        WatchableElement tvSeries = new TVSeries();
        this.productList.add(tvSeries);
    }

    public String getDistributorName() {
        return distributorName;
    }

    public List<WatchableElement> getProductList() {
        return productList;
    }

    public void run(){
        while (true) {
            double rand = Math.random();
            if (rand <= newWatchableElementChance) {
                double rand2 = Math.random();
                if (rand2 <= newMovieChance) {
                    this.addMovie();
                } else {
                    double rand3 = Math.random();
                    if(rand3 <= newTVSeriesChance) {
                        this.addTVSeries();
                    } else {
                        //TODO add Live Stream here
                    }
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkout() {
        long valueOfProdcuts = 0;
        for (WatchableElement element : this.productList) {
            valueOfProdcuts += element.getPrice();
        }

        long checkout = (long) (-1 * (valueOfProdcuts * this.deal) / 100);
        Account.getInstance().accountOperations(checkout);
    }

    public double getDeal() {
        return deal;
    }
}
