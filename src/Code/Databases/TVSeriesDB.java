package Code.Databases;

import java.io.*;
import java.net.*;
import java.util.*;

public class TVSeriesDB {
    private List<String> titleFirstParts = new ArrayList<>();
    private List<String> titleLastParts = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();
    private List<String> productionCountries = new ArrayList<>();
    private List<String> actors = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private Random randomGenerator = new Random();

    private void load() {
        URL url = getClass().getResource("titleFirstPartsTVSeries.txt");
        File file = new File(url.getPath());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.titleFirstParts.add(sc.nextLine());
        }

        url = getClass().getResource("titleLastPartsTVSeries.txt");
        file = new File(url.getPath());

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.titleLastParts.add(sc.nextLine());
        }


        url = getClass().getResource("movieDescriptions.txt");
        file = new File(url.getPath());

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.descriptions.add(sc.nextLine());
        }

        url = getClass().getResource("productionCountries.txt");
        file = new File(url.getPath());

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.productionCountries.add(sc.nextLine());
        }

        url = getClass().getResource("actors.txt");
        file = new File(url.getPath());

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.actors.add(sc.nextLine());
        }

        url = getClass().getResource("genres.txt");
        file = new File(url.getPath());

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.genres.add(sc.nextLine());
        }
    }

    public TVSeriesDB() {
        this.load();
    }

    public ArrayList<String> getTVSeriesData() {
        ArrayList<String> TVSeriesData = new ArrayList<>();
        int titleFirstPartIndex = this.randomGenerator.nextInt(this.titleFirstParts.size());
        int titleLastPartIndex = this.randomGenerator.nextInt(this.titleLastParts.size());
        int descriptionIndex = this.randomGenerator.nextInt(this.descriptions.size());
        int genresIndex = this.randomGenerator.nextInt(this.genres.size());

        TVSeriesData.add(this.titleFirstParts.get(titleFirstPartIndex) + " " + this.titleLastParts.get(titleLastPartIndex));
        TVSeriesData.add(this.descriptions.get(descriptionIndex));
        TVSeriesData.add(Integer.toString(this.randomGenerator.nextInt(100) + 1));
        TVSeriesData.add(Integer.toString(this.randomGenerator.nextInt(40) + 10));
        TVSeriesData.add(this.genres.get(genresIndex));

        return TVSeriesData;
    }

    public ArrayList<String> getProductionCountries() {
        ArrayList<String> pc = new ArrayList<String>();

        int howManyCountries = this.randomGenerator.nextInt(3) + 1;
        for (int i = 0; i < howManyCountries; i++) {
            int countryIndex = this.randomGenerator.nextInt(this.productionCountries.size());
            if(!pc.contains(this.productionCountries.get(countryIndex))){
                pc.add(this.productionCountries.get(countryIndex));
            }
        }

        return pc;
    }

    public ArrayList<String> getCast() {
        ArrayList<String> cast = new ArrayList<String>();

        int howBigCast = this.randomGenerator.nextInt(4) + 1;
        for (int i = 0; i < howBigCast; i++) {
            int actorIndex = this.randomGenerator.nextInt(this.actors.size());
            if (!cast.contains(this.actors.get(actorIndex))) {
                cast.add(this.actors.get(actorIndex));
            }
        }

        return cast;
    }
}
