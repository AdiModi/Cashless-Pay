package dataModels.Users;

import dataModels.Date;
import dataModels.Fingerprint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Student {

    @Getter
    private String firstName, middleName, lastName;
    @Getter
    @Setter
    private Date dateOfBirth;
    @Getter
    @Setter
    private ArrayList<String> transactionID;
    @Getter
    @Setter
    private Fingerprint fingerprint;

    public void setFirstName(String firstName) {
        this.firstName = firstName.toLowerCase();
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.toLowerCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
    }
}
