package Code;

import java.util.ArrayList;

public class TvShow extends WatchableElement {

    private int numberOfEpisodes;
    private int numberOfSeasons;

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

//    public TvShow(String title, String description, int length, float rating, ArrayList<String> productionCountries, float price, int numberOfEpisodes, int numberOfSeasons) {
//        super(title, description, length, rating, productionCountries);
//        this.price = price;
//        this.numberOfEpisodes = numberOfEpisodes;
//        this.numberOfSeasons = numberOfSeasons;
//    }
}
