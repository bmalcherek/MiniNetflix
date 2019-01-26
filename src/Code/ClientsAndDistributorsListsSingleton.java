package Code;

import java.util.ArrayList;

public class ClientsAndDistributorsListsSingleton {
    private static ClientsAndDistributorsListsSingleton instance;
    private ArrayList<Distributor> distributorsList = null;
    private ArrayList<Client> clientsList = null;

    public static ClientsAndDistributorsListsSingleton getInstance() {
        if(instance == null){
            instance = new ClientsAndDistributorsListsSingleton();
        }

        return instance;
    }

    private ClientsAndDistributorsListsSingleton() {
        distributorsList = new ArrayList<>();
        clientsList = new ArrayList<>();
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public ArrayList<Distributor> getDistributorsList() {
        return this.distributorsList;
    }

    public void addDistributor(Distributor distributor) {
        distributorsList.add(distributor);
        distributor.start();
//        distributor.setDaemon(true);
    }

    public void addClient(Client client) {
        clientsList.add(client);
        client.start();
//        client.setDaemon(true);
    }

}

