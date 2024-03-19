/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accommodation;

public class Student {

    private String StudentId;
    private String FirstName;
    private String LastName;
    private String mobileNumber;
    private String LeaseNumber;
    
  
    public Student(String Studentid, String FirstName, String LastName, String mobileNumber,String LeaseNumber) {
      this.StudentId = StudentId;
      this.FirstName = FirstName;
      this.mobileNumber = mobileNumber;
      this.LastName=LastName;
      this.LeaseNumber=LeaseNumber;
      
    }
  
    public String getId() {
      return StudentId;
    }
  
    public String getFName() {
      return FirstName;
    }
  
    public String getLName() {
      return LastName;
    }
  
    public String getMobileNumber() {
      return mobileNumber;
    }
  
    public String getLeaseNumber() {
      return LeaseNumber;
    }
  
  }