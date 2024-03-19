/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accommodation;

public class AccommodationStatus {

  private boolean isOccupied;
  private boolean isUnoccupied;

  public AccommodationStatus(boolean isOccupied, boolean isUnoccupied) {
    this.isOccupied = isOccupied;
    this.isUnoccupied = isUnoccupied;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public boolean isUnoccupied() {
    return isUnoccupied;
  }

  public String getStatus() {
    if (isOccupied()) {
      return "Occupied";
    } else if (isUnoccupied()) {  
      return "Unoccupied";
    } else {
      return "Unknown";
    }
  }

  public static void main(String[] args) {
  
    AccommodationStatus status = new AccommodationStatus(true, false);
    
    String statusString = status.getStatus();
    System.out.println(statusString);
    
  }

}
