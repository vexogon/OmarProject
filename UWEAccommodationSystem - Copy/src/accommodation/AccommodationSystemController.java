/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accommodation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author janakamal
 */
public class AccommodationSystemController implements Initializable {

    @FXML
    private TextField txtHallnumber;
    @FXML
    private TextField txtHallmanager;

    @FXML
    private ChoiceBox<Hall> cbHall;
    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtAvailable;
    @FXML
    private TextField txtOffline;
    @FXML
    private TextField txtRequireCleaing;
    @FXML
    private TextField txtAccNumber;
    @FXML
    private Button btnCreate;
    @FXML
    private TextField txtLastName;
    private TextField txtStudentId;
    @FXML
    private TextField txtMobileNumber;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLeaseNumber;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtOccupancy;
    @FXML
    private ChoiceBox<CleaningStatus> cbCleaingstatus;
    @FXML
    private Button btnDelete;
    @FXML
    private Text txtText;
    @FXML
    private BorderPane textTotal;
    
    private ObservableList<Hall> hallData = FXCollections.observableArrayList();
    @FXML
    private TextField txtStudentID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        uweAccommodationTeam accommodationSystem = uweAccommodationTeam.getInstance();
        // uweAccommodationTeam.initializeDummyData();
        
        // setUweAccommodationTeam(uweAccommodationTeam);
        
        // Retrieve the areas to add to the choice box
        ArrayList<Hall> halls = accommodationSystem.getHalls();
        
        for (int i = 0; i<halls.size(); i++)
        {
            // Add the halls to the choice box
            hallData.add(halls.get(i));
        }
        
        // Set the items on the choice box
        cbHall.setItems(hallData);
        cbHall.setValue(hallData.get(0));
        
        cbHall.setOnAction(this::cbExampleChoiceBoxOnAction);
    }

    // The event handler for the choice box
    private void cbExampleChoiceBoxOnAction(ActionEvent event) 
    {
        // Retrieve the selected value from the choice box
        Hall hall = cbHall.getValue();
        String name = hall.getName();
        
        HallManager hallManager = hall.getHallManager();
        
        txtHallmanager.setText(hallManager.getName());
        txtHallnumber.setText(hall.getTelNo());
        txtTotal.setText(String.valueOf(hall.getTotalAccommodation()));
        txtOffline.setText(String.valueOf(hall.getTotalOffline()));
        txtAvailable.setText(String.valueOf(hall.getTotalAvailable()));
        
        
        // Set the value in the text field as proof of concept
        // fxidShowSelected.setText(area.getAreaName());
    }
    
    
    
    

    @FXML
    private void btnCreateOnAction(ActionEvent event) {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String StudentId=txtStudentId.getText();
        String LeaseNumber=txtLeaseNumber.getText();
        String MobileNumber=txtMobileNumber.getText();
        
        Student student = new Student(firstName, lastName, StudentId ,LeaseNumber,MobileNumber);
        
        System.out.println("Button Clicked");
        System.out.println("First Name: "+ firstName);
        System.out.println("Last Name: "+ lastName);
        System.out.println("studentId: "+ StudentId);
        System.out.println("leaseNumber: "+ LeaseNumber);
        System.out.println(" MobileNumber: "+  MobileNumber);
        
        
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
    }
    
    
}
