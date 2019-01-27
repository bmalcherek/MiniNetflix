package Code;

import Code.Databases.TVSeriesDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TVSeries extends WatchableElement {

    private ArrayList<ArrayList<Episode>> seasonsAndEpisodes = new ArrayList<>();
//    private List<String> cast = new ArrayList<>();
//    private String genre;
//    private Date productionDate = new Date();
    private int numberOfSeasons;
    private int numberOfEpisodes;
    private int lengthOfEpisode;

    public TVSeries() {
        TVSeriesDB tvSeriesDB = new TVSeriesDB();
        ArrayList<String> tvSeriesData = tvSeriesDB.getTVSeriesData();
        Random randomGenerator = new Random();

        super.setTitle(tvSeriesData.get(0));
        super.setDescription(tvSeriesData.get(1));
        super.setRating(Integer.valueOf(tvSeriesData.get(2)));
        super.setPrice(Integer.valueOf(tvSeriesData.get(3)));
//        this.genre = tvSeriesData.get(4);
//        this.cast = tvSeriesDB.getCast();
        super.setGenre(tvSeriesData.get(4));
        super.setCast(tvSeriesDB.getCast());
        super.setProductionCountries(tvSeriesDB.getProductionCountries());

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

        Date productionDate = new Date();
        productionDate.setTime(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));
        super.setProductionDate(productionDate);

        this.numberOfSeasons = randomGenerator.nextInt(10);
        this.numberOfEpisodes = randomGenerator.nextInt(10) + 8;
        lengthOfEpisode = randomGenerator.nextInt(40) + 20;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(productionDate);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date tempDate = calendar.getTime();

        for (int i = 0; i < this.numberOfSeasons; i++) {
            ArrayList<Episode> temp = new ArrayList<>();
            for (int j = 0; j < this.numberOfEpisodes; j++) {
                Episode newEpisode = new Episode(tempDate, lengthOfEpisode);
                tempDate = newEpisode.getProductionDate();
                temp.add(newEpisode);
            }
            this.seasonsAndEpisodes.add(temp);
        }

        super.setLength(lengthOfEpisode * this.numberOfEpisodes * this.numberOfSeasons);
    }

//    public List<String> getCast() {
//        return cast;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public Date getProductionDate() {
//        return productionDate;
//    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public int getLengthOfEpisode() {
        return lengthOfEpisode;
    }
}
