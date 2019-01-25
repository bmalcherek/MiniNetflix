package Code;

import Code.Databases.MoviesDB;
import Code.Databases.NamesDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        Simulation simulation = new Simulation();
        simulation.startSimulation();
//        NamesDB namesDB = new NamesDB();
//        namesDB.load();
//        MoviesDB db = new MoviesDB();
    }
}
