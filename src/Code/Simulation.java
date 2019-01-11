package Code;

import java.util.*;

public class Simulation {

    private List<Client> clientList = new ArrayList<Client>();
    private List<Distributor> distributorList = new ArrayList<Distributor>();
    private double newClientChance = 0.7;

    public void startSimulation(){
        TimeHandler timeHandler = new TimeHandler();
        timeHandler.setDaemon(true);
        timeHandler.start();
        double rand;
        this.addDistributor();
        while (true) {
            rand = Math.random();
            if (rand < this.newClientChance) {
                this.addClient();
            }

            for (Distributor distributor : this.distributorList) {
                distributor.addMovie();
            }
        }
    }

    private void addClient() {
        Client newClient = new Client();
        this.clientList.add(newClient);
    }

    private void addDistributor() {
        Distributor newDistributor = new Distributor();
        this.distributorList.add(newDistributor);
    }

}
