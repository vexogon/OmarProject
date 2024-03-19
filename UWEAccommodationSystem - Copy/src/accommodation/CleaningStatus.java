/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accommodation;

public class CleaningStatus {

  public boolean isClean;
  public boolean isDirty; 
  public boolean isOffline;

  public CleaningStatus(boolean isClean, boolean isDirty, boolean isOffline) {
    this.isClean = isClean;
    this.isDirty = isDirty;
    this.isOffline = isOffline;
  }

  public boolean isClean() {
    return isClean;
  }

  public boolean isDirty() {
    return isDirty;
  }

  public boolean isOffline() {
    return isOffline; 
  }
  
  public String getCleaningStatus() {
    if (isClean()) {
      return "Clean";
    } else if (isDirty()) {
      return "Dirty";  
    } else if (isOffline()) {
      return "Offline";
    } else {
      return "Unknown";
    }
    
  }
  
 

  public static void main(String[] args) {
    
    CleaningStatus status = new CleaningStatus(true, false, true);
    
    String statusString = status.getCleaningStatus();
    System.out.println(statusString);
    
  }

}
