package Code;

import Code.Databases.MoviesDB;

import java.util.*;

public class Movie extends WatchableElement {

    private String trailersLinks;
    private MoviesDB moviesDB = new MoviesDB();
    private List<String> cast = new ArrayList<>();

    public Movie(){
        ArrayList<String> movieData = moviesDB.getMovieData();
        ArrayList<String> pc = moviesDB.getProductionCountries();

        super.setTitle(movieData.get(0));
        super.setDescription(movieData.get(1));
        this.trailersLinks = movieData.get(2);
        super.setRating(Integer.valueOf(movieData.get(3)));
        super.setLength(Integer.valueOf(movieData.get(4)));
        super.setPrice(Integer.valueOf(movieData.get(5)));
        super.setProductionCountries(pc);
        this.cast = moviesDB.getCast();
    }
}
