package Code.GUI;

import Code.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MainMenuController implements Initializable {
    @FXML
    Label clientsCountLabel;
    @FXML
    Label distributorsCountLabel;
    @FXML
    Label moviesCountLabel;
    @FXML
    Label tvSeriesCountLabel;
    @FXML
    Label liveStreamsCountLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        distributorsCountLabel.setText("Distributors count: " +
                Integer.toString(ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().size()));
        clientsCountLabel.setText("Clients count: " +
                Integer.toString(ClientsAndDistributorsListsSingleton.getInstance().getClientsList().size()));

    }

    public void startSimulation(){
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }

    public void addDistributor() {
        Distributor newDistributor = new Distributor();
        ClientsAndDistributorsListsSingleton.getInstance().addDistributor(newDistributor);
        distributorsCountLabel.setText("Distributors count: " +
                Integer.toString(ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().size()));
        System.out.println("Distributor Added!");
    }

    public void addClient() {
        Client newClient = new Client();
        ClientsAndDistributorsListsSingleton.getInstance().addClient(newClient);
        clientsCountLabel.setText("Clients count: " +
                Integer.toString(ClientsAndDistributorsListsSingleton.getInstance().getClientsList().size()));
        System.out.println("Client Added!");
    }

    public void addMovie() {
        ArrayList<Distributor> distributorList = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList();
        Random randomGenerator = new Random();

        int distributorIndex = randomGenerator.nextInt(distributorList.size());
        distributorList.get(distributorIndex).addMovie();
    }

    public void addTVSeries() {
        ArrayList<Distributor> distributorList = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList();
        Random randomGenerator = new Random();

        int distributorIndex = randomGenerator.nextInt(distributorList.size());
        distributorList.get(distributorIndex).addTVSeries();
    }

    public void switchToMainMenu(ActionEvent event) throws IOException {
        Parent mainMenuView = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenuViewScene = new Scene(mainMenuView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainMenuViewScene);
        window.show();
    }

    public void switchToDistributorsPanel(ActionEvent event) throws IOException {
        Parent distributorsView = FXMLLoader.load(getClass().getResource("DistributorsMenu.fxml"));
        Scene distributorsViewScene = new Scene(distributorsView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(distributorsViewScene);
        window.show();
    }

    public void switchToClientsMenu(ActionEvent event) throws IOException {
        Parent clientsMenuView = FXMLLoader.load(getClass().getResource("ClientsMenu.fxml"));
        Scene clientsMenuViewScene = new Scene(clientsMenuView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(clientsMenuViewScene);
        window.show();
    }

    public void switchTProductsMenu(ActionEvent event) throws IOException {
        Parent productsMenuView = FXMLLoader.load(getClass().getResource("ProductsMenu.fxml"));
        Scene productsMenuViewScene = new Scene(productsMenuView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(productsMenuViewScene);
        window.show();
    }

}
