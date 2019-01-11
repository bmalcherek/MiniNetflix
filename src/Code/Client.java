package Code;

import Code.Databases.NamesDB;

import java.util.ArrayList;

public class Client{

    private String name;
    private int id;
    private String email;
    private String creditCardNumber;
    private ArrayList<WatchableElement> boughtWatchableElements;

    public Client() {
        NamesDB namesDB = new NamesDB();
        ArrayList<String> clientData = namesDB.getClientData();
        this.name = clientData.get(0);
        this.id = Integer.valueOf(clientData.get(1));
        this.email = clientData.get(2);
        this.creditCardNumber = clientData.get(3);
    }
}
