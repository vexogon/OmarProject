/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accommodation;

public class AccommodationType {

    private String name;
    private String description;
    private float monthlyPrice;
  
    public AccommodationType(String name, String description, float monthlyPrice) {
      this.name = name;
      this.description = description;
      this.monthlyPrice = monthlyPrice;
    }
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public String getDescription() {
      return description;
    }
  
    public void setDescription(String description) {
      this.description = description;
    }
  
    public float getMonthlyPrice() {
      return monthlyPrice;
    }
  
    public void setMonthlyPrice(float monthlyPrice) {
      this.monthlyPrice = monthlyPrice;
    }
  
  }