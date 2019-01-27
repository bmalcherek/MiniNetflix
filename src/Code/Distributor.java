package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Distributor extends Thread{
    private String distributorName;
    private List<WatchableElement> productList = new ArrayList<>();
    private HashMap<String, WatchableElement> productHashMap = new HashMap<>();
    private double deal;

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
        setDaemon(true);
    }

    public void addMovie() {
        WatchableElement movie = new Movie();
        this.productList.add(movie);
        this.productHashMap.put(movie.getTitle(), movie);
    }

    public void addTVSeries() {
        WatchableElement tvSeries = new TVSeries();
        this.productList.add(tvSeries);
        this.productHashMap.put(tvSeries.getTitle(), tvSeries);
    }

    public String getDistributorName() {
        return distributorName;
    }

    public List<WatchableElement> getProductList() {
        return productList;
    }

    public void run(){
        while (ProgramKiller.getInstance().getRunning()) {
            while (true) {
                double newDealChance = 0.05;
                double newWatchableElementChance = 0.2;
                double newMovieChance = 0.7;
                double newTVSeriesChance = 0.5;
                Random randomGenerator = new Random();

                //New deal
                double rand0 = Math.random();
                if (rand0 <= newDealChance) {
                    this.deal = randomGenerator.nextInt(10) + 1;
                }

                //New products
                double rand = Math.random();
                if (rand <= newWatchableElementChance) {
                    double rand2 = Math.random();
                    if (rand2 <= newMovieChance) {
                        this.addMovie();
                    } else {
                        double rand3 = Math.random();
                        if (rand3 <= newTVSeriesChance) {
                            this.addTVSeries();
                        } else {
                            //TODO add Live Stream here
                        }
                    }
                }

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

    public WatchableElement getWatchableElementByName(String name) {
        return productHashMap.get(name);
    }

    public HashMap<String, WatchableElement> getProductHashMap() {
        return productHashMap;
    }
}
