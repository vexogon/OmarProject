package accommodation;

import java.util.ArrayList;
import accommodation.CleaningStatus;

public class uweAccommodationTeam {

  private static uweAccommodationTeam instance=null;
   
  private ArrayList<Hall> halls;

  protected uweAccommodationTeam() {
    halls = new ArrayList<Hall>();
  }

  public ArrayList<Hall> getHalls() {
    return halls;
  }
  
  public void addAccommodations(Hall hall) {
    AccommodationType accommType = new AccommodationType("Standard", "Standard Desc", 700.0f);
    for (int roomNo = 0; roomNo < 30; roomNo++) {
      Accommodation accommodation = new Accommodation(roomNo + 1, accommType);
      hall.addAccommodation(accommodation);
    }
    AccommodationType superiorEnSuite = new AccommodationType("Superior", "Superior Desc", 750.0f);
    for (int roomNo = 30; roomNo < 40; roomNo++) {
      Accommodation accommodation = new Accommodation(roomNo + 1, superiorEnSuite);
      hall.addAccommodation(accommodation);
    }
  }
  public void populateData()
  {
    Hall breconHall = new Hall("Brecon", "07498260224");
    HallManager breconHallManager = new HallManager("John Doe");
    breconHall.setHallManager(breconHallManager);
    addAccommodations(breconHall);
    
    Hall cotswoldHall = new Hall("Cotswold", "07498260223");
    HallManager cotswoldHallManager = new HallManager("James Milner");
    cotswoldHall.setHallManager(cotswoldHallManager);
    addAccommodations(cotswoldHall);    
    
    Hall mendipHall = new Hall("Mendip", "07498260226");
    HallManager mendipHallManager = new HallManager("Mo Salah");
    mendipHall.setHallManager(mendipHallManager);
    addAccommodations(mendipHall);
        
    Hall quantockHall = new Hall("Quantock", "07498260229");
    HallManager quantockHallManager = new HallManager("Wayne Rooney");
    quantockHall.setHallManager(quantockHallManager);
    addAccommodations(quantockHall);
     
    addHall(breconHall);
    addHall(cotswoldHall);
    addHall(mendipHall);
    addHall(quantockHall);
    
    
    
  }
  
  public void addHall(Hall hall) {
    halls.add(hall);
   
  }
  public static uweAccommodationTeam getInstance()
  {
      if (instance==null){
          instance=new uweAccommodationTeam();
          instance.populateData();
      }
      return instance;
    
}

}