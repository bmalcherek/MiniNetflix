package Code.Databases;

import java.io.*;
import java.net.URL;
import java.util.*;

public class NamesDB {
    private List<String> firstNames = new ArrayList<String>();
    private List<String> lastNames = new ArrayList<String>();
    private Random randomGenerator = new Random();
    private int clientID = 0;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void load(){
        URL url = getClass().getResource("firstNames.txt");
        File file = new File(url.getPath());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.firstNames.add(sc.nextLine());
        }

        url = getClass().getResource("lastNames.txt");
        file = new File(url.getPath());
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            this.lastNames.add(sc.nextLine());
        }
    }

    public ArrayList<String> getClientData(){
        ArrayList<String> clientData = new ArrayList<String>();
        int firstNameIndex = this.randomGenerator.nextInt(this.firstNames.size());
        int lastNameIndex = this.randomGenerator.nextInt(this.lastNames.size());

        String firstName = this.firstNames.get(firstNameIndex);
        String lastName = this.lastNames.get(lastNameIndex);
        this.clientID++;

        clientData.add(firstName + " " + lastName);
        clientData.add(Integer.toString(this.clientID));
        clientData.add(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@outlook.com");
        clientData.add(Integer.toString(randomGenerator.nextInt(99999999)) +
                Integer.toString(randomGenerator.nextInt(99999999)));

        return clientData;
    }

    public NamesDB() {
        this.load();
    }
}
