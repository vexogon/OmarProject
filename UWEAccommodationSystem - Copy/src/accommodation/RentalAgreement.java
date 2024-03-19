
package accommodation;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class RentalAgreement {

    private static int nextLeaseNumber = 1000; //starting lease number
    private int leaseNumber;
    private Student student;
    private static List<RentalAgreement> rentalAgreements = new ArrayList<>();

    public RentalAgreement(Student student) {
        this.leaseNumber = generateLeaseNumber();
        this.student = student;
        rentalAgreements.add(this);
    }

    public static int generateLeaseNumber() {
        return nextLeaseNumber++;
    }

    public void assignStudent(Student student) {
        this.student = student;
    }

    public int getLeaseNumber() {
        return leaseNumber;
    }

   public void deleteLeaseNumber() {
    rentalAgreements.remove(this);
    if (!rentalAgreements.isEmpty()) {
        nextLeaseNumber = Collections.max(rentalAgreements, Comparator.comparingInt(RentalAgreement::getLeaseNumber)).getLeaseNumber() + 1;
    } else {
        nextLeaseNumber = 1000; //reset to starting lease number if no agreements exist
    }
}

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}