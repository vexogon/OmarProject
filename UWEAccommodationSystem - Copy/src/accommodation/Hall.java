package accommodation;

import java.util.ArrayList;
import java.util.List;

public class Hall {

    private String name;
    private String telNo;
    private HallManager hallManager;
    private List<Accommodation> accommodations;

    public Hall(String name, String telNo) {
        this.name = name;
        this.telNo = telNo;
        this.accommodations = new ArrayList<Accommodation>();
    }
    

    public String getTelNo() {
        return this.telNo;
    }

    public String getName() {
        return name;
    }

    public HallManager getHallManager() {
        return hallManager;
    }

    public void setHallManager(HallManager hallManager) {
        this.hallManager = hallManager;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void addAccommodation(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public int getTotalAccommodation() {
        return accommodations.size();
    }

    public int getTotalAvailable() {
        int total = 0;
        for (Accommodation accommodation : accommodations) {
            if (!accommodation.getStatus().isOccupied()) {
                total++;
            }
        }
        return total;
    }

    public int getTotalOffline() {
        int total = 0;
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCleaningStatus().isOffline()) { 
                total++;
            }
        }
        return total;
    }
    
    public String toString()
    {
        return this.name;
    }

}