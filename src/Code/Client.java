package Code;

import Code.Databases.NamesDB;

import java.util.*;

public class Client extends Thread{

    private String name;
    private int id;
    private String email;
    private String creditCardNumber;
    private ArrayList<WatchableElement> boughtWatchableElements;
    private Subscription subscription;
    private List<Distributor> distributorList = new ArrayList<>();

    public Client(List<Distributor> distributorList) {
        NamesDB namesDB = new NamesDB();
        ArrayList<String> clientData = namesDB.getClientData();
        this.name = clientData.get(0);
        this.id = Integer.valueOf(clientData.get(1));
        this.email = clientData.get(2);
        this.creditCardNumber = clientData.get(3);
        this.subscription = new Subscription();
        this.distributorList = distributorList;
    }

    public void run(){
        while(true) {

        }
    }

    public void setDistributorList(List<Distributor> distributorList) {
        this.distributorList = distributorList;
    }
}
