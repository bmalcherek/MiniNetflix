package Code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WatchableElement implements Comparable<WatchableElement> {

    private String title;
    private String description;
    private int length;
    private int rating;
    private ArrayList<String> productionCountries;
    private int price;
    private long views;
    private List<String> cast = new ArrayList<>();
    private String genre;
    private Date productionDate = new Date();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<String> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(ArrayList<String> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public synchronized void setViews(long views) {
        this.views = views;
    }

    public synchronized long getViews() {
        return views;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public int compareTo(WatchableElement o) {
        return (int)(this.views - o.views);
    }
}
