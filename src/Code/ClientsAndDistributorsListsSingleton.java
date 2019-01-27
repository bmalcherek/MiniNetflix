package Code;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientsAndDistributorsListsSingleton {
    private static ClientsAndDistributorsListsSingleton instance;
    private ArrayList<Distributor> distributorsList = null;
    private ArrayList<Client> clientsList = null;
    private HashMap<String, Distributor> distributorsHashMap = null;
    private HashMap<String, Client> clientsHashMap = null;

    public static ClientsAndDistributorsListsSingleton getInstance() {
        if(instance == null){
            instance = new ClientsAndDistributorsListsSingleton();
        }

        return instance;
    }

    private ClientsAndDistributorsListsSingleton() {
        distributorsList = new ArrayList<>();
        clientsList = new ArrayList<>();
        distributorsHashMap = new HashMap<>();
        clientsHashMap = new HashMap<>();
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public ArrayList<Distributor> getDistributorsList() {
        return this.distributorsList;
    }

    public void addDistributor(Distributor distributor) {
        distributorsList.add(distributor);
        distributorsHashMap.put(distributor.getDistributorName(), distributor);
        distributor.start();
//        distributor.setDaemon(true);
    }

    public void addClient(Client client) {
        clientsList.add(client);
        clientsHashMap.put(client.getClientName(), client);
        client.start();
//        client.setDaemon(true);
    }

    public Distributor getDistributorByName(String name) {
        return distributorsHashMap.get(name);
    }

}

