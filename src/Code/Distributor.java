package Code;

import java.util.*;

public class Distributor extends Thread{
    private List<WatchableElement> productList = new ArrayList<WatchableElement>();
    private double newMovieChance = 0.7;

    public void addMovie() {
        WatchableElement movie = new Movie();
        this.productList.add(movie);
    }

    public void addTVSeries() {
        WatchableElement tvSeries = new TVSeries();
        this.productList.add(tvSeries);
    }

    public void run(){
        while (true) {
            double rand = Math.random();
            if (rand <= this.newMovieChance) {
                this.addTVSeries();
            }
        }
    }
}
