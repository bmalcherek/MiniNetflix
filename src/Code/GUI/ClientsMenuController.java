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
import javafx.scene.control.ListView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientsMenuController implements Initializable {

    @FXML
    ListView<String> clientsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Client client : ClientsAndDistributorsListsSingleton.getInstance().getClientsList()) {
            clientsListView.getItems().add(client.getClientName());
        }
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
