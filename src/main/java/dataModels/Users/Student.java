package dataModels.Users;

import dataModels.Fingerprint;
import dataModels.Time.Date;
import lombok.Getter;

import java.util.ArrayList;

public class Student {

    @Getter
    private String firstName, middleName, lastName;
    @Getter
    private String barcode;
    @Getter
    private Date dateOfBirth, dateOfIssue;
    @Getter
    private ArrayList<String> transactionID;
    @Getter
    private Fingerprint fingerprint;

    public Student setFirstName(String firstName) {
        this.firstName = firstName.toLowerCase();
        return this;
    }

    public Student setMiddleName(String middleName) {
        this.middleName = middleName.toLowerCase();
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
        return this;
    }

    public Student setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public Student setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Student setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
        return this;
    }

    public Student setTransactionID(ArrayList<String> transactionID) {
        this.transactionID = transactionID;
        return this;
    }

    public Student setFingerprint(Fingerprint fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }
}