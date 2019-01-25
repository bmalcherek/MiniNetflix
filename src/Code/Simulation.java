package Code;

import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Simulation {

    private List<Client> clientList = new ArrayList<>();
    private volatile List<Distributor> distributorList = new ArrayList<>();
    private long account;

    public void startSimulation(){
        TimeHandler timeHandler = new TimeHandler();
        timeHandler.setDaemon(true);
        timeHandler.start();
        while(true) {
            if(timeHandler.checkIfEndOfMonth()){
                System.out.println("Payment time");
            }

            for (Client client : this.clientList) {
                client.setDistributorList(this.distributorList);
            }
        }
    }

//    private void addClient() {
//        Client newClient = new Client(this.distributorList);
//        newClient.setDaemon(true);
//        newClient.start();
//        this.clientList.add(newClient);
//    }
//
//    public void addDistributor() {
//        Distributor newDistributor = new Distributor();
//        newDistributor.setDaemon(true);
//        newDistributor.start();
//        this.distributorList.add(newDistributor);
//
//        System.out.println("Distributor added");
//    }
}
