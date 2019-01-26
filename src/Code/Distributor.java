package Code;

import java.nio.charset.Charset;
import java.util.*;

public class Distributor extends Thread{
    private String distributorName;
    private List<WatchableElement> productList = new ArrayList<>();
    private double newWatchableElementChance = 0.5;
    private double newMovieChance = 0.7;
    private double newTVSeriesChance = 0.5;

    public Distributor() {
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        this.distributorName = new String(array, Charset.forName("UTF-8"));
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
                    this.addTVSeries();
                } else {
                    double rand3 = Math.random();
                    if(rand3 <= newTVSeriesChance) {
                        this.addMovie();
                    } else {
                        //TODO add Live Stream here
                    }
                }
            }
        }
    }
}
