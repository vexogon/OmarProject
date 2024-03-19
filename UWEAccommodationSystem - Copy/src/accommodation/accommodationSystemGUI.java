/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
// import javafx.application.Application.launch;

public class accommodationSystemGUI extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccommodationSystem.fxml"));

        primaryStage.setTitle("AccommodationSystem");
        Scene accommodationSystemScene = new Scene(loader.load());

        primaryStage.setScene(accommodationSystemScene);
        primaryStage.show();

        //Table



        primaryStage.show();
    }


        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLButtonGUI.fxml"));
        
        //Scene scene = new Scene(button, 200, 100);
        primaryStage.setTitle("Button Example");
        Scene glampingSystemScene = new Scene(loader.load());
        
        // FXMLGlampingSystemController controller = loader.getController();
        // controller.setUWEAccommodationSystemGUI(uweAccommodationSystemGUI);
        primaryStage.setScene(glampingSystemScene);
        primaryStage.show(); 
        */
        


    public static void main(String[] args) {
        Application.launch(accommodationSystemGUI.class, args);
    }
}