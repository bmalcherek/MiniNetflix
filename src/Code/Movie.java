package Code;

import Code.Databases.MoviesDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Movie extends WatchableElement {

    private String trailersLinks;
//    private List<String> cast = new ArrayList<>();
    private int availableTime;
//    private String genre;
    private int promotion;
//    private Date productionDate = new Date();

    public Movie(){
        MoviesDB moviesDB = MoviesDB.getInstance();
        ArrayList<String> movieData = moviesDB.getMovieData();
        ArrayList<String> pc = moviesDB.getProductionCountries();

        String d1 = "01/01/1975";
        String d2 = "31/12/2018";
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = sdf.parse(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date2 = sdf.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        super.setTitle(movieData.get(0));
        super.setDescription(movieData.get(1));
        this.trailersLinks = movieData.get(2);
        super.setRating(Integer.valueOf(movieData.get(3)));
        super.setLength(Integer.valueOf(movieData.get(4)));
        super.setPrice(Integer.valueOf(movieData.get(5)));
        this.availableTime = Integer.valueOf(movieData.get(6));
//        this.genre = movieData.get(7);
        super.setGenre(movieData.get(7));
        super.setProductionCountries(pc);
//        this.cast = moviesDB.getCast();
        super.setCast(moviesDB.getCast());
        this.promotion = 0;
        Date productionDate = new Date();
        productionDate.setTime(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));
        super.setProductionDate(productionDate);

        moviesDB = null;
    }

    public String getTrailersLinks() {
        return trailersLinks;
    }
}
