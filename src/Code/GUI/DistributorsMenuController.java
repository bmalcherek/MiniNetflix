package Code.GUI;

import Code.*;
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
import java.util.Collections;
import java.util.ResourceBundle;

public class DistributorsMenuController implements Initializable {
    @FXML
    ListView<String> distributorsListView;
    @FXML
    Label productsCount;
    @FXML
    Label moviesCount;
    @FXML
    Label tvSeriesCount;
    @FXML
    Label value;
    @FXML
    Label deal;
    @FXML
    Label mostWatchedElement;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Distributor distributor : ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList()) {
            distributorsListView.getItems().add(distributor.getDistributorName());
        }
        productsCount.setText("Please choose distributor");
        moviesCount.setText("");
        tvSeriesCount.setText("");
        value.setText("");
        deal.setText("");
        mostWatchedElement.setText("");
    }

    public void showDistributorData() {
        int mCount = 0, tCount = 0, valueOfAllProducts = 0;

        String distributorName = distributorsListView.getSelectionModel().getSelectedItem();
        Distributor distributor = ClientsAndDistributorsListsSingleton.getInstance().getDistributorByName(distributorName);
        productsCount.setText("Total products: " + distributor.getProductList().size());

        for (WatchableElement element : distributor.getProductList()) {
            if (element instanceof Movie) {
                mCount++;
            } else if (element instanceof TVSeries) {
                tCount++;
            }
            valueOfAllProducts += element.getPrice();
        }

        if(!distributor.getProductList().isEmpty()) {
            WatchableElement mostWatched = Collections.max(distributor.getProductList());
            mostWatchedElement.setText("Most watched product is " + mostWatched.getTitle() + " with " + mostWatched.getViews() + " views");
        } else {
            mostWatchedElement.setText("");
        }

        moviesCount.setText("Total Movies: " + mCount);
        tvSeriesCount.setText("Total TV Series: " + tCount);
        value.setText("Value of all products: " + valueOfAllProducts);
        deal.setText("Current deal is " + distributor.getDeal() + "% of value of all products monthly");
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
