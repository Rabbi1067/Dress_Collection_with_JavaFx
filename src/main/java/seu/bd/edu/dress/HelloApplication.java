package seu.bd.edu.dress;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dress.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 600);
        stage.setTitle("Rabbi Store!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void changeScene(String fxml){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 1080, 600);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}