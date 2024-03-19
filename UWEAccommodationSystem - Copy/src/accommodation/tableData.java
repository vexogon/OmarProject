package accommodation;

public class tableData {

    private int roomNumber;

    private String name;

    private Float RentalPrice;

    private Boolean Availability;

    private String CleaningStatus;

    private Accommodation Accommodation;

    private AccommodationStatus AccommodationStatus;

    private CleaningStatus CleaningStatusObj;

    public tableData(Integer roomNumber, String name, Float RentalPrice, Boolean Availability, String CleaningStatus, Accommodation accommodation, AccommodationStatus accommodationStatus, CleaningStatus cleaningStatusObj) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.RentalPrice = RentalPrice;
        this.Availability = Availability;
        this.CleaningStatus = CleaningStatus;
        this.Accommodation = accommodation;
        this.AccommodationStatus = accommodationStatus;
        this.CleaningStatusObj = cleaningStatusObj;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRentalPrice() {
        return RentalPrice;
    }

    public void setRentalPrice(Float rentalPrice) {
        RentalPrice = rentalPrice;
    }

    public Boolean getAvailability() {
        return Availability;
    }

    public void setAvailability(Boolean availability) {
        Availability = availability;
    }

    public String getCleaningStatus() {
        return CleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        CleaningStatus = cleaningStatus;
    }

    public accommodation.Accommodation getAccommodation() {
        return Accommodation;
    }

    public void setAccommodation(accommodation.Accommodation accommodation) {
        Accommodation = accommodation;
    }

    public accommodation.AccommodationStatus getAccommodationStatus() {
        return AccommodationStatus;
    }

    public void setAccommodationStatus(accommodation.AccommodationStatus accommodationStatus) {
        AccommodationStatus = accommodationStatus;
    }

    public accommodation.CleaningStatus getCleaningStatusObj() {
        return CleaningStatusObj;
    }

    public void setCleaningStatusObj(accommodation.CleaningStatus cleaningStatusObj) {
        CleaningStatusObj = cleaningStatusObj;
    }
}




