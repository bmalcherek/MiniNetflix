package Code;

import java.util.Random;

public class Subscription {
    private String name;
    private String maxResolution;
    private int price;
    private int howManyDevices;

    public Subscription() {
        Random randomGenerator = new Random();
        String[] names = {"Free", "Basic", "Family", "Premium"};
        String[] maxResolutions = {"1080p", "720p", "1080p", "4K"};
        int[] prices = {0, 30, 50, 70};
        int[] devices = {1, 2, 4, 8};

        int subscription = randomGenerator.nextInt(4);

        this.name = names[subscription];
        this.maxResolution = maxResolutions[subscription];
        this.price = prices[subscription];
        this.howManyDevices = devices[subscription];
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public int getHowManyDevices() {
        return howManyDevices;
    }
}

