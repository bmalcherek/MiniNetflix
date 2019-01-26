package Code;

import Code.Databases.NamesDB;

import java.util.*;

public class Client extends Thread{


    private String clientName;
    private int id;
    private String email;
    private String creditCardNumber;
    private ArrayList<WatchableElement> boughtWatchableElements;
    private Subscription subscription;

    public Client() {
        NamesDB namesDB = new NamesDB();
        ArrayList<String> clientData = namesDB.getClientData();
        this.clientName = clientData.get(0);
        this.id = Integer.valueOf(clientData.get(1));
        this.email = clientData.get(2);
        this.creditCardNumber = clientData.get(3);
        this.subscription = new Subscription();
    }

    public void run(){
        while(true) {

        }

    }
    public String getClientName() {
        return clientName;
    }
}
