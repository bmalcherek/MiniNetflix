package Code.GUI;

import Code.Client;
import Code.ClientsAndDistributorsListsSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientsMenuController implements Initializable {

    @FXML
    ListView<String> clientsListView;
    @FXML
    Label name;
    @FXML
    Label subscriptionName;
    @FXML
    Label maxResolution;
    @FXML
    Label maxDevices;
    @FXML
    Label price;
    @FXML
    Label boughtElements;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Client client : ClientsAndDistributorsListsSingleton.getInstance().getClientsList()) {
            clientsListView.getItems().add(client.getClientName());
        }

        name.setText("Please select client");
        subscriptionName.setText("");
        maxResolution.setText("");
        maxDevices.setText("");
        price.setText("");
        boughtElements.setText("");
    }

    public void showClientData() {
        String clientName = clientsListView.getSelectionModel().getSelectedItem();
        Client client = ClientsAndDistributorsListsSingleton.getInstance().getClientByName(clientName);

        name.setText(clientName);
        subscriptionName.setText(client.getSubscription().getName());
        maxResolution.setText("Max resolution: " + client.getSubscription().getMaxResolution());
        maxDevices.setText("Max devices: " + client.getSubscription().getHowManyDevices());
        price.setText("Price: " + client.getSubscription().getPrice());
        if(!(client.getSubscription().getPrice() == 0)) {
            boughtElements.setText("Client can watch all products");
        } else {
            boughtElements.setText("Client bought " + client.getBoughtWatchableElements().size() + " products");
        }
    }

    public void deleteClient(ActionEvent event) throws IOException {
        String clientName = clientsListView.getSelectionModel().getSelectedItem();
        Client client = ClientsAndDistributorsListsSingleton.getInstance().getClientByName(clientName);
        ClientsAndDistributorsListsSingleton.getInstance().getClientsList().remove(client);
        ClientsAndDistributorsListsSingleton.getInstance().getClientsHashMap().remove(client.getClientName());
        client = null;
        switchToClientsMenu(event);
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
