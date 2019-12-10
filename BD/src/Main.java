import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String sceneFile = "sample/scene1.fxml";
        Parent root = null;
        URL    url  = null;
        try
        {
            url  = getClass().getClassLoader().getResource( sceneFile );
            root = FXMLLoader.load( url );
            System.out.println( "  fxmlResource = " + sceneFile );
        }
        catch ( Exception ex )
        {
            System.out.println( "Exception on FXMLLoader.load()" );
            System.out.println( "  * url: " + url );
            System.out.println( "  * " + ex );
            System.out.println( "    ----------------------------------------\n" );
            throw ex;
        }

        primaryStage.setTitle("StockControl");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();





    }


    public static void main(String[] args) {
        launch(args);
    }
}
