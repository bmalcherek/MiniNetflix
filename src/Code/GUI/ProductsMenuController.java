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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ProductsMenuController implements Initializable {

    @FXML
    ListView<String> productsListView;
    @FXML
    Label name;
    @FXML
    Label type;
    @FXML
    Label description;
    @FXML
    Label owner;
    @FXML
    Label label0;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Label label4;
    @FXML
    Label label5;
    @FXML
    Label genre;
    @FXML
    Label productionDate;
    @FXML
    Label rating;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Distributor distributor : ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList()){
            for (WatchableElement element : distributor.getProductList()){
                productsListView.getItems().add(element.getTitle());
            }
        }
        name.setText("Please choose product");
        type.setText("");
        description.setText("");
        owner.setText("");
        productionDate.setText("");
        genre.setText("");
        rating.setText("");
        label0.setText("");
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
    }

    public void showProductData() {
        String title = productsListView.getSelectionModel().getSelectedItem();
        WatchableElement element = null;
        Distributor distributor = null;
        for (Distributor dist : ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList()) {
            if (dist.getProductHashMap().containsKey(title)) {
                distributor = dist;
                element = dist.getWatchableElementByName(title);
            }
        }

        String pc = "";
        String cast = "";
        for (int i = 0; i < element.getProductionCountries().size(); i++) {
            pc += (element.getProductionCountries().get(i) + " ");
        }
        for (int i = 0; i < element.getCast().size(); i++) {
            cast += (element.getCast().get(i) + " ");
        }

        name.setText(element.getTitle());
        description.setText(element.getDescription());
        owner.setText("Distributor: " + distributor.getDistributorName());
        genre.setText(element.getGenre());
        rating.setText("Rating: " + element.getRating());

        Date date = element.getProductionDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        productionDate.setText("Production date: " + dateFormat.format(date));

        if(element instanceof Movie) {
            Movie movie = (Movie)element;
            type.setText("Movie");
            label0.setText("Length: " + element.getLength());
            label1.setText("Price: " + element.getPrice());
            label2.setText("Views: " + element.getViews());
            label3.setText("Produced in " + pc);
            label4.setText("Cast: " + cast);
            label5.setText("Trailer link: " + movie.getTrailersLinks());

        } else {
            TVSeries tvSeries = (TVSeries)element;
            type.setText("TV Series");
            label0.setText("Number of seasons: " + tvSeries.getNumberOfSeasons() + ", number of episodes: " + tvSeries.getNumberOfEpisodes());
            label1.setText("Length of episode: " + tvSeries.getLengthOfEpisode());
            label2.setText("Price: " + tvSeries.getPrice());
            label3.setText("Views: " + tvSeries.getViews());
            label4.setText("Produced in " + pc);
            label5.setText("Cast: " + cast);
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
