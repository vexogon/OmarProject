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

    public boolean cleanStatusExistsCheck(Accommodation accommodation) {
        if(accommodation.getCleaningStatus() == null) {
            return false;
        }
        return true;

    }

    public int getTotalAvailable() {
        int total = 0;
        for (int i = 0; i < accommodations.size(); i++) {
                if (!accommodations.get(i).getStatus().isOccupied()) {
                    total++;
                }
                System.out.println(total);
        }

        return total;
    }

    public int getTotalOffline() {
        int total = 0;
        for (Accommodation accommodation : accommodations) {
            if(cleanStatusExistsCheck(accommodation)) {
                if (accommodation.getCleaningStatus().isOffline()) {
                    total++;
                }
            }

        }
        return total;
    }

    public int getAllCleaning() {
        int total = 0;
        for(int i = 0; i < accommodations.size(); i++) {
            if(accommodations.get(i).requireCleaning()) {
                total +=1;
            }
        }
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public String toString()
    {
        return this.name;
    }

}