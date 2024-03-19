/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accommodation;

import javafx.scene.control.TableView;

public class Accommodation {

    private int roomNumber;
    private AccommodationType type;
    private AccommodationStatus status;
    private RentalAgreement rentalAgreement;
    private boolean maintenanceRequested;
    private CleaningStatus cleaningStatus;

    public Accommodation(int roomNumber, AccommodationType type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.status = new AccommodationStatus(false, true);
    }

    public void requestMaintenance() {
        this.maintenanceRequested = true;
    }

    public void changeCleaningStatus(CleaningStatus status) {
        this.cleaningStatus = status;
    }

    public void createRentalAgreement(RentalAgreement agreement) {
        this.rentalAgreement = agreement;
    }

    public void release() {
        this.rentalAgreement = null;
    }

    public RentalAgreement getRentalAgreement() {
        return rentalAgreement;
    }



    public CleaningStatus getCleaningStatus() {

        return cleaningStatus;
    }

    public boolean requireCleaning() {
        if(cleaningStatus == null) {
            return false;
        }
        return cleaningStatus.isDirty();
    }

    public void tableExport(TableView view) {



    }

    public AccommodationType getType() {
        return type;
    }

    public AccommodationStatus getStatus() {
        return status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public void setStatus(AccommodationStatus status) {
        this.status = status;
    }

    public void setRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreement = rentalAgreement;
    }

    public void setMaintenanceRequested(boolean maintenanceRequested) {
        this.maintenanceRequested = maintenanceRequested;
    }

    public void setCleaningStatus(CleaningStatus cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }
}