package Code;

import java.util.*;

public class Distributor {
    private List<WatchableElement> productList = new ArrayList<WatchableElement>();

    public void addMovie() {
        WatchableElement movie = new Movie();
        this.productList.add(movie);
    }
}
