/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package accommodation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static accommodation.uweAccommodationTeam.acomTypes;
import static javafx.application.Application.launch;

/**
 * FXML Controller class
 *
 * @author janakamal
 */
public class AccommodationSystemController implements Initializable {

    @FXML
    private TableView<tableData> table;

    @FXML
    private TableColumn<tableData, Integer> name;

    @FXML
    //Acom type name
    private TableColumn<tableData, String> AccommodationTypeString;

    @FXML
    private TableColumn<tableData, Float> RentalPrice;

    @FXML
    private TableColumn<tableData, Boolean> Availability;

    @FXML
    private TableColumn<tableData, Boolean> CleaningStatus;

    //Create Cleaning statuses for matching acom number

    @FXML
    private ChoiceBox<String> cbCleaingstatus;


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
    //If match and delete is pressed delete
    private TextField txtAccNumber;
    @FXML
    private Button btnCreate;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtMobileNumber;
    @FXML
    private TextField txtFirstName;
    @FXML
    //If match and delete is pressed delete
    private TextField txtLeaseNumber;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtOccupancy;

    @FXML
    private Button btnDelete;
    @FXML
    private Text txtText;
    @FXML
    private BorderPane textTotal;


    @FXML
    private TextField txtStudentID;


    private ObservableList<Hall> hallData = FXCollections.observableArrayList();

    private ObservableList<tableData> tableDataList = FXCollections.observableArrayList();

    private ObservableList<String> CleaningStatusDropDown = FXCollections.observableArrayList();

    private Hall hall;



    //Create a "Table Data" Object that takes in:
    //AccommodationNum
    //AccommodationType
    //RentalPrice
    //Availability
    //CleaningStatus
    //Using Content of Selector

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

        for (int i = 0; i < halls.size(); i++) {
            // Add the halls to the choice box
            hallData.add(halls.get(i));
        }

        // Set the items on the choice box
        cbHall.setItems(hallData);
        cbHall.setValue(hallData.get(0));

        cbHall.setOnAction(this::cbExampleChoiceBoxOnAction);


        //Column creation
        name.setCellValueFactory(new PropertyValueFactory<tableData, Integer>("roomNumber"));
        AccommodationTypeString.setCellValueFactory(new PropertyValueFactory<tableData, String>("name"));
        RentalPrice.setCellValueFactory(new PropertyValueFactory<tableData, Float>("RentalPrice"));
        Availability.setCellValueFactory(new PropertyValueFactory<tableData, Boolean>("Availability"));
        CleaningStatus.setCellValueFactory(new PropertyValueFactory<tableData, Boolean>("CleaningStatus"));


        //Drop down box create CreatingStatuses

        if (CleaningStatusDropDown.size() < 3) {
            CleaningStatusDropDown.add("Clean");
            CleaningStatusDropDown.add("Dirty");
            CleaningStatusDropDown.add("Offline");
        }
        cbCleaingstatus.setItems(CleaningStatusDropDown);





    }

    //Set Acom Num


    // The event handler for the choice box

    private void clearTextFields() {
        // Clear all text fields
        txtHallnumber.clear();
        txtHallmanager.clear();
        txtTotal.clear();
        txtAvailable.clear();
        txtOffline.clear();
        txtRequireCleaing.clear();
        txtAccNumber.clear();
        txtLastName.clear();
        txtMobileNumber.clear();
        txtFirstName.clear();
        txtLeaseNumber.clear();
        txtType.clear();
        txtPrice.clear();
        txtOccupancy.clear();
        txtStudentID.clear();
        txtText.setText(""); // Clear any informational messages
        // You can add more text fields here if needed
        cbCleaingstatus.getSelectionModel().clearSelection(); // Clear selected cleaning status
    }

    private void tableHandler() {

        Hall hall = cbHall.getValue();
        String name = hall.getName();
        //Create Table View Objects
        tableDataList.clear();
        for (int i = 0; i < hall.getTotalAccommodation(); i++) {
            Accommodation acom = hall.getAccommodations().get(i);

            if (!hall.cleanStatusExistsCheck(acom)) {
                acom.changeCleaningStatus(new CleaningStatus(true, false, false));
            }
            System.out.println("HERE HERE _-----");
            System.out.println(acom.getRoomNumber());
            tableData data = new tableData(acom.getRoomNumber(), acom.getType().getName(), acom.getType().getMonthlyPrice(), acom.getStatus().isUnoccupied(), acom.getCleaningStatus().getCleaningStatus(), acom,acom.getStatus(),acom.getCleaningStatus());
            tableDataList.add(data);
        }
        table.setItems(tableDataList);

    }
    private void cbExampleChoiceBoxOnAction(ActionEvent event) {
        // Retrieve the selected value from the choice box
        Hall hall = cbHall.getValue();
        String name = hall.getName();

        //Create Table View Objects
        tableHandler();


        //Get Table View


        //Update Table

        topBarRefersh();


        // Set the value in the text field as proof of concept
        // fxidShowSelected.setText(area.getAreaName());
    }

    private void topBarRefersh() {
        System.out.println("TOP BAR");
        Hall hall = cbHall.getValue();
        HallManager hallManager = hall.getHallManager();
        txtHallmanager.setText(hallManager.getName());
        txtHallnumber.setText(hall.getTelNo());

        txtAvailable.setText(String.valueOf(hall.getTotalAvailable()));
        txtTotal.setText(String.valueOf(hall.getTotalAccommodation()));
        txtOffline.setText(String.valueOf(hall.getTotalOffline()));
        txtRequireCleaing.setText(String.valueOf(hall.getAllCleaning()));
    }


    @FXML
    private void btnCreateOnAction(ActionEvent event) {

        //Selected Table Row finder
        ObservableList<tableData> selectedData;

        selectedData=table.getSelectionModel().getSelectedItems();

        if (selectedData.isEmpty()) {
            System.out.println("No row selected.");
            return; // No row selected, nothing to do
        }
        Hall hall = cbHall.getValue();

        ArrayList<RentalAgreement> rentals = new ArrayList<RentalAgreement>();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String StudentId = txtStudentID.getText();
        String LeaseNumber = txtLeaseNumber.getText();
        String MobileNumber = txtMobileNumber.getText();

        Student student = new Student(firstName, lastName, StudentId, LeaseNumber, MobileNumber);

        System.out.println("Button Clicked");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("studentId: " + StudentId);
        System.out.println("leaseNumber: " + LeaseNumber);
        System.out.println(" MobileNumber: " + MobileNumber);

        if(!Objects.equals(txtStudentID.getText(), "") && !Objects.equals(txtFirstName.getText(), "") && !Objects.equals(txtLastName.getText(), "") && !Objects.equals(txtStudentID.getText(), "") && !Objects.equals(txtLeaseNumber.getText(), "") && !Objects.equals(txtMobileNumber.getText(), "")) {

            RentalAgreement agreement = new RentalAgreement(student);

            Accommodation acom = selectedData.get(0).getAccommodation();

            if(acom.getRentalAgreement() != null) {
                txtText.setText("Sorry, This room already has an agreement");
                return;
            }
            acom.setRentalAgreement(agreement);
                AccommodationStatus acomStatus = new AccommodationStatus(true, false);
                acom.setStatus(acomStatus);

            hall.setAccommodations(hall.getAccommodations());
            txtText.setText("Agreement Created & Saved");


        }






        //Check for fields with entries
            //Get currently selected acom and change its number
        Accommodation currentAcom;
        for(int i =0; i < hall.getTotalAccommodation(); i++) {
            Accommodation currentCheckAcom = hall.getAccommodations().get(i);
            System.out.println("ROOM NUMBER:");
            System.out.println(selectedData.get(0).getRoomNumber());
            if(currentCheckAcom.equals(selectedData.get(0).getAccommodation())) {
                System.out.println("HIT");
                currentAcom = currentCheckAcom;
                int convertedStringNum = 0;
                try {
                    convertedStringNum = Integer.parseInt(txtAccNumber.getText());
                }
                catch (NumberFormatException e) {
                    convertedStringNum = 0;
                }
                if(!Objects.equals(txtAccNumber.getText(), "")) {
                    System.out.println("CONVERTED NUM");
                    System.out.println(convertedStringNum);
                    currentAcom.setRoomNumber(convertedStringNum);
                    System.out.println("WORKED");
                }
                }

            if(!Objects.equals(txtType.getText(), "")) {
                currentAcom = selectedData.get(0).getAccommodation();
                System.out.println(txtType.getText());
                if(!Objects.equals(txtType.getText(), "") && !Objects.equals(txtType.getText(), "Standard") && !Objects.equals(txtType.getText(), "Superior")){
                    txtType.setText("Invalid Input");
                    return;
                }
                if(currentAcom.getType().getName() == txtType.getText()) {
                    return;
                }
                int price = 700;
                if(txtType.getText() == "Superior") {
                    price+=50;
                }
                AccommodationType newType = new AccommodationType(txtType.getText(), txtType.getText().concat(" desc"),price);
                System.out.println("COMPLETED");
                currentAcom.setType(newType);

            }

            if(!Objects.equals(txtPrice.getText(), "")) {
                currentAcom = selectedData.get(0).getAccommodation();
                currentAcom.getType().setMonthlyPrice(Float.parseFloat(txtPrice.getText()));


            }
            if(!Objects.equals(txtOccupancy.getText(), "")) {
                currentAcom = selectedData.get(0).getAccommodation();

                System.out.println("SELECTED ACOM");
                System.out.println(currentAcom.getRoomNumber());

                if(!Objects.equals(txtOccupancy.getText(), "true") && !Objects.equals(txtOccupancy.getText(), "false")) {
                    txtOccupancy.setText("Invalid Input");

                }


                AccommodationStatus acomStatus = new AccommodationStatus(false, true);
                System.out.println(txtOccupancy.getText());
                if(txtOccupancy.getText() == "true") {
                    System.out.println("HIT THIS THIS ");
                    acomStatus = new AccommodationStatus(true, false);

                }

                System.out.println("UPDATED");
                currentAcom.setStatus(acomStatus);





            }
            currentAcom = selectedData.get(0).getAccommodation();
            if(!Objects.equals(cbCleaingstatus.getValue(), currentAcom.getCleaningStatus().getCleaningStatus())) {
                accommodation.CleaningStatus newCleanStat = new CleaningStatus(true,false,false);
                if(Objects.equals(cbCleaingstatus.getValue(), "Dirty")) {
                    newCleanStat = new CleaningStatus(false,true,false);
                }
                if(Objects.equals(cbCleaingstatus.getValue(), "Offline")) {
                    newCleanStat = new CleaningStatus(false,false,true);

                }

                currentAcom.setCleaningStatus(newCleanStat);


            }




        }
        clearTextFields();
        topBarRefersh();
        tableHandler();



}

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {

        Hall hall = cbHall.getValue();
        ObservableList<tableData> selectedData;

        selectedData=table.getSelectionModel().getSelectedItems();

        Accommodation selectedAcom = selectedData.get(0).getAccommodation();

        for(int i = 0; i < hall.getTotalAccommodation(); i++) {
            if(hall.getAccommodations().get(i) == selectedAcom) {
                hall.getAccommodations().remove(i);
            }
        }
        clearTextFields();
        topBarRefersh();
        tableHandler();


    }





}
